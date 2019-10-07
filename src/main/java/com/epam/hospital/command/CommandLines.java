package com.epam.hospital.command;

public enum CommandLines {
    ONE("1 - add patients "),
    TWO("2 - delete patients by id "),
    TREE("3 - update patients by id "),
    FOUR("4 - add Doctor "),
    FIVE("5 - delete Doctor by id "),
    SIX("6 - update Doctor by id "),
    SEVEN("7 - show Doctors "),
    EIGHT("8 - show Patients "),
    NINE("9 - Show List of command "),
    ZERO("0 - exit");

    private String message;

    CommandLines(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
