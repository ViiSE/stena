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

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * AtomicLongArray protection.
 */
public final class WalAtmLongArr implements Wall<AtomicLongArray> {

    private final Wall<Object> walNotNull;

    public WalAtmLongArr() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect atomicLongArray.
     *
     * @param atmLongArrName Protected atomicLongArray name.
     * @param atmLongArr     Protected atomicLongArray.
     * @throws ProtectException If atomicLongArray is null and length of atomicLongArray is 0.
     */
    @Override
    public void protect(final String atmLongArrName, final AtomicLongArray atmLongArr) throws ProtectException {
        String _atmLongArrName = atmLongArrName == null ? "atomicLongArray" : atmLongArrName;
        walNotNull.protect(_atmLongArrName, atmLongArr);
        if (atmLongArr.length() == 0) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _atmLongArrName
            ));
        }
    }

    /**
     * Protect atomicLongArray. {@code atmLongArrName} is {@code "atomicLongArray"}.
     *
     * @param atmLongArr Protected atomicLongArray.
     * @throws ProtectException If atomicLongArray is null and length of atomicLongArray is 0.
     */
    @Override
    public void protect(final AtomicLongArray atmLongArr) throws ProtectException {
        protect("atomicLongArray", atmLongArr);
    }
}
