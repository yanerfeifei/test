package com.xyl.singleton;

/**
 *
 * 功能描述: 饱汉模式多线程下优化
 *
 * @param:
 * @return:
 * @auther: Alisa.Xie
 * @date: 2018/5/11 11:32
 */
public class TestSingletonTwo {
    private static TestSingletonTwo testSingletonTwo = null;
    public TestSingletonTwo(){}
    public synchronized static TestSingletonTwo getTestSingletonTwo(){
        if(null == testSingletonTwo){
            return new TestSingletonTwo();
        }
        return testSingletonTwo;
    }
}
