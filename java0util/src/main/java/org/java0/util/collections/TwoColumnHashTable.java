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
public class TwoColumnHashTable<T1, T2> extends
        AbstractHashTable<TwoColumnTable.Row<T1, T2>, TwoColumnTable<T1, T2>>
        implements TwoColumnTable<T1, T2> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(FourColumnHashTable.class
            .getName());

    private static final int COLUMNS = 2;

    public static class Row<T1, T2> extends OneColumnHashTable.Row<T1> implements
            TwoColumnTable.Row<T1, T2> {

        /**
         * Create a new TwoColumnTableRow.
         *
         * @param t1
         * @param t2
         */
        public Row(T1 t1, T2 t2) {
            super(new Object[] { t1, t2 });
        }

        /**
         * Create a new TwoColumnTableRow.
         *
         * @param values
         */
        public Row(Object[] values) {
            super(values);
        }

        /**
         * @see org.java0.util.collections.TwoColumnTable.Row#getValue2()
         */
        @SuppressWarnings("unchecked")
        @Override
        public T2 getValue2() {
            return (T2) getValue(1);
        }
    }

    private TwoColumnHashTable() {
        super(COLUMNS);
    }

    public static <T1, T2> TwoColumnHashTable<T1, T2> create() {
        return new TwoColumnHashTable<T1, T2>();
    }

    /**
     * @see org.java0.util.collections.FourColumnTable#select(java.lang.Object,
     *      java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public TwoColumnTable<T1, T2> select(T1 t1, T2 t2) {
        return select(new Object[] { t1, t2 });
    }

    /**
     * @see org.java0.util.collections.TwoColumnTable#append(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean append(T1 t1, T2 t2) {
        return append(new Row<T1, T2>(t1, t2));
    }

    /**
     * @see org.java0.util.collections.TwoColumnTable#exists(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean exists(T1 t1, T2 t2) {
        return exists(new Row<T1, T2>(t1, t2));
    }

    /**
     * @see org.java0.util.collections.TwoColumnTable#delete(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean delete(T1 t1, T2 t2) {
        return delete(new Row<T1, T2>(t1, t2));
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createRow(java.lang.Object[])
     */
    @Override
    protected TwoColumnTable.Row<T1, T2> createRow(Object[] objects) {
        return new Row<T1, T2>(objects);
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createTable()
     */
    @Override
    protected TwoColumnTable<T1, T2> createTable() {
        return new TwoColumnHashTable<T1, T2>();
    }
}