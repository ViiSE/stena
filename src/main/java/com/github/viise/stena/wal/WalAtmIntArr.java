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

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray protection.
 */
public final class WalAtmIntArr implements Wall<AtomicIntegerArray> {

    private final Wall<Object> walNotNull;

    public WalAtmIntArr() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect atomicIntegerArray.
     *
     * @param atmIntArrName Protected atomicIntegerArray name.
     * @param atmIntArr     Protected atomicIntegerArray.
     * @throws ProtectException If atomicIntegerArray is null and length of atomicIntegerArray is 0.
     */
    @Override
    public void protect(final String atmIntArrName, final AtomicIntegerArray atmIntArr) throws ProtectException {
        String _atmIntArrName = atmIntArrName == null ? "atomicIntegerArray" : atmIntArrName;
        walNotNull.protect(_atmIntArrName, atmIntArr);
        if (atmIntArr.length() == 0) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _atmIntArrName
            ));
        }
    }

    /**
     * Protect atomicIntegerArray. {@code atmIntArrName} is {@code "atomicIntegerArray"}.
     *
     * @param atmIntArr Protected atomicIntegerArray.
     * @throws ProtectException If atomicIntegerArray is null and length of atomicIntegerArray is 0.
     */
    @Override
    public void protect(final AtomicIntegerArray atmIntArr) throws ProtectException {
        protect("atomicIntegerArray", atmIntArr);
    }
}
