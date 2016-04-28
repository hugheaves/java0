package org.java0.process;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BasicProcessInfo {
    public static final int MISSING_VALUE = -1;
    public static final String MISSING_STRING_VALUE = "";

    public int getPid();

    public int getParentPid();

    public long getUserMilliseconds();

    public long getSystemMilliseconds();

    public long getElapsedMilliseconds();

    public long getResidentBytes();

    public long getVirtualBytes();

    public long getMajorFaults();

    public long getMinorFaults();

    public void setPid(int pid);

    public void setParentPid(int parentPid);

    public void setUserMilliseconds(long userMilliseconds);

    public void setSystemMilliseconds(long systemMilliseconds);

    public void setElapsedMilliseconds(long elapsedMilliseconds);

    public void setResidentBytes(long residentBytes);

    public void setVirtualBytes(long virtualBytes);

    public void setMajorFaults(long majorFaults);

    public void setMinorFaults(long minorFaults);

    public default void copyInfo(final BasicProcessInfo info) {
        if (info != null) {
            copyIfNotMissing(this::setPid, info::getPid);
            copyIfNotMissing(this::setParentPid, info::getParentPid);
            copyIfNotMissing(this::setUserMilliseconds, info::getUserMilliseconds);
            copyIfNotMissing(this::setSystemMilliseconds, info::getSystemMilliseconds);
            copyIfNotMissing(this::setElapsedMilliseconds, info::getElapsedMilliseconds);
            copyIfNotMissing(this::setResidentBytes, info::getResidentBytes);
            copyIfNotMissing(this::setVirtualBytes, info::getVirtualBytes);
            copyIfNotMissing(this::setMajorFaults, info::getMajorFaults);
            copyIfNotMissing(this::setMinorFaults, info::getMinorFaults);
        }
    }

    public default void addInfo(final BasicProcessInfo info) {
        if (info != null) {
            addIfNotMissing(this::setUserMilliseconds, this::getUserMilliseconds, info::getUserMilliseconds);
            addIfNotMissing(this::setSystemMilliseconds, this::getSystemMilliseconds, info::getSystemMilliseconds);
            addIfNotMissing(this::setElapsedMilliseconds, this::getElapsedMilliseconds, info::getElapsedMilliseconds);
            addIfNotMissing(this::setResidentBytes, this::getResidentBytes, info::getResidentBytes);
            addIfNotMissing(this::setVirtualBytes, this::getVirtualBytes, info::getVirtualBytes);
            addIfNotMissing(this::setMajorFaults, this::getMajorFaults, info::getMajorFaults);
            addIfNotMissing(this::setMinorFaults, this::getMinorFaults, info::getMinorFaults);
        }
    }

    public default <T extends Number> void copyIfNotMissing(final Consumer<T> set, final Supplier<T> get) {
        final T value = get.get();
        if (value.longValue() != MISSING_VALUE) {
            set.accept(value);
        }
    }

    public default <T extends Number> void addIfNotMissing(final Consumer<T> set, final Supplier<T> getThis,
            final Supplier<T> getOther) {
        final T value = getOther.get();
        if (value.longValue() != MISSING_VALUE) {
            set.accept(value);
        }
    }
}
