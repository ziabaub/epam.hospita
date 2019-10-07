package com.epam.hospital.singelton;

public class IdGenerator {
    private static Integer id;

    private IdGenerator() {
    }

    public static Integer getNewId() {
        if (id == null){
            id = 100;
        }
        return ++id;
    }
    

}
