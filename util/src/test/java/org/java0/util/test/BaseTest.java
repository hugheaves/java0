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

package org.java0.util.test;

import java.util.logging.Logger;

import org.java0.util.logging.LogUtil;
import org.junit.BeforeClass;

public class BaseTest {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    public BaseTest() {
    }

    @BeforeClass
    public static void setup() {
        LogUtil.initLogging("test-logging.properties");
    }

}
