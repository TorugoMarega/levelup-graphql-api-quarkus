package br.com.levelup.model;

public enum Role {

    ADMIN("Administrador"),
    APPRENTICE("Aprendiz");


    private String value;

    void UserRole(String value) {
        this.value = value;
    }

    Role(String value) {
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