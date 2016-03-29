package org.java0.util;

import org.java0.core.type.AbstractNamedObject;
import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class Progress extends AbstractNamedObject {
    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(Progress.class);
    private static final Level DEFAULT_LEVEL = Level.DEBUG;
    private static final String DEFAULT_NAME = "Progress";
    private static final long DEFAULT_INTERVAL = 10000;

    /** The Constant logger. */
    private final Logger logger;
    /** The level. */
    private final Level level;

    private final long interval;

    private long startTime = 0;

    private long eventCount = 0;

    private long countThreshold = 0;

    private long totalEvents = 0;

    private long expectedEvents = 0;

    public Progress() {
        this(DEFAULT_NAME, DEFAULT_INTERVAL, DEFAULT_LEVEL, DEFAULT_LOGGER);
    }

    public Progress(final Level level) {
        this(DEFAULT_NAME, DEFAULT_INTERVAL, level, DEFAULT_LOGGER);
    }

    public Progress(final Level level, final Logger logger) {
        this(DEFAULT_NAME, DEFAULT_INTERVAL, level, logger);
    }

    public Progress(final long interval, final Level level, final Logger logger) {
        this(DEFAULT_NAME, interval, level, logger);
    }

    public Progress(final String name, final long interval, final Level level, final Logger logger) {
        super(name);
        this.logger = logger;
        this.level = level;
        this.interval = interval;
    }

    public void mark() {
        if (++eventCount > countThreshold) {
            final long currentTime = System.currentTimeMillis();
            totalEvents += eventCount;
            eventCount = 0;

            if (startTime == 0) {
                startTime = currentTime;
                logger.log(level, "{}: Starting", name);
            } else {
                final long elapsedTime = currentTime - startTime;
                if (elapsedTime < interval / 2) {
                    countThreshold = (long) (totalEvents * 1.5);
                } else {
                    final double timePerEvent = (double) elapsedTime / (double) totalEvents;
                    if (timePerEvent > 0) {
                        countThreshold = (long) (interval / timePerEvent);
                    }
                    if (expectedEvents != 0) {
                        logger.log(level, "{}: processed {}%", name,
                                Math.round((double) totalEvents * 1000 / expectedEvents) / 10);
                    } else {
                        logger.log(level, "{}: processed {}", name, totalEvents);
                    }
                }
            }
        }
    }

    public void reset(final int expectedEvents) {
        this.expectedEvents = expectedEvents;
        startTime = 0;
        eventCount = 0;
        countThreshold = 0;
        totalEvents = 0;
    }

    public void reset() {
        reset(0);
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

}
