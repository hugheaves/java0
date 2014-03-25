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
package org.java0.amount;


import org.java0.amount.angularvelocity.AngularVelocity;
import org.java0.unit.angularvelocity.DegreesPerMillisecond;
import org.java0.unit.angularvelocity.DegreesPerSecond;
import org.java0.unit.angularvelocity.RadiansPerSecond;
import org.junit.Assert;
import org.junit.Test;

public class AngularVelocityTest {
	public static final double SMALL_AMOUNT = 0.00000000001;

	@Test
	public void test1() {
		AngularVelocity a = new AngularVelocity(45, DegreesPerSecond.INSTANCE);
		double b = a.getValue(DegreesPerSecond.INSTANCE).doubleValue();
		Assert.assertEquals(45.0, b, SMALL_AMOUNT);
	}

	@Test
	public void test2() {
		AngularVelocity a = new AngularVelocity(45, DegreesPerSecond.INSTANCE);
		double b = a.getValue(RadiansPerSecond.INSTANCE).doubleValue();
		Assert.assertEquals(Math.PI / 4, b, SMALL_AMOUNT);
	}

	@Test
	public void test3() {
		AngularVelocity a = new AngularVelocity(45, DegreesPerMillisecond.INSTANCE);
		double b = a.getValue(RadiansPerSecond.INSTANCE).doubleValue();
		Assert.assertEquals(Math.PI / 4000, b, SMALL_AMOUNT);
	}

	@Test
	public void test4() {
		AngularVelocity a = new AngularVelocity(Math.PI / 1000, RadiansPerSecond.INSTANCE);
		double b = a.getValue(DegreesPerMillisecond.INSTANCE).doubleValue();
		Assert.assertEquals(180, b, SMALL_AMOUNT);
	}
}
