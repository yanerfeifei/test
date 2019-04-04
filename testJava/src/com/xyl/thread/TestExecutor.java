package com.xyl.thread;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  16:18:51
 * @Description:定时器测试
 */
public class TestExecutor {
    private Executor executor;

    /**
     * 设置执行器
     *
     * @param executor
     */
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    /**
     * 用执行器执行多个任务
     */
    public void executeTasks() {
        //连续执行10个任务
        for (int i = 0; i < 10; i++) {
            executor.execute(new TestTask("任务" + i));
        }
    }

    public static void main(String[] args) {
        TestExecutor testExecutor = new TestExecutor();
        testExecutor.setExecutor(Executors.newFixedThreadPool(2));
        testExecutor.executeTasks();
    }
}
