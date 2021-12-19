package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Not zero long protection.
 */
public final class WalNotZeroLong implements Wall<Long> {

    private final Wall<Object> walNotNull;

    public WalNotZeroLong() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect not zero long.
     *
     * @param longObjName Protected long name.
     * @param longObj     Protected long.
     * @throws ProtectException If long is null and zero.
     */
    @Override
    public void protect(final String longObjName, final Long longObj) throws ProtectException {
        String _longObjName = longObjName == null ? "long" : longObjName;
        walNotNull.protect(_longObjName, longObj);
        if (longObj.equals(0L)) {
            throw new ProtectException(String.format(
                    "%s must be not zero.",
                    _longObjName
            ));
        }
    }

    /**
     * Protect not zero long. {@code longObjName} is {@code "long"}.
     *
     * @param longObj Protected long.
     * @throws ProtectException If long is null and zero.
     */
    @Override
    public void protect(final Long longObj) throws ProtectException {
        protect("long", longObj);
    }
}
