package com.padelapp.telegram.template.enums;

public enum SportEmojiEnum {
    PADEL("🎾"),
    FOOTBOLEY("⚽️"),
    VOLLEYBALL("🏐"),
    BASEBALL("⚾️");


    private final String emoji;

    SportEmojiEnum(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}

