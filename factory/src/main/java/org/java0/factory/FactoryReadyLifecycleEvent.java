package org.java0.factory;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class FactoryReadyLifecycleEvent {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(FactoryReadyLifecycleEvent.class);

    private final Factory factory;

    public FactoryReadyLifecycleEvent(final Factory factory) {
        this.factory = factory;
    }

    public Factory getFactory() {
        return factory;
    }
}
