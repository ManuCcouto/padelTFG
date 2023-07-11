package com.padelapp.telegram.template.forms;

import com.padelapp.telegram.template.enums.GenderEnum;
import com.padelapp.telegram.template.enums.SportEmojiEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageTemplate {


        private String day;
        private String time;
        private SportEmojiEnum sportEmoji;
        private String resourceName;
        private GenderEnum gender;
        private String level;
        private String status;
        private String annotation;
        private String shareCode;



        public String generateMessage() {
            StringBuilder message = new StringBuilder();

            message.append("📅 ").append(day).append("\n\n");
            message.append("⏰ ").append(time).append("\n\n");
            message.append(sportEmoji.getEmoji()).append(" ").append(resourceName).append("\n\n");
            message.append("🚻 ").append(gender.getValue()).append("\n\n");

            for (String genderEmoji : gender.getEmojis()) {
                message.append(genderEmoji).append("\n");
            }
            message.append("\n");

            if (!level.isEmpty()) {
                message.append("NIVEL: ").append(level).append("\n\n");
            }

            if (!status.isEmpty()) {
                message.append(status).append("\n");
            }

            if (!annotation.isEmpty()) {
                message.append("ANOTACIÓN: ").append(annotation).append("\n");
            }

            if (!shareCode.isEmpty()) {
                message.append("Código para compartir: ").append(shareCode).append("\n");
            }

            return message.toString();
        }

        public String generateDefaultMessage() {
            this.day = "HOY";
            this.time = "20.30h";
            this.resourceName = "";
            this.gender = GenderEnum.INDIFERENTE;
            this.sportEmoji= SportEmojiEnum.BASEBALL;
            this.level = "Lo marca el primer@ en anotarse";
            this.status = "";
            this.annotation = "";
            this.shareCode = "";
            return generateMessage();

        }

        public String generateCustomMessage(String day, String time, String resourceName, String level,
                                            String status, String annotation, String shareCode, GenderEnum gender, SportEmojiEnum sportEmoji) {
            this.day = day;
            this.time = time;
            this.resourceName = resourceName;
            this.level = level;
            this.status = status;
            this.gender= gender;
            this.annotation = annotation;
            this.shareCode = shareCode;
            this.sportEmoji= sportEmoji;
            return generateMessage();
        }
    }


