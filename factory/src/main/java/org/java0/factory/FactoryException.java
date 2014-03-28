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
 */
package org.java0.factory;

import org.java0.core.type.UncheckedException;

public class FactoryException extends UncheckedException {

    /**
	 *
	 */
    private static final long serialVersionUID = -1386977596580959248L;

    /**
     * Create a new FactoryException.
     * 
     */
    public FactoryException() {
        super();

    }

    /**
     * Create a new FactoryException.
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public FactoryException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * Create a new FactoryException.
     * 
     * @param message
     * @param cause
     */
    public FactoryException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * Create a new FactoryException.
     * 
     * @param message
     */
    public FactoryException(String message) {
        super(message);

    }

    /**
     * Create a new FactoryException.
     * 
     * @param cause
     */
    public FactoryException(Throwable cause) {
        super(cause);

    }

}
