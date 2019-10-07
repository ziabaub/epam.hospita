package com.epam.hospital.singelton;

import com.epam.hospital.entity.Hospital;
import com.epam.hospital.entity.curd.Doctors;
import com.epam.hospital.entity.curd.Patients;

public class SingletonHospital {

    private SingletonHospital() {
    }

    private static Hospital hospital;

    public static Hospital getInstance() {
        if (hospital == null) {
            Doctors doctors = new Doctors();
            Patients patients = new Patients();
            hospital = new Hospital(doctors, patients);
        }
        return hospital;
    }

    public static void init(Hospital h) {
        if (hospital != null) {
            return;
        }
        hospital = h;
        if (hospital.getDoctors() == null) {
            hospital.setDoctors(new Doctors());
        }
        if (hospital.getPatients() == null) {
            hospital.setPatients(new Patients());
        }

    }
}

