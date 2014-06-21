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

import org.java0.amount.angularvelocity.AngularVelocityAmount;
import org.java0.unit.angularvelocity.DegreesPerMillisecondUnit;
import org.java0.unit.angularvelocity.DegreesPerSecondUnit;
import org.java0.unit.angularvelocity.RadiansPerSecondUnit;
import org.junit.Assert;
import org.junit.Test;

public class AngularVelocityTest {
    public static final double SMALL_AMOUNT = 0.00000000001;

    @Test
    public void test1() {
        AngularVelocityAmount a = new AngularVelocityAmount(45,
                DegreesPerSecondUnit.INSTANCE);
        double b = a.value(DegreesPerSecondUnit.INSTANCE).doubleValue();
        Assert.assertEquals(45.0, b, SMALL_AMOUNT);
    }

    @Test
    public void test2() {
        AngularVelocityAmount a = new AngularVelocityAmount(45,
                DegreesPerSecondUnit.INSTANCE);
        double b = a.value(RadiansPerSecondUnit.INSTANCE).doubleValue();
        Assert.assertEquals(Math.PI / 4, b, SMALL_AMOUNT);
    }

    @Test
    public void test3() {
        AngularVelocityAmount a = new AngularVelocityAmount(45,
                DegreesPerMillisecondUnit.INSTANCE);
        double b = a.value(RadiansPerSecondUnit.INSTANCE).doubleValue();
        Assert.assertEquals(((45 * 1000.0) / 360) * 2 * Math.PI, b,
                SMALL_AMOUNT);
    }

    @Test
    public void test4() {
        AngularVelocityAmount a = new AngularVelocityAmount(Math.PI / 1000,
                RadiansPerSecondUnit.INSTANCE);
        double b = a.value(DegreesPerMillisecondUnit.INSTANCE).doubleValue();
        Assert.assertEquals(.00018, b, SMALL_AMOUNT);
    }
}
