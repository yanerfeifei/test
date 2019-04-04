package com.xyl.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年04月27日  14:24:11
 * @Description:
 */
public class JdkEight {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squareNums.toString());


        List<String> wordList = Arrays.asList("a","b", "c", "d");
        List<String> output = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(output.toString());
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("concat:"+concat+"------------------->");
         // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("minValue:"+minValue+"------------------->");
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println("sumValue:"+sumValue+"------------------->");
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println("sumValue:"+sumValue+"------------------->");
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
        System.out.println("concat:"+concat+"------------------->");
    }
}
