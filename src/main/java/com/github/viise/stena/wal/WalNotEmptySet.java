package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Collection;
import java.util.Set;

/**
 * Not empty set protection.
 */
public final class WalNotEmptySet<T> implements Wall<Set<T>> {

    private final Wall<Collection<T>> walNotEmptyCollection;

    public WalNotEmptySet() {
        this.walNotEmptyCollection = new WalNotEmptyCollection<>();
    }

    /**
     * Protect set.
     *
     * @param setName Protected set name.
     * @param set     Protected set.
     * @throws ProtectException If set is null or empty.
     */
    @Override
    public void protect(final String setName, final Set<T> set) throws ProtectException {
        String _setName = setName == null ? "set" : setName;
        walNotEmptyCollection.protect(_setName, set);
    }

    /**
     * Protect set. {@code setName} is {@code "set"}.
     *
     * @param set Protected set.
     * @throws ProtectException If set is null or empty.
     */
    @Override
    public void protect(final Set<T> set) throws ProtectException {
        protect("set", set);
    }
}
