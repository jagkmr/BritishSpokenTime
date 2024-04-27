package org.example.services;

import org.apache.commons.collections.CollectionUtils;
import org.example.interfaces.Publisher;
import org.example.interfaces.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CommandLineProcessor extends AbstractProcessor<String, String>{

    Validator<String> validator;
    List<Publisher<String>> publishers;

    public CommandLineProcessor(Validator<String> validator, List<Publisher<String>> publishers){
        this.validator = validator;
        this.publishers = publishers;
    }

    @Override
    public String getInput() {
        try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
            return buffReader.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validate(String input) { 
        return validator.validate(input);
    }

    @Override
    public String process(String input) {

        return null;
    }

    @Override
    public void postProcess(String output) {
        if (CollectionUtils.isNotEmpty(publishers)){
            publishers.forEach(publisher -> publisher.publish(output));
        }
    }
}
