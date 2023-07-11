package com.padelapp.telegram.template.forms;

import com.padelapp.telegram.template.utils.DateUtils;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Button {

    public static InlineKeyboardMarkup createDayButtons(){
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
        return keyboardMarkup;
    }
    public static InlineKeyboardMarkup createDayButtons(MessageTemplate messageTemplate) {
        LocalDate currentDate = LocalDate.now();
        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        List<String> days = new ArrayList<>(); // Obtener una lista de días
        days.add("2023-05-01");
        days.add("2023-05-02");
        days.add("2023-05-03");
        for (String day : days) {
            LocalDate dia = currentDate.plusDays(1);
            String dayDescription = DateUtils.DayDescription.valueOf(dia.getDayOfWeek().name()).getDescription();
            String callbackData = "choose_day_" + day;

            InlineKeyboardButton dayButton = new InlineKeyboardButton(messageTemplate.generateDefaultMessage());
            dayButton.setCallbackData(callbackData);

            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(dayButton);
            keyboardRows.add(row);
        }

       // List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
       // keyboardRows.add(buttonsRow);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboardRows);
        return keyboardMarkup;
    }

    public static InlineKeyboardMarkup createLevelButtons(){
        InlineKeyboardButton level1Button = new InlineKeyboardButton("1");
        level1Button.setCallbackData("choose_level_1");

        InlineKeyboardButton level2Button = new InlineKeyboardButton("2");
        level2Button.setCallbackData("choose_level_2");

        InlineKeyboardButton level3Button = new InlineKeyboardButton("3");
        level3Button.setCallbackData("choose_level_3");

        InlineKeyboardButton level4Button = new InlineKeyboardButton("4");
        level4Button.setCallbackData("choose_level_4");

        InlineKeyboardButton level5Button = new InlineKeyboardButton("5");
        level5Button.setCallbackData("choose_level_5");

        List<InlineKeyboardButton> buttonsRow = new ArrayList<>();
        buttonsRow.add(level1Button);
        buttonsRow.add(level2Button);
        buttonsRow.add(level3Button);
        buttonsRow.add(level4Button);
        buttonsRow.add(level5Button);

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(buttonsRow);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboardRows);
        return keyboardMarkup;
    }
}
