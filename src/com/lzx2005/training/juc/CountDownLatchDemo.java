package com.lzx2005.training.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Task(countDownLatch), "Thread1").start();
        new Thread(new Task(countDownLatch), "Thread2").start();
        new Thread(new Task(countDownLatch), "Thread3").start();

        countDownLatch.await();

        System.out.println("所有线程到达");

    }


    static class Task implements Runnable{

        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：到达");
            countDownLatch.countDown();
        }
    }
}
