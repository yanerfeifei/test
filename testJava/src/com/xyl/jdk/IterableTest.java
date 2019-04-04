package com.xyl.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月14日  10:11:41
 * @Description:
 */
public class IterableTest {
    public static void main(String[] args) {
        /*List list = new ArrayList();
        list.iterator();*/
        String[] a = { "17", "52", "33", "412", "59", "62", "71" };
        List<String> list = Arrays.asList(a);
        //这个是使用的lambda表达式的的循环
        list.forEach(cc -> System.out.println(cc));
        System.out.println("------------------------------------>");

        String[] b = { "17", "52", "33", "412", "59", "62", "71" };
        List<String> list1 = Arrays.asList(b);
        //这个是使用lambda表达式的简化版本双冒号表达式（调用out对象的println方法）
        list1.forEach(System.out::println);
        System.out.println("------------------------------------>");

        String[] c = { "17", "52", "33", "412", "59", "62", "71" };
        List<String> list2 = Arrays.asList(c);
        //这个还是用的java8提供的新函数，但是没有用lambda表达式
        list2.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                // TODO Auto-generated method stub
                System.out.println(t);
            }
        });
    }
}
