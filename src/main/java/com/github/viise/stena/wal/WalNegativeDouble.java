package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Negative double protection.
 */
public final class WalNegativeDouble implements Wall<Double> {

    private final Wall<Object> walNotNull;

    public WalNegativeDouble() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative double.
     *
     * @param doubleObjName Protected double name.
     * @param doubleObj     Protected double.
     * @throws ProtectException If double is null and positive.
     */
    @Override
    public void protect(final String doubleObjName, final Double doubleObj) throws ProtectException {
        String _doubleObjName = doubleObjName == null ? "double" : doubleObjName;
        walNotNull.protect(_doubleObjName, doubleObj);
        if (doubleObj > 0.0d) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _doubleObjName
            ));
        }
    }

    /**
     * Protect negative double. {@code doubleObjName} is {@code "double"}.
     *
     * @param doubleObj Protected double.
     * @throws ProtectException If double is null and positive.
     */
    @Override
    public void protect(final Double doubleObj) throws ProtectException {
        protect("double", doubleObj);
    }
}