package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

/**
 * Not empty string protection.
 */
public final class WalNotEmptyStr implements Wall<String> {

    private final Wall<Object> walNotNull;

    public WalNotEmptyStr() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect string.
     *
     * @param strName Protected string name.
     * @param str     Protected string.
     * @throws ProtectException If string is null or empty.
     */
    @Override
    public void protect(final String strName, final String str) throws ProtectException {
        String _strName = strName == null ? "string" : strName;
        walNotNull.protect(_strName, str);
        if (str.isEmpty()) {
            throw new ProtectException(String.format(
                    "%s is empty.",
                    _strName
            ));
        }
    }

    /**
     * Protect string. {@code strName} is {@code "string"}.
     *
     * @param srt Protected string.
     * @throws ProtectException If string is null or empty.
     */
    @Override
    public void protect(final String srt) throws ProtectException {
        protect("string", srt);
    }
}
