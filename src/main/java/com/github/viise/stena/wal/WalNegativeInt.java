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
 * Negative int protection.
 */
public final class WalNegativeInt implements Wall<Integer> {

    private final Wall<Object> walNotNull;

    public WalNegativeInt() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative int.
     *
     * @param intObjName Protected int name.
     * @param intObj     Protected int.
     * @throws ProtectException If int is null and positive.
     */
    @Override
    public void protect(final String intObjName, final Integer intObj) throws ProtectException {
        String _intObjName = intObjName == null ? "integer" : intObjName;
        walNotNull.protect(_intObjName, intObj);
        if (intObj > 0) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _intObjName
            ));
        }
    }

    /**
     * Protect negative int. {@code intObjName} is {@code "integer"}.
     *
     * @param intObj Protected int.
     * @throws ProtectException If int is null and positive.
     */
    @Override
    public void protect(final Integer intObj) throws ProtectException {
        protect("integer", intObj);
    }
}
