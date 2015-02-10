package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

public class PatientAddress implements Serializable{
	private String district;
	private String state;
	private int pincode;
	private int contactno;
	private int patientAddressID;
	private String address;
    private String currentAddress;

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
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

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	public int getPatientAddressID() {
		return patientAddressID;
	}

	public void setPatientAddressID(int patientAddressID) {
		this.patientAddressID = patientAddressID;
	}


	@Override
    public String toString() {
        return "PatientAddress [district=" + district + ", state=" + state
                + ", pincode=" + pincode + ", contactno=" + contactno
                + ", patientAddressID=" + patientAddressID + ", address="
                + address + ", currentAddress=" + currentAddress + "]";
    }
}
