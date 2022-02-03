package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalNotZeroLongTest {

    private final Wall<Long> walNotZeroLong = new WalNotZeroLong();

    @Test
    public void protect_success_1() throws ProtectException {
        walNotZeroLong.protect(1L);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Long myLong = 1L;
        walNotZeroLong.protect("myLong", myLong);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotZeroLong.protect(null, 1L);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "long is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotZeroLong.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "long must be not zero."
    )
    public void protect_zero_1() throws ProtectException {
        walNotZeroLong.protect(0L);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myLong must be not zero."
    )
    public void protect_zero_2() throws ProtectException {
        walNotZeroLong.protect("myLong", 0L);
    }
}
