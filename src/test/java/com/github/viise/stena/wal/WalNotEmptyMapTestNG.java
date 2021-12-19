package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class WalNotEmptyMapTestNG {

    private final Wall<Map<?, ?>> walNotEmptyMap = new WalNotEmptyMap();

    @Test
    public void protect_success_1() throws ProtectException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello!");

        walNotEmptyMap.protect(map);
    }

    @Test
    public void protect_success_2() throws ProtectException {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "Hello!");

        walNotEmptyMap.protect("myMap", myMap);
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello!");

        walNotEmptyMap.protect(null, map);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "map is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyMap.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "map is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyMap.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myMap is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyMap.protect("myMap", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "map is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyMap.protect(new HashMap<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myMap is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyMap.protect("myMap", new HashMap<>());
    }
}
