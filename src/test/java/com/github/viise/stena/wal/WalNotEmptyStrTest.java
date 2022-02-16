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

public class WalNotEmptyStrTest {

    private final Wall<String> walNotEmptyStr = new WalNotEmptyStr();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyStr.protect("Hello");
    }

    @Test
    public void protect_success_2() throws ProtectException {
        String myStr = "Hello!";
        walNotEmptyStr.protect("myStr", myStr);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyStr.protect(null, "Hello");
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "string is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyStr.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "string is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyStr.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myStr is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyStr.protect("myStr", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "string is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyStr.protect("");
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myStr is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyStr.protect("myStr", "");
    }
}
