package com.epam.hospital.command.impl.doctor;

import com.epam.hospital.command.Command;
import com.epam.hospital.entity.Doctor;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.DoctorService;
import com.epam.hospital.utils.DataValidator;

public class HireDoctor implements Command {

    @Override
    public void execute() {
        DoctorService doctorService = new DoctorService();
        Doctor doctor = buildDoctor();
        if (doctor == null) return;
        doctorService.hireDoctor(doctor);
        System.out.println("Success");
    }

    private Doctor buildDoctor() {
        System.out.println("enter doctor name ");
        String name = Reader.nextString();
        if (isBadFormat(name)) return null;
        System.out.println("enter doctor last name ");
        String lastName = Reader.nextString();
        if (isBadFormat(lastName)) return null;
        System.out.println("enter section");
        String section = Reader.nextString();
        if (isBadFormat(section)) return null;
        System.out.println("enter phone number");
        String phoneNumber = Reader.nextString();
        boolean bool = DataValidator.checkPhoneNumber(phoneNumber);
        if (!bool) {
            System.out.println("wrong data [ " + phoneNumber + " ]");
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setLastName(lastName);
        doctor.setSection(section);
        doctor.setPhoneNumber(phoneNumber);
        return doctor;
    }

    private boolean isBadFormat(String name) {
        boolean isValid = DataValidator.checkWord(name);
        if (!isValid) {
            System.out.println("should not contains special character  [ " + name + " ]");
            return true;
        }
        return false;
    }
}
