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
package org.java0.units.unit;

import java.util.logging.Logger;

import org.java0.test.BaseTest;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class NumericUnitTest extends BaseTest {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(NumericUnitTest.class.getName());

    @Test
    public void test1() {

        // final AngularSpeedUnit b = Units.DEGREES.divide(Units.SECONDS);
        //
        // final AngularAccelerationUnit c = b.divide(Units.SECONDS);
        //
        // final TimeUnit d = c.divide(Units.DEGREES_PER_MILLISECOND);
        //
        // final AngularSpeedUnit u1 = Units.DEGREES.divide(Units.SECONDS);
        //
        // final AngularAccelerationUnit u2 = u1.divide(Units.SECONDS);
        //
        // @SuppressWarnings("unused")
        // final Unit u3 = u2.multiply(Units.DEGREES);
        //
        // @SuppressWarnings("unused")
        // final Unit velocitySquaredUnit =
        // Units.DEGREES.divide(Units.SECONDS).divide(Units.SECONDS)
        // .multiply(Units.DEGREES);

    }
}
