package com.padelapp.telegram.template.states;

import com.padelapp.telegram.template.forms.MessageTemplate;
import com.padelapp.telegram.template.forms.FormBuilder;
import com.padelapp.telegram.template.forms.FormState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ChooseResourceState implements FormState {
    private FormBuilder formBuilder;
    @Autowired
    MessageTemplate messageTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ChooseLevelState.class);
    @Override
    public void setMessage() {
        Update update = this.formBuilder.getUpdate();
        SendMessage message = this.sendDefaultMessage(update.getMessage().getChatId());



//        // Configurar lista de recursos y botones de selección
        // ...
        logger.info("ChooseResourceState" + message.toString());
        logger.info("ChooseResourceState la respuesta " + formBuilder.getFormResponses().toString());
        //message.setText("Selecciona la pista:");
        // Configurar botones de selección del día
        // ...
        //InlineKeyboardMarkup bookings = Button.createDayButtons(messageTemplate);
        //message.setReplyMarkup(bookings);

        //this.formBuilder.setSendMessage(Collections.singletonList(message));

        this.formBuilder.setSendMessage(this.sendDefaultMessages(update.getMessage().getChatId()));


    }

    @Override
    public void processFormResponse(Update update) {
        // Validar y guardar la respuesta en el builder
        //   formBuilder.saveResponse("Recurso", response);
        logger.info("this.getMessage() {}", update );

        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        logger.info("chatId de la callback {}", chatId );
        logger.info("ChooseResourceState processFormResponse" + update);
        CallbackQuery callbackQuery = update.getCallbackQuery();
        logger.info("Calback" + callbackQuery);
        logger.info("Los ids de los botones: " +formBuilder.getMessagesHistoricId());

        this.formBuilder.setDeleteMessage(getDeleteMessages(formBuilder.getMessagesHistoricId(),String.valueOf(chatId)));
        logger.info("this.getMessage() {}",this.formBuilder.getUpdate());
       //this.formBuilder.setSendMessage(Collections.singletonList(message));
        logger.info("numero Botones disponibles: " + this.formBuilder.getSendMessage().size());
        logger.info(" Botones disponibles: " + this.formBuilder.getSendMessage().toString());
        SendMessage echoMes = this.echoMessage(update);
        this.formBuilder.setSendMessage(Collections.singletonList(echoMes));
        formBuilder.setNextState(new ChooseLevelState());
        formBuilder.startForm(update);
    }

    @Override
    public FormState getNextState(String condition) {
        return null;
    }


    @Override
    public void processFormResponse(Map<String, String> formResponses, String userInput) {

    }

    @Override
    public void setBuilder(FormBuilder builder) {
        this.formBuilder = builder;
    }

    private String getTelegramId(Update update) {
        Message messageReceived = update.getMessage();
        return String.valueOf(messageReceived.getChatId());
    }

    private SendMessage sendDefaultMessage(long chatId) {
        logger.info("sendDefaultMessage chatId {}", chatId);
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

        this.messageTemplate = new MessageTemplate();
        String defaultMessage = messageTemplate.generateDefaultMessage();
        message.setText(defaultMessage);

        InlineKeyboardButton button = new InlineKeyboardButton("Unirse");
        button.setCallbackData("get_user_name");


        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(Collections.singletonList(row));

        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    private List<SendMessage> sendDefaultMessages(long chatId) {
        List<SendMessage> messageList = new ArrayList<>();

        this.messageTemplate = new MessageTemplate();
        List<String> days = new ArrayList<>(); // Obtener una lista de días
        days.add("2023-05-01");
        days.add("2023-05-02");
        days.add("2023-05-03");

        for (String day : days) {
            String defaultMessage = messageTemplate.generateDefaultMessage();

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText(defaultMessage);

            InlineKeyboardButton button = new InlineKeyboardButton("reserva " + day + " - " + day.length());
            button.setCallbackData("day_" + day + "_" + day.length());

            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(button);

            InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
            keyboardMarkup.setKeyboard(Collections.singletonList(row));

            message.setReplyMarkup(keyboardMarkup);

            messageList.add(message);
        }

        return messageList;
    }

    private List<DeleteMessage> getDeleteMessages(List<Integer> messageIds,String chatId) {
        logger.info("los ids de los que se borraran {}",messageIds );
        List<DeleteMessage> deleteMessages = new ArrayList<>();
        for (Integer messageId : messageIds) {
            DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
            deleteMessages.add(deleteMessage);
        }
        return deleteMessages;
    }
    private SendMessage echoMessage(Update update) {
        // Obtener el callback data del botón seleccionado

        logger.info("update.getCallbackQuery().getData() {}", update.getCallbackQuery().getMessage().getText());
        String callbackData = update.getCallbackQuery().getData();

        // Construir la respuesta del bot
        String responseText = "Has seleccionado: " + update.getCallbackQuery().getMessage().getText();

        // Crear un objeto SendMessage para enviar la respuesta
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        message.setText(responseText);
        logger.info("antes de la setAllowSendingWithoutReply {}", message);
        message.setAllowSendingWithoutReply(false);
        logger.info("despues de la setAllowSendingWithoutReply {}", message);

        return message;
    }

}