package com.xyl.singleton;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  11:50:27
 * @Description:恶汉模式
 */
public class SingletonHunger {
    private static SingletonHunger singletonHunger = new SingletonHunger();
    private SingletonHunger(){}
    public SingletonHunger getSingletonHunger(){
        return singletonHunger;
    }
}
