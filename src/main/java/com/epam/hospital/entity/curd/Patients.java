package com.epam.hospital.entity.curd;

import com.epam.hospital.entity.Patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Patients implements CRUD<Patient>, Serializable {
    private List<Patient> patientList;

    public Patients() {
        patientList = new ArrayList<>();
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    @Override
    public void add(Patient entity) {
        patientList.add(entity);
    }

    @Override
    public Optional<Patient> getById(int id) {
        return patientList.stream().
                filter(p -> p.getId() == id).
                findFirst();
    }

    @Override
    public Optional<Patient> getByName(String name) {
        return patientList.stream().
                filter(p -> p.getFirstName().equals(name)).
                findFirst();
    }

    @Override
    public void update(int id, Patient entity) {
        patientList = patientList.stream().
                map(p -> (p.getId() == id) ? entity : p).
                collect(Collectors.toList());
    }

    @Override
    public void delete(Patient entity) {
        patientList.removeIf(p -> p.equals(entity));
    }

    @Override
    public void deleteById(int id) {
        patientList.removeIf(p -> p.getId() == id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients1 = (Patients) o;
        return Objects.equals(patientList, patients1.patientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientList);
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patients=" + patientList +
                '}';
    }
}
