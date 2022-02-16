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

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference protection.
 */
public final class WalAtmStampRef<V> implements Wall<AtomicStampedReference<V>> {

    private final Wall<Object> walNotNull;

    public WalAtmStampRef() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect atomicStampedReference.
     *
     * @param atmStampRefName Protected atomicStampedReference name.
     * @param atmStampRef     Protected atomicStampedReference.
     * @throws ProtectException If atomicStampedReference is null and reference is null.
     */
    @Override
    public void protect(final String atmStampRefName, final AtomicStampedReference<V> atmStampRef) throws ProtectException {
        String _atmStampRefName = atmStampRefName == null ? "atomicStampedReference" : atmStampRefName;
        walNotNull.protect(_atmStampRefName, atmStampRef);
        walNotNull.protect(String.format("%s value", _atmStampRefName), atmStampRef.getReference());
    }

    /**
     * Protect atomicStampedReference. {@code atmStampRefName} is {@code "atomicStampedReference"}.
     *
     * @param atmStampRef Protected atomicStampedReference.
     * @throws ProtectException If atomicStampedReference is null and reference is null.
     */
    @Override
    public void protect(final AtomicStampedReference<V> atmStampRef) throws ProtectException {
        protect("atomicStampedReference", atmStampRef);
    }
}
