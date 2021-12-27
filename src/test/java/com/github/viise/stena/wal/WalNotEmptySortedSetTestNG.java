package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class WalNotEmptySortedSetTestNG {

    private final Wall<SortedSet<String>> walNotEmptySortedSet = new WalNotEmptySortedSet<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptySortedSet.protect(new TreeSet<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptySortedSet.protect("mySortedSet", new TreeSet<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptySortedSet.protect(null, new TreeSet<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "sortedSet is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptySortedSet.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "sortedSet is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptySortedSet.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySortedSet is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptySortedSet.protect("mySortedSet", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "sortedSet is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptySortedSet.protect(new TreeSet<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "mySortedSet is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptySortedSet.protect("mySortedSet", new TreeSet<>());
    }
}
