/*
 * Copyright (C) 2015  Hugh Eaves
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
package org.java0.units.quantity;

import java.util.logging.Logger;

import org.java0.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericAmountTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(NumericAmountTest.class.getName());

    public static final double SMALL_AMOUNT = 0.00000000001;

    @Before
    public void before() {
        logger.info("Starting test");
    }

    @Test
    public void test0() {
        // final Angle a = QuantityFactory.getQuantity(Units.DEGREES, 360);
        // final Angle b = QuantityFactory.getQuantity(Units.RADIANS, 2 *
        // Math.PI);
        // final double result =
        // a.subtract(b).value(Units.DEGREES).doubleValue();
        // Assert.assertEquals(0.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test1() {
        // final Angle a = QuantityFactory.getQuantity(Units.DEGREES, 360);
        // final Angle b = QuantityFactory.getQuantity(Units.DEGREES, 360);
        // final double result = a.add(b).value(Units.DEGREES).doubleValue();
        // Assert.assertEquals(720.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test2() {
        // final Angle a = QuantityFactory.getQuantity(Units.DEGREES, 500);
        // final Angle b = QuantityFactory.getQuantity(Units.DEGREES, 1000);
        // final double result =
        // a.subtract(b).value(Units.DEGREES).doubleValue();
        // Assert.assertEquals(-500.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test3() {
        // final Angle a = QuantityFactory.getQuantity(Units.RADIANS, Math.PI *
        // 2);
        // final Angle b = QuantityFactory.getQuantity(Units.DEGREES, 1000);
        // final double result = a.add(b).value(Units.DEGREES).doubleValue();
        // Assert.assertEquals(1360.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test4() {
        // final Angle a = QuantityFactory.getQuantity(Units.RADIANS, Math.PI *
        // 2);
        // final Time b = QuantityFactory.getQuantity(Units.SECONDS, 60);
        // final QuantityQuotient<Angle, Time> quotient = a.divide(b);
        // final double result =
        // quotient.value(Units.DEGREES_PER_SECOND).doubleValue();
        // Assert.assertEquals(6.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test5() {
        // final Angle a = QuantityFactory.getQuantity(Units.RADIANS, Math.PI *
        // 2);
        // final Time b = QuantityFactory.getQuantity(Units.SECONDS, 60);
        // final AngularSpeed quotient = a.divide(b);
        // final double result =
        // quotient.value(Units.DEGREES_PER_SECOND).doubleValue();
        // Assert.assertEquals(6.0, result, SMALL_AMOUNT);
    }

    @Test
    public void test6() {
        // final Angle a = QuantityFactory.getQuantity(Units.DEGREES, 600);
        // final Time b = QuantityFactory.getQuantity(Units.SECONDS, 2.5);
        // final AngularSpeed quotient = a.divide(b);
        // final double result =
        // quotient.value(Units.RADIANS_PER_SECOND).doubleValue();
        // Assert.assertEquals((Math.PI * 2.0 * 2.0 / 3.0), result,
        // SMALL_AMOUNT);
    }

    @Test
    public void test7() {
        // final Angle a = QuantityFactory.getQuantity(Units.DEGREES, 600);
        // final Time b = QuantityFactory.getQuantity(Units.MILLISECONDS, 2500);
        // final AngularSpeed quotient = a.divide(b);
        // final double result =
        // quotient.value(Units.RADIANS_PER_MILLISECOND).doubleValue();
        // Assert.assertEquals((Math.PI * 2.0 * 2.0 / 3.0), result,
        // SMALL_AMOUNT);
    }

    @Test
    public void test8() {
        // final Angle a = QuantityFactory.getQuantity(Units.RADIANS, Math.PI *
        // 2);
        // final Time b = QuantityFactory.getQuantity(Units.SECONDS, 10);
        // final QuantityQuotient<Time, Angle> resultQuotient = b.divide(a);
        // final double result = resultQuotient.value().doubleValue();
        // Assert.assertEquals(10 / (Math.PI * 2), result, SMALL_AMOUNT);
    }

    @Test
    public void test9() {
        // final Angle a = QuantityFactory.getQuantity(Units.RADIANS, Math.PI *
        // 2);
        // final Time b = QuantityFactory.getQuantity(Units.SECONDS, 10);
        // final QuantityQuotient<Time, Angle> resultQuotient = b.divide(a);
        // final double result =
        // resultQuotient.value(Units.MILLISECONDS.divide(Units.DEGREES)).doubleValue();
        // Assert.assertEquals(10000.0 / 360, result, SMALL_AMOUNT);
    }

    @Test
    public void tesT00() {
        // final Angle a = QuantityFactory.getQuantity(Units.RADIANS, Math.PI *
        // 2);
        // final Time b = QuantityFactory.getQuantity(Units.SECONDS, 10);
        // final QuantityProduct<Angle, Time> product = a.multiply(b);
        // final double result = product.value().doubleValue();
        // Assert.assertEquals(Math.PI * 2 * 10, result, SMALL_AMOUNT);
    }

}
