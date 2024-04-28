package org.example.services;

import org.example.interfaces.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Publishes the output to commandLine
 */
public class CommandLinePublisher implements Publisher<String> {
    Logger LOG = LoggerFactory.getLogger(CommandLineInput.class);

    @Override
    public boolean publish(String output) {
        LOG.info("publishing output -> " + output);
        System.out.println(output);
        return true;
    }
}
