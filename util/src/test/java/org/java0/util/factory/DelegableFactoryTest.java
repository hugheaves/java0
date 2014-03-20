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
package org.java0.util.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.java0.util.tag.NameTag;
import org.java0.util.test.BaseTest;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class DelegableFactoryTest extends BaseTest {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(DelegableFactoryTest.class.getName());

    @Test
    public void test1() {
        Factory factory = new TestFactory();

        TestClass1 instance1 = factory.getObject(TestClass1.class);

        assertNotNull(instance1);

        TestClass2 instance2 = factory.getObject(TestClass2.class);

        assertNotNull(instance2);

        TestInterface1 interface1 = factory.getObject(TestInterface1.class,
        new NameTag("A"));
        assertTrue(interface1 instanceof TestClass4);

        interface1 = factory.getObject(TestInterface1.class,
        new NameTag("B"));
        assertTrue(interface1 instanceof TestClass5);
    }
}
