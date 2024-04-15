package com.example.laba3;

import javafx.beans.property.*;

public class Student {
    private StringProperty name;
    private StringProperty surname;
    private IntegerProperty age;
    private StringProperty otchestvo;
    private StringProperty siti;
    private StringProperty grupp;
    public Student(String name, String surname, int age,  String otchestvo,String siti,String grupp ) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.age = new SimpleIntegerProperty(age);
        this.otchestvo = new SimpleStringProperty(otchestvo);
        this.siti = new SimpleStringProperty(siti);
        this.grupp = new SimpleStringProperty(grupp);
    }
    public Student() {
        this("", "", 0,"", "","");
    }
    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getSurname() {
        return surname.get();
    }
    public StringProperty surnameProperty() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname.set(surname);
    }
    public int getAge() {
        return age.get();
    }
    public IntegerProperty ageProperty() {
        return age;
    }
    public void setAge(int age) {
        this.age.set(age);
    }

    public String toString() {
        return "Имя = " + getName() +
                ", Фамилия = " + getSurname() +
                ", Отчество = " + getOtchestvo() +
                ", Возраст = " + getAge()+
                ", Город проживания = " + getSiti() +
                ", Группа = " + getGrupp() ;
    }

    public String getOtchestvo() {
        return otchestvo.get();
    }

    public StringProperty otchestvoProperty() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo.set(otchestvo);
    }

    public String getSiti() {
        return siti.get();
    }

    public StringProperty sitiProperty() {
        return siti;
    }

    public void setSiti(String siti) {
        this.siti.set(siti);
    }

    public String getGrupp() {
        return grupp.get();
    }

    public StringProperty gruppProperty() {
        return grupp;
    }

    public void setGrupp(String grupp) {
        this.grupp.set(grupp);
    }
}
