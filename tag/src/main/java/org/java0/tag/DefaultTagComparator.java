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
package org.java0.tag;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class DefaultTagComparator implements TagComparator {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger
            .getLogger(DefaultTagComparator.class.getName());


    @Override
    public int matchScore(Tag a, Tag b) {
        int score = 0;

        if (a == null || b == null) {
            if (a != b) {
                score = Integer.MIN_VALUE;
            }
        } else {
            score = compareSets(a.allTags(), b.allTags());
        }

        return score;
    }

    /**
     * @param tagSet
     * @param value
     * @return
     */
    private int compareSets(Set<Tag> aSet, Set<Tag> bSet) {
        int score = 0;

        Set<Tag> aSetCopy = new HashSet<>(aSet);

        for (Tag b : bSet) {
            if (aSet.contains(b)) {
                aSetCopy.remove(b);
                ++score;
            } else {
                --score;
            }
        }

        score -= aSetCopy.size();

        return score;
    }
}
