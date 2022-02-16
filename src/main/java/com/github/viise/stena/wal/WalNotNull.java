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
