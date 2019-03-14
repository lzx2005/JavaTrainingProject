package com.lzx2005.training.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            final int n = i;
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    System.out.println("Accessing：" + n);
                    Thread.sleep((long) (Math.random() * 10000));
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("线程池关闭");
    }
}
