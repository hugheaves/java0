package org.java0.measurement.unit;

import org.java0.measurement.Units;
import org.java0.measurement.quantity.Time;

public interface TimeUnit extends BaseUnit<Time> {

    public java.util.concurrent.TimeUnit convertFromTimeUnit();

    /**
     * Convert to time unit.
     * 
     * @param unit
     *            the unit
     * @return the time unit
     */
    public static TimeUnit convertToTimeUnit(final java.util.concurrent.TimeUnit unit) {
        switch (unit) {
        case DAYS:
            return Units.DAYS;
        case HOURS:
            return Units.HOURS;
        case MICROSECONDS:
            return Units.MICROSECONDS;
        case MILLISECONDS:
            return Units.MILLISECONDS;
        case MINUTES:
            return Units.MINUTES;
        case NANOSECONDS:
            return Units.NANOSECONDS;
        case SECONDS:
            return Units.SECONDS;
        default:
            return null;
        }

    }
}
