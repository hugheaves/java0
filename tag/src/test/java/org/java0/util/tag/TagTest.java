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
package org.java0.util.tag;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.java0.tag.DefaultTagComparator;
import org.java0.tag.LocalHostTag;
import org.java0.tag.NamedTag;
import org.java0.tag.RemoteHostTag;
import org.java0.tag.Tag;
import org.java0.tag.TagComparator;
import org.java0.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class TagTest extends BaseTest {
	private static final Logger logger = Logger.getLogger(TagTest.class
			.getName());

	private List<Tag> tags = null;

	protected final TagComparator tagComparator = new DefaultTagComparator();

	@Before
	public void createTestData() {
		logger.info("CreateTestData");
		tags = new ArrayList<>();
		tags.add(new NamedTag("one")); // 0
		tags.add(new NamedTag("two")); // 1
		tags.add(new NamedTag("one").link(new NamedTag("1"))); // 2
		tags.add(new NamedTag("one").link(new NamedTag("2"))); // 3
		tags.add(new NamedTag("one").link(new NamedTag("4"))); // 4
		tags.add(new NamedTag("one").link(new NamedTag("4"))); // 5
		tags.add(new NamedTag("one").link(RemoteHostTag.INSTANCE)); // 6
		tags.add(new NamedTag("one").link(LocalHostTag.INSTANCE)); // 7
		tags.add(new NamedTag("one")); // 8
		tags.add(new NamedTag("one").link(new NamedTag("two")).link(
				new NamedTag("three"))); // 9
		tags.add(new NamedTag("one").link(new NamedTag("two")).link(
				new NamedTag("three").link(new NamedTag("four")))); // 10

	}

	@Test
	public void testA() {
		for (int i = 0; i < tags.size(); ++i) {
			for (int j = 0; j < tags.size(); ++j) {
				assertEquals(
						tagComparator.matchScore(tags.get(i), tags.get(j)),
						tagComparator.matchScore(tags.get(j), tags.get(i)));
			}
		}
	}

	@Test
	public void tesT0() {
		assertEquals(-2, tagComparator.matchScore(tags.get(0), tags.get(1)));
	}

	@Test
	public void test2() {
		assertEquals(-1, tagComparator.matchScore(tags.get(2), tags.get(3)));
	}

	@Test
	public void test3() {
		assertEquals(2, tagComparator.matchScore(tags.get(4), tags.get(5)));
	}

	@Test
	public void test4() {
		assertEquals(-1, tagComparator.matchScore(tags.get(6), tags.get(7)));
	}

	@Test
	public void test5() {
		assertEquals(0, tagComparator.matchScore(tags.get(7), tags.get(8)));
	}

	@Test
	public void test6() {
		assertEquals(1, tagComparator.matchScore(tags.get(0), tags.get(8)));
	}

	@Test
	public void test7() {
		assertEquals(2, tagComparator.matchScore(tags.get(9), tags.get(10)));
	}

	@Test
	public void test8() {
		Tag one = new NamedTag("one");
		one.link(one);
		assertEquals(-1, tagComparator.matchScore(one, tags.get(9)));
		Tag two = new NamedTag("two").link(new NamedTag("three"));
		assertEquals(1, tagComparator.matchScore(two, tags.get(9)));
		one.link(two);
		assertEquals(3, tagComparator.matchScore(two, tags.get(9)));

	}
}
