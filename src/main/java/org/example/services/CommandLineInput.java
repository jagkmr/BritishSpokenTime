package org.example.services;

import org.apache.commons.lang3.StringUtils;
import org.example.interfaces.InputProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Command line input interface, fetches user input and forwards it to processor
 */
public class CommandLineInput implements InputProcessor {

    public void getInputAndProcess(AbstractProcessor processor) {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter the time in following format HH:MM (or) type exit");
            String input = buffReader.readLine();
            do {
                if ("exit".equalsIgnoreCase(input.trim())) {
                    return;
                }
                if (StringUtils.isNotEmpty(input.trim())) {
                    try {
                        processor.processInput(input.trim());
                    }
                    catch (Exception e) {
                        System.out.println("Exception occurred, please enter valid input in format HH:MM (or) type exit");
                    }
                }
                input = buffReader.readLine();
            } while (!"exit".equalsIgnoreCase(input.trim()));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
