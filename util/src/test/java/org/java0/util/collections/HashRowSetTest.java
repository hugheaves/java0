/*
 * Copyright (C) 2014 Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.java0.util.collections;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.java0.util.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class HashRowSetTest extends BaseTest {
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger(HashRowSetTest.class
            .getName());

    List<FourColumnRow<String, Integer, Boolean, String>> rows = null;

    @Before
    public void createTestData() {
        rows = new ArrayList<FourColumnRow<String, Integer, Boolean, String>>();

        rows.add(new FourColumnRow<>("hello", 1, true, "world"));
        rows.add(new FourColumnRow<>("hello1", 1, true, "world"));
        rows.add(new FourColumnRow<>("hello2", 1, true, "world"));
        rows.add(new FourColumnRow<>("hello", 1, true, "world1"));
        rows.add(new FourColumnRow<>("hello", 1, true, "world2")); // DUP
        // A
        rows.add(new FourColumnRow<>("hello", 2, true, "world"));
        rows.add(new FourColumnRow<>("hello", 3, true, "world")); // DUP
        // B
        rows.add(new FourColumnRow<>("hello", 3, false, "world"));
        rows.add(new FourColumnRow<>("hello1", 3, true, "world"));
        rows.add(new FourColumnRow<>("hello", 3, true, "world2"));
        rows.add(new FourColumnRow<>("hello", 1, false, "world"));
        rows.add(new FourColumnRow<>("hello", 3, true, "world")); // DUP
                                                                // B
        rows.add(new FourColumnRow<>("hello", 1, true, "world2")); // DUP
        // A
        rows.add(new FourColumnRow<>("last", 2, false, "row"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test1() {
        RowSet<FourColumnRow<String, Integer, Boolean, String>> table = new HashRowSet<>();

        assertTrue(table.isEmpty());

        table.add(rows.get(0));

        assertFalse(table.isEmpty());
        assertEquals(1, table.size());

        table.addAll(rows);
        assertEquals(12, table.size());

        RowSet<FourColumnRow<String, Integer, Boolean, String>> result = table
                .select(new FourColumnRow<>("hello", 1, true, "world"));

        assertNotNull(result);
        assertEquals(1, result.size());

        FourColumnRow<String, Integer, Boolean, String> row = table.iterator()
                .next();
        assertEquals(rows.get(0), row);

        result = table
                .select(new FourColumnRow<String, Integer, Boolean, String>(
                        "hello", null, null, null));
        assertEquals(8, result.size());

        result = table
                .select(new FourColumnRow<String, Integer, Boolean, String>(
                        "hello", 3, null, null));
        assertEquals(3, result.size());

        result = table
                .select(new FourColumnRow<String, Integer, Boolean, String>(
                        "hello1", null, null, "world"));
        assertEquals(2, result.size());

        assertThat(result, hasItems(rows.get(1), rows.get(8)));

        result = table
                .select(new FourColumnRow<String, Integer, Boolean, String>(
                        null, null, null, null));
        assertEquals(12, result.size());

    }
}
