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

public class WalPositiveFloatTest {

    private final Wall<Float> walPositiveFloatEps = new WalPositiveFloat();

    @Test
    public void protect_success_1() throws ProtectException {
        walPositiveFloatEps.protect(1.0f);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Float myFloat = 1.0f;
        walPositiveFloatEps.protect("myFloat", myFloat);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walPositiveFloatEps.protect(null, 1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walPositiveFloatEps.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float must be positive."
    )
    public void protect_eps_1() throws ProtectException {
        walPositiveFloatEps.protect(-1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myFloat must be positive."
    )
    public void protect_eps_2() throws ProtectException {
        walPositiveFloatEps.protect("myFloat", -1.0f);
    }
}
