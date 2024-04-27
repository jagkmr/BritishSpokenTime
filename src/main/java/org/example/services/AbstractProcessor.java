package org.example.services;

import org.example.exceptions.ValidationException;
import org.example.interfaces.Processor;
import org.example.interfaces.Publisher;
import org.example.interfaces.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class AbstractProcessor<T, R> implements Processor<T, R> {

    private final Logger LOG = LoggerFactory.getLogger(AbstractProcessor.class);

    public void startProcess(){
        T input = getInput();
        boolean isValid = validate(input);
        if (!isValid){
            // throw exception
            LOG.error("Received invalid input=" + input);
            throw new ValidationException(input + " is invalid");
        }
        postProcess(process(input));
    }
}
