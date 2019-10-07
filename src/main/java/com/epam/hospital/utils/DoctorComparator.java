package com.epam.hospital.utils;

import com.epam.hospital.entity.Doctor;

import java.util.Comparator;

public class DoctorComparator implements Comparator<Doctor> {


    @Override
    public int compare(Doctor o1, Doctor o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
