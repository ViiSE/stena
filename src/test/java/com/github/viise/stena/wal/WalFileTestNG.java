package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.io.File;

public class WalFileTestNG {

    private final String testFileName = String.format(
            "%s%s",
            System.getProperty("user.dir"),
            "/src/test/resources/walFileTest.txt"
    );

    private final String testFileNameNotExists = "/src/test/resources/walFileTestNotExists.txt";

    private final Wall<File> walFile = new WalFile();
    
    @Test
    public void success_1() throws ProtectException {
        File file = new File(testFileName);
        walFile.protect(file);
    }

    @Test
    public void success_2() throws ProtectException {
        File myFile = new File(testFileName);
        walFile.protect("myFile", myFile);
    }

    @Test
    public void success_objNameIsNull() throws ProtectException {
        File file = new File(testFileName);
        walFile.protect(null, file);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "file is null."
    )
    public void protect_fileIsNull_1() throws ProtectException {
        walFile.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myFile is null."
    )
    public void protect_fileIsNull_2() throws ProtectException {
        walFile.protect("myFile", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "file is null."
    )
    public void protect_fileIsNull_3() throws ProtectException {
        walFile.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "file with pathname '/src/test/resources/walFileTestNotExists.txt' is not exists."
    )
    public void protect_fileIsNotExist_1() throws ProtectException {
        walFile.protect(new File(testFileNameNotExists));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myFile with pathname '/src/test/resources/walFileTestNotExists.txt' is not exists."
    )
    public void protect_fileIsNotExist_2() throws ProtectException {
        walFile.protect("myFile", new File(testFileNameNotExists));
    }
}
