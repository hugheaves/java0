package org.java0.core.type;

public class AbstractLongIdentified implements LongIdentified {
    protected long id;

    protected AbstractLongIdentified(final long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
