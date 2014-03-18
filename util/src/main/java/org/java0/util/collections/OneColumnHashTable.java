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
public class OneColumnHashTable<T1> extends
        AbstractHashTable<OneColumnTable.Row<T1>, OneColumnTable<T1>> implements
        OneColumnTable<T1> {

    private static final int COLUMNS = 1;

    /**
     * Create a new OneColumnHashTable.
     *
     * @param numColumns
     */
    protected OneColumnHashTable() {
        super(COLUMNS);

    }

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(OneColumnHashTable.class
            .getName());

    public static class Row<T1> extends AbstractHashTable.Row implements
            OneColumnTable.Row<T1> {

        /**
         * Create a new OneColumnTableRow.
         *
         * @param t1
         */
        public Row(T1 t1) {
            super(new Object[] { t1 });
        }

        /**
         * Create a new OneColumnTableRow.
         *
         * @param values
         */
        public Row(Object[] values) {
            super(values);

        }

        /**
         * @see org.java0.util.collections.OneColumnTable.Row#getValue1()
         */
        @SuppressWarnings("unchecked")
        @Override
        public T1 getValue1() {
            return (T1) getValue(0);
        }
    }

    /**
     * @see org.java0.util.collections.OneColumnTable#append(java.lang.Object)
     */
    @Override
    public boolean append(T1 t1) {
        return false;
    }

    /**
     * @see org.java0.util.collections.OneColumnTable#exists(java.lang.Object)
     */
    @Override
    public boolean exists(T1 t1) {
        return false;
    }

    /**
     * @see org.java0.util.collections.OneColumnTable#delete(java.lang.Object)
     */
    @Override
    public boolean delete(T1 t1) {
        return false;
    }

    /**
     * @see org.java0.util.collections.OneColumnTable#select(java.lang.Object)
     */
    @Override
    public OneColumnTable<T1> select(T1 t1) {
        return null;
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createRow(java.lang.Object[])
     */
    @Override
    protected org.java0.util.collections.OneColumnTable.Row<T1> createRow(
            Object[] objects) {
        return null;
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createTable()
     */
    @Override
    protected OneColumnTable<T1> createTable() {
        return null;
    }
}
