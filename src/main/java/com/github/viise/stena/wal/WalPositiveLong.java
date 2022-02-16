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
 * Positive long protection.
 */
public final class WalPositiveLong implements Wall<Long> {

    private final Wall<Object> walNotNull;

    public WalPositiveLong() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect positive long.
     *
     * @param longObjName Protected long name.
     * @param longObj     Protected long.
     * @throws ProtectException If long is null and negative.
     */
    @Override
    public void protect(final String longObjName, final Long longObj) throws ProtectException {
        String _longObjName = longObjName == null ? "long" : longObjName;
        walNotNull.protect(_longObjName, longObj);
        if (longObj < 0L) {
            throw new ProtectException(String.format(
                    "%s must be positive.",
                    _longObjName
            ));
        }
    }

    /**
     * Protect positive long. {@code longObjName} is {@code "long"}.
     *
     * @param checkedObj Protected long.
     * @throws ProtectException If long is null and negative.
     */
    @Override
    public void protect(final Long checkedObj) throws ProtectException {
        protect("long", checkedObj);
    }
}
