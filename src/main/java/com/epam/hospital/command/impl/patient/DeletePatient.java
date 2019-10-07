package com.epam.hospital.command.impl.patient;

import com.epam.hospital.command.Command;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.PatientService;

public class DeletePatient implements Command {
    @Override
    public void execute() {
        PatientService patientService = new PatientService();
        System.out.println("enter id of patient");
        int id = Reader.nextInt();
        if (!patientService.contains(id)){
            System.out.println("id not available");
            return;
        }
        patientService.deletePatient(id);
    }
}
