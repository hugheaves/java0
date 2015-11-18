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
package org.java0.core.exception;

/**
 * Base class for any unchecked exceptions.
 *
 * @author Hugh Eaves
 *
 */
public class UncheckedException extends RuntimeException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2514564486316394958L;

    /**
     * Create a new UncheckedException.
     *
     */
    public UncheckedException() {
        super();

    }

    /**
     * Create a new UncheckedException.
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public UncheckedException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * Create a new UncheckedException.
     *
     * @param message
     * @param cause
     */
    public UncheckedException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * Create a new UncheckedException.
     *
     * @param message
     */
    public UncheckedException(String message) {
        super(message);

    }

    /**
     * Create a new UncheckedException.
     *
     * @param cause
     */
    public UncheckedException(Throwable cause) {
        super(cause);

    }

}
