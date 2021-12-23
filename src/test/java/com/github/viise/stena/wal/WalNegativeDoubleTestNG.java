package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNegativeDoubleTestNG {

    private final Wall<Double> walNegativeDouble = new WalNegativeDouble();

    @Test
    public void protect_success_1() throws ProtectException {
        walNegativeDouble.protect(-1.0d);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Double myDouble = -1.0d;
        walNegativeDouble.protect("myDouble", myDouble);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNegativeDouble.protect(null, -1.0d);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "double is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNegativeDouble.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "double must be negative."
    )
    public void protect_eps_1() throws ProtectException {
        walNegativeDouble.protect(1.0d);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDouble must be negative."
    )
    public void protect_eps_2() throws ProtectException {
        walNegativeDouble.protect("myDouble", 1.0d);
    }
}
