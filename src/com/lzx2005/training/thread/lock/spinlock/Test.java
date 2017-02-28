package com.lzx2005.training.thread.lock.spinlock;

/**
 * Created by Lizhengxian on 2017/2/28.
 */
public class Test implements Runnable {
    static int sum;
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

        Thread.currentThread().sleep(1000);
        System.out.println(sum);
    }

    @Override
    public void run() {
        this.lock.lock();
        this.lock.lock();
        sum++;
        this.lock.unLock();
        this.lock.unLock();
    }

}