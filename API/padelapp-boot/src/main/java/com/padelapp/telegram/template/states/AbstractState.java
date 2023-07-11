package com.padelapp.telegram.template.states;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AbstractState {
    public String getTelegramId(Update update) {
        Message messageReceived = update.getMessage();
        return String.valueOf(messageReceived.getChatId());
    }
}
