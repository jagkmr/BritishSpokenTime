package org.example.interfaces;

/**
 * Validator interface to validate input "<B>T</B>"
 *
 * @param <T>
 */
public interface Validator<T> {
    boolean validate(T input);
}
