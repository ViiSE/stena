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
