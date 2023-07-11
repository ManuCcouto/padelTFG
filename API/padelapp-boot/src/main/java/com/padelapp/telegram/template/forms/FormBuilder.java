package com.padelapp.telegram.template.forms;

import com.padelapp.telegram.observer.FormBuilderObserver;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ToString
public class FormBuilder implements FormBuilderObserver  {

    private FormState currentState;
    private Map<String, String> formResponses;
    private List<SendMessage> sendMessage;
    private Update update;
    private boolean isFinalState;
    private FormBuilderObserver observer;
    private List<Integer> messagesHistoricId;
    private String chatID;

    private static final Logger logger = LoggerFactory.getLogger(FormBuilder.class);

    public FormBuilder(FormState currentState, Update update) {
        this.currentState = currentState;
        this.messagesHistoricId = new ArrayList<>();
        this.formResponses = new HashMap<>();
        this.currentState.setBuilder(this);
        this.update=update;
        this.isFinalState=false;
        this.sendMessage = new ArrayList<>();
        this.chatID=update.getMessage().getChatId().toString();

    }

    public void startForm(Update update) {
        this.currentState.setMessage();
       this.setUpdate(update);
    }

    public void processFormResponse(Update update) {
        currentState.processFormResponse(update);
    }

    public void setNextState(FormState nextState) {
        nextState.setBuilder(this);
        this.currentState = nextState;
    }

    public void saveResponse(String field, String response) {
        formResponses.put(field, response);
    }

    public Map<String, String> getFormResponses() {
        return formResponses;
    }
    public List<SendMessage> getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(List<SendMessage> sendMessage) {
        this.sendMessage = sendMessage;
        logger.info("observer "+ sendMessage+"  "+ observer);
        if (observer != null) {
            observer.onSendMessageUpdated(sendMessage);
        }
    }
    public void setDeleteMessage(List<DeleteMessage> deleteMessages) {
        if (observer != null) {
            observer.onDeletedMessageUpdated(deleteMessages);
        }
    }

    public void setFormResponses(Map<String, String> formResponses) {
        this.formResponses = formResponses;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    public void setFinalState(boolean finalState) {
        isFinalState = finalState;
    }
    public void setObserver(FormBuilderObserver observer) {
        this.observer = observer;
    }

    public List<Integer> getMessagesHistoricId() {
        return messagesHistoricId;
    }

    public void setMessagesHistoricId(List<Integer> messagesHistoricId) {
        this.messagesHistoricId = messagesHistoricId;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    @Override
    public void onSendMessageUpdated(List<SendMessage> sendMessage) {
        if (observer != null) {
            observer.onSendMessageUpdated(sendMessage);
        }
    }

    @Override
    public void onDeletedMessageUpdated(List<DeleteMessage> deleteMessage) {
        if (observer != null) {
            observer.onDeletedMessageUpdated(deleteMessage);
        }

    }
}
