package com.xyl.Synchronized;

/**
 * Created by meridian on 2018/9/26.
 */
public class SynchronizedTest {

    public synchronized void test1(){
    }

    public void test2(){
        synchronized(this){
        }
    }
}
