package com;

/**
 * Created by jsst_ on 12/8/2017.
 */
public class RunnableLambda {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3 ; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        Runnable runnableLambda = () ->{
            for (int i = 0; i < 3 ; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread t = new Thread(runnableLambda);
        t.run();
        t.join();
    }
}
