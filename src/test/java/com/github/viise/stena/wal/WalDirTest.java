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

import java.io.File;

public class WalDirTest {

    private final String testDirName = String.format(
            "%s%s",
            System.getProperty("user.dir"),
            "/src/test/resources/walDirTest"
    );

    private final String testFileName = String.format(
            "%s%s",
            System.getProperty("user.dir"),
            "/src/test/resources/walFileTest.txt"
    );

    private final String testDirNameNotExists = "/src/test/resources/walDirTestNotExists";

    private final Wall<File> walDir = new WalDir();
    
    @Test
    public void success_1() throws ProtectException {
        File dir = new File(testDirName);
        walDir.protect(dir);
    }

    @Test
    public void success_2() throws ProtectException {
        File myDir = new File(testDirName);
        walDir.protect("myDir", myDir);
    }

    @Test
    public void success_objNameIsNull() throws ProtectException {
        File dir = new File(testDirName);
        walDir.protect(null, dir);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "directory is null."
    )
    public void protect_dirIsNull_1() throws ProtectException {
        walDir.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDir is null."
    )
    public void protect_dirIsNull_2() throws ProtectException {
        walDir.protect("myDir", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "directory is null."
    )
    public void protect_dirIsNull_3() throws ProtectException {
        walDir.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "directory with pathname '/src/test/resources/walDirTestNotExists' is not exists."
    )
    public void protect_dirIsNotExist_1() throws ProtectException {
        walDir.protect(new File(testDirNameNotExists));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDir with pathname '/src/test/resources/walDirTestNotExists' is not exists."
    )
    public void protect_dirIsNotExist_2() throws ProtectException {
        walDir.protect("myDir", new File(testDirNameNotExists));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "file is not a directory : '.*/src/test/resources/walFileTest.txt'."
    )
    public void protect_dirIsNotDir_1() throws ProtectException {
        walDir.protect(new File(testFileName));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDir is not a directory : '.*/src/test/resources/walFileTest.txt'."
    )
    public void protect_dirIsNotDir_2() throws ProtectException {
        walDir.protect("myDir", new File(testFileName));
    }
}
