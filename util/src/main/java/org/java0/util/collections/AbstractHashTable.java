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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public abstract class AbstractHashTable<R extends Table.Row, T extends Table<R>>
        implements Table<R> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(AbstractHashTable.class.getName());

    protected int numColumns;

    protected Set<R> entries;

    protected SetMap<Object, R>[] index;

    public static class Row implements Table.Row {

        protected Object[] values;
        protected int[] valuePositions;
        protected int hashCode = CollectionsConstants.HASHCODE_MAGIC_NUM;

        public Row(Object[] values) {
            // for (int i = 0; i < values.length; ++i) {
            // assert (values[i] != null);
            // }
            this.values = values;
        }

        @Override
        public Object getValue(int valueNum) {
            return values[valueNum];
        }

        @Override
        public int numColumns() {
            return values.length;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Table.Row) {
                Table.Row tuple = (Table.Row) obj;

                if (tuple.numColumns() != numColumns()) {
                    return false;
                }

                for (int i = 0; i < numColumns(); ++i) {
                    Object a = getValue(i);
                    Object b = tuple.getValue(i);
                    if (a == null || b == null) {
                        if (a != b) {
                            return false;
                        }
                    } else {
                        if (!a.equals(b)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            // Check if we've previously calculated the hashCode.
            // This is a heuristic that assumes (hopefully correctly)
            // that the actual hash code is almost never actually MAGIC_NUM.
            if (hashCode != CollectionsConstants.HASHCODE_MAGIC_NUM) {
                return hashCode;
            }

            int shift = 32 / numColumns();

            hashCode = 0;

            for (int valueNum = 0; valueNum < numColumns(); ++valueNum) {
                hashCode = hashCode << shift;
                Object val = getValue(valueNum);
                if (val != null) {
                    hashCode = hashCode ^ val.hashCode();
                }
            }

            return hashCode;
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append(getClass().getName());
            buffer.append(": ");
            for (int i = 0; i < values.length; ++i) {
                if (i > 0) {
                    buffer.append(", ");
                }
                buffer.append("values[");
                buffer.append(i);
                buffer.append("]=");
                buffer.append(values[i]);
            }
            return buffer.toString();
        }

    }

    @SuppressWarnings("unchecked")
    protected AbstractHashTable(int numColumns) {
        this.numColumns = numColumns;
        entries = new HashSet<R>();
        index = new SetMap[numColumns];
        for (int i = 0; i < numColumns; ++i) {
            index[i] = new HashSetMap<>();
        }
    }

    protected boolean deleteBySingleColumn(int column, Object key) {
        Set<R> matches = index[column].get(key);
        if (matches != null & matches.size() > 0) {
            for (R row : matches) {
                entries.remove(row);
                for (int i = 0; i < numColumns; ++i) {
                    if (i != column) {
                        index[i].remove(key, row);
                    }
                }
            }
            index[column].remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean append(R row) {
        boolean added = entries.add(row);
        if (added) {
            for (int i = 0; i < numColumns; ++i) {
                index[i].add(row.getValue(i), row);
            }
        }
        return added;
    }

    @Override
    public boolean delete(R row) {
        boolean removed = entries.remove(row);
        for (int i = 0; i < numColumns; ++i) {
            index[i].remove(row.getValue(i), row);
        }
        return removed;
    }

    @Override
    public boolean exists(R row) {
        return entries.contains(row);
    }

    /**
     * @param objects
     * @return
     */
    protected T select(Object[] objects) {
        int[] valuePositions = valuePositions(objects);

        // TODO Use list for less overhead?
        Set<R> returnSet = null;
        T returnTable = null;

        if (valuePositions.length == 0) {
            returnSet = buildSet(entries);
        } else if (valuePositions.length == numColumns) {
            R newRow = createRow(objects);
            if (entries.contains(newRow)) {
                returnSet = new HashSet<R>(1);
                returnSet.add(newRow);
            }
        } else if (valuePositions.length == 1) {
            returnSet =
                    buildSet(index[valuePositions[0]]
                            .get(objects[valuePositions[0]]));
        } else {
            returnSet = buildSet(objects, valuePositions);
        }

        if (returnSet != null) {
            returnTable = createTable();
            returnTable.appendAll(returnSet);
        }

        return returnTable;
    }

    /**
     * @param rows
     * @return
     */
    private Set<R> buildSet(Set<R> rows) {
        return new HashSet<R>(rows);
    }

    /**
     * @param objects
     * @return
     */
    protected abstract R createRow(Object[] objects);

    /**
     * @param objects
     * @return
     */
    protected abstract T createTable();

    /**
     * @param objects
     * @param valuePositions
     * @return
     */
    private Set<R> buildSet(Object[] objects, int[] valuePositions) {
        Set<R> returnSet =
                new HashSet<R>(
                        index[valuePositions[0]]
                                .get(objects[valuePositions[0]]));
        for (int i = 1; i < valuePositions.length; ++i) {
            returnSet.retainAll(index[valuePositions[i]]
                    .get(objects[valuePositions[i]]));
        }
        return returnSet;
    }

    /**
     * Find positions of non-null objects.
     *
     * @param objects
     * @return
     */
    private int[] valuePositions(Object[] objects) {
        int count = 0;
        for (int i = 0; i < objects.length; ++i) {
            if (objects[i] != null) {
                ++count;
            }
        }
        int[] valuePositions = new int[count];
        count = 0;
        for (int i = 0; i < objects.length; ++i) {
            if (objects[i] != null) {
                valuePositions[count++] = i;
            }
        }
        return valuePositions;
    }

    @Override
    public void deleteAll() {
        entries.clear();
        for (int i = 0; i < entries.size(); ++i) {
            index[i].clear();
        }
    }

    /**
     * @see org.java0.util.collections.Table#rowSet()
     */
    @Override
    public Set<R> rowSet() {
        return entries;
    }

    /**
     * @see org.java0.util.collections.Table#appendAll(java.util.Collection)
     */
    @Override
    public boolean appendAll(Collection<? extends R> rows) {
        boolean appended = false;
        for (R row : rows) {
            if (append(row)) {
                appended = true;
            }
        }
        return appended;
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public int size() {
        return entries.size();
    }
}