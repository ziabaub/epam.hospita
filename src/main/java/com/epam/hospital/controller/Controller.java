package com.epam.hospital.controller;

import com.epam.hospital.command.Command;
import com.epam.hospital.command.CommandFactory;
import com.epam.hospital.reader.Reader;
import org.apache.log4j.Logger;

public class Controller {
    private static final Logger logger = Logger.getLogger(Controller.class);

    public static void main(String[] args) {
        printOrders();
        int result = Reader.nextInt();
        CommandFactory commandFactory = new CommandFactory();

        try {
            while (result != 0) {
                printOrders();
                Command command = commandFactory.getCommand(result);
                command.execute();
                result = Reader.nextInt();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private static void printOrders() {
        Orders[] values = Orders.values();
        for (Orders o : values) {
            System.out.println(o.getMessage());
        }
    }
}
