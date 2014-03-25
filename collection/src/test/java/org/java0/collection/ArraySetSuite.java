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
 *
 */
package org.java0.collection;

import java.util.Arrays;
import java.util.Set;

import junit.framework.TestSuite;

import org.java0.collection.ArraySet;
import org.java0.test.BaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.testing.SetTestSuiteBuilder;
import com.google.common.collect.testing.TestStringSetGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.SetFeature;
/**
 * @author Hugh Eaves
 *
 */
@RunWith(AllTests.class)
@SuiteClasses(ArraySetSuite.class)
public class ArraySetSuite extends BaseTest {

	public static TestSuite suite() {
		setupLogging();

		TestStringSetGenerator generator = new TestStringSetGenerator() {

			@Override
			protected Set<String> create(String[] elements) {
				Set<String> set = new ArraySet<String>();
				set.addAll(Arrays.asList(elements));
				return set;
			}

		};

		TestSuite suite = SetTestSuiteBuilder
				.using(generator)
				.named("ArraySetTest")
				.withFeatures(SetFeature.GENERAL_PURPOSE,
						CollectionFeature.SUPPORTS_ADD,
						CollectionFeature.SUPPORTS_REMOVE,
						CollectionFeature.SUPPORTS_ITERATOR_REMOVE,
						CollectionFeature.GENERAL_PURPOSE, CollectionSize.ANY)
				.createTestSuite();

		return suite;
	}

}
