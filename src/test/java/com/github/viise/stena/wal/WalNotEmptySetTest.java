package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class WalNotEmptySetTest {

    private final Wall<Set<String>> walNotEmptySet = new WalNotEmptySet<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptySet.protect(new HashSet<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptySet.protect("mySet", new HashSet<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptySet.protect(null, new HashSet<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "set is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptySet.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "set is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptySet.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySet is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptySet.protect("mySet", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "set is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptySet.protect(new HashSet<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySet is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptySet.protect("mySet", new HashSet<>());
    }
}
