package org.example.interfaces;

public interface Processor<T,R> {

    boolean validate(T input);
    R process(T input);
    void postProcess(R output);
}
