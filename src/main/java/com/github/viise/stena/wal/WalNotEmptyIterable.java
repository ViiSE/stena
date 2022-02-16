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
