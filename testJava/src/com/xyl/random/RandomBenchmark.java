package com.xyl.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by meridian on 2018/11/15.
 */
public class RandomBenchmark {
    //并发场景下，ThreadLocalRandom 可以明显的提升性能
    public static void main(String[] args) {
        //ThreadLocalRandom 切记不要调用 current 方法之后，作为共享变量使用
        //ThreadLocalRandom.current() 会使用初始化它的线程来填充随机种子，这会带来导致多个线程使用相同的 seed
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i<10;i++){
            new Thread(() -> {
                System.out.println(rand.nextInt(10000));
            }).start();
        }
        //确保不同线程获取不同的 seed，最简单的方式便是每次调用都是使用 current()
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.nextInt(10000));
            new Thread(() -> {
                System.out.println(ThreadLocalRandom.current().nextInt(10000));
            }).start();
        }
    }
}
