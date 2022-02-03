package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNotEmptyStrTest {

    private final Wall<String> walNotEmptyStr = new WalNotEmptyStr();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyStr.protect("Hello");
    }

    @Test
    public void protect_success_2() throws ProtectException {
        String myStr = "Hello!";
        walNotEmptyStr.protect("myStr", myStr);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyStr.protect(null, "Hello");
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "string is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyStr.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "string is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyStr.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myStr is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyStr.protect("myStr", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "string is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyStr.protect("");
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myStr is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyStr.protect("myStr", "");
    }
}
