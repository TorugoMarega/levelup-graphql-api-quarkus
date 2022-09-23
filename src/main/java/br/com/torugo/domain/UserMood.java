package br.com.torugo.domain;

public enum UserMood {

    ESTRESSADO("Estressado!" + "\uD83E\uDD2F"),
    FELIZ("Feliz!" + "\uD83D\uDE01"),
    OCUPADO("Ocupado!" + "\uD83E\uDD10"),
    TRISTE("Triste!" + "\uD83D\uDE2D"),
    FRIO("Congelando!" + "\uD83E\uDD76"),
    CALOR("Derretendo!" + "\uD83E\uDD75"),
    TRANSCENDENDO("Atingi o nirvana!" + "\uD83D\uDE07"),
    BADASS("O brabo!" + "\uD83D\uDE0E"),
    NEUTRO("Neutro!" + "\uD83D\uDE11");


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