package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Positive float protection.
 */
public final class WalPositiveFloat implements Wall<Float> {

    private final Wall<Object> walNotNull;

    public WalPositiveFloat() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect positive float.
     *
     * @param floatObjName Protected float name.
     * @param floatObj     Protected float.
     * @throws ProtectException If float is null and negative.
     */
    @Override
    public void protect(final String floatObjName, final Float floatObj) throws ProtectException {
        String _floatObjName = floatObjName == null ? "float" : floatObjName;
        walNotNull.protect(_floatObjName, floatObj);
        if (floatObj < 0.0f) {
            throw new ProtectException(String.format(
                    "%s  must be positive.",
                    _floatObjName
            ));
        }
    }

    /**
     * Protect positive float. {@code floatObjName} is {@code "float"}.
     *
     * @param floatObj Protected float.
     * @throws ProtectException If float is null and negative.
     */
    @Override
    public void protect(final Float floatObj) throws ProtectException {
        protect("float", floatObj);
    }
}
