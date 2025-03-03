package com.example.e_transport.Wora;

public class UserOrders {
    String paddress,daddress,mobile,weight,date,ppoint,dpoint,selectedVehicle;
//    String mobile,date;

    public UserOrders() {
    }

//    public UserOrders(String mobile, String date) {
    public UserOrders(String paddress, String daddress, String mobile, String weight, String date, String ppoint, String dpoint,String selectedVehicle) {
        this.selectedVehicle=selectedVehicle;
        this.paddress = paddress;
        this.daddress = daddress;
        this.mobile = mobile;
        this.weight = weight;
        this.date = date;
        this.ppoint = ppoint;
        this.dpoint = dpoint;
        this.selectedVehicle=selectedVehicle;
    }


    public String getPaddress() {
        return paddress;
    }

    public String getDaddress() {
        return daddress;
    }

    public String getMobileno() {
        return mobile;
    }

    public String getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }

    public String getSelectedVehicle()
    {
        return selectedVehicle;
    }
}
