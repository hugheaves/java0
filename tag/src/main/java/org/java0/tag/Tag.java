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
package org.java0.tag;

import java.util.Set;

/**
 * <p>
 * A {@code Tag} is a lightweight container for a value object, that also has
 * the ability to link other {@code Tag} objects to form a collection of related
 * tags.
 *
 * The linking between tags is bidirectional, so that all tags in a collection
 * provide the ability to access all other tags in the collection.
 *
 * @author Hugh Eaves
 *
 */
public interface Tag {
	/**
	 * Links a tag to this tag. This method is used to create sets of related
	 * tags.
	 *
	 * @param tag
	 *            the tag to link
	 * @return a reference to this tag (for chaining invocations)
	 */

	public Tag link(Tag tag);

	/**
	 * Returns the set of tags in this tag collection.
	 *
	 * @return
	 */
	public Set<Tag> getAll();

	/**
	 * Retrieve the type (Class) of this tag.
	 *
	 * @return the class of this tag.
	 */
	public Class<? extends Tag> getType();

	/**
	 * Retrieve the value of this tag.
	 *
	 * @return the value of this tag.
	 */
	public Object getValue();

	/**
	 * This method is called on a tag to set the "master" tag. This method is
	 * not normally called directly.
	 *
	 * @param tag
	 */
	public void setMaster(Tag tag);

	/**
	 * @return
	 */
	public Tag getMaster();

	public void unlink();

	/**
	 * Retrieves the number of tags is this tag group (including this Tag).
	 *
	 * @return the number of tags is this tag group (including this Tag).
	 */
	public int size();
}
