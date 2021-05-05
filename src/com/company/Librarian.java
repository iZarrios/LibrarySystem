package com.company;

public class Librarian {
    private String Name;
    private String Password;
    private String Email;
    private String Address;
    private String City;
    private String contactNo;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Librarian(String name, String password, String email, String address, String city, String contactNo) {
        Name = name;
        Password = password;
        Email = email;
        Address = address;
        City = city;
        this.contactNo = contactNo;
    }
}
