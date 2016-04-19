package org.java0.util;

import java.util.Random;

import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.junit.Test;

public class ProgressTest {
    private static final Logger logger = LoggerFactory.getLogger(ProgressTest.class);

    public Random random = new Random(0);

    public static final int NUM_EVENTS = 150;
    public static final int LOG_INTERVAL = 200;

    @Test
    public void test1() {
        logger.error("starting");
        final int interval = 15;
        final int jitter = 5;
        final Progress progress = new Progress(200, Level.INFO);
        progress.reset(NUM_EVENTS);
        for (int i = 0; i < NUM_EVENTS; ++i) {
            progress.mark();
            try {
                final double sleepTime = interval + jitter - (random.nextDouble() * 2 * jitter);
                Thread.sleep(Math.round(sleepTime));
            } catch (final InterruptedException e) {
                logger.error("Caught exception in auto-generated catch block", e);
            }
        }
    }
}
