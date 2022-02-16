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
import org.testng.annotations.Test;

public class WalNegativeShortTest {

    private final Wall<Short> walNegativeShort = new WalNegativeShort();

    @Test
    public void protect_success_1() throws ProtectException {
        walNegativeShort.protect((short) -1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Short myShort = (short) -1;
        walNegativeShort.protect("myShort", myShort);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNegativeShort.protect(null, (short) -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNegativeShort.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short must be negative."
    )
    public void protect_negative_1() throws ProtectException {
        walNegativeShort.protect((short) 1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myShort must be negative."
    )
    public void protect_negative_2() throws ProtectException {
        walNegativeShort.protect("myShort", (short) 1);
    }
}
