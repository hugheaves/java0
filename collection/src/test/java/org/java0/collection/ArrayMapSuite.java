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
package org.java0.collection;

import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestSuite;

import org.java0.test.BaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.testing.MapTestSuiteBuilder;
import com.google.common.collect.testing.TestStringMapGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.MapFeature;

/**
 * @author Hugh Eaves
 *
 */
@RunWith(AllTests.class)
@SuiteClasses(ArrayMapSuite.class)
public class ArrayMapSuite extends BaseTest {

	public static TestSuite suite() {

		TestStringMapGenerator generator = new TestStringMapGenerator() {

			@Override
			protected Map<String, String> create(Entry<String, String>[] entries) {
				Map<String, String> map = new ArrayMap<>();
				for (Entry<String, String> entry : entries) {
					map.put(entry.getKey(), entry.getValue());
				}
				return map;

			}

		};

		TestSuite suite = MapTestSuiteBuilder
				.using(generator)
				.named("ArrayMapSuite")
				.withFeatures(MapFeature.GENERAL_PURPOSE,
						MapFeature.ALLOWS_NULL_VALUES,
						CollectionFeature.SUPPORTS_ITERATOR_REMOVE,
						CollectionSize.ANY).createTestSuite();

		return suite;
	}

}
