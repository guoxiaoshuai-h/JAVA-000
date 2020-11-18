package com.auto;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 14:52
 */
public class StudentService {

    private Student student;

    public StudentService() {
    }

    public StudentService(Student student) {
        this.student = student;
    }

    public void say() {
        System.out.println("大家好，我叫" + student.getName()
                + ", 今年" + student.getAge() + "岁"
                + ",性别：" + student.getSex());
    }
}
