package com.lzx2005.training.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        new CyclicBarrierDemo().go();
    }

    private void go() {
        System.out.println("主线程执行");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(new Task(cyclicBarrier), "Thread1").start();
        new Thread(new Task(cyclicBarrier), "Thread2").start();
        new Thread(new Task(cyclicBarrier), "Thread3").start();
        System.out.println("主线程继续执行");
    }

    class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "开始等待");
                int await = cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "剩余数：" + await);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "继续执行");
        }
    }

}
