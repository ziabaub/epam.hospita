package com.epam.hospital.singelton;

public class IdGenerator {
    private static int id;

    private IdGenerator() {
    }

    public static int getNewId() {
        return ++id;
    }

}
