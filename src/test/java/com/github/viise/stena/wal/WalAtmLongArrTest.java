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

import java.util.concurrent.atomic.AtomicLongArray;

public class WalAtmLongArrTest {

    private final Wall<AtomicLongArray> walAtmLongArr = new WalAtmLongArr();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walAtmLongArr.protect(new AtomicLongArray(new long[] {0L}));
    }

    @Test
    public void protect_success_2() throws ProtectException {
        AtomicLongArray myAtmLongArr = new AtomicLongArray(new long[] {0L});
        walAtmLongArr.protect("myAtmLongArr", myAtmLongArr);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walAtmLongArr.protect(null, new AtomicLongArray(new long[] {0L}));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicLongArray is empty."
    )
    public void protect_empty_objNameIsNull() throws ProtectException {
        walAtmLongArr.protect(null, new AtomicLongArray(new long[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicLongArray is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walAtmLongArr.protect(new AtomicLongArray(new long[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmLongArr is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walAtmLongArr.protect("myAtmLongArr", new AtomicLongArray(new long[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicLongArray is null."
    )
    public void protect_null_1() throws ProtectException {
        walAtmLongArr.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmLongArr is null."
    )
    public void protect_null_2() throws ProtectException {
        walAtmLongArr.protect("myAtmLongArr", null);
    }
}
