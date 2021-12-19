package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Float less than epsilon protection.
 * More suitable case of protection is float value is almost zero.
 */
public final class WalFloatEps implements Wall<Float> {

    private final Wall<Object> walNotNull;

    private final Float eps;

    /**
     * Ctor.
     *
     * @param eps double value that double value checked must not exceed.
     */
    public WalFloatEps(Float eps) {
        this.eps = eps;
        this.walNotNull = new WalNotNull();
    }

    /**
     * Ctor.
     * Objue of {@code eps} is {@code 0.000001f}.
     */
    public WalFloatEps() {
        this(0.000001f);
    }

    /**
     * Protect float.
     *
     * @param floatObjName Protected float name.
     * @param floatObj     Protected float.
     * @throws ProtectException If float value is null and float is more than eps, or eps is null.
     */
    @Override
    public void protect(final String floatObjName, final Float floatObj) throws ProtectException {
        String _floatObjName = floatObjName == null ? "float" : floatObjName;
        walNotNull.protect(_floatObjName, floatObj);
        walNotNull.protect("eps", eps);
        if (floatObj > eps) {
            throw new ProtectException(String.format(
                    "%s must be less than eps.",
                    _floatObjName
            ));
        }
    }

    /**
     * Protect float. {@code floatObjName} is {@code "float"}.
     *
     * @param floatObj Protected float.
     * @throws ProtectException If float value is null and float is more than eps, or eps is null.
     */
    @Override
    public void protect(final Float floatObj) throws ProtectException {
        protect("float", floatObj);
    }
}
