package com.padelapp.telegram.template.states;

import com.padelapp.telegram.template.forms.Button;
import com.padelapp.telegram.template.forms.FormBuilder;
import com.padelapp.telegram.template.forms.FormState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChooseLevelState implements FormState {
    private FormBuilder formBuilder;
    private static final Logger logger = LoggerFactory.getLogger(ChooseLevelState.class);
    @Override
    public void setMessage() {
        Update update = this.formBuilder.getUpdate();
        logger.info("Update {} ",update.toString());
        SendMessage message = new SendMessage();
        message.setChatId(this.formBuilder.getChatID());

        message.setText("Que nivel tienes?");

        // Configurar botones de selección del día
        // ...
        InlineKeyboardMarkup levelButtons = Button.createLevelButtons();
        message.setReplyMarkup(levelButtons);

        logger.info("levelbuttos" + message.toString());


        formBuilder.setSendMessage(Collections.singletonList(message));



    }

    @Override
    public void processFormResponse(Update update) {

        CallbackQuery callbackQuery = update.getCallbackQuery();
        String callbackData = callbackQuery.getData();
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        SendMessage echoMes = this.echoMessage(update);
        DeleteMessage deleteMessage= new DeleteMessage(String.valueOf(chatId),messageId);
       // this.formBuilder.setDeleteMessage(Collections.singletonList(deleteMessage));
        this.formBuilder.setSendMessage(Collections.singletonList(echoMes));
        logger.info("Los ids de los botones: " +formBuilder.getMessagesHistoricId());
        // Validar y guardar la respuesta en el builder
        // formBuilder.saveResponse("Día", response);
        logger.info("response" + callbackData);

        // Cambiar al siguiente estado
        SendMessage message = new SendMessage();
        //message.setChatId(chatId);
        message.setText("nivel:" + formBuilder.getMessagesHistoricId().toString() );

        // Crear y configurar los botones de recurso
       /* InlineKeyboardMarkup resourceButtons = createResourceButtons();
        message.setReplyMarkup(resourceButtons);*/
        Map<String, String> mapa = new HashMap<>();
        mapa.put("dia", "jueves");
        formBuilder.setFormResponses(mapa);
        logger.info("formbuider" + formBuilder.toString());

        logger.info("formbuider" + formBuilder.toString());

        // formBuilder.setNextState(new ChooseResourceState());
    }

    @Override
    public FormState getNextState(String condition) {
        return new ChooseResourceState();
    }



    @Override
    public void processFormResponse(Map<String, String> formResponses, String userInput) {

    }

    @Override
    public void setBuilder(FormBuilder builder) {
        this.formBuilder=builder;

    }

    private String getTelegramId(Update update) {
        Message messageReceived = update.getMessage();
        return String.valueOf(messageReceived.getChatId());
    }

    private SendMessage echoMessage(Update update) {
        // Obtener el callback data del botón seleccionado
        String callbackData = update.getCallbackQuery().getData();

        // Construir la respuesta del bot
        String responseText = "Has seleccionado: " + callbackData;

        // Crear un objeto SendMessage para enviar la respuesta
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        message.setText(responseText);
        message.setText(responseText);
        return message;
    }
}