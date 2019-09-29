package com.epam.hospital.command;

import com.epam.hospital.exception.CommandException;


public class CommandFactory {

    public Command getCommand(int number) throws CommandException {
        try {
            String commandNumber = convertToText(number);
            String commandTypeValue = commandNumber.toUpperCase();
            CommandType currentType = CommandType.getCommand(commandTypeValue);
            return currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            throw new CommandException("can't find Command", e);
        }
    }

    private String convertToText(int number) {
        String result ="";
        switch (number){
            case 1:
                result ="add_patient";
                break;
            case 2:
                result ="delete_patient_by_id";
                break;
            case 3:
                result ="delete_patient_by_name";
                break;
            case 4:
                result ="update_patient_by_id";
                break;
            case 5:
                result ="add_doctor";
                break;
            case 6:
                result ="delete_doctor_by_id";
                break;
            case 7:
                result ="delete_doctor_by_name";
                break;
            case 8:
                result ="update_doctor_by_id";
                break;
            case 9:
                result ="show_doctors";
                break;
            case 10:
                result ="show_patients";
                break;
            case 0:
                result ="exit";
                break;
        }
        return result;
    }
}
