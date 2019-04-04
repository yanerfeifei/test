package com.xyl.singleton;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  11:23:53
 * @Description:饱汉模式
 */
public class TestSingleton {
    private static TestSingleton testSingleton = null;
    public TestSingleton(){};
    public TestSingleton getTestSingleton(){
        if(null == testSingleton){
            return new TestSingleton();
        }
        return testSingleton;
    }
}
