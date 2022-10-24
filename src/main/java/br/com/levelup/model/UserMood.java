package br.com.levelup.model;

public enum UserMood {

    ESTRESSADO("\uD83E\uDD2F"),
    PISTOLA("\uD83E\uDD2C"),
    FELIZ("\uD83D\uDE01"),
    OCUPADO("\uD83E\uDD10"),
    TRISTE("\uD83D\uDE2D"),
    FRIO("\uD83E\uDD76"),
    CALOR("\uD83E\uDD75"),
    TRANSCENDENDO("\uD83D\uDE07"),
    BADASS("\uD83D\uDE0E"),
    NEUTRO("\uD83D\uDE11");


    private final String value;

    UserMood(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}