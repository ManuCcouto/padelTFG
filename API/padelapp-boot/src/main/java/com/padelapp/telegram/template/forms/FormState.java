package com.padelapp.telegram.template.forms;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public interface  FormState {
    void setMessage();
    void processFormResponse(Update update);
     FormState getNextState(String condition);

   void processFormResponse(Map<String, String> formResponses, String userInput);

    void setBuilder(FormBuilder builder);
}
