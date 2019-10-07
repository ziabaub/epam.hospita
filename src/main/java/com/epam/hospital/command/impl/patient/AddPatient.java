package com.epam.hospital.command.impl.patient;

import com.epam.hospital.command.Command;
import com.epam.hospital.entity.Patient;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.utils.DataValidator;

public class AddPatient implements Command {

    @Override
    public void execute() {
        PatientService patientService = new PatientService();
        Patient patient = buildPatient();
        if (patient == null) return;
        patientService.addPatient(patient);
        System.out.println("Success");
    }

    private Patient buildPatient() {
        System.out.println("enter patient name ");
        String name = Reader.nextString();
        if (isBadFormat(name)) return null;
        System.out.println("enter patient last name ");
        String lastName = Reader.nextString();
        if (isBadFormat(lastName)) return null;
        System.out.println("enter phone number");
        String phoneNumber = Reader.nextString();
        boolean bool = DataValidator.checkPhoneNumber(phoneNumber);
        if (!bool) {
            System.out.println("wrong data [ " + phoneNumber + " ]");
            return null;
        }
        Patient patient = new Patient();
        patient.setFirstName(name);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phoneNumber);
        return patient;
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
