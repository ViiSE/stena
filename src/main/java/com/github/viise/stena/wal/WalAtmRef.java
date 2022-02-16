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

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference protection.
 */
public final class WalAtmRef<O> implements Wall<AtomicReference<O>> {

    private final Wall<Object> walNotNull;

    public WalAtmRef() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect atomicReference.
     *
     * @param atmRefName Protected atomicReference name.
     * @param atmRef     Protected atomicReference.
     * @throws ProtectException If atomicReference is null and value of atomicReference is null.
     */
    @Override
    public void protect(final String atmRefName, final AtomicReference<O> atmRef) throws ProtectException {
        String _atmRefName = atmRefName == null ? "atomicReference" : atmRefName;
        walNotNull.protect(_atmRefName, atmRef);
        walNotNull.protect(String.format("%s value", _atmRefName), atmRef.get());
    }

    /**
     * Protect atomicReference. {@code atmRefName} is {@code "atomicReference"}.
     *
     * @param atmRef Protected atomicReference.
     * @throws ProtectException If atomicReference is null and value of atomicReference is null.
     */
    @Override
    public void protect(final AtomicReference<O> atmRef) throws ProtectException {
        protect("atomicReference", atmRef);
    }
}
