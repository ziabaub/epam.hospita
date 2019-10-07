package com.epam.hospital.service;

import com.epam.hospital.entity.Doctor;
import com.epam.hospital.entity.Entity;
import com.epam.hospital.entity.curd.Doctors;
import com.epam.hospital.singelton.SingletonHospital;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DoctorService {
    private Doctors doctors;

    public DoctorService() {
        doctors = SingletonHospital.getInstance().getDoctors();
    }

    public void hireDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public String showDoctorsList(Comparator<Entity> comparator) {
        List<Doctor> patientList = doctors.getDoctorList().stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        StringBuilder data = new StringBuilder();
        String line = "-----------------------------------------------------------------------------------------------\n";
        data.append(line);
        data.append(String.format("%5s %25s %25s %25s %10s %n", "id", "name", "last name", "section", "tel"));
        data.append(line);
        for (Doctor d : patientList) {
            data.append(String.format("%5s %25s %25s %25s %10s %n",
                    d.getId(), d.getFirstName(), d.getLastName(), d.getSection(), d.getPhoneNumber()));
        }
        data.append(line);
        return data.toString();
    }

    public boolean contains(int id) {
        Optional<Doctor> doctor = doctors.getById(id);
        return doctor.isPresent();
    }

    public void updateName(int id, String name) {
        Optional<Doctor> optDoctor = doctors.getById(id);
        if (optDoctor.isPresent()) {
            Doctor doctor = optDoctor.get();
            doctor.setFirstName(name);
        }
    }

    public void updateLastName(int id, String lastName) {
        Optional<Doctor> optDoctor = doctors.getById(id);
        if (optDoctor.isPresent()) {
            Doctor doctor = optDoctor.get();
            doctor.setLastName(lastName);
        }
    }

    public void updateSection(int id, String section) {
        Optional<Doctor> optDoctor = doctors.getById(id);
        if (optDoctor.isPresent()) {
            Doctor doctor = optDoctor.get();
            doctor.setSection(section);
        }
    }

    public void updatePhone(int id, String phone) {
        Optional<Doctor> optDoctor = doctors.getById(id);
        if (optDoctor.isPresent()) {
            Doctor doctor = optDoctor.get();
            doctor.setPhoneNumber(phone);
        }
    }

    public void fireDoctor(int id) {
        doctors.deleteById(id);
    }
}