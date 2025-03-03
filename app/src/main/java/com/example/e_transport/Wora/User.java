package com.example.e_transport.Wora;

public class User {
String mobileno,date,selectedVehicle,weight;
    public User() {
    }

    public User(String mobileno, String date, String selectedVehicle, String weight) {
        this.mobileno = mobileno;
        this.date = date;
        this.selectedVehicle = selectedVehicle;
        this.weight = weight;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getDate() {
        return date;
    }

    public String getSelectedVehicle() {
        return selectedVehicle;
    }

    public String getWeight() {
        return weight;
    }


}
