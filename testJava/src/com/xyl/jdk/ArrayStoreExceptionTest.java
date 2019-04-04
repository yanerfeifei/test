package com.xyl.jdk;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月14日  09:10:35
 * @Description:
 */
public class ArrayStoreExceptionTest {
    public static void main(String[] args) {
        Object x[] = new String[3];
        x[0] = new Integer(0);
    }
}
