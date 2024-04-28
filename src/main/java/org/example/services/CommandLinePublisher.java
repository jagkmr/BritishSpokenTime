package org.example.services;

import org.example.interfaces.Publisher;

public class CommandLinePublisher implements Publisher<String> {
    @Override
    public boolean publish(String output) {
        System.out.println(output);
        return true;
    }
}
