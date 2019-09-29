package com.epam.hospital.entity;

import com.epam.hospital.entity.curd.Doctors;
import com.epam.hospital.entity.curd.Patients;

import java.io.Serializable;
import java.util.Objects;

public class Hospital implements Serializable {
    private Doctors doctors;
    private Patients patients;

    public Hospital() {
    }

    public Hospital(Doctors doctors, Patients patients) {
        this.doctors = doctors;
        this.patients = patients;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(doctors, hospital.doctors) &&
                Objects.equals(patients, hospital.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctors, patients);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
