package com.epam.hospital.entity.curd;

import com.epam.hospital.entity.Doctor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Doctors implements CRUD<Doctor> , Serializable {
    private List<Doctor> doctors;

    public Doctors() {
        doctors = new ArrayList<>();
    }

    @Override
    public void add(Doctor entity) {
        doctors.add(entity);
    }

    @Override
    public Optional<Doctor> getById(int id) {
        return doctors.stream()
                .filter(d -> d.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Doctor> getByName(String name) {
        return doctors.stream()
                .filter(d -> d.getFirstName().equals(name))
                .findFirst();
    }

    @Override
    public void update(int id, Doctor entity) {
        doctors = doctors.stream().
                map(d -> (d.getId() == id) ? entity : d).
                collect(Collectors.toList());
    }

    @Override
    public void delete(Doctor entity) {
        doctors.removeIf(d -> d.equals(entity));
    }

    @Override
    public void deleteById(int id) {
        doctors.removeIf(d -> d.getId() == id);
    }
}
