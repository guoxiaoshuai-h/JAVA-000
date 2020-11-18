package com.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 14:47
 */
@ConfigurationProperties(prefix = "spring.student")
public class Student {
    private int age;

    private String name;

    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
