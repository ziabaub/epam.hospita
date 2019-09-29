package com.epam.hospital.command;


import java.util.HashMap;
import java.util.Map;

public enum CommandType {

    ADD_DOCTOR(new AddDoctor()),
    ADD_PATIENT(new AddPatient());
    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCurrentCommand() {
        return command;
    }

    private static final Map<String, CommandType> lookup = new HashMap<>();

    static {
        for (CommandType env : CommandType.values()) {
            lookup.put(env.toString(), env);
        }
    }

    public static CommandType getCommand(String type) {
        return lookup.get(type);
    }
}
