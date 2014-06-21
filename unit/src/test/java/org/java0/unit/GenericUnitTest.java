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

import org.java0.quantity.Numeric;
import org.java0.quantity.NumericProduct;
import org.java0.quantity.QuantityProduct;
import org.java0.quantity.QuantityQuotient;
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

        UnitProduct<NumericProduct, Numeric, Numeric> ab = a.multiply(b);

        logger.info(ab.getName());

        assertEquals(0.5, ab.convertToSystem(0.5).doubleValue(), SMALL_AMOUNT);
        assertEquals(1.0, ab.convertToSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(2.0, ab.convertToSystem(2).doubleValue(), SMALL_AMOUNT);
        assertEquals(0.5, ab.convertFromSystem(0.5).doubleValue(), SMALL_AMOUNT);
        assertEquals(1.0, ab.convertFromSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(2.0, ab.convertFromSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test2() {
        UnitProduct<QuantityProduct<Numeric, Numeric>, Numeric, Numeric> dadb = da
                .multiply(db);
        logger.info(dadb.getName());

        assertEquals(50, dadb.convertToSystem(0.5).doubleValue(), SMALL_AMOUNT);
        assertEquals(100, dadb.convertToSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(200, dadb.convertToSystem(2).doubleValue(), SMALL_AMOUNT);
        assertEquals(.005, dadb.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.01, dadb.convertFromSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(.02, dadb.convertFromSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test3() {
        UnitProduct<QuantityProduct<Numeric, Numeric>, Numeric, Numeric> damb = da
                .multiply(mb);
        logger.info(damb.getName());

        assertEquals(damb.convertToSystem(0.5).doubleValue(), .005,
                SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(1).doubleValue(), .01, SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(2).doubleValue(), .02, SMALL_AMOUNT);
        assertEquals(50, damb.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(100, damb.convertFromSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(200, damb.convertFromSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test4() {
        UnitProduct<QuantityProduct<Numeric, Numeric>, Numeric, Numeric> mbda = mb
                .multiply(da);
        logger.info(mbda.getName());

        assertEquals(mbda.convertToSystem(0.5).doubleValue(), .005,
                SMALL_AMOUNT);
        assertEquals(mbda.convertToSystem(1).doubleValue(), .01, SMALL_AMOUNT);
        assertEquals(mbda.convertToSystem(2).doubleValue(), .02, SMALL_AMOUNT);
        assertEquals(50, mbda.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(100, mbda.convertFromSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(200, mbda.convertFromSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test5() {
        UnitQuotient<QuantityQuotient<Numeric, Numeric>, Numeric, Numeric> ab = a
                .divide(b);
        logger.info(ab.getName());

        assertEquals(0.5, ab.convertToSystem(0.5).doubleValue(), SMALL_AMOUNT);
        assertEquals(1.0, ab.convertToSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(2.0, ab.convertToSystem(2).doubleValue(), SMALL_AMOUNT);
        assertEquals(0.5, ab.convertFromSystem(0.5).doubleValue(), SMALL_AMOUNT);
        assertEquals(1.0, ab.convertFromSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(2.0, ab.convertFromSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test6() {
        UnitQuotient<QuantityQuotient<Numeric, Numeric>, Numeric, Numeric> dadb = da
                .divide(db);
        logger.info(dadb.getName());

        assertEquals(0.5, dadb.convertToSystem(0.5).doubleValue(), SMALL_AMOUNT);
        assertEquals(1.0, dadb.convertToSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(2.0, dadb.convertToSystem(2).doubleValue(), SMALL_AMOUNT);
        assertEquals(0.5, dadb.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(1.0, dadb.convertFromSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(2.0, dadb.convertFromSystem(2).doubleValue(), SMALL_AMOUNT);
    }

    @Test
    public void test7() {
        UnitQuotient<QuantityQuotient<Numeric, Numeric>, Numeric, Numeric> damb = da
                .divide(mb);
        logger.info(damb.getName());

        assertEquals(damb.convertToSystem(0.5).doubleValue(), 5000,
                SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(1).doubleValue(), 10000, SMALL_AMOUNT);
        assertEquals(damb.convertToSystem(2).doubleValue(), 20000, SMALL_AMOUNT);
        assertEquals(0.00005, damb.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(0.0001, damb.convertFromSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(0.0002, damb.convertFromSystem(2).doubleValue(),
                SMALL_AMOUNT);
    }

    @Test
    public void test8() {
        UnitQuotient<QuantityQuotient<Numeric, Numeric>, Numeric, Numeric> mbda = mb
                .divide(da);
        logger.info(mbda.getName());

        assertEquals(.00005, mbda.convertToSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.0001, mbda.convertToSystem(1).doubleValue(), SMALL_AMOUNT);
        assertEquals(.0002, mbda.convertToSystem(2).doubleValue(), SMALL_AMOUNT);
        assertEquals(5000, mbda.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(10000, mbda.convertFromSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(20000, mbda.convertFromSystem(2).doubleValue(),
                SMALL_AMOUNT);
    }

    @Test
    public void test9() {
        UnitQuotient<QuantityQuotient<Numeric, Numeric>, Numeric, Numeric> mbda = mb
                .divide(da);
        logger.info(mbda.getName());

        UnitQuotient<QuantityQuotient<QuantityQuotient<Numeric, Numeric>, Numeric>, QuantityQuotient<Numeric, Numeric>, Numeric> mbdaca = mbda
                .divide(ca);

        logger.info(mbdaca.getName());

        assertEquals(.0000005, mbdaca.convertToSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.000001, mbdaca.convertToSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.000002, mbdaca.convertToSystem(2).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(500000, mbdaca.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(1000000, mbdaca.convertFromSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(2000000, mbdaca.convertFromSystem(2).doubleValue(),
                SMALL_AMOUNT);
    }

    @Test
    public void test10() {
        UnitQuotient<QuantityQuotient<Numeric, Numeric>, Numeric, Numeric> mbda = mb
                .divide(da);
        logger.info(mbda.getName());

        UnitQuotient<QuantityQuotient<QuantityQuotient<Numeric, Numeric>, Numeric>, QuantityQuotient<Numeric, Numeric>, Numeric> mbdaca = mbda
                .divide(ca);
        logger.info(mbdaca.getName());

        UnitProduct<QuantityProduct<Numeric, QuantityQuotient<QuantityQuotient<Numeric, Numeric>, Numeric>>, Numeric, QuantityQuotient<QuantityQuotient<Numeric, Numeric>, Numeric>> dbmbdaca = db
                .multiply(mbdaca);
        logger.info(mbdaca.getName());

        assertEquals(.000005, dbmbdaca.convertToSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.00001, dbmbdaca.convertToSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(.00002, dbmbdaca.convertToSystem(2).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(50000, dbmbdaca.convertFromSystem(0.5).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(100000, dbmbdaca.convertFromSystem(1).doubleValue(),
                SMALL_AMOUNT);
        assertEquals(200000, dbmbdaca.convertFromSystem(2).doubleValue(),
                SMALL_AMOUNT);
    }
}
