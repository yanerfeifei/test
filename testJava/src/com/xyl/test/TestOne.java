package com.xyl.test;

import com.xyl.domain.User;

import java.util.Scanner;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年04月24日  16:35:49
 * @Description:
 */
public class TestOne {
    public static void main(String[] args) {
        System.out.println("*******************************");
        System.out.println("请输入一个数字");
        Scanner scan = new Scanner(System.in);
        User user = new User();
        setPro(user);
        int count = scan.nextInt();
        for (int i = 0; i <count ; i++) {
            System.out.println("This number is :"+i);
        }
        System.out.println("*******************************"+user.toString());
    }

    public static void setPro(User u) {
        u.setAge(12);
        u.setSex(2);
        u.setUname("张三");
    }
}
