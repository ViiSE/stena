package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

public class WalNotEmptyCollectionTest {

    private final Wall<Collection<String>> walNotEmptyCollection = new WalNotEmptyCollection<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyCollection.protect(new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptyCollection.protect("myCollection", new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyCollection.protect(null, new ArrayList<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "collection is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyCollection.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "collection is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyCollection.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myCollection is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyCollection.protect("myCollection", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "collection is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyCollection.protect(new ArrayList<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myCollection is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyCollection.protect("myCollection", new ArrayList<>());
    }
}
