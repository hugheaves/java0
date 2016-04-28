/*
 * Copyright (C) 2016  Hugh Eaves
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
package org.java0.util;

import java.util.function.Function;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

/**
 * @author Hugh Eaves
 *
 */
public class SystemPropertyUtil {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(SystemPropertyUtil.class);

    public static <T> T getProperty(final String key, final Function<String, T> converter, final T defaultValue) {
        T value = defaultValue;
        final String property = System.getProperty(key);
        if (property != null) {
            try {
                value = converter.apply(property);
            } catch (final NumberFormatException e) {
            }
        }
        return value;
    }
}
