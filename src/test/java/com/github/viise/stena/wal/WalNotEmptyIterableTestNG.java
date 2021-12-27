package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WalNotEmptyIterableTestNG {

    private final Wall<Iterable<String>> walNotEmptyIterable = new WalNotEmptyIterable<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyIterable.protect(new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptyIterable.protect("myIterable", new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyIterable.protect(null, new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "iterable is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyIterable.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "iterable is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyIterable.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myIterable is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyIterable.protect("myIterable", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "iterable is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyIterable.protect(new ArrayList<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myIterable is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyIterable.protect("myIterable", new ArrayList<>());
    }
}
