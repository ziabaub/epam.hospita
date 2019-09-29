package com.epam.hospital.controller;

public enum Orders {
    ONE("1 - add patients"),
    TWO("2 - delete patients by id "),
    TREE("3 - delete patients by name"),
    FOUR("4 - update patients by id"),
    FIVE("5 - add Doctor"),
    SIX("6 - delete Doctor by id  "),
    SEVEN("7 - delete Doctor by name "),
    EIGHT("8 - update Doctor by id  "),
    NINE("9 - show Doctors "),
    TEN("10 - show Patients "),
    ELEVEN("11 - Show List of order "),
    zero("0 - exit");

    private String message;

    Orders(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
