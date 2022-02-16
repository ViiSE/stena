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
