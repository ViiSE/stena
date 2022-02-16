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
 * Natural int protection.
 */
public final class WalNaturalInt implements Wall<Integer> {

    private final Wall<Object> walNotNull;
    private final Wall<Integer> walPositiveInt;
    private final Wall<Integer> walNotZeroInt;

    public WalNaturalInt() {
        this.walNotNull = new WalNotNull();
        this.walPositiveInt = new WalPositiveInt();
        this.walNotZeroInt = new WalNotZeroInt();
    }

    /**
     * Protect natural int.
     *
     * @param intObjName Protected natural int name.
     * @param intObj     Protected natural int.
     * @throws ProtectException If natural int is null, zero or negative.
     */
    @Override
    public void protect(final String intObjName, final Integer intObj) throws ProtectException {
        String _intObjName = intObjName == null ? "integer" : intObjName;
        walNotNull.protect(_intObjName, intObj);
        walNotZeroInt.protect(_intObjName, intObj);
        walPositiveInt.protect(_intObjName, intObj);
    }

    /**
     * Protect natural int. {@code intObj} is {@code "integer"}.
     *
     * @param intObj Protected natural int.
     * @throws ProtectException If natural int is null, zero or negative.
     */
    @Override
    public void protect(final Integer intObj) throws ProtectException {
        protect("integer", intObj);
    }
}
