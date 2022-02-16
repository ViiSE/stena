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

import java.util.HashSet;
import java.util.Set;

public class WalNotEmptySetTest {

    private final Wall<Set<String>> walNotEmptySet = new WalNotEmptySet<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptySet.protect(new HashSet<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptySet.protect("mySet", new HashSet<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptySet.protect(null, new HashSet<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "set is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptySet.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "set is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptySet.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySet is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptySet.protect("mySet", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "set is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptySet.protect(new HashSet<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySet is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptySet.protect("mySet", new HashSet<>());
    }
}
