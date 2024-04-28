package org.example.services;

import org.example.exceptions.ValidationException;
import org.example.interfaces.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractProcessor<T, R> implements Processor<T, R> {

    private final Logger LOG = LoggerFactory.getLogger(AbstractProcessor.class);

    public void processInput(T input){
        boolean isValid = validate(input);
        if (!isValid){
            // throw exception
            LOG.error("Received invalid input=" + input);
            throw new ValidationException(input + " is invalid");
        }
        postProcess(process(input));
    }
}
