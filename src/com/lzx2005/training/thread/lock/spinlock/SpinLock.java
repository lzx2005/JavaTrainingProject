package com.lzx2005.training.thread.lock.spinlock;

/**
 * Created by Lizhengxian on 2017/2/28.
 * 可重入的自旋锁  (重新进入 不会出现死锁)
 */

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    //持有自旋锁的线程对象
    AtomicReference<Thread> owner = new AtomicReference<Thread>();
    private int count;//用一个计数器 来做 重入锁获取次数的计数
    public void lock() {
        Thread cur = Thread.currentThread();
        //如果是相同的对象，直接返回，记录下进入锁的次数
        if (cur == owner.get()) {
            count++;
            return;
        }

        while (!owner.compareAndSet(null, cur)) {
            //当线程越来越多  由于while循环 会浪费CPU时间片，
            // CompareAndSet 需要多次对同一内存进行访问
            //会造成内存的竞争，然而对于X86，
            // 会采取竞争内存总线的方式来访问内存，
            //所以会造成内存访问速度下降(其他线程老访问缓存)，
            // 因而会影响整个系统的性能
        }
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        if (cur == owner.get()) {
            if (count > 0) {
                count--;
            } else {
                owner.compareAndSet(cur, null);
            }
        }
    }
}