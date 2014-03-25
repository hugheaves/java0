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
 *
 */
package org.java0.logging;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.java0.logging.LevelUtil;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class LevelUtilTest {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LevelUtilTest.class
			.getName());

	@Test()
	public void testNextHighest() {
		Level betweenConfigAndInfo = new Level("betweenConfigAndInfo", 600, "") {
			private static final long serialVersionUID = 1L;
		};

		assertEquals(Level.FINEST, LevelUtil.nextHighest(Level.ALL));
		assertEquals(Level.FINER, LevelUtil.nextHighest(Level.FINEST));
		assertEquals(Level.FINE, LevelUtil.nextHighest(Level.FINER));
		assertEquals(Level.CONFIG, LevelUtil.nextHighest(Level.FINE));
		assertEquals(Level.INFO, LevelUtil.nextHighest(Level.CONFIG));
		assertEquals(Level.INFO, LevelUtil.nextHighest(betweenConfigAndInfo));
		assertEquals(Level.WARNING, LevelUtil.nextHighest(Level.INFO));
		assertEquals(Level.SEVERE, LevelUtil.nextHighest(Level.WARNING));
		assertEquals(Level.OFF, LevelUtil.nextHighest(Level.SEVERE));
		assertEquals(Level.OFF, LevelUtil.nextHighest(Level.OFF));
	}

	@Test()
	public void testNextLowest() {
		Level betweenConfigAndInfo = new Level("betweenConfigAndInfo", 600, "") {
			private static final long serialVersionUID = 1L;
		};

		assertEquals(Level.ALL, LevelUtil.nextLowest(Level.ALL));
		assertEquals(Level.ALL, LevelUtil.nextLowest(Level.FINEST));
		assertEquals(Level.FINEST, LevelUtil.nextLowest(Level.FINER));
		assertEquals(Level.FINER, LevelUtil.nextLowest(Level.FINE));
		assertEquals(Level.FINE, LevelUtil.nextLowest(Level.CONFIG));
		assertEquals(Level.CONFIG, LevelUtil.nextLowest(betweenConfigAndInfo));
		assertEquals(Level.CONFIG, LevelUtil.nextLowest(Level.INFO));
		assertEquals(Level.INFO, LevelUtil.nextLowest(Level.WARNING));
		assertEquals(Level.WARNING, LevelUtil.nextLowest(Level.SEVERE));
		assertEquals(Level.SEVERE, LevelUtil.nextLowest(Level.OFF));
	}


}
