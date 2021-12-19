package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Not empty iterable protection.
 */
public final class WalNotEmptyIterable<T> implements Wall<Iterable<T>> {

    private final Wall<Object> walNotNull;

    public WalNotEmptyIterable() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect iterable.
     *
     * @param itrName Protected iterable name.
     * @param itr     Protected iterable.
     * @throws ProtectException If iterable is null or empty.
     */
    @Override
    public void protect(final String itrName, final Iterable<T> itr) throws ProtectException {
        String _itrName = itrName == null ? "iterable" : itrName;
        walNotNull.protect(_itrName, itr);
        if (itr.spliterator().getExactSizeIfKnown() == 0L) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _itrName
            ));
        }
    }

    /**
     * Protect iterable. {@code itrName} is {@code "iterable"}.
     *
     * @param itr Protected iterable.
     * @throws ProtectException If iterable is null or empty.
     */
    @Override
    public void protect(final Iterable<T> itr) throws ProtectException {
        protect("iterable", itr);
    }
}
