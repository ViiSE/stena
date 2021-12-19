package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Collection;

/**
 * Not empty collection protection.
 */
public final class WalNotEmptyCollection<T> implements Wall<Collection<T>> {

    private final Wall<Object> walNotNull;

    public WalNotEmptyCollection() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect collection.
     *
     * @param cltName Protected collection name.
     * @param clt     Protected collection.
     * @throws ProtectException If collection is null or empty.
     */
    @Override
    public void protect(final String cltName, final Collection<T> clt) throws ProtectException {
        String _cltName = cltName == null ? "collection" : cltName;
        walNotNull.protect(_cltName, clt);
        if (clt.isEmpty()) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _cltName
            ));
        }
    }

    /**
     * Protect collection. {@code cltName} is {@code "collection"}.
     *
     * @param clt Protected collection.
     * @throws ProtectException If collection is null or empty.
     */
    @Override
    public void protect(final Collection<T> clt) throws ProtectException {
        protect("collection", clt);
    }
}
