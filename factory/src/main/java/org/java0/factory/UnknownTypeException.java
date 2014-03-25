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

/**
 * @author Hugh Eaves
 *
 */
public class UnknownTypeException extends FactoryException {

    /**
	 *
	 */
    private static final long serialVersionUID = -6733437121700887912L;

    /**
     * Create a new UnknownTypeException.
     *
     */
    public UnknownTypeException() {
        super();

    }

    /**
     * Create a new UnknownTypeException.
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public UnknownTypeException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * Create a new UnknownTypeException.
     *
     * @param message
     * @param cause
     */
    public UnknownTypeException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * Create a new UnknownTypeException.
     *
     * @param message
     */
    public UnknownTypeException(String message) {
        super(message);

    }

    /**
     * Create a new UnknownTypeException.
     *
     * @param cause
     */
    public UnknownTypeException(Throwable cause) {
        super(cause);

    }


//    /**
//     * @param type
//     * @param config
//     */
//    public UnknownTypeException(Class<?> type, Object[] config) {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("Type: ");
//        buffer.append(type.getName());
//        buffer.append(", Config: ");
//        for (int i = 0; i < config.length; ++i) {
//            buffer.append(config[i].toString());
//            if (i + 1 < config.length) {
//                buffer.append(",");
//            }
//        }
//        this.message = buffer.toString();
//    }
//
//    @Override
//    public String getMessage() {
//        if (message == null) {
//            return super.getMessage();
//        } else {
//            return message;
//        }
//    }

}
