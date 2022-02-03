package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class WalAtmRefArrTest {

    private final Wall<AtomicReferenceArray<String>> walAtmIntArr = new WalAtmRefArr<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walAtmIntArr.protect(new AtomicReferenceArray<>(new String[] {"Hello!"}));
    }

    @Test
    public void protect_success_2() throws ProtectException {
        AtomicReferenceArray<String> myAtmRefArr = new AtomicReferenceArray<>(new String[] {"Hello!"});
        walAtmIntArr.protect("myAtmRefArr", myAtmRefArr);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walAtmIntArr.protect(null, new AtomicReferenceArray<>(new String[] {"Hello!"}));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicReferenceArray is empty."
    )
    public void protect_empty_objNameIsNull() throws ProtectException {
        walAtmIntArr.protect(null, new AtomicReferenceArray<>(new String[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicReferenceArray is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walAtmIntArr.protect(new AtomicReferenceArray<>(new String[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmRefArr is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walAtmIntArr.protect("myAtmRefArr", new AtomicReferenceArray<>(new String[0]));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicReferenceArray is null."
    )
    public void protect_null_1() throws ProtectException {
        walAtmIntArr.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmRefArr is null."
    )
    public void protect_null_2() throws ProtectException {
        walAtmIntArr.protect("myAtmRefArr", null);
    }
}
