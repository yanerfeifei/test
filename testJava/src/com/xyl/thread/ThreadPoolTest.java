package com.xyl.thread;

import java.util.concurrent.Executors;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  15:31:38
 * @Description:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        System.out.println("主线程运行开始。。。。。。。。");
        Executors.newCachedThreadPool().submit(() -> {
                System.out.println("子线程1异步完成某些任务。。。。"+Thread.currentThread().getName());
        });
        Executors.newCachedThreadPool().submit(() ->{
            System.out.println("子线程2异步完成某些任务。。。。"+Thread.currentThread().getName());
        });
        System.out.println("主线程运行结束。。。。。。。。");
    }
}
