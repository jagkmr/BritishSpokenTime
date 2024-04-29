package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.interfaces.InputProcessor;
import org.example.interfaces.Publisher;
import org.example.interfaces.Validator;
import org.example.services.AbstractProcessor;
import org.example.services.BritishSpokenTimeProcessor;
import org.example.services.CommandLineInput;
import org.example.services.CommandLinePublisher;
import org.example.services.validator.TwelveHourTimeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Logger LOG = LoggerFactory.getLogger("Main.class");

    public static void main(String[] args) {

        // set log level
        try {
            Configurator.setRootLevel(Level.valueOf(System.getProperty("logLevel", "OFF")));
        }
        catch (IllegalArgumentException ex) {
            LOG.error("Invalid value passed for logLevel property, defaulting the logLevel to OFF");
            Configurator.setRootLevel(Level.valueOf("OFF"));
        }

        LOG.info("Starting main method");

        Validator<String> twelveHourTimeValidator = new TwelveHourTimeValidator();
        List<Publisher<String>> publishers = new ArrayList<>();

        Publisher<String> commandLinePublisher = new CommandLinePublisher();
        publishers.add(commandLinePublisher);

        // Get processor, add validator and publishers
        AbstractProcessor<String, String> processor = new BritishSpokenTimeProcessor(twelveHourTimeValidator, publishers);

        InputProcessor commandLineInput = new CommandLineInput();
        // start process
        commandLineInput.getInputAndProcess(processor);
    }
}