package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Collection;
import java.util.Deque;

/**
 * Not empty deque protection.
 */
public final class WalNotEmptyDeque<T> implements Wall<Deque<T>> {

    private final Wall<Collection<T>> walNotEmptyCollection;

    public WalNotEmptyDeque() {
        this.walNotEmptyCollection = new WalNotEmptyCollection<>();
    }

    /**
     * Protect deque.
     *
     * @param deqName Protected deque name.
     * @param deq     Protected deque.
     * @throws ProtectException If deque is null or empty.
     */
    @Override
    public void protect(final String deqName, final Deque<T> deq) throws ProtectException {
        String _deqName = deqName == null ? "deque" : deqName;
        walNotEmptyCollection.protect(_deqName, deq);
    }

    /**
     * Protect deque. {@code deqName} is {@code "deque"}.
     *
     * @param deq Protected deque.
     * @throws ProtectException If deque is null or empty.
     */
    @Override
    public void protect(final Deque<T> deq) throws ProtectException {
        protect("deque", deq);
    }
}
