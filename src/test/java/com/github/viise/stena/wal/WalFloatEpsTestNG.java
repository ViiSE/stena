package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalFloatEpsTestNG {

    private final Wall<Float> walFloatEps = new WalFloatEps();

    @Test
    public void protect_success_1() throws ProtectException {
        walFloatEps.protect(0.0000000000000001f);
    }

    @Test
    public void protect_success_ctor2() throws ProtectException {
        new WalFloatEps(0.0000001f).protect(0.0000000000000001f);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Float myFloat = 0.0000000000000001f;
        walFloatEps.protect("myFloat", myFloat);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walFloatEps.protect(null, 0.0000000000000001f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walFloatEps.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float must be less than eps."
    )
    public void protect_eps_1() throws ProtectException {
        walFloatEps.protect(1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myFloat must be less than eps."
    )
    public void protect_eps_2() throws ProtectException {
        walFloatEps.protect("myFloat", 1.0f);
    }
}
