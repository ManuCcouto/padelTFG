package com.padelapp.telegram.template.enums;

public enum BookingStatusEnum {

    CLOSED("CERRADO", "🔒"),
    PREBOOKING("PRE-RESERVA", "📅"),
    CANCELED("CANCELADO", "❌"),
    BLOCKED("BLOQUEADO", "🚫"),
    OWNER("PROPIETARIO", "👑");


    private final String description;
    private final String emoji;

    BookingStatusEnum(String description, String emoji) {
        this.description = description;
        this.emoji = emoji;
    }

    public String getDescription() {
        return description;
    }

    public String getEmoji() {
        return emoji;
    }

}
