package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalPositiveIntTest {

    private final Wall<Integer> walPositiveInt = new WalPositiveInt();

    @Test
    public void protect_success_1() throws ProtectException {
        walPositiveInt.protect(1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Integer myInt = 1;
        walPositiveInt.protect("myInt", myInt);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walPositiveInt.protect(null, 1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walPositiveInt.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be positive."
    )
    public void protect_negative_1() throws ProtectException {
        walPositiveInt.protect(-1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be positive."
    )
    public void protect_negative_2() throws ProtectException {
        walPositiveInt.protect("myInt", -1);
    }
}
