package com.lzx2005.training.thread.lock.spinlock;

/**
 * Created by Lizhengxian on 2017/2/28.
 *
 */

import java.util.concurrent.atomic.AtomicReference;

public class BadSpinLock {
    //持有自旋锁的线程对象
    AtomicReference<Thread> owner = new AtomicReference<Thread>();

    public void lock() {
        Thread cur = Thread.currentThread();
        while (!owner.compareAndSet(null, cur)) {
            System.out.println(cur.getName()+ " wait lock release");
        }
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        if (cur == owner.get()) {
            owner.compareAndSet(cur, null);
            System.out.println(cur.getName()+ " release lock");
        }
    }
}