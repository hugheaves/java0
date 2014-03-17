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
package org.java0.util.tag;

import java.util.logging.Logger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.java0.util.collections.FourColumnHashTable;
import org.java0.util.collections.FourColumnTable;
import org.java0.util.collections.FourColumnTable.Row;
import org.java0.util.tag.DefaultTagComparator;
import org.java0.util.tag.LocalHostTag;
import org.java0.util.tag.NameTag;
import org.java0.util.tag.RemoteHostTag;
import org.java0.util.tag.Tag;
import org.java0.util.tag.TagComparator;
import org.java0.util.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
        tags.add(new NameTag("blah"));  //0
        tags.add(new NameTag("yada")); //1
        tags.add(new NameTag("blah").link(new NameTag("1"))); //2
        tags.add(new NameTag("blah").link(new NameTag("2"))); //3
        tags.add(new NameTag("blah").link(new NameTag("4"))); //4
        tags.add(new NameTag("blah").link(new NameTag("4"))); //5
        tags.add(new NameTag("blah").link(RemoteHostTag.INSTANCE)); //6
        tags.add(new NameTag("blah").link(LocalHostTag.INSTANCE)); //7
        tags.add(new NameTag("blah")); //8

    }

    @Test
    public void test1() {
        assertEquals(-2,
                tagComparator.matchScore(tags.get(0), tags.get(1)));
    }

    @Test
    public void test2() {
        assertEquals(-1,
                tagComparator.matchScore(tags.get(2), tags.get(3)));
    }

    @Test
    public void test3() {
        assertEquals(2, tagComparator.matchScore(tags.get(4), tags.get(5)));
    }

    @Test
    public void test4() {
        assertEquals(-1,
                tagComparator.matchScore(tags.get(6), tags.get(7)));
    }

    @Test
    public void test5() {
        assertEquals(0, tagComparator.matchScore(tags.get(7), tags.get(8)));
    }

    @Test
    public void test6() {
        assertEquals(1, tagComparator.matchScore(tags.get(0), tags.get(8)));
    }

}