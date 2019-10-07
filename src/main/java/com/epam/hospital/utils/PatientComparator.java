package com.epam.hospital.utils;

import com.epam.hospital.entity.Patient;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {


    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
