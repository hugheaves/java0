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

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.java0.tag.Tag;

/**
 * @author Hugh Eaves
 *
 */
public class InjectableFields {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(InjectableFields.class.getName());

    private final Set<InjectableField> injectableFields = new HashSet<>();

    public InjectableFields add(String name, Class<?> type) {
        injectableFields.add(new InjectableField(name, type, null));
        return this;
    }

    public InjectableFields add(String name, Class<?> type, Tag tag) {
        injectableFields.add(new InjectableField(name, type, tag));
        return this;
    }

    /**
     * @return the injectableFields
     */
    public Set<InjectableField> getAll() {
        return injectableFields;
    }
}
