package com.clone;

import lombok.Data;

/**
 * Created by meridian on 2018/12/10.
 */
@Data
public class StudentClone implements Cloneable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
    public static void main(String[] args)throws CloneNotSupportedException {
        StudentClone s = new StudentClone();
        s.setAge(1);
        s.setName("张三");
        System.out.println(s.toString());
        StudentClone sc = (StudentClone) s.clone();
        sc.setAge(45);
        sc.setName("李四");
        System.out.println("-------------------------------");
        System.out.println(sc.toString());
        System.out.println(s.toString());

        s.setAge(14);
        s.setName("张三sa");
        System.out.println("-------------------------------");
        System.out.println(sc.toString());
        System.out.println(s.toString());

    }
}
