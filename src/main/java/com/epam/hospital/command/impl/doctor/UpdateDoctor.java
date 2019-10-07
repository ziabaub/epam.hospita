package com.epam.hospital.command.impl.doctor;

import com.epam.hospital.command.Command;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.DoctorService;

public class UpdateDoctor implements Command {
    @Override
    public void execute() {
        DoctorService doctorService = new DoctorService();
        System.out.println("enter doctor id ");
        int id = Reader.nextInt();
        if (!doctorService.contains(id)) {
            System.out.println("id not available");
            return;
        }
        System.out.println(" 1- for name \n 2- for last name \n 3- section \n 4- for phone ");
        int choice = Reader.nextInt();
        switch (choice) {
            case 1:
                System.out.println("enter new name");
                String name = Reader.nextString();
                doctorService.updateName(id, name);
                break;
            case 2:
                System.out.println("enter new last name");
                String lastName = Reader.nextString();
                doctorService.updateLastName(id, lastName);
                break;
            case 3:
                System.out.println("enter new section");
                String section = Reader.nextString();
                doctorService.updateSection(id, section);
                break;
            case 4:
                System.out.println("enter new phone");
                String phone = Reader.nextString();
                doctorService.updatePhone(id, phone);
                break;
            default:
                System.out.println("wrong choice");
        }
    }
}
