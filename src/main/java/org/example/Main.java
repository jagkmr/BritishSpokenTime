package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.interfaces.Publisher;
import org.example.services.AbstractProcessor;
import org.example.services.BritishSpokenTimeProcessor;
import org.example.services.CommandLineInput;
import org.example.services.CommandLinePublisher;
import org.example.services.validator.TwelveHourTimeValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // set log level
        Configurator.setRootLevel(Level.valueOf(System.getProperty("logLevel", "OFF")));

        TwelveHourTimeValidator twelveHourTimeValidator = new TwelveHourTimeValidator();
        List<Publisher<String>> publishers = new ArrayList<>();

        Publisher<String> commandLinePublisher = new CommandLinePublisher();
        publishers.add(commandLinePublisher);

        // Get processor, add validator and publishers
        AbstractProcessor<String, String> processor = new BritishSpokenTimeProcessor(twelveHourTimeValidator, publishers);

        CommandLineInput commandLineInput = new CommandLineInput();
        // start process
        commandLineInput.getInputAndProcess(processor);
    }
}