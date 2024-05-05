package com.example.laba3rkp.domains;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private String name;
    private String surname;
    private String patronym;
    private Integer age;
    private String sity;
    private String group;

    public Student() {
        this("", "", "", 0, "", "");
    }

    public Student(String name, String surname, String patronym, Integer age, String sity, String group) {
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.age = age;
        this.sity = sity;
        this.group = group;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronym='" + patronym + '\'' +
                ", age=" + age +
                ", sity='" + sity + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}

