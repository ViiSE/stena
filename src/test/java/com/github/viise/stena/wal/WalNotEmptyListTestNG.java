package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WalNotEmptyListTestNG {

    private final Wall<List<String>> walNotEmptyList = new WalNotEmptyList<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyList.protect(new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptyList.protect("myList", new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyList.protect(null, new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "list is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyList.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "list is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyList.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myList is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyList.protect("myList", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "list is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyList.protect(new ArrayList<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myList is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyList.protect("myList", new ArrayList<>());
    }
}
