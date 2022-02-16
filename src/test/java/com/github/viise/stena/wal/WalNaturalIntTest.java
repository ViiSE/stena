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

public class WalNaturalIntTest {

    private final Wall<Integer> walNaturalInt = new WalNaturalInt();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNaturalInt.protect(1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Integer myInt = 1;
        walNaturalInt.protect("myInt", myInt);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        Integer myInt = 1;
        walNaturalInt.protect(null, myInt);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be positive."
    )
    public void protect_negative_objNameIsNull() throws ProtectException {
        walNaturalInt.protect(null, -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be positive."
    )
    public void protect_negative_1() throws ProtectException {
        walNaturalInt.protect(-1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be positive."
    )
    public void protect_negative_2() throws ProtectException {
        walNaturalInt.protect("myInt", -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be not zero."
    )
    public void protect_zero_1() throws ProtectException {
        walNaturalInt.protect(0);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be not zero."
    )
    public void protect_zero_2() throws ProtectException {
        walNaturalInt.protect("myInt", 0);
    }
}
