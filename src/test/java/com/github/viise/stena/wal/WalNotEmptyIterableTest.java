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

import java.util.ArrayList;

public class WalNotEmptyIterableTest {

    private final Wall<Iterable<String>> walNotEmptyIterable = new WalNotEmptyIterable<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyIterable.protect(new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptyIterable.protect("myIterable", new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyIterable.protect(null, new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "iterable is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyIterable.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "iterable is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyIterable.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myIterable is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyIterable.protect("myIterable", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "iterable is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyIterable.protect(new ArrayList<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myIterable is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyIterable.protect("myIterable", new ArrayList<>());
    }
}
