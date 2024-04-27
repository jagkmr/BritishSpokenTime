package org.example.services;

import org.example.interfaces.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPublisher<T, R> implements Publisher<R> {

    private final Logger LOG = LoggerFactory.getLogger(AbstractPublisher.class);

    public boolean publish(R output) {
        try {

            publish(output);

            return true;
        } catch (Exception e) {
            LOG.error("Exception occurred while publishing the results to one of the publisher", e);
            return false;
        }
    }
}
