package com.padelapp.telegram.observer;


import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

import java.util.List;

public interface FormBuilderObserver {
    void onSendMessageUpdated(List<SendMessage> sendMessage);

    void onDeletedMessageUpdated(List<DeleteMessage> deleteMessage);
}
