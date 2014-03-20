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
package org.java0.util.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import junit.framework.TestSuite;

import org.java0.util.test.BaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.testing.ListTestSuiteBuilder;
import com.google.common.collect.testing.QueueTestSuiteBuilder;
import com.google.common.collect.testing.TestStringListGenerator;
import com.google.common.collect.testing.TestStringQueueGenerator;
import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.features.CollectionSize;
/**
 * @author Hugh Eaves
 *
 */
@RunWith(AllTests.class)
@SuiteClasses(ArrayBufferSuite.class)
public class ArrayBufferSuite extends BaseTest {

    public static TestSuite suite() {
        setupLogging();

        TestStringListGenerator listGenerator = new TestStringListGenerator() {

            @Override
            protected List<String> create(String[] elements) {
                List<String> buffer = new ArrayBuffer<String>(1000);
                buffer.addAll(Arrays.asList(elements));
                return buffer;
            }

        };

        TestStringQueueGenerator queueGenerator = new TestStringQueueGenerator() {

            @Override
            protected Queue<String> create(String[] elements) {
                Queue<String> buffer = new ArrayBuffer<String>(1000);
                buffer.addAll(Arrays.asList(elements));
                return buffer;
            }

        };

        TestSuite listSuite = ListTestSuiteBuilder
                .using(listGenerator)
                .named("ArrayBufferSuite")
                .withFeatures(
                        CollectionFeature.ALLOWS_NULL_VALUES,
                        CollectionFeature.SUPPORTS_ADD,
                        CollectionFeature.SUPPORTS_REMOVE,
                        CollectionFeature.SUPPORTS_ITERATOR_REMOVE,
                        CollectionSize.ANY)
                .createTestSuite();

        TestSuite queueSuite = QueueTestSuiteBuilder
                .using(queueGenerator)
                .named("ArrayBufferSuite")
                .withFeatures(
                        CollectionFeature.ALLOWS_NULL_VALUES,
                        CollectionFeature.SUPPORTS_ADD,
                        CollectionFeature.SUPPORTS_REMOVE,
                        CollectionFeature.SUPPORTS_ITERATOR_REMOVE,
                        CollectionSize.ANY)
                .createTestSuite();

        for (int i = 0; i < queueSuite.testCount(); ++i) {
            listSuite.addTest(queueSuite.testAt(i));

        }

        return listSuite;
    }

}
