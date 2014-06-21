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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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

    @Override
    public Tag link(Tag tag) {
        if (tag == null) {
            throw new NullPointerException();
        }
        if (delegate != null) {
            delegate.link(tag);
        } else {
            if (tag.size() > 1) {
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

    @Override
    public int size() {
        if (delegate != null) {
            return delegate.size();
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

    /**
     * @see java.util.Set#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @see java.util.Set#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * @see java.util.Set#iterator()
     */
    @Override
    public Iterator<Tag> iterator() {
        return null;
    }

    /**
     * @see java.util.Set#toArray()
     */
    @Override
    public Object[] toArray() {
        return null;
    }

    /**
     * @see java.util.Set#toArray(java.lang.Object[])
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * @see java.util.Set#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * @see java.util.Set#containsAll(java.util.Collection)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /**
     * @see java.util.Set#addAll(java.util.Collection)
     */
    @Override
    public boolean addAll(Collection<? extends Tag> c) {
        return false;
    }

    /**
     * @see java.util.Set#retainAll(java.util.Collection)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * @see java.util.Set#removeAll(java.util.Collection)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * @see java.util.Set#clear()
     */
    @Override
    public void clear() {
    }

    /**
     * @see java.util.Set#add(java.lang.Object)
     */
    @Override
    public boolean add(Tag e) {
        return false;
    }
}
