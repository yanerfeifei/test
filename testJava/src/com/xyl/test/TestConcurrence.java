package com.xyl.test;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月07日  09:26:04
 * @Description:测试  多线程一定快吗
 */
public class TestConcurrence {
    private static final long count = 100001;

    public static void main(String[] args) {
        concurrence();
        serial();
    }

    private static void serial() {
        long s = System.currentTimeMillis();
        int a = 0;
        int b = 0;
        for (int i = 0; i < count; i++) {
            a+=5;
        }
        for (int i = 0; i < count; i++) {
            b--;
        }
        System.out.print(System.currentTimeMillis()-s);
        System.out.print("tyuiop");
    }

    private static void concurrence() {
        long s = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a+=5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        System.out.print(System.currentTimeMillis()-s);
        System.out.print("ttty");
    }
}
/******
 * 结论，多线程不一定快
 */
