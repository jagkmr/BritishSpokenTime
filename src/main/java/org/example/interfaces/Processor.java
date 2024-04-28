package org.example.interfaces;

/**
 * Processor interface which defines the basic steps needed to process an input "<B>T</B>" to produce output "<B>R</B>"
 *
 * @param <T>
 * @param <R>
 */
public interface Processor<T, R> {
    boolean validate(T input);

    R process(T input);

    void postProcess(R output);
}
