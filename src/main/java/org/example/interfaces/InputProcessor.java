package org.example.interfaces;

import org.example.services.AbstractProcessor;

/**
 * Interface to fetch input and process the input to a processor.
 */
public interface InputProcessor {
    void getInputAndProcess(AbstractProcessor processor);
}
