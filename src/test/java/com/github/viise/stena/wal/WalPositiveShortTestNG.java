package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalPositiveShortTestNG {

    private final Wall<Short> walPositiveShort = new WalPositiveShort();

    @Test
    public void protect_success_1() throws ProtectException {
        walPositiveShort.protect((short) 1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Short myShort = (short) 1;
        walPositiveShort.protect("myShort", myShort);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walPositiveShort.protect(null, (short) 1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walPositiveShort.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short must be positive."
    )
    public void protect_negative_1() throws ProtectException {
        walPositiveShort.protect((short) -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myShort must be positive."
    )
    public void protect_negative_2() throws ProtectException {
        walPositiveShort.protect("myShort", (short) -1);
    }
}
