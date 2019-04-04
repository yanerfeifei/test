package com.clone;

import lombok.Data;

/**
 * Created by meridian on 2018/12/13.
 */
@Data
public class Teacher  implements Cloneable{
    private String name;
    private int age;
    private String phone;
    private StudentClone studentClone;

    public StudentClone getStudentClone() {
        return studentClone;
    }

    public void setStudentClone(StudentClone studentClone) {
        this.studentClone = studentClone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o = null;
        try {
                 o = super.clone();
            } catch (CloneNotSupportedException e) {
                 System.out.println(e.toString());
            }
        studentClone = (StudentClone) studentClone.clone();
        return o;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher t = new Teacher();
        t.setAge(56);
        t.setName("张老师");
        t.setPhone("12345678909");
        StudentClone s1 = new StudentClone();
        s1.setName("李四");
        s1.setAge(23);
        t.setStudentClone(s1);
        Teacher t2 = (Teacher) t.clone();
        t2.getStudentClone().setName("张三");
        System.out.println(t.toString());
        System.out.println("------------>");
        System.out.println(t2.toString());
    }
}
