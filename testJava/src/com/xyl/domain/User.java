package com.xyl.domain;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年04月24日  16:55:05
 * @Description:
 */
public class User {
    private String uname;//姓名
    private int age;//年龄
    private int sex; //性别

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public User(String uname, int age, int sex) {
        this.uname = uname;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
