package com.lzx2005.training.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lizhengxian on 2017/2/28.
 */
public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,number*i);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        for(int i=0;i<10;i++){
            threads[i]=new Thread(new Calculator(i));
            if((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }

        try {
            FileWriter fileWriter = new FileWriter("text.conf",true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i=0;i<10;i++){
                printWriter.print("Main : Status of Thread "+i+" : "+threads[i].getState());
                states[i]=threads[i].getState();
            }


            for(int i=0;i<10;i++){
                threads[i].start();
            }

            boolean finish = false;
            while (!finish){
                for(int i=0;i<10;i++){
                    if(threads[i].getState()!=states[i]){
                        writeThreadInfo(printWriter,threads[i],states[i]);
                        states[i]=threads[i].getState();
                    }
                }
                finish=true;
                for(int i=0;i<10;i++){
                    finish = finish && (threads[i].getState()== Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        System.out.println("printing...");
        System.err.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        System.err.printf("Main : Priority: %d\n",thread.getPriority());
        System.err.printf("Main : Old State: %s\n",state);
        System.err.printf("Main : New State: %s\n",thread.getState());
        System.err.printf("Main : ====================================\n");
    }
}
