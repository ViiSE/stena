package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalPositiveFloatTest {

    private final Wall<Float> walPositiveFloatEps = new WalPositiveFloat();

    @Test
    public void protect_success_1() throws ProtectException {
        walPositiveFloatEps.protect(1.0f);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Float myFloat = 1.0f;
        walPositiveFloatEps.protect("myFloat", myFloat);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walPositiveFloatEps.protect(null, 1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walPositiveFloatEps.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "float must be positive."
    )
    public void protect_eps_1() throws ProtectException {
        walPositiveFloatEps.protect(-1.0f);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myFloat must be positive."
    )
    public void protect_eps_2() throws ProtectException {
        walPositiveFloatEps.protect("myFloat", -1.0f);
    }
}
