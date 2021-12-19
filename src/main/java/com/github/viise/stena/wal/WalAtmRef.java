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
