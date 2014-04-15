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
package org.java0.unit;

import java.util.logging.Logger;

import org.java0.test.BaseTest;
import org.java0.unit.angle.AngleUnit;
import org.java0.unit.angle.DegreesUnit;
import org.java0.unit.angularvelocity.DegreesPerMillisecondUnit;
import org.java0.unit.time.SecondsUnit;
import org.java0.unit.time.TimeUnit;
import org.junit.Test;

/**
 * @author Hugh Eaves
 * 
 */
public class NumericUnitTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(NumericUnitTest.class
            .getName());

    @Test
    public void test1() {
        DegreesUnit degreesUnit = DegreesUnit.INSTANCE;

        UnitProduct<AngleUnit, TimeUnit> b = degreesUnit
                .multiply(SecondsUnit.INSTANCE);

        UnitProduct<UnitProduct<AngleUnit, TimeUnit>, TimeUnit> c = b
                .multiply(SecondsUnit.INSTANCE);

        UnitQuotient<UnitProduct<UnitProduct<AngleUnit, TimeUnit>, TimeUnit>, UnitQuotient<AngleUnit, TimeUnit>> d = c
                .divide(DegreesPerMillisecondUnit.INSTANCE);

        logger.info(d.getName());
    }
}
