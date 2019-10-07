package com.epam.hospital.command.impl.patient;

import com.epam.hospital.command.Command;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.utils.IdEntityComparator;
import com.epam.hospital.utils.PatientComparator;

import java.util.Comparator;

public class ShowPatientsList implements Command {
    @Override
    public void execute() {
        PatientService patientService = new PatientService();
        System.out.println("1- by name \n2- by id");
        int choice = Reader.nextInt();
        Comparator comparable = new IdEntityComparator();
        if (choice == 1) {
            comparable = new PatientComparator();
        }
        String list = patientService.showPatientsList(comparable);
        System.out.println(list);
    }
}
