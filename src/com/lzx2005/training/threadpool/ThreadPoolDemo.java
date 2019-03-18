package com.lzx2005.training.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzlizx on 2019/3/5
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                100,
                10,
                TimeUnit.MILLISECONDS,
                queue
        );
        for(int i=0;i<11;i++){
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(queue.size());
    }
}
