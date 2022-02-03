package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

public class WalPositiveLongTest {

    private final Wall<Long> walPositiveLong = new WalPositiveLong();

    @Test
    public void protect_success_1() throws ProtectException {
        walPositiveLong.protect(1L);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Long myLong = 1L;
        walPositiveLong.protect("myLong", myLong);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walPositiveLong.protect(null, 1L);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "long is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walPositiveLong.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "long must be positive."
    )
    public void protect_negative_1() throws ProtectException {
        walPositiveLong.protect(-1L);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myLong must be positive."
    )
    public void protect_negative_2() throws ProtectException {
        walPositiveLong.protect("myLong", -1L);
    }
}
