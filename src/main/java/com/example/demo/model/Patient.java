package com.example.demo.model;

public class Patient {
    private String id;
    private String Name;
    private String dob;
    private String date;

    public Patient() {
    }

    public Patient(String id, String name, String dob, String date) {
        this.id = id;
        Name = name;
        this.dob = dob;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
