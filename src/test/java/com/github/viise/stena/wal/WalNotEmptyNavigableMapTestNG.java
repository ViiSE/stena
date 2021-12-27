package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class WalNotEmptyNavigableMapTestNG {

    private final Wall<NavigableMap<?, ?>> walNotEmptyNavigableMap = new WalNotEmptyNavigableMap();

    @Test
    public void protect_success_1() throws ProtectException {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "Hello!");

        walNotEmptyNavigableMap.protect(navigableMap);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        NavigableMap<Integer, String> myNavigableMap = new TreeMap<>();
        myNavigableMap.put(1, "Hello!");

        walNotEmptyNavigableMap.protect("myNavigableMap", myNavigableMap);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "Hello!");

        walNotEmptyNavigableMap.protect(null, navigableMap);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "navigableMap is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyNavigableMap.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "navigableMap is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyNavigableMap.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myNavigableMap is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyNavigableMap.protect("myNavigableMap", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "navigableMap is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyNavigableMap.protect(new TreeMap<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myNavigableMap is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyNavigableMap.protect("myNavigableMap", new TreeMap<>());
    }
}
