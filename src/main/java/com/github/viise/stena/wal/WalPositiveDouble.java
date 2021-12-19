package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Positive double protection.
 */
public final class WalPositiveDouble implements Wall<Double> {

    private final Wall<Object> walNotNull;

    public WalPositiveDouble() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect positive double.
     *
     * @param doubleObjName Protected double name.
     * @param doubleObj     Protected double.
     * @throws ProtectException If double is null and negative.
     */
    @Override
    public void protect(final String doubleObjName, final Double doubleObj) throws ProtectException {
        String _doubleObjName = doubleObjName == null ? "double" : doubleObjName;
        walNotNull.protect(_doubleObjName, doubleObj);
        if (doubleObj < 0.0d) {
            throw new ProtectException(String.format(
                    "%s must be positive.",
                    _doubleObjName
            ));
        }
    }

    /**
     * Protect positive double. {@code doubleObjName} is {@code "double"}.
     *
     * @param doubleObj Protected double.
     * @throws ProtectException If double is null and negative.
     */
    @Override
    public void protect(final Double doubleObj) throws ProtectException {
        protect("double", doubleObj);
    }
}
