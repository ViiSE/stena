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
