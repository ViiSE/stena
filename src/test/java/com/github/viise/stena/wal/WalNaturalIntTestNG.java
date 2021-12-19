package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNaturalIntTestNG {

    private final Wall<Integer> walNaturalInt = new WalNaturalInt();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNaturalInt.protect(1);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Integer myInt = 1;
        walNaturalInt.protect("myInt", myInt);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        Integer myInt = 1;
        walNaturalInt.protect(null, myInt);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be positive."
    )
    public void protect_negative_objNameIsNull() throws ProtectException {
        walNaturalInt.protect(null, -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be positive."
    )
    public void protect_negative_1() throws ProtectException {
        walNaturalInt.protect(-1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be positive."
    )
    public void protect_negative_2() throws ProtectException {
        walNaturalInt.protect("myInt", -1);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "integer must be not zero."
    )
    public void protect_zero_1() throws ProtectException {
        walNaturalInt.protect(0);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myInt must be not zero."
    )
    public void protect_zero_2() throws ProtectException {
        walNaturalInt.protect("myInt", 0);
    }
}
