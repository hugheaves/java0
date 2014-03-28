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

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.java0.test.BaseTest;
import org.java0.unit.impl.GenericUnit;
import org.junit.Test;

/**
 * @author Hugh Eaves
 * 
 */
public class GenericUnitTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(GenericUnitTest.class
            .getName());

    public static final double SMALL_AMOUNT = 0.00000000001;

    GenericUnit a = new GenericUnit("a", 1, 0);
    GenericUnit da = new GenericUnit("da", 10, 0);
    GenericUnit ma = new GenericUnit("ma", .001, 0);
    GenericUnit ca = new GenericUnit("ca", 100, 0);
    GenericUnit b = new GenericUnit("b", 1, 0);
    GenericUnit db = new GenericUnit("db", 10, 0);
    GenericUnit mb = new GenericUnit("mb", .001, 0);
    GenericUnit cb = new GenericUnit("cb", 100, 0);

    @Test
    public void test1() {

        NumericUnitProduct<GenericUnit, GenericUnit> ab = a.multiply(b);
        logger.info(ab.getName());

        assertEquals(ab.convertToSystem(0.5).doubleValue(), 0.5, SMALL_AMOUNT);
        assertEquals(ab.convertToSystem(1).doubleValue(), 1.0, SMALL_AMOUNT);
        assertEquals(ab.convertToSystem(2).doubleValue(), 2.0, SMALL_AMOUNT);
    }

    @Test
    public void test2() {
        NumericUnitProduct<GenericUnit, GenericUnit> dadb = da.multiply(db);
        logger.info(dadb.getName());

        assertEquals(dadb.convertToSystem(0.5).doubleValue(), 50, SMALL_AMOUNT);
        assertEquals(dadb.convertToSystem(1).doubleValue(), 100, SMALL_AMOUNT);
        assertEquals(dadb.convertToSystem(2).doubleValue(), 200, SMALL_AMOUNT);
    }

    @Test
    public void test3() {
        NumericUnitProduct<GenericUnit, GenericUnit> damb = da.multiply(mb);
        logger.info(damb.getName());

        assertEquals(damb.convertToSystem(0.5).doubleValue(), .005,
                SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(1).doubleValue(), .01, SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(2).doubleValue(), .02, SMALL_AMOUNT);
    }

    @Test
    public void test4() {
        NumericUnitProduct<GenericUnit, GenericUnit> mbda = mb.multiply(da);
        logger.info(mbda.getName());

        assertEquals(mbda.convertToSystem(0.5).doubleValue(), .005,
                SMALL_AMOUNT);
        assertEquals(mbda.convertToSystem(1).doubleValue(), .01, SMALL_AMOUNT);
        assertEquals(mbda.convertToSystem(2).doubleValue(), .02, SMALL_AMOUNT);
    }

    @Test
    public void test5() {
        NumericUnitQuotient<GenericUnit, GenericUnit> ab = a.divide(b);
        logger.info(ab.getName());

        assertEquals(ab.convertToSystem(0.5).doubleValue(), 0.5, SMALL_AMOUNT);
        assertEquals(ab.convertToSystem(1).doubleValue(), 1.0, SMALL_AMOUNT);
        assertEquals(ab.convertToSystem(2).doubleValue(), 2.0, SMALL_AMOUNT);
    }

    @Test
    public void test6() {
        NumericUnitQuotient<GenericUnit, GenericUnit> dadb = da.divide(db);
        logger.info(dadb.getName());

        assertEquals(dadb.convertToSystem(0.5).doubleValue(), 0.5, SMALL_AMOUNT);
        assertEquals(dadb.convertToSystem(1).doubleValue(), 1, SMALL_AMOUNT);
        assertEquals(dadb.convertToSystem(2).doubleValue(), 2, SMALL_AMOUNT);
    }

    @Test
    public void test7() {
        NumericUnitQuotient<GenericUnit, GenericUnit> damb = da.divide(mb);
        logger.info(damb.getName());

        assertEquals(damb.convertToSystem(0.5).doubleValue(), 5000,
                SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(1).doubleValue(), 10000, SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(2).doubleValue(), 20000, SMALL_AMOUNT);
    }

    @Test
    public void test8() {
        NumericUnitQuotient<GenericUnit, GenericUnit> mbda = mb.divide(da);
        logger.info(mbda.getName());

        assertEquals(.00005, mbda.convertToSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.0001, mbda.convertToSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(.0002, mbda.convertToSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test9() {
        NumericUnitQuotient<GenericUnit, GenericUnit> mbda = mb.divide(da);
        logger.info(mbda.getName());

        NumericUnitQuotient<NumericUnitQuotient<GenericUnit, GenericUnit>, GenericUnit> mbdaca = mbda
                .divide(ca);
        logger.info(mbdaca.getName());

        assertEquals(.0000005, mbdaca.convertToSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.000001, mbdaca.convertToSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.000002, mbdaca.convertToSystem(2).doubleValue(),
                SMALL_AMOUNT);
    }

    @Test
    public void test10() {
        NumericUnitQuotient<GenericUnit, GenericUnit> mbda = mb.divide(da);
        logger.info(mbda.getName());

        NumericUnitQuotient<NumericUnitQuotient<GenericUnit, GenericUnit>, GenericUnit> mbdaca = mbda
                .divide(ca);
        logger.info(mbdaca.getName());

        NumericUnitProduct<GenericUnit, NumericUnitQuotient<NumericUnitQuotient<GenericUnit, GenericUnit>, GenericUnit>> dbmbdaca = db
                .multiply(mbdaca);
        logger.info(mbdaca.getName());

        assertEquals(.000005, dbmbdaca.convertToSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.00001, dbmbdaca.convertToSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.00002, dbmbdaca.convertToSystem(2).doubleValue(),
                SMALL_AMOUNT);
    }
}
