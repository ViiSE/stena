package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Double less than epsilon protection.
 * More suitable case of protection is double value is almost zero.
 */
public final class WalDoubleEps implements Wall<Double> {

    private final Wall<Object> walNotNull;

    private final Double eps;

    /**
     * Ctor.
     *
     * @param eps double value that double value checked must not exceed.
     */
    public WalDoubleEps(Double eps) {
        this.eps = eps;
        this.walNotNull = new WalNotNull();
    }

    /**
     * Ctor.
     * Value of {@code eps} is {@code 0.000001d}.
     */
    public WalDoubleEps() {
        this(0.000001d);
    }

    /**
     * Protect double.
     *
     * @param doubleObjName Protected double name.
     * @param doubleObj     Protected double.
     * @throws ProtectException If double value is null and double is more than eps, or eps is null.
     */
    @Override
    public void protect(final String doubleObjName, final Double doubleObj) throws ProtectException {
        String _doubleObjName = doubleObjName == null ? "double" : doubleObjName;
        walNotNull.protect(_doubleObjName, doubleObj);
        walNotNull.protect("eps", eps);
        if (doubleObj > eps) {
            throw new ProtectException(String.format(
                    "%s must be less than eps.",
                    _doubleObjName
            ));
        }
    }

    /**
     * Protect double. {@code doubleObjName} is {@code "double"}.
     *
     * @param doubleObj Protected double.
     * @throws ProtectException If double value is null and double is more than eps, or eps is null.
     */
    @Override
    public void protect(final Double doubleObj) throws ProtectException {
        protect("double", doubleObj);
    }
}
