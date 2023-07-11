package com.padelapp.telegram.template.enums;

public enum GenderEnum {

    MIXTO("MIXTO", new String[]{"🚹", "🚺", "🚹", "🚺"}),
    INDIFERENTE("INDIFERENTE", new String[]{"🚹🚺", "🚺🚹", "🚹🚺", "🚺🚹"}),
    MASCULINO("MASCULINO", new String[]{"🚹", "🚹", "🚹", "🚹"}),
    FEMENINO("FEMENINO", new String[]{"🚺", "🚺", "🚺", "🚺"});

    private final String value;
    private final String[] emojis;

    GenderEnum(String value, String[] emojis) {
        this.value = value;
        this.emojis = emojis;
    }

    public String getValue() {
        return value;
    }

    public String[] getEmojis() {
        return emojis;
    }
}

