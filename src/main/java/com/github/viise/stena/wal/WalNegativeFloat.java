package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Negative float protection.
 */
public final class WalNegativeFloat implements Wall<Float> {

    private final Wall<Object> walNotNull;

    public WalNegativeFloat() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative float.
     *
     * @param floatObjName Protected float name.
     * @param floatObj     Protected float.
     * @throws ProtectException If float is null and positive.
     */
    @Override
    public void protect(final String floatObjName, final Float floatObj) throws ProtectException {
        String _floatObjName = floatObjName == null ? "float" : floatObjName;
        walNotNull.protect(_floatObjName, floatObj);
        if (floatObj > 0.0f) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _floatObjName
            ));
        }
    }

    /**
     * Protect negative float. {@code floatObjName} is {@code "float"}.
     *
     * @param floatObj Protected float.
     * @throws ProtectException If float is null and positive.
     */
    @Override
    public void protect(final Float floatObj) throws ProtectException {
        protect("float", floatObj);
    }
}
