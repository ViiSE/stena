package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Negative short protection.
 */
public final class WalNegativeShort implements Wall<Short> {

    private final Wall<Object> walNotNull;

    public WalNegativeShort() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative short.
     *
     * @param shortObjName Protected short name.
     * @param shortObj     Protected short.
     * @throws ProtectException If short is null and positive.
     */
    @Override
    public void protect(final String shortObjName, final Short shortObj) throws ProtectException {
        String _shortObjName = shortObjName == null ? "short" : shortObjName;
        walNotNull.protect(_shortObjName, shortObj);
        if (shortObj > 0) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _shortObjName
            ));
        }
    }

    /**
     * Protect negative short. {@code shortObjName} is {@code "short"}.
     *
     * @param shortObj Protected short.
     * @throws ProtectException If short is null and positive.
     */
    @Override
    public void protect(final Short shortObj) throws ProtectException {
        protect("short", shortObj);
    }
}
