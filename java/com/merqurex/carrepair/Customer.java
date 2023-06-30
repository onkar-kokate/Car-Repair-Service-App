package com.merqurex.carrepair;

public class Customer {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String locality;
    private String city;
    private String state;
    private int pincode;
    private String carManufacturer;
    private String carModel;
    private String carMYear;

    public Customer(String firstName, String lastName, int phoneNumber, String email, String locality, String city, String state, int pincode, String carManufacturer, String carModel, String carMYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carMYear = carMYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarMYear() {
        return carMYear;
    }
}
