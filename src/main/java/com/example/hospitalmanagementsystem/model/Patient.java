package com.example.hospitalmanagementsystem.model;

public class Patient {
    public int id;
    public String firstName;
    public String lastName;
    public String gender;
    public String phone_no;
    public String address;

    Patient() {};
    public Patient(int id, String firstName, String lastName, String gender, String phone_no, String address) {
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
}
