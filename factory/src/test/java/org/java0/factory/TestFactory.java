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

import java.util.logging.Logger;

import org.java0.factory.AbstractDelegableFactory;
import org.java0.tag.NamedTag;

/**
 * @author Hugh Eaves
 *
 */
public class TestFactory extends AbstractDelegableFactory {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(TestFactory.class
            .getName());

    public TestFactory() {
        this.addType(TestClass1.class, true);
        this.addType(TestClass2.class, true);
        this.addType(TestInterface1.class, true, TestClass3.class);
        this.addType(TestInterface1.class, new NamedTag("A"), true, TestClass4.class);
        this.addType(TestInterface1.class, new NamedTag("B"), true, TestClass5.class);
    }
}
