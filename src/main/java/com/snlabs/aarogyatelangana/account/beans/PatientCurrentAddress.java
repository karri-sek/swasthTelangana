package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

public class PatientCurrentAddress implements Serializable{
    private String district;
    private String state;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PatientCurrentAddress{");
        sb.append("district='").append(district).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", pincode=").append(pincode);
        sb.append(", sameAsPresentAddress='").append(sameAsPresentAddress).append('\'');
        sb.append(", patientAddressID=").append(patientAddressID);
        sb.append(", address='").append(address).append('\'');
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    private int pincode;
    private String sameAsPresentAddress;
    private int patientAddressID;
    private String address;
    private String cityName;

    public String getSameAsPresentAddress() {
        return sameAsPresentAddress;
    }

    public void setSameAsPresentAddress(String sameAsPresentAddress) {
        this.sameAsPresentAddress = sameAsPresentAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getPatientAddressID() {
        return patientAddressID;
    }

    public void setPatientAddressID(int patientAddressID) {
        this.patientAddressID = patientAddressID;
    }


}
