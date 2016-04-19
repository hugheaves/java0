package org.java0.measurement.unit;

import org.java0.measurement.quantity.Speed;

public interface SpeedUnit extends BaseUnit<Speed> {
    AccelerationUnit divide(TimeUnit unit);
}
