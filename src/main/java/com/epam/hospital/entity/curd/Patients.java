package com.epam.hospital.entity.curd;

import com.epam.hospital.entity.Patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Patients implements CRUD<Patient>, Serializable {
    private List<Patient> patients;

    public Patients() {
        patients = new ArrayList<>();
    }

    @Override
    public void add(Patient entity) {
        patients.add(entity);
    }

    @Override
    public Optional<Patient> getById(int id) {
        return patients.stream().
                filter(p-> p.getId()==id).
                findFirst();
    }

    @Override
    public Optional<Patient> getByName(String name) {
        return patients.stream().
                filter(p-> p.getFirstName().equals(name)).
                findFirst();
    }

    @Override
    public void update(int id, Patient entity) {
        patients = patients.stream().
                map(p -> (p.getId() == id) ? entity : p).
                collect(Collectors.toList());
    }

    @Override
    public void delete(Patient entity) {
        patients.removeIf(p -> p.equals(entity));
    }

    @Override
    public void deleteById(int id) {
        patients.removeIf(p -> p.getId() == id);
    }
}
