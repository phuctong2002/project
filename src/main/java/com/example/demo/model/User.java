package com.example.demo.model;

public class User {
    private String name;
    private int age;
    private String id;
    private String address;
    public User(){

    }
    public User(String name, int age, String id, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }




}
