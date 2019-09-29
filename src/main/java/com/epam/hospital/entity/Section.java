package com.epam.hospital.entity;

import java.io.Serializable;

public enum Section implements Serializable {
    ACCIDENT("Accident"),
    ADMISSION("Admission"),
    BREAST("Breast"),
    CARDIOLOGY("Cardiology");

    private String sec;

    Section(String sec) {
        this.sec = sec;
    }

    public String getSec() {
        return sec;
    }
}
