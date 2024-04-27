package org.example.interfaces;

public interface Processor<T,R> {
    T getInput();
    boolean validate(T input);
    R process(T input);
    void postProcess(R output);
}
