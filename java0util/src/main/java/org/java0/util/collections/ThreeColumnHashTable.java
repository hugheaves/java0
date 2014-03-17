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

import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class ThreeColumnHashTable<T1, T2, T3>
        extends
        AbstractHashTable<ThreeColumnTable.Row<T1, T2, T3>, ThreeColumnTable<T1, T2, T3>>
        implements ThreeColumnTable<T1, T2, T3> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(FourColumnHashTable.class
            .getName());

    private static final int COLUMNS = 3;

    public static class Row<T1, T2, T3> extends TwoColumnHashTable.Row<T1, T2>
            implements ThreeColumnTable.Row<T1, T2, T3> {

        /**
         * Create a new ThreeColumnTableRow.
         *
         * @param t1
         * @param t2
         * @param t3
         */
        public Row(T1 t1, T2 t2, T3 t3) {
            super(new Object[] { t1, t2, t3 });
        }

        public static <T1, T2, T3> Row<T1, T2, T3> create(T1 t1, T2 t2, T3 t3) {
            return new Row<T1, T2, T3>(t1, t2, t3);
        }

        /**
         * Create a new ThreeColumnTableRow.
         *
         * @param values
         */
        public Row(Object[] values) {
            super(values);

        }

        /**
         * @see org.java0.util.collections.ThreeColumnTable.Row#getValue3()
         */
        @SuppressWarnings("unchecked")
        @Override
        public T3 getValue3() {
            return (T3) getValue(2);
        }
    }

    private ThreeColumnHashTable() {
        super(COLUMNS);
    }

    public static <T1, T2, T3> ThreeColumnHashTable<T1, T2, T3> create() {
        return new ThreeColumnHashTable<T1, T2, T3>();
    }

    @Override
    public ThreeColumnTable<T1, T2, T3> select(T1 t1, T2 t2, T3 t3) {
        return select(new Object[] { t1, t2, t3 });
    }

    /**
     * @see org.java0.util.collections.ThreeColumnTable#append(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean append(T1 t1, T2 t2, T3 t3) {
        return append(new Row<T1, T2, T3>(t1, t2, t3));
    }

    /**
     * @see org.java0.util.collections.ThreeColumnTable#exists(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean exists(T1 t1, T2 t2, T3 t3) {
        return exists(new Row<T1, T2, T3>(t1, t2, t3));
    }

    /**
     * @see org.java0.util.collections.ThreeColumnTable#delete(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean delete(T1 t1, T2 t2, T3 t3) {
        return delete(new Row<T1, T2, T3>(t1, t2, t3));
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createRow(java.lang.Object[])
     */
    @Override
    protected ThreeColumnTable.Row<T1, T2, T3> createRow(Object[] objects) {
        return new Row<T1, T2, T3>(objects);
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createTable()
     */
    @Override
    protected ThreeColumnTable<T1, T2, T3> createTable() {
        return new ThreeColumnHashTable<T1, T2, T3>();
    }
}
