package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * AtomicReferenceArray protection.
 */
public final class WalAtmRefArr<O> implements Wall<AtomicReferenceArray<O>> {

    private final Wall<Object> walNotNull;

    public WalAtmRefArr() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect atomicReferenceArray.
     *
     * @param atmRefArrName Protected atomicReferenceArray name.
     * @param atmRefArr     Protected atomicReferenceArray.
     * @throws ProtectException If atomicReferenceArray is null and length of atomicReferenceArray is 0.
     */
    @Override
    public void protect(final String atmRefArrName, final AtomicReferenceArray<O> atmRefArr) throws ProtectException {
        String _atmRefArrName = atmRefArrName == null ? "atomicReferenceArray" : atmRefArrName;
        walNotNull.protect(_atmRefArrName, atmRefArr);
        if (atmRefArr.length() == 0) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _atmRefArrName
            ));
        }
    }

    /**
     * Protect atomicReferenceArray. {@code atmRefArrName} is {@code "atomicReferenceArray"}.
     *
     * @param atmRefArrName Protected atomicReferenceArray.
     * @throws ProtectException If atomicIntegerArray is null and length of atomicIntegerArray is 0.
     */
    @Override
    public void protect(final AtomicReferenceArray<O> atmRefArrName) throws ProtectException {
        protect("atomicReferenceArray", atmRefArrName);
    }
}
