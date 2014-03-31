/*
 * Copyright (C) 2014  Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.java0.quantity;

import java.util.logging.Logger;

import org.java0.quantity.angle.Angle;
import org.java0.quantity.angularvelocity.AngularVelocity;
import org.java0.quantity.time.Time;
import org.java0.test.BaseTest;
import org.java0.unit.angle.AngleUnit;
import org.java0.unit.angle.DegreesUnit;
import org.java0.unit.angle.RadiansUnit;
import org.java0.unit.angularvelocity.DegreesPerSecondUnit;
import org.java0.unit.angularvelocity.RadiansPerSecondUnit;
import org.java0.unit.impl.UnitQuotientImpl;
import org.java0.unit.time.MillisecondsUnit;
import org.java0.unit.time.SecondsUnit;
import org.java0.unit.time.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericAmountTest extends BaseTest {
    private static final Logger logger = Logger
            .getLogger(NumericAmountTest.class.getName());

    public static final double SMALL_AMOUNT = 0.00000000001;

    @Before
    public void before() {
        logger.info("Starting test");
    }

    @Test
    public void test0() {
        Angle a = new Angle(360, DegreesUnit.INSTANCE);
        Angle b = new Angle(2 * Math.PI, RadiansUnit.INSTANCE);
        double result = a.subtract(b).value(DegreesUnit.INSTANCE).doubleValue();
        Assert.assertEquals(0.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test1() {
        Angle a = new Angle(360, DegreesUnit.INSTANCE);
        Angle b = new Angle(360, DegreesUnit.INSTANCE);
        double result = a.add(b).value(DegreesUnit.INSTANCE).doubleValue();
        Assert.assertEquals(720.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test2() {
        Angle a = new Angle(500, DegreesUnit.INSTANCE);
        Angle b = new Angle(1000, DegreesUnit.INSTANCE);
        double result = a.subtract(b).value(DegreesUnit.INSTANCE).doubleValue();
        Assert.assertEquals(-500.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test3() {
        Angle a = new Angle(Math.PI * 2, RadiansUnit.INSTANCE);
        Angle b = new Angle(1000, DegreesUnit.INSTANCE);
        double result = a.add(b).value(DegreesUnit.INSTANCE).doubleValue();
        Assert.assertEquals(1360.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test4() {
        Angle a = new Angle(Math.PI * 2, RadiansUnit.INSTANCE);
        Time b = new Time(60, SecondsUnit.INSTANCE);
        QuantityQuotient<AngleUnit, TimeUnit> quotient = a.divide(b);
        double result = quotient.value(DegreesPerSecondUnit.INSTANCE)
                .doubleValue();
        Assert.assertEquals(6.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test5() {
        Angle a = new Angle(Math.PI * 2, RadiansUnit.INSTANCE);
        Time b = new Time(60, SecondsUnit.INSTANCE);
        AngularVelocity quotient = new AngularVelocity(a.divide(b));
        double result = quotient.value(DegreesPerSecondUnit.INSTANCE)
                .doubleValue();
        Assert.assertEquals(6.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test6() {
        Angle a = new Angle(600, DegreesUnit.INSTANCE);
        Time b = new Time(2.5, SecondsUnit.INSTANCE);
        AngularVelocity quotient = new AngularVelocity(a.divide(b));
        double result = quotient.value(RadiansPerSecondUnit.INSTANCE)
                .doubleValue();
        Assert.assertEquals((Math.PI * 2.0 * 2.0 / 3.0), result, SMALL_AMOUNT);
    }

    @Test
    public void test7() {
        Angle a = new Angle(600, DegreesUnit.INSTANCE);
        Time b = new Time(2500, MillisecondsUnit.INSTANCE);
        AngularVelocity quotient = new AngularVelocity(a.divide(b));
        double result = quotient.value(RadiansPerSecondUnit.INSTANCE)
                .doubleValue();
        Assert.assertEquals((Math.PI * 2.0 * 2.0 / 3.0), result, SMALL_AMOUNT);
    }

    @Test
    public void test8() {
        Angle a = new Angle(Math.PI * 2, RadiansUnit.INSTANCE);
        Time b = new Time(10, SecondsUnit.INSTANCE);
        QuantityQuotient<TimeUnit, AngleUnit> quotient = b.divide(a);
        double result = quotient.value(
                new UnitQuotientImpl<TimeUnit, AngleUnit>(
                        SecondsUnit.INSTANCE, RadiansUnit.INSTANCE))
                .doubleValue();
        Assert.assertEquals(10 / (Math.PI * 2), result, SMALL_AMOUNT);
    }

    @Test
    public void test9() {
        Angle a = new Angle(Math.PI * 2, RadiansUnit.INSTANCE);
        Time b = new Time(10, SecondsUnit.INSTANCE);
        QuantityQuotient<TimeUnit, AngleUnit> quotient = b.divide(a);
        double result = quotient.value(
                new UnitQuotientImpl<TimeUnit, AngleUnit>(
                        MillisecondsUnit.INSTANCE, DegreesUnit.INSTANCE))
                .doubleValue();
        Assert.assertEquals(10000.0 / 360, result, SMALL_AMOUNT);
    }

}
