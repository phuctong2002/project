package com.example.demo.model;

public class Staff {
    private String name;
    private int age;
    private String address;
    private String id;
    public Staff( String name, int age, String address, String id){
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
    }
    public Staff(){

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
