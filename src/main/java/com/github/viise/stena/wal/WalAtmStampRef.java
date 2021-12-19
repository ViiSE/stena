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
