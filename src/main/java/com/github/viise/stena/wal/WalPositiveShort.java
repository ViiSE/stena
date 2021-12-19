package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Positive short protection.
 */
public final class WalPositiveShort implements Wall<Short> {

    private final Wall<Object> walNotNull;

    public WalPositiveShort() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect positive short.
     *
     * @param shortObjName Protected short name.
     * @param shortObj     Protected short.
     * @throws ProtectException If short is null and negative.
     */
    @Override
    public void protect(final String shortObjName, final Short shortObj) throws ProtectException {
        String _shortObjName = shortObjName == null ? "short" : shortObjName;
        walNotNull.protect(_shortObjName, shortObj);
        if (shortObj < (short) 0) {
            throw new ProtectException(String.format(
                    "%s must be positive.",
                    _shortObjName
            ));
        }
    }

    /**
     * Protect positive short. {@code shortObjName} is {@code "short"}.
     *
     * @param shortObj Protected short.
     * @throws ProtectException If short is null and negative.
     */
    @Override
    public void protect(final Short shortObj) throws ProtectException {
        protect("short", shortObj);
    }
}
