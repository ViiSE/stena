package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNotZeroShortTestNG {

    private final Wall<Short> walNotZeroShort = new WalNotZeroShort();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotZeroShort.protect((short) 1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Short myShort = (short) 1;
        walNotZeroShort.protect("myShort", myShort);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotZeroShort.protect(null, (short) 1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotZeroShort.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "short must be not zero."
    )
    public void protect_zero_1() throws ProtectException {
        walNotZeroShort.protect((short) 0);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myShort must be not zero."
    )
    public void protect_zero_2() throws ProtectException {
        walNotZeroShort.protect("myShort", (short) 0);
    }
}
