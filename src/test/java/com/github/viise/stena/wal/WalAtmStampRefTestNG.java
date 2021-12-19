package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicStampedReference;

public class WalAtmStampRefTestNG {

    private final Wall<AtomicStampedReference<String>> walAtmRef = new WalAtmStampRef<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walAtmRef.protect(new AtomicStampedReference<>("Hello!", 0));
    }

    @Test
    public void protect_success_2() throws ProtectException {
        AtomicStampedReference<String> myAtmStampRef = new AtomicStampedReference<>("Hello!", 0);
        walAtmRef.protect("myAtmStampRef", myAtmStampRef);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walAtmRef.protect(null, new AtomicStampedReference<>("Hello!", 0));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicStampedReference is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walAtmRef.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicStampedReference is null."
    )
    public void protect_null_1() throws ProtectException {
        walAtmRef.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmStampRef is null."
    )
    public void protect_null_2() throws ProtectException {
        walAtmRef.protect("myAtmStampRef", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "atomicStampedReference value is null."
    )
    public void protect_nullValue_1() throws ProtectException {
        walAtmRef.protect(new AtomicStampedReference<>(null, 0));
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myAtmStampRef value is null."
    )
    public void protect_nullValue_2() throws ProtectException {
        walAtmRef.protect("myAtmStampRef", new AtomicStampedReference<>(null, 0));
    }
}
