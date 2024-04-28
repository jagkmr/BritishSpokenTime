package org.example.interfaces;

/**
 * Publisher interface to publish output "<B>R</B>"
 *
 * @param <R>
 */
public interface Publisher<R> {
    boolean publish(R output);
}
