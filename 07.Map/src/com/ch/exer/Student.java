package com.ch.exer;

/**
 * @author chenpi
 * @create 2022-02-21 16:21
 */
public class Student implements Comparable {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSocre() {
        return score;
    }

    public void setSocre(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student stu = (Student) o;
            return -(this.score - stu.score);
        }
        throw new RuntimeException("输入类型不匹配！");
    }
}
