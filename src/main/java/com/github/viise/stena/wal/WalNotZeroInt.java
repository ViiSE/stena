package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Not zero int protection.
 */
public final class WalNotZeroInt implements Wall<Integer> {

    private final Wall<Object> walNotNull;

    public WalNotZeroInt() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect not zero int.
     *
     * @param intObjName Protected int name.
     * @param intObj     Protected int.
     * @throws ProtectException If int is null and zero.
     */
    @Override
    public void protect(final String intObjName, final Integer intObj) throws ProtectException {
        String _intObjName = intObjName == null ? "integer" : intObjName;
        walNotNull.protect(_intObjName, intObj);
        if (intObj.equals(0)) {
            throw new ProtectException(String.format(
                    "%s must be not zero.",
                    _intObjName
            ));
        }
    }

    /**
     * Protect not zero int. {@code intObjName} is {@code "integer"}.
     *
     * @param intObj Protected int.
     * @throws ProtectException If int is null and zero.
     */
    @Override
    public void protect(final Integer intObj) throws ProtectException {
        protect("integer", intObj);
    }
}
