package com.epam.hospital.command.impl.doctor;

import com.epam.hospital.command.Command;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.DoctorService;

public class FireDoctor implements Command {
    @Override
    public void execute() {
        DoctorService doctorService = new DoctorService();
        System.out.println("enter id of doctor");
        int id = Reader.nextInt();
        if (!doctorService.contains(id)){
            System.out.println("id not available");
            return;
        }
        doctorService.fireDoctor(id);
    }
}
