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
