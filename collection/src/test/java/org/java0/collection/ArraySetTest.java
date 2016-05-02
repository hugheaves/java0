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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.test.BaseTest;
import org.java0.util.timing.Stopwatch;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class ArraySetTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ArraySetTest.class.getName());

    static Random random = new Random();

    public static final int NUM_LISTS = 5000;
    public static final int MIN_ADD_VALUES = 10;
    public static final int MAX_ADD_VALUES = 50;
    public static final int MAX_VALUE = 100;
    public static final int MAX_REMOVE_VALUES = 200;
    public static final int REPEATS = 10;

    static List<List<Integer>> addLists = genAddList(NUM_LISTS, MIN_ADD_VALUES, MAX_ADD_VALUES, MAX_VALUE);;
    static List<List<Integer>> removeLists = genRemoveList(addLists, MAX_REMOVE_VALUES, MAX_VALUE);

    @Test
    public void timedComparison() {
        final Stopwatch hash = new Stopwatch("hash", Level.DEBUG);
        final Stopwatch array = new Stopwatch("array", Level.DEBUG);

        int arrayTotalElementsAdded = 0;
        int arrayTotalElementsRemaining = 0;
        int hashTotalElementsAdded = 0;
        int hashTotalElementsRemaining = 0;

        for (int j = 0; j < addLists.size(); ++j) {

            Set<Integer> arraySet = null;
            boolean arrayAdded = false;
            boolean arrayRemoved = false;

            array.start();
            for (int i = 0; i < REPEATS; ++i) {
                arraySet = new ArraySet<>(addLists.size());
                arrayAdded = arraySet.addAll(addLists.get(j));
                arrayTotalElementsAdded += arraySet.size();
                arrayRemoved = arraySet.removeAll(removeLists.get(j));
                arrayTotalElementsRemaining += arraySet.size();
            }
            array.stop();

            Set<Integer> hashSet = null;
            boolean hashAdded = false;
            ;
            boolean hashRemoved = false;

            hash.start();
            for (int i = 0; i < REPEATS; ++i) {
                hashSet = new HashSet<>(addLists.size());
                hashAdded = hashSet.addAll(addLists.get(j));
                hashTotalElementsAdded += hashSet.size();
                hashRemoved = hashSet.removeAll(removeLists.get(j));
                hashTotalElementsRemaining += hashSet.size();
            }
            hash.stop();

            assertEquals(hashSet, arraySet);
            assertEquals(hashAdded, arrayAdded);
            assertEquals(hashRemoved, arrayRemoved);
            assertEquals(hashTotalElementsAdded, arrayTotalElementsAdded);
            assertEquals(hashTotalElementsRemaining, arrayTotalElementsRemaining);
        }

        logger.info("element counts", "hashTotalElementsAdded", hashTotalElementsAdded, "arrayTotalElementsAdded",
                arrayTotalElementsAdded, "hashTotalElementsRemaining", hashTotalElementsRemaining,
                "arrayTotalElementsRemaining", arrayTotalElementsRemaining);
        hash.log(Level.INFO);
        array.log(Level.INFO);
    }

    public static List<List<Integer>> genAddList(final int numLists, final int minValues, final int maxValues,
            final int maxValue) {
        final List<List<Integer>> listList = new ArrayList<>(numLists);
        for (int i = 0; i < numLists; ++i) {
            final int size = random.nextInt(maxValues + 1 - minValues) + minValues;
            final int range = random.nextInt(maxValue) + 1;
            final List<Integer> list = new ArrayList<>(size);
            for (int j = 0; j < size; ++j) {
                list.add(random.nextInt(range));
            }
            listList.add(list);
        }
        return listList;
    }

    private static List<List<Integer>> genRemoveList(final List<List<Integer>> addLists, final int maxSize,
            final int maxValue) {
        final List<List<Integer>> removeLists = new ArrayList<>(addLists.size());
        for (@SuppressWarnings("unused")
        final List<Integer> addList : addLists) {
            final int size = random.nextInt(maxSize);
            final int range = random.nextInt(maxValue) + 1;
            final List<Integer> removeList = new ArrayList<Integer>(size);
            for (int j = 0; j < size; ++j) {
                removeList.add(random.nextInt(range));
            }
            removeLists.add(removeList);
        }
        return removeLists;

    }

}
