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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import junit.framework.TestSuite;

import org.java0.collection.HashSetMap;
import org.java0.test.BaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.testing.Helpers;
import com.google.common.collect.testing.MapTestSuiteBuilder;
import com.google.common.collect.testing.SampleElements;
import com.google.common.collect.testing.TestMapGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.MapFeature;

/**
 * @author Hugh Eaves
 * 
 */
@RunWith(AllTests.class)
@SuiteClasses(HashSetMapSuite.class)
public class HashSetMapSuite extends BaseTest {

    public static TestSuite suite() {
        setupLogging();

        TestMapGenerator<String, Set<String>> generator = new TestMapGenerator<String, Set<String>>() {

            @Override
            public SampleElements<Map.Entry<String, Set<String>>> samples() {
                return new SampleElements<Map.Entry<String, Set<String>>>(
                        Helpers.mapEntry(
                                "AAA",
                                (Set<String>) new HashSet<String>(Arrays
                                        .asList(new String[] { "111", "222" }))),
                        Helpers.mapEntry(
                                "BBB",
                                (Set<String>) new HashSet<String>(Arrays
                                        .asList(new String[] { "333", "444" }))),
                        Helpers.mapEntry(
                                "CCC",
                                (Set<String>) new HashSet<String>(Arrays
                                        .asList(new String[] { "555", "666" }))),
                        Helpers.mapEntry(
                                "DDD",
                                (Set<String>) new HashSet<String>(Arrays
                                        .asList(new String[] { "777", "888" }))),
                        Helpers.mapEntry(
                                "EEE",
                                (Set<String>) new HashSet<String>(Arrays
                                        .asList(new String[] { "999", "000" }))));
            }

            @Override
            public Map<String, Set<String>> create(Object... entries) {
                Map<String, Set<String>> map = new HashSetMap<String, String>();
                for (Object o : entries) {
                    @SuppressWarnings("unchecked")
                    Entry<String, Set<String>> entry = (Entry<String, Set<String>>) o;
                    map.put(entry.getKey(), entry.getValue());
                }
                return map;

            }

            @Override
            @SuppressWarnings("unchecked")
            public final Entry<String, Set<String>>[] createArray(int length) {
                return new Entry[length];
            }

            @Override
            public final String[] createKeyArray(int length) {
                return new String[length];
            }

            @SuppressWarnings("unchecked")
            @Override
            public final HashSet<String>[] createValueArray(int length) {
                return new HashSet[length];
            }

            /** Returns the original element list, unchanged. */
            @Override
            public Iterable<Entry<String, Set<String>>> order(
                    List<Entry<String, Set<String>>> insertionOrder) {
                return insertionOrder;
            }
        };

        TestSuite suite = MapTestSuiteBuilder
                .using(generator)
                .named("HashSetMapSuite")
                .withFeatures(MapFeature.GENERAL_PURPOSE,
                        MapFeature.FAILS_FAST_ON_CONCURRENT_MODIFICATION,
                        MapFeature.SUPPORTS_PUT, MapFeature.SUPPORTS_REMOVE,
                        MapFeature.ALLOWS_NULL_KEYS,
                        MapFeature.ALLOWS_NULL_VALUES,
                        CollectionFeature.SUPPORTS_ITERATOR_REMOVE,
                        CollectionSize.ANY).createTestSuite();

        return suite;
    }
}
