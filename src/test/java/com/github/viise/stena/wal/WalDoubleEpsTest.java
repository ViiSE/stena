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

public class WalDoubleEpsTest {

    private final Wall<Double> walDoubleEps = new WalDoubleEps();

    @Test
    public void protect_success_1() throws ProtectException {
        walDoubleEps.protect(0.0000000000000001d);
    }

    @Test
    public void protect_success_ctor2() throws ProtectException {
        new WalDoubleEps(0.0000001d).protect(0.0000000000000001d);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Double myDouble = 0.0000000000000001d;
        walDoubleEps.protect("myDouble", myDouble);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walDoubleEps.protect(null, 0.0000000000000001d);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "double is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walDoubleEps.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "double must be less than eps."
    )
    public void protect_eps_1() throws ProtectException {
        walDoubleEps.protect(1.0d);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDouble must be less than eps."
    )
    public void protect_eps_2() throws ProtectException {
        walDoubleEps.protect("myDouble", 1.0d);
    }
}
