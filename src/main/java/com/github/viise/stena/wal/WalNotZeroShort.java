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
 * Not zero short protection.
 */
public final class WalNotZeroShort implements Wall<Short> {

    private final Wall<Object> walNotNull;

    public WalNotZeroShort() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect not zero short.
     *
     * @param shortObjName Protected short name.
     * @param shortObj     Protected short.
     * @throws ProtectException If short is null and zero.
     */
    @Override
    public void protect(final String shortObjName, final Short shortObj) throws ProtectException {
        String _shortObjName = shortObjName == null ? "short" : shortObjName;
        walNotNull.protect(_shortObjName, shortObj);
        if (shortObj.equals((short) 0)) {
            throw new ProtectException(String.format(
                    "%s must be not zero.",
                    _shortObjName
            ));
        }
    }

    /**
     * Protect not zero short. {@code shortObjName} is {@code "short"}.
     *
     * @param shortObj Protected short.
     * @throws ProtectException If short is null and zero.
     */
    @Override
    public void protect(final Short shortObj) throws ProtectException {
        protect("short", shortObj);
    }
}
