package com.padelapp.telegram.sercvice;

import com.padelapp.service.BookingService;
import com.padelapp.telegram.observer.FormBuilderObserver;
import com.padelapp.telegram.template.forms.FormBuilder;
import com.padelapp.telegram.template.forms.MessageTemplate;
import com.padelapp.telegram.template.states.ChooseDayState;
import com.padelapp.telegram.template.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Configurable
public class MyTelegramBot extends TelegramLongPollingBot {
    @Autowired
    private BookingService reservaService;
    private FormBuilder formBuilder;
    @Autowired
    MessageTemplate messageTemplate;
    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    private static final Logger logger = LoggerFactory.getLogger(MyTelegramBot.class);
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message messageReceived = update.getMessage();
            long chatId = messageReceived.getChatId();
            logger.info("chat id: {}", chatId);
            if (messageReceived.getText().equals("/partidas")) {
              //  deleteMessages(chatId);
                formBuilder = new FormBuilder(new ChooseDayState(), update);
                formBuilder.startForm(update);
//                FormState nextState = formBuilder.getNextState();
//                if (nextState != null) {
//                    SendMessage nextMessage = nextState.startForm(update);
                for (SendMessage sendMessage : formBuilder.getSendMessage()) {
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();

                    }
                }
            }

        } else {
            // Procesar la respuesta del usuario si proviene de una callback
            if (update.hasCallbackQuery()) {
                clean(update);
                formBuilder.processFormResponse(update);

                CallbackQuery callbackQuery = update.getCallbackQuery();
                String callbackData = callbackQuery.getData();

                //deleteLastMessage();

            }
        }


        List<Integer> messageIds = formBuilder.getMessagesHistoricId();
        formBuilder.setObserver(new FormBuilderObserver() {
            @Override
            public void onSendMessageUpdated(List<SendMessage> sendMessages) {
                for (SendMessage sendMessage : sendMessages) {
                    try {
                        Message sentMessage = execute(sendMessage);  // Enviar el mensaje y obtener el mensaje enviado con el ID asignado
                        if (sendMessage.getAllowSendingWithoutReply()==null){
                        Integer messageId = sentMessage.getMessageId();  // Obtener el ID del mensaje enviado
                        logger.info("mensajes enviados {}",sentMessage.toString());
                        messageIds.add(messageId);
                        }
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onDeletedMessageUpdated(List<DeleteMessage> deleteMessages) {
                logger.info("mensajes a borrar {} ", deleteMessages.toString());
                for (DeleteMessage deleteMessage : deleteMessages) {
                    try {
                        logger.info("borrando mensaje {} ",deleteMessage);
                        execute(deleteMessage);
                    } catch (TelegramApiException e) {
                        logger.error("error al borrar mensaje {} ",e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    public void echoMessage(Update update) {
        // Obtener el texto del mensaje del usuario
        String messageText = update.getMessage().getText();

        // Construir la respuesta del bot
        String responseText = "Has seleccionado: " + messageText;

        // Crear un objeto SendMessage para enviar la respuesta
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        message.setText(responseText);

        try {
            // Enviar el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendEditableMessage(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("¡Este mensaje es editable! Haz clic en el botón para editarlo.");

        // Agregar un botón para editar el mensaje
        InlineKeyboardButton editButton = new InlineKeyboardButton("Editar");
        editButton.setCallbackData("editar_mensaje");

        // Crear una fila de teclado en línea y añadir el botón
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(editButton);

        // Crear un objeto InlineKeyboardMarkup y añadir la fila de botones
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(Collections.singletonList(row));

        // Establecer el teclado en línea en el mensaje
        message.setReplyMarkup(keyboardMarkup);

        try {
            // Enviar el mensaje inicial
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
 private void  limpieza(){
   if(this.formBuilder.getSendMessage().isEmpty()){

   }
 }
    private void deleteMessages(long chatId) {
        GetUpdates getUpdates = new GetUpdates();
        getUpdates.setLimit(100); // Obtén los últimos 100 mensajes (puedes ajustar el número según tus necesidades)

        try {
            List<Update> updates = execute(getUpdates);

            for (Update update : updates) {
                Message message = update.getMessage();
                if (message != null) {
                    DeleteMessage deleteMessage = new DeleteMessage(String.valueOf(chatId), message.getMessageId());
                    execute(deleteMessage);
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void editMessage(Message message) {
        EditMessageText editedMessage = new EditMessageText();
        editedMessage.setChatId(String.valueOf(message.getChatId()));
        editedMessage.setMessageId(message.getMessageId());

        // Obtener el texto actual del mensaje
        String currentText = message.getText();

        // Modificar el texto del mensaje según las necesidades
        String newText = currentText + "\n\nPor favor, edita este mensaje y envíalo.";

        editedMessage.setText(newText);

        try {
            // Editar y enviar el mensaje modificado
            execute(editedMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void deleteLastMessage() {
        GetUpdates getUpdates = new GetUpdates();
        getUpdates.setLimit(1);  // Obtener solo el último mensaje

        try {
            List<Update> updates = execute(getUpdates);
            logger.info("deleteLastMessage  " + updates.toString());
            if (!updates.isEmpty()) {
                Update lastUpdate = updates.get(0);
                logger.info("deleteLastMessage lastUpdate " + lastUpdate.toString());
                Long chatId = lastUpdate.getMessage().getChatId();
                Integer messageId = lastUpdate.getMessage().getMessageId();
                DeleteMessage deleteMessage = new DeleteMessage(String.valueOf(chatId), messageId);
                execute(deleteMessage);
            }
        } catch (TelegramApiException e) {

            logger.info("TelegramApiException deleteLastMessage " + e.toString());
        }
    }
private void clean(Update update){
    List<InlineKeyboardButton> buttons = new ArrayList<>();

    if (update.hasMessage() && update.getMessage().hasReplyMarkup()) {
        InlineKeyboardMarkup replyMarkup = update.getMessage().getReplyMarkup();
        if (replyMarkup != null && replyMarkup.getKeyboard() != null) {
            buttons = replyMarkup.getKeyboard().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }
    } else if (update.hasCallbackQuery() && update.getCallbackQuery().getMessage().hasReplyMarkup()) {
        InlineKeyboardMarkup replyMarkup = update.getCallbackQuery().getMessage().getReplyMarkup();
        if (replyMarkup != null && replyMarkup.getKeyboard() != null) {
            buttons = replyMarkup.getKeyboard().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }
    }

    for (InlineKeyboardButton button : buttons) {
        logger.info("ID: " + button.getCallbackData() + ", Texto: " + button.getText());
    }
}
    private void cajaTexto(String chatId) {
        // Crear una nueva instancia de InlineKeyboardButton con el tipo "input_text"
        InlineKeyboardButton inputTextButton = new InlineKeyboardButton();
        inputTextButton.setText("Ingresa texto");
        inputTextButton.setCallbackData("input_text_button");

// Configurar el tipo de entrada como "inputTextMessageContent"
        InputTextMessageContent inputTextMessageContent = new InputTextMessageContent();
        inputTextMessageContent.setMessageText("Por favor, ingresa un texto:");

// Asignar el tipo de entrada al botón
        inputTextButton.setSwitchInlineQueryCurrentChat(inputTextMessageContent.toString());

// Agregar el botón a la lista de botones
        List<InlineKeyboardButton> buttonsRow = new ArrayList<>();
        buttonsRow.add(inputTextButton);
        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(buttonsRow);

// Crear el teclado en línea con los botones
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboardRows);

// Crear el mensaje con el teclado en línea
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Selecciona una opción:");
        message.setReplyMarkup(keyboardMarkup);

// Enviar el mensaje al usuario
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void processUserResponse(Message message) {
        String text = message.getText();
        long chatId = message.getChatId();

        if (text.startsWith("👤 Nombre:")) {
            String userName = text.replace("👤 Nombre:", "").trim();

            InlineKeyboardButton maleButton = new InlineKeyboardButton("🚹 Masculino");
            maleButton.setCallbackData("choose_gender_male");

            InlineKeyboardButton femaleButton = new InlineKeyboardButton("🚺 Femenino");
            femaleButton.setCallbackData("choose_gender_female");

            List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
            buttonsRow1.add(maleButton);

            List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();
            buttonsRow2.add(femaleButton);

            List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
            keyboardRows.add(buttonsRow1);
            keyboardRows.add(buttonsRow2);

            InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboardRows);

            SendMessage messageGender = new SendMessage(String.valueOf(chatId), "Selecciona tu género:");
            messageGender.setReplyMarkup(keyboardMarkup);

            try {
                execute(messageGender);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            // Aquí puedes guardar el nombre del usuario junto con su ID en tu sistema
            // Por ejemplo, puedes usar una base de datos o algún otro mecanismo de almacenamiento
        }
    }

    private void sendGenderSelection(long userId) {
        InlineKeyboardButton maleButton = new InlineKeyboardButton("🚹 Masculino");
        maleButton.setCallbackData("choose_gender_male");

        InlineKeyboardButton femaleButton = new InlineKeyboardButton("🚺 Femenino");
        femaleButton.setCallbackData("choose_gender_female");

        List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
        buttonsRow1.add(maleButton);

        List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();
        buttonsRow2.add(femaleButton);

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(buttonsRow1);
        keyboardRows.add(buttonsRow2);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboardRows);

        SendMessage messageGender = new SendMessage(String.valueOf(userId), "Selecciona tu género:");
        messageGender.setReplyMarkup(keyboardMarkup);

        try {
            execute(messageGender);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void saveUserGender(String userId, String gender) {
        logger.info(String.valueOf(userId) + " " + gender);
    }


    public static String generateCode(long chatId) throws NoSuchAlgorithmException {
        // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();

        // Formatear la fecha y hora como una cadena numérica
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");
        String timestamp = now.format(formatter);

        // Concatenar la cadena de fecha y hora con el ID de chat
        String input = timestamp + chatId;

        // Calcular el hash de la cadena usando el algoritmo SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // Convertir el hash a una cadena hexadecimal
        StringBuilder builder = new StringBuilder();
        for (byte b : hashBytes) {
            builder.append(String.format("%02x", b));
        }
        String hash = builder.toString();

        // Tomar los primeros 8 caracteres del hash para obtener el código compartido
        String code = hash.substring(0, 8);

        return code;
    }

    @Scheduled(cron = "0 0,30 * * * *") // Se ejecuta en horas y medias horas del día
    public void verificarReservas() {
        String chatId = "41670211"; // Reemplazar con el ID del chat al que deseas enviar el mensaje
        String mensaje = "¡Tu reserva está a punto de comenzar!";
        this.enviarMensaje(chatId, mensaje);
    }

    private void sendMatchDayOptions(long chatId) {
        InlineKeyboardButton todayButton = new InlineKeyboardButton(DateUtils.DayDescription.TODAY.getDescription());
        todayButton.setCallbackData("choose_day_today");

        InlineKeyboardButton tomorrowButton = new InlineKeyboardButton(DateUtils.DayDescription.TOMORROW.getDescription());
        tomorrowButton.setCallbackData("choose_day_tomorrow");

        LocalDate currentDate = LocalDate.now();
        InlineKeyboardButton day2Button = new InlineKeyboardButton(DateUtils.DayDescription.valueOf(currentDate.plusDays(2).getDayOfWeek().name()).getDescription());
        day2Button.setCallbackData("choose_day_" + currentDate.plusDays(2));

        InlineKeyboardButton day3Button = new InlineKeyboardButton(DateUtils.DayDescription.valueOf(currentDate.plusDays(3).getDayOfWeek().name()).getDescription());
        day3Button.setCallbackData("choose_day_" + currentDate.plusDays(3));

        InlineKeyboardButton day4Button = new InlineKeyboardButton(DateUtils.DayDescription.valueOf(currentDate.plusDays(4).getDayOfWeek().name()).getDescription());
        day4Button.setCallbackData("choose_day_" + currentDate.plusDays(4));

        List<InlineKeyboardButton> buttonsRow = new ArrayList<>();
        buttonsRow.add(todayButton);
        buttonsRow.add(tomorrowButton);
        buttonsRow.add(day2Button);
        buttonsRow.add(day3Button);
        buttonsRow.add(day4Button);

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(buttonsRow);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboardRows);

        SendMessage message = new SendMessage(String.valueOf(chatId), "Selecciona una opción:");
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensaje(String chatId, String mensaje) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(mensaje);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            // Manejar cualquier excepción que pueda ocurrir al enviar el mensaje
            e.printStackTrace();
        }
    }

    private String dameMensaje(String chatId, String message) {
        return "LA reserva de " + chatId + " su mensaje " + message + "no te olvides!! ";
    }

    private void sendDefaultMessage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

        String defaultMessage = messageTemplate.generateDefaultMessage();
        message.setText(defaultMessage);

        InlineKeyboardButton button = new InlineKeyboardButton("Unirse");
        button.setCallbackData("get_user_name");


        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(Collections.singletonList(row));

        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendUserNameRequest(long userId) {
        SendMessage message = new SendMessage(String.valueOf(userId), "Por favor, ingresa tu nombre:");
        sendGenderSelection(userId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}