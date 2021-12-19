package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Collection;
import java.util.Queue;

/**
 * Not empty queue protection.
 */
public final class WalNotEmptyQueue<T> implements Wall<Queue<T>> {

    private final Wall<Collection<T>> walNotEmptyCollection;

    public WalNotEmptyQueue() {
        this.walNotEmptyCollection = new WalNotEmptyCollection<>();
    }

    /**
     * Protect queue.
     *
     * @param queName Protected queue name.
     * @param que     Protected queue.
     * @throws ProtectException If queue is null or empty.
     */
    @Override
    public void protect(final String queName, final Queue<T> que) throws ProtectException {
        String _queName = queName == null ? "queue" : queName;
        walNotEmptyCollection.protect(_queName, que);
    }

    /**
     * Protect queue. {@code queName} is {@code "queue"}.
     *
     * @param que Protected queue.
     * @throws ProtectException If queue is null or empty.
     */
    @Override
    public void protect(final Queue<T> que) throws ProtectException {
        protect("queue", que);
    }
}
