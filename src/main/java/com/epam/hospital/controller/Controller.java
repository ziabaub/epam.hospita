package com.epam.hospital.controller;

import com.epam.hospital.command.Command;
import com.epam.hospital.command.CommandFactory;
import com.epam.hospital.command.impl.ShowCommandList;
import com.epam.hospital.reader.Reader;


public class Controller {

    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        databaseLoader.load();
        Command start = new ShowCommandList();
        start.execute();
        int result = Reader.nextInt();
        CommandFactory commandFactory = new CommandFactory();
        while (result != 0) {
            Command command = commandFactory.getCommand(result);
            command.execute();
            System.out.println("next Command or 9 to show list of command ");
            result = Reader.nextInt();
        }
        databaseLoader.destroy();
    }

}
