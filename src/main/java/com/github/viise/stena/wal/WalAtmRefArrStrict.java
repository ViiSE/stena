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

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Strict atomicReferenceArray protection.
 */
public final class WalAtmRefArrStrict<O> implements Wall<AtomicReferenceArray<O>> {

    private final Wall<Object> walNotNull;
    private final Wall<AtomicReferenceArray<O>> walAtmRefArr;

    public WalAtmRefArrStrict() {
        this.walNotNull = new WalNotNull();
        this.walAtmRefArr = new WalAtmRefArr<>();
    }

    /**
     * Protect atomicReferenceArray.
     *
     * @param atmRefArrName Protected atomicReferenceArray name.
     * @param atmRefArr     Protected atomicReferenceArray.
     * @throws ProtectException If atomicReferenceArray is null, length of atomicReferenceArray is 0, and any element of
     *                          array is null.
     */
    @Override
    public void protect(final String atmRefArrName, final AtomicReferenceArray<O> atmRefArr) throws ProtectException {
        String _atmRefArrName = atmRefArrName == null ? "atomicReferenceArray" : atmRefArrName;
        walAtmRefArr.protect(_atmRefArrName, atmRefArr);
        for (int i = 0; i < atmRefArr.length(); i++) {
            walNotNull.protect(String.format("%s[%d]", _atmRefArrName, i), atmRefArr.get(i));
        }
    }

    /**
     * Protect atomicReferenceArray. {@code atmRefArrName} is {@code "atomicReferenceArray"}.
     *
     * @param atmRefArrName Protected atomicReferenceArray.
     * @throws ProtectException If atomicIntegerArray is null and length of atomicIntegerArray is 0, and any element of
     *                          array is null.
     */
    @Override
    public void protect(final AtomicReferenceArray<O> atmRefArrName) throws ProtectException {
        protect("atomicReferenceArray", atmRefArrName);
    }
}
