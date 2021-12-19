package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class WalAtmRefTestNG {

    private final Wall<AtomicReference<String>> walAtmRef = new WalAtmRef<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walAtmRef.protect(new AtomicReference<>("Hello!"));
    }

    @Test
    public void protect_success_2() throws ProtectException {
        AtomicReference<String> myAtmRef = new AtomicReference<>("Hello!");
        walAtmRef.protect("myAtmRef", myAtmRef);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walAtmRef.protect(null, new AtomicReference<>("Hello!"));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicReference is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walAtmRef.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicReference is null."
    )
    public void protect_null_1() throws ProtectException {
        walAtmRef.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmRef is null."
    )
    public void protect_null_2() throws ProtectException {
        walAtmRef.protect("myAtmRef", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicReference value is null."
    )
    public void protect_nullValue_1() throws ProtectException {
        walAtmRef.protect(new AtomicReference<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmRef value is null."
    )
    public void protect_nullValue_2() throws ProtectException {
        walAtmRef.protect("myAtmRef", new AtomicReference<>());
    }
}
