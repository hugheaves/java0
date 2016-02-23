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
package org.java0.annotation;

import org.java0.factory.AbstractDelegableFactory;
import org.java0.factory.NewObjectProvider;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class TaggedClassFactory extends AbstractDelegableFactory {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(TaggedClassFactory.class);

    /**
     * Adds a concrete type to the factory.
     *
     * @param concreteType
     * @param singleton
     */
    @Override
    protected <T> void addType(final Class<T> concreteType, final boolean singleton) {
        addType(concreteType, ConverterFactory.convertAnnotations(concreteType),
                new NewObjectProvider<T>(concreteType, singleton));
    }

    /**
     * Adds a mapping from a lookup type to a concrete type.
     *
     * @param lookupType
     * @param singleton
     * @param concreteType
     */
    @Override
    protected <T> void addType(final Class<T> lookupType, final boolean singleton,
            final Class<? extends T> concreteType) {
        addType(lookupType, ConverterFactory.convertAnnotations(concreteType),
                new NewObjectProvider<T>(concreteType, singleton));
    }
}
