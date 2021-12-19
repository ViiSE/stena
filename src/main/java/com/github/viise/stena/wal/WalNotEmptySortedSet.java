package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Collection;
import java.util.SortedSet;

/**
 * Not empty sortedSet protection.
 */
public final class WalNotEmptySortedSet<T> implements Wall<SortedSet<T>> {

    private final Wall<Collection<T>> walNotEmptyCollection;

    public WalNotEmptySortedSet() {
        this.walNotEmptyCollection = new WalNotEmptyCollection<>();
    }

    /**
     * Protect sortedSet.
     *
     * @param srtSetName Protected sortedSet name.
     * @param srtSet     Protected sortedSet.
     * @throws ProtectException If sortedSet is null or empty.
     */
    @Override
    public void protect(final String srtSetName, final SortedSet<T> srtSet) throws ProtectException {
        String _srtSetName = srtSetName == null ? "sortedSet" : srtSetName;
        walNotEmptyCollection.protect(_srtSetName, srtSet);
    }

    /**
     * Protect sortedSet. {@code srtSetName} is {@code "sortedSet"}.
     *
     * @param srtSet Protected sortedSet.
     * @throws ProtectException If sortedSet is null or empty.
     */
    @Override
    public void protect(final SortedSet<T> srtSet) throws ProtectException {
        protect("sortedSet", srtSet);
    }
}
