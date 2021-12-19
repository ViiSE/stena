package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Not null object protection.
 */
public final class WalNotNull implements Wall<Object> {

    /**
     * Protect object.
     *
     * @param objName Protected object name.
     * @param obj     Protected object.
     * @throws ProtectException If object is null.
     */
    @Override
    public void protect(final String objName, final Object obj) throws ProtectException {
        String _objName = objName == null ? "object" : objName;
        if (obj == null) {
            throw new ProtectException(String.format(
                    "%s is null.",
                    _objName
            ));
        }
    }

    /**
     * Protect object. {@code objName} is {@code "object"}.
     *
     * @param obj Protected object.
     * @throws ProtectException If object is null.
     */
    @Override
    public void protect(final Object obj) throws ProtectException {
        protect("object", obj);
    }
}
