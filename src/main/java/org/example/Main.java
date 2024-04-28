package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.interfaces.Publisher;
import org.example.services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configurator.setRootLevel(Level.DEBUG);

        TwelveHourTimeValidator twelveHourTimeValidator = new TwelveHourTimeValidator();
        List<Publisher<String>> publishers = new ArrayList<>();

        Publisher<String> commandLinePublisher = new CommandLinePublisher();
        publishers.add(commandLinePublisher);


        AbstractProcessor<String, String> processor = new BritishSpokenTimeProcessor(twelveHourTimeValidator, publishers);
        CommandLineInput commandLineInput = new CommandLineInput();
        commandLineInput.getInputAndProcess(processor);
    }
}