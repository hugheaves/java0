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

import org.java0.util.collections.FourColumnTable.Row;
import org.java0.util.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class FourColumnHashTableTest extends BaseTest {
    @SuppressWarnings("unused")
    private static Logger logger = Logger
            .getLogger(FourColumnHashTableTest.class.getName());

    List<FourColumnTable.Row<String, Integer, Boolean, String>> rows = null;

    @Before
    public void createTestData() {
        rows = new ArrayList<FourColumnTable.Row<String, Integer, Boolean, String>>();

        rows.add(FourColumnHashTable.Row.create("hello", 1, true, "world"));
        rows.add(FourColumnHashTable.Row.create("hello1", 1, true, "world"));
        rows.add(FourColumnHashTable.Row.create("hello2", 1, true, "world"));
        rows.add(FourColumnHashTable.Row.create("hello", 1, true, "world1"));
        rows.add(FourColumnHashTable.Row.create("hello", 1, true, "world2")); // DUP
        // A
        rows.add(FourColumnHashTable.Row.create("hello", 2, true, "world"));
        rows.add(FourColumnHashTable.Row.create("hello", 3, true, "world")); // DUP
        // B
        rows.add(FourColumnHashTable.Row.create("hello", 3, false, "world"));
        rows.add(FourColumnHashTable.Row.create("hello1", 3, true, "world"));
        rows.add(FourColumnHashTable.Row.create("hello", 3, true, "world2"));
        rows.add(FourColumnHashTable.Row.create("hello", 1, false, "world"));
        rows.add(FourColumnHashTable.Row.create("hello", 3, true, "world")); // DUP
                                                                             // B
        rows.add(FourColumnHashTable.Row.create("hello", 1, true, "world2")); // DUP
        // A
        rows.add(FourColumnHashTable.Row.create("last", 2, false, "row"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test1() {
        FourColumnTable<String, Integer, Boolean, String> table = FourColumnHashTable
                .create();

        assertTrue(table.isEmpty());

        table.append(rows.get(0));

        assertFalse(table.isEmpty());
        assertEquals(1, table.size());

        table.appendAll(rows);
        assertEquals(12, table.size());

        FourColumnTable<String, Integer, Boolean, String> result = table
                .select("hello", 1, true, "world");

        assertNotNull(result);
        assertEquals(1, result.size());

        Row<String, Integer, Boolean, String> row = table.rowSet().iterator()
                .next();
        assertEquals(rows.get(0), row);

        result = table.select("hello", null, null, null);
        assertEquals(8, result.size());

        result = table.select("hello", 3, null, null);
        assertEquals(3, result.size());

        result = table.select("hello1", null, null, "world");
        assertEquals(2, result.size());

        assertThat(result.rowSet(), hasItems(rows.get(1), rows.get(8)));

        result = table.select(null, null, null, null);
        assertEquals(12, result.size());

    }
}
