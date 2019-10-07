package com.epam.hospital.utils;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    @Test
    public void checkWord() {
        String word = "ziad";

        boolean expected = DataValidator.checkWord(word);

        Assert.assertTrue(expected);
    }

    @Test
    public void checkPhoneNumber() {
        String number = "4722956";

        boolean expected = DataValidator.checkPhoneNumber(number);

        Assert.assertTrue(expected);
    }
}