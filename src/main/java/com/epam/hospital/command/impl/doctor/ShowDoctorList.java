package com.epam.hospital.command.impl.doctor;

import com.epam.hospital.command.Command;
import com.epam.hospital.reader.Reader;
import com.epam.hospital.service.DoctorService;
import com.epam.hospital.utils.DoctorComparator;
import com.epam.hospital.utils.IdEntityComparator;

import java.util.Comparator;

public class ShowDoctorList implements Command {
    @Override
    public void execute() {
        DoctorService doctorService = new DoctorService();
        System.out.println("1- by name \n2- by id");
        int choice = Reader.nextInt();
        Comparator comparable = new IdEntityComparator();
        if (choice == 1) {
            comparable = new DoctorComparator();
        }
        String list = doctorService.showDoctorsList(comparable);
        System.out.println(list);
    }
}
