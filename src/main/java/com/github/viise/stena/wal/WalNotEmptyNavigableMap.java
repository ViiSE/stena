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
import java.util.NavigableMap;

/**
 * Not empty navigableMap protection.
 */
public final class WalNotEmptyNavigableMap implements Wall<NavigableMap<?, ?>> {

    private final Wall<Map<?, ?>> walNotEmptyMap;

    public WalNotEmptyNavigableMap() {
        this.walNotEmptyMap = new WalNotEmptyMap();
    }

    /**
     * Protect navigableMap.
     *
     * @param navMapName Protected navigableMap name.
     * @param navMap     Protected navigableMap.
     * @throws ProtectException If navigableMap is null or empty.
     */
    @Override
    public void protect(final String navMapName, final NavigableMap<?, ?> navMap) throws ProtectException {
        String _navMapName = navMapName == null ? "navigableMap" : navMapName;
        walNotEmptyMap.protect(_navMapName, navMap);
    }

    /**
     * Protect navigableMap. {@code navMapName} is {@code "navigableMap}.
     *
     * @param navMap Protected navigableMap.
     * @throws ProtectException If navigableMap is null or empty.
     */
    @Override
    public void protect(final NavigableMap<?, ?> navMap) throws ProtectException {
        protect("navigableMap", navMap);
    }
}
