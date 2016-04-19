package org.java0.measurement;

import org.java0.measurement.impl.unit.AngleUnitImpl;
import org.java0.measurement.impl.unit.EnergyUnitImpl;
import org.java0.measurement.impl.unit.ForceUnitImpl;
import org.java0.measurement.impl.unit.LengthUnitImpl;
import org.java0.measurement.impl.unit.MassUnitImpl;
import org.java0.measurement.impl.unit.NumericUnitImpl;
import org.java0.measurement.impl.unit.PowerUnitImpl;
import org.java0.measurement.impl.unit.TemperatureUnitImpl;
import org.java0.measurement.impl.unit.TimeUnitImpl;
import org.java0.measurement.unit.AngleUnit;
import org.java0.measurement.unit.AngularAccelerationUnit;
import org.java0.measurement.unit.AngularSpeedUnit;
import org.java0.measurement.unit.EnergyUnit;
import org.java0.measurement.unit.ForceUnit;
import org.java0.measurement.unit.LengthUnit;
import org.java0.measurement.unit.MassUnit;
import org.java0.measurement.unit.NumericUnit;
import org.java0.measurement.unit.PowerUnit;
import org.java0.measurement.unit.SpeedUnit;
import org.java0.measurement.unit.TemperatureUnit;
import org.java0.measurement.unit.TimeUnit;

public class Units {

    private Units() {
    };

    public static final NumericUnit NANO = new NumericUnitImpl("n", "nano", 0.0000000001d);
    public static final NumericUnit MICRO = new NumericUnitImpl("u", "micro", 0.0000001d);
    public static final NumericUnit MILLI = new NumericUnitImpl("m", "milli", 0.0001d);
    public static final NumericUnit ONE = new NumericUnitImpl("1", "1", 1d);
    public static final NumericUnit KILO = new NumericUnitImpl("k", "kilo", 1000d);

    /*
     * Angle units.
     */
    public static final AngleUnit DEGREES = new AngleUnitImpl("\u00B0", "Degree", Math.PI / 180);
    public static final AngleUnit RADIANS = new AngleUnitImpl("rad", "Radian");
    public static final AngleUnit REVOLUTIONS = new AngleUnitImpl("rev", "Revolution", Math.PI * 2);

    /*
     * Time units.
     */
    public static final TimeUnit SECONDS = new TimeUnitImpl("s", "second", java.util.concurrent.TimeUnit.SECONDS);
    public static final TimeUnit MINUTES = new TimeUnitImpl("min", "minute", java.util.concurrent.TimeUnit.MINUTES,
            60d);
    public static final TimeUnit HOURS = new TimeUnitImpl("hr", "hour", java.util.concurrent.TimeUnit.HOURS, 3600d);
    public static final TimeUnit DAYS = new TimeUnitImpl("dy", "day", java.util.concurrent.TimeUnit.DAYS, 86400d);
    public static final TimeUnit NANOSECONDS = NANO.multiply(SECONDS);
    public static final TimeUnit MICROSECONDS = MICRO.multiply(SECONDS);
    public static final TimeUnit MILLISECONDS = MILLI.multiply(SECONDS);

    /*
     * AngularSpeed units.
     */
    public static final AngularSpeedUnit DEGREES_PER_SECOND = DEGREES.divide(SECONDS);
    public static final AngularSpeedUnit DEGREES_PER_MILLISECOND = DEGREES.divide(MILLISECONDS);
    public static final AngularSpeedUnit RADIANS_PER_SECOND = RADIANS.divide(SECONDS);
    public static final AngularSpeedUnit RADIANS_PER_MILLISECOND = RADIANS.divide(MILLISECONDS);
    public static final AngularSpeedUnit REVOLUTIONS_PER_MINUTE = REVOLUTIONS.divide(MINUTES);

    /*
     * AngularAcceleration units.
     */
    public static final AngularAccelerationUnit DEGREES_PER_SECOND_PER_SECOND = DEGREES_PER_SECOND.divide(SECONDS);

    /*
     * Length units.
     */
    public static final LengthUnit METERS = new LengthUnitImpl("m", "meter");
    public static final LengthUnit MILES = new LengthUnitImpl("", "mile", 1609.344d);

    /*
     * Temperature units.
     */
    public static final TemperatureUnit FAHRENHEIT = new TemperatureUnitImpl("\u00B0F", "fahrenheit", 5d / 9d, 459.67d);
    public static final TemperatureUnit KELVIN = new TemperatureUnitImpl("\u00B0K", "kelvin");
    public static final TemperatureUnit CELCIUS = new TemperatureUnitImpl("\u00B0C", "celcius", 1d, 273.15d);

    public static final ForceUnit NEWTONS = new ForceUnitImpl("N", "newton");

    /*
     * Energy units.
     */
    public static final EnergyUnit JOULES = new EnergyUnitImpl("J", "joule");
    public static final EnergyUnit NEWTON_METERS = NEWTONS.multiply(METERS);

    /*
     * Power units.
     */
    public static final PowerUnit WATTS = new PowerUnitImpl("W", "watt");
    public static final PowerUnit MILLIWATTS = MILLI.multiply(WATTS);
    public static final PowerUnit KILOWATTS = KILO.multiply(WATTS);

    /*
     * Speed units.
     */
    public static final SpeedUnit MILES_PER_HOUR = MILES.divide(HOURS);
    public static final SpeedUnit METERS_PER_SECOND = METERS.divide(SECONDS);

    /*
     * Mass units.
     */
    public static final MassUnit GRAMS = new MassUnitImpl("g", "gram");
    public static final MassUnit KILOGRAMS = KILO.multiply(GRAMS);

}
