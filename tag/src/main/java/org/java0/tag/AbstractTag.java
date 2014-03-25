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
// TODO Returned collections should be unmodifiable
public class AbstractTag implements Tag {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(AbstractTag.class
            .getName());

    /**
     * The value of this tag
     */
    private final Object value;

    /**
     * A SetMap of all the tags linked to this tag (including this one).
     */
    private Set<Tag> allTags = null;

    /**
     * A reference to the tag that tracks the whole set of tags. If this
     * variable is null, then this tag is responsible for keeping track of all
     * the tags.
     */
    private Tag delegate = null;

    private int hashCode = Constants.HASHCODE_MAGIC_NUM;

    protected AbstractTag(Object value) {
        assert (value != null);
        this.value = value;
    }

    /**
     * @see org.java0.tag.Tag#link(org.java0.tag.Tag)
     */
    @Override
    public Tag link(Tag tag) {
        if (tag == null) {
            throw new NullPointerException();
        }
        if (delegate != null) {
            delegate.link(tag);
        } else {
            if (tag.numTags() > 1){
                if (allTags == null) {
                    allTags = tag.allTags();
                    allTags.add(this);
                } else {
                    allTags.addAll(tag.allTags());
                }
            } else {
                allTags().add(tag);
            }
            tag.setParent(this);
        }
        return this;
    }

    /**
     * @see org.java0.tag.Tag#allTags()
     */
    @Override
    public Set<Tag> allTags() {
        if (delegate != null) {
            return delegate.allTags();
        } else {
            if (allTags == null) {
                allTags = new HashSet<>();
                allTags.add(this);
            }
            return allTags;
        }
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
     * @see org.java0.tag.Tag#setParent(org.java0.tag.Tag)
     */
    @Override
    public void setParent(Tag tag) {
        this.delegate = tag;
        allTags = null;
    }

    /**
     * @see org.java0.tag.Tag#numTags()
     */
    @Override
    public int numTags() {
        if (delegate != null) {
            return delegate.numTags();
        } else {
            if (allTags == null) {
                return 1;
            } else {
                return allTags.size();
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
}
