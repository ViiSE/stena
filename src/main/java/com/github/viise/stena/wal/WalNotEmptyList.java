package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Collection;
import java.util.List;

/**
 * Not empty list protection.
 */
public final class WalNotEmptyList<T> implements Wall<List<T>> {

    private final Wall<Collection<T>> walNotEmptyCollection;

    public WalNotEmptyList() {
        this.walNotEmptyCollection = new WalNotEmptyCollection<>();
    }

    /**
     * Protect list.
     *
     * @param listName Protected list name.
     * @param list     Protected list.
     * @throws ProtectException If list is null or empty.
     */
    @Override
    public void protect(final String listName, final List<T> list) throws ProtectException {
        String _listName = listName == null ? "list" : listName;
        walNotEmptyCollection.protect(_listName, list);
    }

    /**
     * Protect list. {@code listName} is {@code "list"}.
     *
     * @param list Protected list.
     * @throws ProtectException If list is null or empty.
     */
    @Override
    public void protect(final List<T> list) throws ProtectException {
        protect("list", list);
    }
}
