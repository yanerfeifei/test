package com.xyl.thread;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  16:19:35
 * @Description:一个实现了Runnable接口的任务
 */
public class TestTask implements Runnable {
    private String taskName;

    public TestTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        //一个比较耗时的工作
        for (int i = 0; i < 9999999; i++) ;
        System.out.println("执行 " + taskName + " ,所在线程ID为：" + Thread.currentThread().getId());
    }
}