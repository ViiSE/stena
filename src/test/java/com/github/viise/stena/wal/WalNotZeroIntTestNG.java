package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNotZeroIntTestNG {

    private final Wall<Integer> walNotZeroInt = new WalNotZeroInt();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotZeroInt.protect(1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Integer myInt = 1;
        walNotZeroInt.protect("myInt", myInt);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotZeroInt.protect(null, 1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotZeroInt.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be not zero."
    )
    public void protect_zero_1() throws ProtectException {
        walNotZeroInt.protect(0);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be not zero."
    )
    public void protect_zero_2() throws ProtectException {
        walNotZeroInt.protect("myInt", 0);
    }
}
