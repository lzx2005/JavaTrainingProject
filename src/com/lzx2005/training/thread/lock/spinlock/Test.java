package com.lzx2005.training.thread.lock.spinlock;

/**
 * Created by Lizhengxian on 2017/2/28.
 */
public class Test implements Runnable {
    static int acc1=1000;
    static int acc2=1000;
    private SpinLock lock;

    public Test(SpinLock lock) {
        this.lock = lock;
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 100; i++) {
            Test test = new Test(lock);
            Thread t = new Thread(test);
            t.start();
        }

        Thread.currentThread().sleep(100000);
        System.out.println(acc1);
        System.out.println(acc2);
    }

    @Override
    public void run() {
        try {
            transAcc1ToAcc2(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void transAcc1ToAcc2(int count) throws InterruptedException {
        acc1 = acc1-count;
        Thread.currentThread().sleep(100);
        acc2 = acc2+count;
    }
}