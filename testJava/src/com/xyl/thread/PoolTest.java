package com.xyl.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  15:24:34
 * @Description:
 */
public class PoolTest {
    private static final int threads = 10;
    public static void main(String[] args) {
        ExecutorService ser = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            MyRunnable myRunnable = new MyRunnable();
            ser.execute(myRunnable);
        }
        ser.shutdown();
        while (!ser.isTerminated()){}
        System.out.println("所有线程加载完毕。。");
    }
}
class MyRunnable implements  Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

