package com.lzx2005.training.juc;

import io.github.lzx2005.constants.BrowserType;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start exchange...");
                String exchange = stringExchanger.exchange(Thread.currentThread().getName() + " calls");
                System.out.println(Thread.currentThread().getName() + " received : " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread1").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " start exchange...");
                String exchange = stringExchanger.exchange(Thread.currentThread().getName() + " calls");
                System.out.println(Thread.currentThread().getName() + " received : " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread2").start();

        BrowserType chrome = BrowserType.valueOf("Chrome");
        System.out.println(chrome);

    }
}
