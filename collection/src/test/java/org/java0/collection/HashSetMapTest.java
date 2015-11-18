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
package org.java0.collection;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.logging.Logger;

import org.java0.collection.setmap.HashSetMap;
import org.java0.test.BaseTest;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class HashSetMapTest extends BaseTest {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(HashSetMapTest.class
			.getName());

	@Test
	public void test1() {
		HashSetMap<Integer, String> setMap = new HashSetMap<>();
		setMap.add(1, "A");
		setMap.add(2, "B");
		setMap.add(3, "C");
		setMap.add(1, "D");
		setMap.add(1, "E");
		setMap.add(2, "F");
		setMap.add(5, "G");
		setMap.add(2, "H");

		assertEquals(8, setMap.numVals());
		assertEquals(4, setMap.size());

		assertEquals(3, setMap.get(2).size());
		assertEquals(3, setMap.get(1).size());

		assertFalse(setMap.removeValue(1, "B"));

		assertTrue(setMap.removeValue(2, "B"));

		assertThat(setMap.get(1), hasItems("A", "D", "E"));
		assertThat(setMap.get(2), hasItems("F", "H"));
		assertThat(setMap.get(2), not(hasItems("B")));

	}

	@Test
	public void equalsTest() {
		HashSetMap<Object, Object> setMap1 = new HashSetMap<>();
		HashSetMap<Object, Object> setMap2 = new HashSetMap<>();

		setMap1.add("A", "1");
		setMap1.add("B", "2");
		setMap1.add("A", "3");
		setMap1.add("B", "4");
		setMap1.add("C", "5");
		setMap1.add("C", "6");
		setMap1.add("C", "7");
		setMap1.add(5, "8");
		setMap1.add("set", new HashSet<Object>());

		setMap2.add("C", "5");
		setMap2.add("C", "6");
		setMap2.add("set", new HashSet<Object>());
		setMap2.add(5, "8");
		setMap2.add("A", "1");
		setMap2.add("B", "2");
		setMap2.add("C", "7");
		setMap2.add("A", "3");
		setMap2.add("B", "4");

		assertTrue(setMap1.equals(setMap2));
		assertEquals(setMap1.hashCode(), setMap2.hashCode());
	}
}
