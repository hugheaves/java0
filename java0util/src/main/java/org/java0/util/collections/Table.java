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
import java.util.Set;

/**
 * A table is a collection that implements basic "associative" operations on a
 * set of rows and columns. This class defines the basic operations on a table.
 *
 * @author Hugh Eaves
 *
 */
public interface Table<T extends Table.Row> {
    /**
     * Basic operations on a row.
     *
     * @author Hugh Eaves
     *
     */
    public interface Row {
        /**
         * Returns a value from a row.
         *
         * @param valueNum
         *            The column number of the value to return, starting at
         *            zero.
         * @return The object stored in this row at the specified column.
         */
        public Object getValue(int columnNum);

        /**
         * Returns the number of columns in this row.
         *
         * @return
         */
        public int numColumns();
    }

    /**
     * Removes all rows from the table.
     */
    public void deleteAll();

    /**
     * Retrieves all rows from the table
     */
    public Set<T> rowSet();

    /**
     * Appends a new row to the table.
     *
     * @param row
     *            the row
     * @return true is the new row was added. false if the row already existed
     *         in the table.
     */
    public boolean append(T row);

    /**
     * Appends new rows to the table.
     *
     * @param rows
     *            the collection of rows to add
     * @return true is at least one new row was added. false otherwise
     */
    public boolean appendAll(Collection<? extends T> rows);

    /**
     * Checks to see if a row exists in the table.
     *
     * @param row
     *            the row
     * @return true if the row exists in the table, false otherwise.
     */
    public boolean exists(T row);

    /**
     * Deletes a row from the table.
     *
     * @param row
     *            the row
     * @return true if the row was deleted from the table, false if the row was
     *         not deleted (because it did not exist in the table).
     */
    public boolean delete(T row);

    /**
     * Checks if the table has no rows
     *
     * @return true if there are no rows in the table.
     */
    boolean isEmpty();

    /**
     * Retrieves the number of rows in the table.
     *
     * @return the number of rows in the table.
     */
    int size();

}
