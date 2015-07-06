package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

public class PatientAddress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7855220043544010300L;
	private String district;
	private String state;
	private int pincode;
    private String cityName;
	private int patientAddressID;
	private String address;
    private String contactno;
    private long patientID;
    
    public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
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

	@Override
	public String toString() {
		return "PatientAddress [district=" + district + ", state=" + state
				+ ", pincode=" + pincode + ", cityName=" + cityName
				+ ", patientAddressID=" + patientAddressID + ", address="
				+ address + ", contactno=" + contactno + ", patientID="
				+ patientID + "]";
	}
	
}
