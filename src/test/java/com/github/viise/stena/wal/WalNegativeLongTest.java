package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNegativeLongTest {

    private final Wall<Long> walNegativeLong = new WalNegativeLong();

    @Test
    public void protect_success_1() throws ProtectException {
        walNegativeLong.protect(-1L);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Long myLong = -1L;
        walNegativeLong.protect("myLong", myLong);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNegativeLong.protect(null, -1L);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "long is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNegativeLong.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "long must be negative."
    )
    public void protect_negative_1() throws ProtectException {
        walNegativeLong.protect(1L);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myLong must be negative."
    )
    public void protect_negative_2() throws ProtectException {
        walNegativeLong.protect("myLong", 1L);
    }
}
