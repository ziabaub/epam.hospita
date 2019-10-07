package com.epam.hospital.command;

import com.epam.hospital.command.impl.patient.AddPatient;
import com.epam.hospital.command.impl.doctor.FireDoctor;
import com.epam.hospital.command.impl.doctor.HireDoctor;
import com.epam.hospital.command.impl.ShowCommandList;
import com.epam.hospital.command.impl.doctor.ShowDoctorList;
import com.epam.hospital.command.impl.doctor.UpdateDoctor;
import com.epam.hospital.command.impl.patient.DeletePatient;
import com.epam.hospital.command.impl.patient.ShowPatientsList;
import com.epam.hospital.command.impl.patient.UpdatePatient;

public class CommandFactory {

    public Command getCommand(int number) {
        switch (number) {
            case 1:
                return new AddPatient();
            case 2:
                return new DeletePatient();
            case 3:
                return new UpdatePatient();
            case 4:
                return new HireDoctor();
            case 5:
                return new FireDoctor();
            case 6:
                return new UpdateDoctor();
            case 7:
                return new ShowDoctorList();
            case 8:
                return new ShowPatientsList();
            default:
                return new ShowCommandList();
        }
    }
}
