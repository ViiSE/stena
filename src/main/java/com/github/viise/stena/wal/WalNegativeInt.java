package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Negative int protection.
 */
public final class WalNegativeInt implements Wall<Integer> {

    private final Wall<Object> walNotNull;

    public WalNegativeInt() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative int.
     *
     * @param intObjName Protected int name.
     * @param intObj     Protected int.
     * @throws ProtectException If int is null and positive.
     */
    @Override
    public void protect(final String intObjName, final Integer intObj) throws ProtectException {
        String _intObjName = intObjName == null ? "integer" : intObjName;
        walNotNull.protect(_intObjName, intObj);
        if (intObj > 0) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _intObjName
            ));
        }
    }

    /**
     * Protect negative int. {@code intObjName} is {@code "integer"}.
     *
     * @param intObj Protected int.
     * @throws ProtectException If int is null and positive.
     */
    @Override
    public void protect(final Integer intObj) throws ProtectException {
        protect("integer", intObj);
    }
}
