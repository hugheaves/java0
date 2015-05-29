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

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.java0.core.type.Constants;

/**
 * @author Hugh Eaves
 *
 */
public class AbstractTag implements Tag {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AbstractTag.class
			.getName());

	/**
	 * The value of this tag
	 */
	private final Object value;

	/**
	 * The list of all the tags linked to this tag (including this one).
	 */
	private Set<Tag> tagSet = null;

	/**
	 * A reference to the tag that tracks the whole set of tags.
	 */
	private Tag master = this;

	private int hashCode = Constants.HASHCODE_MAGIC_NUM;

	protected AbstractTag(Object value) {
		assert (value != null);
		this.value = value;
	}

	@Override
	public Tag link(Tag tag) {
		if (tag == null) {
			throw new NullPointerException();
		}
		// This is not the master tag, so delegate
		if (getMaster() != this) {
			getMaster().link(tag);
		} else { // this tag is a master tag
			// if the other tag is part of a different set, merge the sets
			if (tag.getMaster() != this) {
				if (tag.size() == 1) {
					tag.setMaster(this);
					tagSet().add(tag);
				} else if (tag.size() > this.size()) {
					for (Tag thisTag : tagSet()) {
						if (thisTag != this) {
							thisTag.unlink();
						}
						tag.link(thisTag);
					}
					this.unlink();
					tag.link(this);
				} else {
					for (Tag thatTag : tag.getAll()) {
						thatTag.unlink();
						link(thatTag);
					}
				}
			} else {
				// already part of this tag set
			}
		}
		return this;
	}

	protected Set<Tag> tagSet() {
		if (tagSet == null) {
			tagSet = new HashSet<>();
			tagSet.add(this);
		}
		return tagSet;
	}

	/**
	 * @see org.java0.tag.Tag#getType()
	 */
	@Override
	public Class<? extends Tag> getType() {
		return this.getClass();
	}

	/**
	 * @see org.java0.tag.Tag#getValue()
	 */
	@Override
	public Object getValue() {
		return value;
	}

	/**
	 * @see org.java0.tag.Tag#setMaster(org.java0.tag.Tag)
	 */
	@Override
	public void setMaster(Tag tag) {
		this.master = tag;
		tagSet = null;
	}

	@Override
	public Tag getMaster() {
		return master;
	}

	@Override
	public int size() {
		if (getMaster() != this) {
			return getMaster().size();
		} else {
			if (tagSet == null) {
				return 1;
			} else {
				return tagSet.size();
			}
		}
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		} else if (object instanceof Tag) {
			Tag tag = (Tag) object;
			if (tag.getType() == getType() && tag.getValue().equals(getValue())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (hashCode != Constants.HASHCODE_MAGIC_NUM) {
			return hashCode;
		}

		hashCode = getType().hashCode() ^ getValue().hashCode();

		return hashCode;
	}

	@Override
	public String toString() {
		return getType().getName() + "/" + value.toString();
	}

	/**
	 * @see org.java0.tag.Tag#getAll()
	 */
	@Override
	public Set<Tag> getAll() {
		return tagSet();
	}

	/**
	 * @see org.java0.tag.Tag#unlink()
	 */
	@Override
	public void unlink() {
		this.master = this;
		tagSet = null;
	}
}
