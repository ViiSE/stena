/*
 * Copyright 2022 ViiSE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
