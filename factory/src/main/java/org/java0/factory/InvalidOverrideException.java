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
package org.java0.factory;

public class InvalidOverrideException extends FactoryException {

    /**
	 *
	 */
    private static final long serialVersionUID = 2529182866354590373L;

    /**
     * Create a new InvalidOverrideException.
     *
     */
    public InvalidOverrideException() {
        super();

    }

    /**
     * Create a new InvalidOverrideException.
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public InvalidOverrideException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * Create a new InvalidOverrideException.
     *
     * @param message
     * @param cause
     */
    public InvalidOverrideException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * Create a new InvalidOverrideException.
     *
     * @param message
     */
    public InvalidOverrideException(String message) {
        super(message);

    }

    /**
     * Create a new InvalidOverrideException.
     *
     * @param cause
     */
    public InvalidOverrideException(Throwable cause) {
        super(cause);

    }
}
