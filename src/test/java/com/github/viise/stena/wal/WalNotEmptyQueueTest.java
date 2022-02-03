package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class WalNotEmptyQueueTest {

    private final Wall<Queue<String>> walNotEmptyQueue = new WalNotEmptyQueue<>();
    
    @Test
    public void protect_success_1() throws ProtectException {
        walNotEmptyQueue.protect(new PriorityQueue<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_2() throws ProtectException {
        walNotEmptyQueue.protect("myQueue", new PriorityQueue<String>() {{ add("Hello!"); }});
    }

    @Test
    public void protect_success_objNameIsNull() throws ProtectException {
        walNotEmptyQueue.protect(null, new PriorityQueue<String>() {{ add("Hello!"); }});
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "queue is null."
    )
    public void protect_null_objNameIsNull() throws ProtectException {
        walNotEmptyQueue.protect(null, null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "queue is null."
    )
    public void protect_null_1() throws ProtectException {
        walNotEmptyQueue.protect(null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myQueue is null."
    )
    public void protect_null_2() throws ProtectException {
        walNotEmptyQueue.protect("myQueue", null);
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "queue is empty."
    )
    public void protect_empty_1() throws ProtectException {
        walNotEmptyQueue.protect(new PriorityQueue<>());
    }

    @Test(
            expectedExceptions = ProtectException.class,
            expectedExceptionsMessageRegExp = "myQueue is empty."
    )
    public void protect_empty_2() throws ProtectException {
        walNotEmptyQueue.protect("myQueue", new PriorityQueue<>());
    }
}
