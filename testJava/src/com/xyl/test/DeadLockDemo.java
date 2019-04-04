package com.xyl.test;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月07日  09:49:56
 * @Description:演示线程职中的死锁
 */
public class DeadLockDemo {
    private String a = "A";
    private String b = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    try {
                        Thread.currentThread().sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.print(1);
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    synchronized (a){
                        System.out.println(2);
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
