package com.ch.java1;

/**
 * @author chenpi
 * @create 2022-03-21 15:56
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("My nation is " + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException,ClassCastException {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("I am a Person");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
