package com.xyl.singleton;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  13:50:52
 * @Description:
 */
public class SingletonHolder {
    private static class SingletonHolderMo{
        private static final SingletonHolder sing = new SingletonHolder();
        private SingletonHolderMo(){}
    }
    private SingletonHolder(){}
    public synchronized static SingletonHolder getSingletonHolder(){
        return SingletonHolderMo.sing;
    }
}
