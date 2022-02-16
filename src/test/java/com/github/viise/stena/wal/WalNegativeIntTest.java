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

public class WalNegativeIntTest {

    private final Wall<Integer> walNegativeInt = new WalNegativeInt();

    @Test
    public void protect_success1() throws ProtectException {
        walNegativeInt.protect(-1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Integer myInt = -1;
        walNegativeInt.protect("myInt", myInt);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNegativeInt.protect(null, -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNegativeInt.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be negative."
    )
    public void protect_negative_1() throws ProtectException {
        walNegativeInt.protect(1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be negative."
    )
    public void protect_negative_2() throws ProtectException {
        walNegativeInt.protect("myInt", 1);
    }
}
