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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.TestSuite;

import org.java0.collection.rowset.HashRowSet;
import org.java0.collection.tuple.FourTuple;
import org.java0.collection.tuple.Tuple;
import org.java0.test.BaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.testing.SampleElements;
import com.google.common.collect.testing.SetTestSuiteBuilder;
import com.google.common.collect.testing.TestSetGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
import com.google.common.collect.testing.features.SetFeature;

/**
 * @author Hugh Eaves
 * 
 */
@RunWith(AllTests.class)
@SuiteClasses(HashRowSetSuite.class)
public class HashRowSetSuite extends BaseTest {

    public static TestSuite suite() {

        TestSetGenerator<Tuple> generator = new TestSetGenerator<Tuple>() {

            @Override
            public SampleElements<Tuple> samples() {
                return new SampleElements<Tuple>(new FourTuple<>("hello", 1,
                        true, "world"), new FourTuple<>("hello1", 1, true,
                        "world"), new FourTuple<>("hello2", 1, true,
                        "world"), new FourTuple<>("hello", 1, true,
                        "world1"), new FourTuple<>("hello", 1, true,
                        "world2"));
            }

            @Override
            public Tuple[] createArray(int length) {
                return new Tuple[length];
            }

            @Override
            public Iterable<Tuple> order(List<Tuple> insertionOrder) {
                return insertionOrder;
            }

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public Set<Tuple> create(Object... elements) {
                Set<Tuple> set = new HashRowSet();
                set.addAll((Collection) Arrays.asList(elements));
                return set;
            }

        };

        TestSuite suite = SetTestSuiteBuilder
                .using(generator)
                .named("HashRowSetSuite")
                .withFeatures(SetFeature.GENERAL_PURPOSE,
                        CollectionFeature.SUPPORTS_ADD,
                        CollectionFeature.SUPPORTS_REMOVE,
                        CollectionFeature.SUPPORTS_ITERATOR_REMOVE,
                        CollectionFeature.GENERAL_PURPOSE, CollectionSize.ANY)
                .createTestSuite();

        return suite;
    }

}
