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

import java.util.Set;

import org.java0.util.collections.SetMap;

/**
 * <p>
 * A {@code Tag} is an object that is used to differentiate between several
 * entities of the same type.
 *
 * <p>
 * Each tag can be added to other tags, forming a collection of tags where the
 * entire collection of tags is accessible through any of the other tags in the
 * collection.
 * <p>
 * Comparing one tag to another generates a score that represents how closely
 * the tags match.
 * <p>
 *
 * @author Hugh Eaves
 *
 */
public interface Tag {
    /**
     * Links a new tag to this tag. This method can be used to create groups of
     * linked tags.
     *
     * @param tag
     * @return a reference to this tag (for chaining invocations)
     */
    public Tag link(Tag tag);

    /**
     * Returns the tags that have been linked to this tag and this tag.
     *
     * @return
     */
    public Set<Tag> allTags();

    /**
     * Returns the type of this tag.
     *
     * @return a class representing the type of this tag.
     */
    public Class<? extends Tag> getType();

    /**
     * Retrieve the value of this tag.
     *
     * @return the value of this tag.
     */
    public Object getValue();

    /**
     * Tells this tag that it should delegate "tag set tracking"
     * responsibilities to the given tag.
     *
     * @param abstractTag
     */
    public void setDelegate(Tag tag);

    /**
     * Returns the number of tags linked with this tag (including this one).
     *
     * @return
     */
    public int numTags();
}
