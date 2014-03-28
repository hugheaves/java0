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

import org.java0.quantity.angle.Angle;
import org.java0.unit.angle.DegreesUnit;
import org.java0.unit.angle.RadiansUnit;
import org.junit.Assert;
import org.junit.Test;

public class AngleTest {
    public static final double SMALL_AMOUNT = 0.00000000001;

    @Test
    public void test1() {
        Angle a = new Angle(360, DegreesUnit.INSTANCE);
        double b = a.value(DegreesUnit.INSTANCE).doubleValue();
        Assert.assertEquals(360.0, b, SMALL_AMOUNT);
    }

    @Test
    public void test2() {
        Angle a = new Angle(360, DegreesUnit.INSTANCE);
        double b = a.value(RadiansUnit.INSTANCE).doubleValue();
        Assert.assertEquals(Math.PI * 2, b, SMALL_AMOUNT);
    }

    @Test
    public void test3() {
        Angle a = new Angle(Math.PI * 4, RadiansUnit.INSTANCE);
        double b = a.value(DegreesUnit.INSTANCE).doubleValue();
        Assert.assertEquals(720.0, b, SMALL_AMOUNT);
    }
}
