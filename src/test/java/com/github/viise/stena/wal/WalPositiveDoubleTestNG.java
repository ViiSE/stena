package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalPositiveDoubleTestNG {

    private final Wall<Double> walPositiveDouble = new WalPositiveDouble();

    @Test
    public void protect_success_1() throws ProtectException {
        walPositiveDouble.protect(1.0d);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Double myDouble = 1.0d;
        walPositiveDouble.protect("myDouble", myDouble);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walPositiveDouble.protect(null, 1.0d);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "double is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walPositiveDouble.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "double must be positive."
    )
    public void protect_eps_1() throws ProtectException {
        walPositiveDouble.protect(-1.0d);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDouble must be positive."
    )
    public void protect_eps_2() throws ProtectException {
        walPositiveDouble.protect("myDouble", -1.0d);
    }
}
