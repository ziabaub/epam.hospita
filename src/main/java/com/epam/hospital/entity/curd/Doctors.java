package com.epam.hospital.entity.curd;

import com.epam.hospital.entity.Doctor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Doctors implements CRUD<Doctor>, Serializable {
    private List<Doctor> doctorList;

    public Doctors() {
        doctorList = new ArrayList<>();
    }


    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    @Override
    public void add(Doctor entity) {
        doctorList.add(entity);
    }

    @Override
    public Optional<Doctor> getById(int id) {
        return doctorList.stream()
                .filter(d -> d.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Doctor> getByName(String name) {
        return doctorList.stream()
                .filter(d -> d.getFirstName().equals(name))
                .findFirst();
    }

    @Override
    public void update(int id, Doctor entity) {
        doctorList = doctorList.stream().
                map(d -> (d.getId() == id) ? entity : d).
                collect(Collectors.toList());
    }

    @Override
    public void delete(Doctor entity) {
        doctorList.removeIf(d -> d.equals(entity));
    }

    @Override
    public void deleteById(int id) {
        doctorList.removeIf(d -> d.getId() == id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctors doctors1 = (Doctors) o;
        return Objects.equals(doctorList, doctors1.doctorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorList);
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctors=" + doctorList +
                '}';
    }
}
