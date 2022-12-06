package com.example.mobile_project;

public class User {

    public String address;
    public String email;
    public String fname;
    public String lname;
    public String notes;
    public String number;

    public User(){

    }

    public User(String address, String email, String fname, String lname, String notes, String number) {
        this.address = address;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.notes = notes;
        this.number = number;
    }



    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
