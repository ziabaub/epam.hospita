package com.epam.hospital.utils;

public class DataValidator {

    private static final String WORD_REGEX = "[A-Za-z]+";
    private static final String PHONE_REGEX = "[0-9]{7}";

    private DataValidator() {
    }

    public static boolean checkWord(String word) {
        if (word == null){
            return false;
        }
        return word.matches(WORD_REGEX);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return phoneNumber.matches(PHONE_REGEX);
    }

}