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
package org.java0.collection.rowset;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.java0.collection.setmap.HashSetMap;
import org.java0.collection.setmap.SetMap;
import org.java0.collection.tuple.Tuple;
import org.java0.core.type.Null;

/**
 * @author Hugh Eaves
 *
 */
public class HashRowSet<R extends Tuple> extends AbstractSet<R> implements
        RowSet<R> {
    private static final Logger logger = Logger.getLogger(HashRowSet.class
            .getName());

    protected Set<R> entries;

    protected SetMap<Object, R>[] index;

    protected class HashRowSetIterator implements Iterator<R> {
        protected Iterator<R> setIterator;
        protected R lastValue = null;

        public HashRowSetIterator() {
            setIterator = entries.iterator();
        }

        /**
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return setIterator.hasNext();
        }

        /**
         * @see java.util.Iterator#next()
         */
        @Override
        public R next() {
            lastValue = setIterator.next();
            return lastValue;
        }

        /**
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {
            setIterator.remove();
            removeFromIndex(lastValue);
            lastValue = null;
        }

    }

    protected class SelectKey {
        protected R row;
        protected int[] keyColumns;
        int numKeyColumns = 0;

        /**
         * Create a new SelectKey.
         *
         * @param row
         * @param keyColumns
         */
        public SelectKey(R row, boolean[] nullIsKey) {
            this.row = row;
            initKeyColumns(row, nullIsKey);
        }

        /**
         * Determine column numbers of key values
         *
         * @param keyColumn
         * @return
         */
        private void initKeyColumns(R row, boolean[] nullIsKey) {
            keyColumns = new int[row.size()];
            for (int column = 0; column < row.size(); ++column) {
                if ((column < nullIsKey.length && nullIsKey[column])
                        || (row.get(column) != null)) {
                    keyColumns[numKeyColumns++] = column;
                }
            }
        }

        public int numKeys() {
            return numKeyColumns;
        }

        public Object key(int keyNum) {
            Object object = Null.safe(row.get(columnNum(keyNum)));
            return object;
        }

        public int columnNum(int keyNum) {
            return keyColumns[keyNum];
        }

    }

    public HashRowSet() {
        entries = new HashSet<R>();
    }

    @SuppressWarnings("unchecked")
    protected void addToIndex(Tuple row) {
        if (index == null) {
            index = new HashSetMap[row.size()];
            for (int i = 0; i < row.size(); ++i) {
                index[i] = new HashSetMap<>();
            }
        }
        for (int i = 0; i < row.size(); ++i) {
            index[i].add(row.get(i), (R) row);
        }
    }

    @SuppressWarnings("unchecked")
    protected void removeFromIndex(Tuple row) {
        for (int i = 0; i < row.size(); ++i) {
            index[i].remove(row.get(i), (R) row);
        }
    }

    @Override
    public boolean add(R row) {
        if (row == null) {
            throw new NullPointerException();
        }
        boolean added = entries.add(row);
        if (added) {
            addToIndex(row);
        }
        return added;
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Tuple)) {
            return false;
        }
        Tuple row = (Tuple) object;
        boolean removed = entries.remove(row);
        if (removed) {
            removeFromIndex(row);
        }
        return removed;
    }

    @Override
    public boolean contains(Object object) {
        return entries.contains(object);
    }

    /**
     * @param objects
     * @return
     */
    @Override
    public RowSet<R> select(R row, boolean... nullIsKey) {
        SelectKey selectKey = new SelectKey(row, nullIsKey);

        RowSet<R> returnTable = createTable();

        // Handle special cases where we're looking for either
        // a single row match, or all the rows
        if (selectKey.numKeys() == 0) {
            returnTable.addAll(entries);
        } else if (selectKey.numKeys() == row.size()) {
            if (entries.contains(row)) {
                returnTable.add(row);
            }
        }
        // Otherwise, we're looking for a partial match, which
        // is a little more complicated
        else {
            returnTable.addAll(findMatchingRows(selectKey));
        }

        return returnTable;
    }

    /**
     * @param objects
     * @return
     */
    @SuppressWarnings("unchecked")
    protected RowSet<R> createTable() {
        try {
            return getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.log(Level.SEVERE,
                    "Caught exception in auto-generated catch block", e);
        }
        return null;
    }

    /**
     * @param row
     * @param keyColumns
     * @return
     */
    private Collection<R> findMatchingRows(SelectKey selectKey) {
        Set<R> returnSet = null;

        for (int valueNum = 0; valueNum < selectKey.numKeys(); ++valueNum) {
            // Pull the values from the index for this column
            Object key = selectKey.key(valueNum);
            Set<R> values = index[selectKey.columnNum(valueNum)].get(key);

            // If we haven't initialized the return set yet
            if (returnSet == null) {
                // If no matching values, create an empty set
                if (values == null) {
                    returnSet = new HashSet<R>();
                }
                // Otherwise, build a new set from the values
                else {
                    returnSet = new HashSet<R>(values);
                }
            } else {
                // Compute the intersection of the values found so far
                // and the values from the index column
                returnSet.retainAll(values);
            }

            // if we have an empty set, we're done
            if (returnSet.isEmpty()) {
                break;
            }
        }
        return returnSet;
    }

    @Override
    public void clear() {
        entries.clear();
        for (int i = 0; i < entries.size(); ++i) {
            index[i].clear();
        }
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public int size() {
        return entries.size();
    }

    /**
     * @see java.util.AbstractCollection#iterator()
     */
    @Override
    public Iterator<R> iterator() {
        return new HashRowSetIterator();
    }
}