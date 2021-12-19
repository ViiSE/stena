package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Negative long protection.
 */
public final class WalNegativeLong implements Wall<Long> {

    private final Wall<Object> walNotNull;

    public WalNegativeLong() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect negative long.
     *
     * @param longObjName Protected long name.
     * @param longObj     Protected long.
     * @throws ProtectException If long is null and positive.
     */
    @Override
    public void protect(final String longObjName, final Long longObj) throws ProtectException {
        String _longObjName = longObjName == null ? "long" : longObjName;
        walNotNull.protect(_longObjName, longObj);
        if (longObj > 0L) {
            throw new ProtectException(String.format(
                    "%s must be negative.",
                    _longObjName
            ));
        }
    }

    /**
     * Protect negative long. {@code longObjName} is {@code "long"}.
     *
     * @param longObj Protected long.
     * @throws ProtectException If long is null and positive.
     */
    @Override
    public void protect(final Long longObj) throws ProtectException {
        protect("long", longObj);
    }
}
