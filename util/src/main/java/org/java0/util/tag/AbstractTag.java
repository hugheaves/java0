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

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.java0.util.collections.CollectionsConstants;
import org.java0.util.collections.HashSetMap;
import org.java0.util.collections.SetMap;

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
     * The type of this tag
     */
    private final Class<? extends Tag> type;

    /**
     * A SetMap of all the tags linked to this tag (including this one).
     */
    private Set<Tag> allTags = null;

    /**
     * A SetMap of all the tags linked to this tag (excluding this one).
     */
    private Set<Tag> linkedTags = null;

    /**
     * A reference to the tag that tracks the whole set of tags. If this
     * variable is null, then this tag is responsible for keeping track of all
     * the tags.
     */
    private Tag delegate;

    private int hashCode = CollectionsConstants.HASHCODE_MAGIC_NUM;

    protected AbstractTag(Class<? extends Tag> type, Object value) {
        assert(type != null);
        assert(value != null);
        this.type = type;
        this.value = value;
        allTags = new HashSet<>();
        allTags.add(this);
    }

    /**
     * @see org.java0.util.tag.Tag#link(org.java0.util.tag.Tag)
     */
    @Override
    public Tag link(Tag tag) {
        if (delegate != null) {
            delegate.link(tag);
        } else {
            if (linkedTags == null) {
                linkedTags = new HashSet<>();
            }
            linkedTags.add(tag);
            allTags.add(tag);
            tag.setDelegate(this);
        }
        return this;
    }

    /**
     * @see org.java0.util.tag.Tag#allTags()
     */
    @Override
    public Set<Tag> allTags() {
        if (delegate != null) {
            return delegate.allTags();
        } else {
            return allTags;
        }
    }

    /**
     * @see org.java0.util.tag.Tag#getType()
     */
    @Override
    public Class<? extends Tag> getType() {
        return type;
    }

    /**
     * @see org.java0.util.tag.Tag#getValue()
     */
    @Override
    public Object getValue() {
        return value;
    }

    /**
     * @see org.java0.util.tag.Tag#setDelegate(org.java0.util.tag.Tag)
     */
    @Override
    public void setDelegate(Tag delegate) {
        this.delegate = delegate;
        if (linkedTags != null) {
            for (Tag tag : linkedTags) {
                delegate.link(tag);
            }
        }
        allTags = null;
        linkedTags = null;
    }

    /**
     * @see org.java0.util.tag.Tag#numTags()
     */
    @Override
    public int numTags() {
        if (delegate != null) {
            return delegate.numTags();
        } else {
            return allTags.size();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
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
        if (hashCode != CollectionsConstants.HASHCODE_MAGIC_NUM) {
            return hashCode;
        }

        hashCode = getType().hashCode() ^ getValue().hashCode();

        return hashCode;
    }

    @Override
    public String toString() {
        return type.getName() + "/" + value.toString();

    }
}
