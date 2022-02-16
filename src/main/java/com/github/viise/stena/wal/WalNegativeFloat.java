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
 * Negative float protection.
 */
public final class WalNegativeFloat implements Wall<Float> {

    private final Wall<Object> walNotNull;

    public WalNegativeFloat() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative float.
     *
     * @param floatObjName Protected float name.
     * @param floatObj     Protected float.
     * @throws ProtectException If float is null and positive.
     */
    @Override
    public void protect(final String floatObjName, final Float floatObj) throws ProtectException {
        String _floatObjName = floatObjName == null ? "float" : floatObjName;
        walNotNull.protect(_floatObjName, floatObj);
        if (floatObj > 0.0f) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _floatObjName
            ));
        }
    }

    /**
     * Protect negative float. {@code floatObjName} is {@code "float"}.
     *
     * @param floatObj Protected float.
     * @throws ProtectException If float is null and positive.
     */
    @Override
    public void protect(final Float floatObj) throws ProtectException {
        protect("float", floatObj);
    }
}
