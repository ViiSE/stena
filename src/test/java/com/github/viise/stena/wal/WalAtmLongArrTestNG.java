package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicLongArray;

public class WalAtmLongArrTestNG {

    private final Wall<AtomicLongArray> walAtmLongArr = new WalAtmLongArr();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walAtmLongArr.protect(new AtomicLongArray(new long[] {0L}));
    }

    @Test
    public void protect_success_2() throws ProtectException {
        AtomicLongArray myAtmLongArr = new AtomicLongArray(new long[] {0L});
        walAtmLongArr.protect("myAtmLongArr", myAtmLongArr);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walAtmLongArr.protect(null, new AtomicLongArray(new long[] {0L}));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicLongArray is empty."
    )
    public void protect_empty_objNameIsNull() throws ProtectException {
        walAtmLongArr.protect(null, new AtomicLongArray(new long[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicLongArray is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walAtmLongArr.protect(new AtomicLongArray(new long[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmLongArr is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walAtmLongArr.protect("myAtmLongArr", new AtomicLongArray(new long[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicLongArray is null."
    )
    public void protect_null_1() throws ProtectException {
        walAtmLongArr.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmLongArr is null."
    )
    public void protect_null_2() throws ProtectException {
        walAtmLongArr.protect("myAtmLongArr", null);
    }
}
