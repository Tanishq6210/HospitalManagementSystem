package com.example.hospitalmanagementsystem.model;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone_no;
    private String address;

    public Doctor(){};
    public Doctor(int id, String firstName, String lastName, String gender, String phone_no, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone_no = phone_no;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
