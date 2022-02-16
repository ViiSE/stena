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

public class WalNotNullTest {

    private final Wall<Object> walNotNull = new WalNotNull();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotNull.protect("Hello!");
    }

    @Test
    public void protect_success_2() throws ProtectException {
        String myObj = "Hello!";
        walNotNull.protect("myObj", myObj);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotNull.protect(null, "Hello!");
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "object is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotNull.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "object is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotNull.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myObj is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotNull.protect("myObj", null);
    }
}
