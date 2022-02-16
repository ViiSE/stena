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

import java.util.Map;
import java.util.SortedMap;

/**
 * Not empty sortedMap protection.
 */
public final class WalNotEmptySortedMap implements Wall<SortedMap<?, ?>> {

    private final Wall<Map<?, ?>> walNotEmptyMap;

    public WalNotEmptySortedMap() {
        this.walNotEmptyMap = new WalNotEmptyMap();
    }

    /**
     * Protect sortedMap.
     *
     * @param srtMapName Protected sortedMap name.
     * @param srtMap     Protected sortedMap.
     * @throws ProtectException If sortedMap is null or empty.
     */
    @Override
    public void protect(final String srtMapName, final SortedMap<?, ?> srtMap) throws ProtectException {
        String _srtMapName = srtMapName == null ? "sortedMap" : srtMapName;
        walNotEmptyMap.protect(_srtMapName, srtMap);
    }

    /**
     * Protect sortedMap. {@code srtMapName} is {@code "sortedMap"}.
     *
     * @param srtMap Protected sortedMap.
     * @throws ProtectException If sortedMap is null or empty.
     */
    @Override
    public void protect(final SortedMap<?, ?> srtMap) throws ProtectException {
        protect("sortedMap", srtMap);
    }
}
