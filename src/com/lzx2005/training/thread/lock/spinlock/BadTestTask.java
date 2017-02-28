package com.lzx2005.training.thread.lock.spinlock;

/**
 * Created by Lizhengxian on 2017/2/28.
 */

public class BadTestTask implements Runnable{
    static int sum;
    private BadSpinLock lock;

    public BadTestTask(BadSpinLock lock) {
        this.lock = lock;
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        BadSpinLock lock = new BadSpinLock();
        for (int i = 0; i < 2; i++) {
            BadTestTask test = new BadTestTask(lock);
            Thread t = new Thread(test);
            t.start();
        }

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
