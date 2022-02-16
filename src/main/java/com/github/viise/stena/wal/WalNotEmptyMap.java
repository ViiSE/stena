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

/**
 * Not empty map protection.
 */
public final class WalNotEmptyMap implements Wall<Map<?, ?>> {

    private final Wall<Object> walNotNull;

    public WalNotEmptyMap() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect map.
     *
     * @param mapName Protected map name.
     * @param map     Protected map.
     * @throws ProtectException If map is null or empty.
     */
    @Override
    public void protect(final String mapName, final Map<?, ?> map) throws ProtectException {
        String _mapName = mapName == null ? "map" : mapName;
        walNotNull.protect(_mapName, map);
        if (map.isEmpty()) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _mapName
            ));
        }
    }

    /**
     * Protect map. {@code "mapName"} is {@code "map"}.
     *
     * @param map Protected map.
     * @throws ProtectException If map is null or empty.
     */
    @Override
    public void protect(final Map<?, ?> map) throws ProtectException {
        protect("map", map);
    }
}
