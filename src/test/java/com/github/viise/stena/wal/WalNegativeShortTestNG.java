package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNegativeShortTestNG {

    private final Wall<Short> walNegativeShort = new WalNegativeShort();

    @Test
    public void protect_success_1() throws ProtectException {
        walNegativeShort.protect((short) -1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Short myShort = (short) -1;
        walNegativeShort.protect("myShort", myShort);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNegativeShort.protect(null, (short) -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNegativeShort.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short must be negative."
    )
    public void protect_negative_1() throws ProtectException {
        walNegativeShort.protect((short) 1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myShort must be negative."
    )
    public void protect_negative_2() throws ProtectException {
        walNegativeShort.protect("myShort", (short) 1);
    }
}
