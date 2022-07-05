package com.example.demo.model;

public class User {
    private String name;
    private String dob;
    private String id;
    private String address;
    private int a1;
    private int a2;

    public int getNumberInjection() {
        return numberInjection;
    }

    public void setNumberInjection(int numberInjection) {
        this.numberInjection = numberInjection;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private int a3;
    private int a4;

    private int numberInjection;
    private String gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


    public User(){

    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public int getA3() {
        return a3;
    }

    public void setA3(int a3) {
        this.a3 = a3;
    }

    public int getA4() {
        return a4;
    }

    public void setA4(int a4) {
        this.a4 = a4;
    }

    public User(String name, String dob, String id, String address) {
        this.name = name;
        this.dob = dob;
        this.id = id;
        this.address = address;
        this.a1 = 0;
        this.a2 = 0;
        this.a3 = 0;
        this.a4 = 0;
    }
    public User(String name, String dob, String id, String address, int a1, int a2, int a3, int  a4) {
        this.name = name;
        this.dob = dob;
        this.id = id;
        this.address = address;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public String getDob() {
        return dob;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }




}
