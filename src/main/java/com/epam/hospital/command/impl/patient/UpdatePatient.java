package com.epam.hospital.command.impl.patient;

import com.epam.hospital.command.Command;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.PatientService;

public class UpdatePatient implements Command {
    @Override
    public void execute() {
        PatientService patientService = new PatientService();
        System.out.println("enter patient id ");
        int id = Reader.nextInt();
        if (!patientService.contains(id)) {
            System.out.println("id not available");
            return;
        }
        System.out.println(" 1- for name \n 2- for last name \n 3- for phone ");
        int choice = Reader.nextInt();
        switch (choice) {
            case 1:
                System.out.println("enter new name");
                String name = Reader.nextString();
                patientService.updateName(id, name);
                break;
            case 2:
                System.out.println("enter new last name");
                String lastName = Reader.nextString();
                patientService.updateLastName(id, lastName);
                break;
            case 3:
                System.out.println("enter new phone");
                String phone = Reader.nextString();
                patientService.updatePhone(id, phone);
                break;
            default:
                System.out.println("wrong choice");
        }
    }
}
