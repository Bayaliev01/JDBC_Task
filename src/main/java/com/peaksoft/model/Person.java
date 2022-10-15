package com.peaksoft.model;

public class Person {
    private int id ;
    private String name;
    private String surName;
    private int age;
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "  Person - " +
                " (id - " + id +
                " ) -- (, name - " + name + '\'' +
                " ) -- (, surName - " + surName + '\'' +
                " ) -- (, age - " + age +
                " ) -- (, position - " + position +")\n";
    }
}
