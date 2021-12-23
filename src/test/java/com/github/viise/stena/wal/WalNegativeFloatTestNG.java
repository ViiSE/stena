package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNegativeFloatTestNG {

    private final Wall<Float> walNegativeFloatEps = new WalNegativeFloat();

    @Test
    public void protect_success_1() throws ProtectException {
        walNegativeFloatEps.protect(-1.0f);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Float myFloat = -1.0f;
        walNegativeFloatEps.protect("myFloat", myFloat);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNegativeFloatEps.protect(null, -1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNegativeFloatEps.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float must be negative."
    )
    public void protect_eps_1() throws ProtectException {
        walNegativeFloatEps.protect(1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myFloat must be negative."
    )
    public void protect_eps_2() throws ProtectException {
        walNegativeFloatEps.protect("myFloat", 1.0f);
    }
}
