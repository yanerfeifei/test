package com.xyl.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月11日  17:42:13
 * @Description:
 */
public class NewGongNeng {
    public static void main(String[] args) {
        //1.可以通过Collection系列集合提供的stream() 或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中静态方法 stream() 获取数组流
       /* Person[] persons = new Person[10];
        Stream<Person> stream2 = Arrays.stream(persons);*/

        //3.通过Stream类中的静态方法 of()
        Stream<String> stream3 = Stream.of("a","b","c");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(8).forEach(System.out :: print);
        //stream4.limit(8).forEach(e -> System.out.print(e));

        //生成
        Stream.generate(() -> Math.random()).limit(6)
                .forEach(System.out :: println);
    }
}
