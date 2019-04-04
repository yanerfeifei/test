package com.xyl.singleton;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  11:38:41
 * @Description:饱汉模式变种2
 */
public class SingletonThree {
    private static SingletonThree singletonThree = null;
    private SingletonThree(){}
    public synchronized static SingletonThree getSingletonThree(){
        if(null == singletonThree){
            synchronized (SingletonThree.class){
                singletonThree = new SingletonThree();
            }
        }
        return singletonThree;
    }
}
