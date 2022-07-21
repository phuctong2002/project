package com.example.demo.model;

public class Patient_Inject {
    private String ID_patient;
    private String Name;
    private String dob;
    private String address;
    private int NthInjection;
    private String name_vaccine;

    public Patient_Inject() {
    }

    public Patient_Inject(String ID_patient, String name, String dob, String adress, int nthInjection, String name_vaccine) {
        this.ID_patient = ID_patient;
        Name = name;
        this.dob = dob;
        this.address = adress;
        NthInjection = nthInjection;
        this.name_vaccine = name_vaccine;
    }

    public String getID_patient() {
        return ID_patient;
    }

    public void setID_patient(String ID_patient) {
        this.ID_patient = ID_patient;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public int getNthInjection() {
        return NthInjection;
    }

    public void setNthInjection(int nthInjection) {
        NthInjection = nthInjection;
    }

    public String getName_vaccine() {
        return name_vaccine;
    }

    public void setName_vaccine(String name_vaccine) {
        this.name_vaccine = name_vaccine;
    }
}
