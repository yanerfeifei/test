package com.xyl.jdk;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月14日  09:24:31
 * @Description:
 */
public class ComparableTest {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setAge(12);
        e.setName("燕儿");
        Employee e1 = new Employee();
        e1.setName("张三");
        e1.setAge(23);
        if(e.compareTo(e1)>0){
            System.out.println("年龄大于");
        }
        if(e.compareTo(e1)==0){
            System.out.println("等于");
        }
        if(e.compareTo(e1)<0){
            System.out.println("小于");
        }
    }
}
class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    @Override
    public int compareTo(Employee e) {
        if(this.getAge()>e.getAge())
            return 1;
        if(this.getAge()<e.getAge())
            return -1;
        return 0;
    }
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
}