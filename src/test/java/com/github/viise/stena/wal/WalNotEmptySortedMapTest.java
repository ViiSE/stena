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

import java.util.SortedMap;
import java.util.TreeMap;

public class WalNotEmptySortedMapTest {

    private final Wall<SortedMap<?, ?>> walNotEmptySortedMap = new WalNotEmptySortedMap();

    @Test
    public void protect_success_1() throws ProtectException {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(1, "Hello!");

        walNotEmptySortedMap.protect(sortedMap);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        SortedMap<Integer, String> mySortedMap = new TreeMap<>();
        mySortedMap.put(1, "Hello!");

        walNotEmptySortedMap.protect("mySortedMap", mySortedMap);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(1, "Hello!");

        walNotEmptySortedMap.protect(null, sortedMap);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "sortedMap is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptySortedMap.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "sortedMap is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptySortedMap.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySortedMap is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptySortedMap.protect("mySortedMap", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "sortedMap is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptySortedMap.protect(new TreeMap<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySortedMap is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptySortedMap.protect("mySortedMap", new TreeMap<>());
    }
}
