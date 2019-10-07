package com.epam.hospital.command.impl;

import com.epam.hospital.command.Command;
import com.epam.hospital.command.CommandLines;

public class ShowCommandList implements Command {

    @Override
    public void execute() {
        CommandLines[] values = CommandLines.values();
        for (CommandLines o : values) {
            System.out.println(o.getMessage());
        }
    }
}
