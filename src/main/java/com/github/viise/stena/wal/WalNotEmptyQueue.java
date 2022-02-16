/*
 * Copyright 2022 ViiSE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
