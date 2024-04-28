package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.interfaces.Publisher;
import org.example.services.*;
import org.example.services.validator.TwelveHourTimeValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configurator.setRootLevel(Level.valueOf(System.getProperty("logLevel", "OFF")));

        TwelveHourTimeValidator twelveHourTimeValidator = new TwelveHourTimeValidator();
        List<Publisher<String>> publishers = new ArrayList<>();

        Publisher<String> commandLinePublisher = new CommandLinePublisher();
        publishers.add(commandLinePublisher);


        AbstractProcessor<String, String> processor = new BritishSpokenTimeProcessor(twelveHourTimeValidator, publishers);
        CommandLineInput commandLineInput = new CommandLineInput();
        commandLineInput.getInputAndProcess(processor);
    }
}