package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class WalNotEmptyDequeueTestNG {

    private final Wall<Deque<String>> walNotEmptyDeque = new WalNotEmptyDeque<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyDeque.protect(new ArrayDeque<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptyDeque.protect("myDeque", new ArrayDeque<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyDeque.protect(null, new ArrayDeque<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "deque is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyDeque.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "deque is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyDeque.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDeque is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyDeque.protect("myDeque", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "deque is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyDeque.protect(new ArrayDeque<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myDeque is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyDeque.protect("myDeque", new ArrayDeque<>());
    }
}
