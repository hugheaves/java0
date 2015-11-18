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
package org.java0.unit;

import java.util.logging.Logger;

import org.java0.quantity.Angle;
import org.java0.quantity.AngularAcceleration;
import org.java0.quantity.AngularVelocity;
import org.java0.quantity.QuantityProduct;
import org.java0.quantity.QuantityQuotient;
import org.java0.quantity.Time;
import org.java0.test.BaseTest;
import org.java0.unit.angle.DegreesUnit;
import org.java0.unit.angularvelocity.DegreesPerMillisecondUnit;
import org.java0.unit.time.SecondsUnit;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class NumericUnitTest extends BaseTest {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(NumericUnitTest.class
			.getName());

	@Test
	public void test1() {
		final DegreesUnit degreesUnit = DegreesUnit.INSTANCE;

		final UnitQuotient<AngularVelocity, Angle, Time> b = degreesUnit
				.divide(SecondsUnit.INSTANCE);

		final UnitQuotient<AngularAcceleration, AngularVelocity, Time> c = b
				.divide(SecondsUnit.INSTANCE);

		final Unit<Time> d = c
				.divideAndCancel1(DegreesPerMillisecondUnit.INSTANCE);

		final UnitQuotient<AngularVelocity, Angle, Time> u1 = DegreesUnit.INSTANCE
				.divide(SecondsUnit.INSTANCE);

		final UnitQuotient<AngularAcceleration, AngularVelocity, Time> u2 = u1
				.divide(SecondsUnit.INSTANCE);

		@SuppressWarnings("unused")
		final UnitProduct<QuantityProduct<AngularAcceleration, Angle>, AngularAcceleration, Angle> u3 = u2
				.multiply(DegreesUnit.INSTANCE);

		@SuppressWarnings("unused")
		final UnitProduct<QuantityProduct<QuantityQuotient<QuantityQuotient<Angle, Time>, Time>, Angle>, QuantityQuotient<QuantityQuotient<Angle, Time>, Time>, Angle> velocitySquaredUnit = DegreesUnit.INSTANCE
				.divide(SecondsUnit.INSTANCE).divide(SecondsUnit.INSTANCE)
				.multiply(DegreesUnit.INSTANCE);

		// logger.info(d.getName());
	}
}
