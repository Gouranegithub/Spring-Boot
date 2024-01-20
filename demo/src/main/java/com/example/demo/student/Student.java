package com.example.demo.student;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private int age;
    private String email;
    private LocalDate dob;

    public Student() {
    }

    public Student(long id, String name, int age, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, int age, String email, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student:{" +
                "id: " + id +
                ", name: " + name +
                ", age: " + age +
                ", email: " + email +
                ", DateOfBirth: " + dob +
                "}";

    }

}