package com.xyl.singleton;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  11:46:59
 * @Description:
 */
public class SingletonFour {
    private static volatile SingletonFour singletonFour = null;
    private SingletonFour(){}
    public synchronized static SingletonFour getSingletonFour(){
        if(null == singletonFour){
            synchronized (SingletonFour.class){
                singletonFour = new SingletonFour();
            }
        }
        return singletonFour;
    }
}
