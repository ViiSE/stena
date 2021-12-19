package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNotNullTestNG {

    private final Wall<Object> walNotNull = new WalNotNull();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotNull.protect("Hello!");
    }

    @Test
    public void protect_success_2() throws ProtectException {
        String myObj = "Hello!";
        walNotNull.protect("myObj", myObj);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotNull.protect(null, "Hello!");
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "object is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotNull.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "object is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotNull.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myObj is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotNull.protect("myObj", null);
    }
}
