package com.epam.hospital.service;

import com.epam.hospital.entity.Entity;
import com.epam.hospital.entity.Patient;
import com.epam.hospital.entity.curd.Patients;
import com.epam.hospital.singelton.SingletonHospital;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatientService {
    private Patients patients;

    public PatientService() {
        patients = SingletonHospital.getInstance().getPatients();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public String showPatientsList(Comparator<Entity> comparator) {
        List<Patient> patientList = patients.getPatientList().stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        StringBuilder data = new StringBuilder();
        String line = "----------------------------------------------------------------------\n";
        data.append(line);
        data.append(String.format("%5s %25s %25s %10s %n", "id", "name", "last name", "tel"));
        data.append(line);
        for (Patient p : patientList) {
            data.append(String.format("%5s %25s %25s %10s %n",
                    p.getId(), p.getFirstName(), p.getLastName(), p.getPhoneNumber()));
        }
        data.append(line);
        return data.toString();
    }

    public boolean contains(int id) {
        Optional<Patient> patient = patients.getById(id);
        return patient.isPresent();
    }

    public void updateName(int id, String name) {
        Optional<Patient> optPatient = patients.getById(id);
        if (optPatient.isPresent()) {
            Patient patient = optPatient.get();
            patient.setFirstName(name);
        }
    }

    public void updateLastName(int id, String lastName) {
        Optional<Patient> optPatient = patients.getById(id);
        if (optPatient.isPresent()) {
            Patient patient = optPatient.get();
            patient.setLastName(lastName);
        }
    }

    public void updatePhone(int id, String phone) {
        Optional<Patient> optPatient = patients.getById(id);
        if (optPatient.isPresent()) {
            Patient patient = optPatient.get();
            patient.setPhoneNumber(phone);
        }
    }

    public void deletePatient(int id) {
        patients.deleteById(id);
    }
}