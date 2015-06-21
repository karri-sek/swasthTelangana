package com.snlabs.aarogyatelangana.account.beans;

public class ReferralAddress {
	private String referralName;
	private String address;
	private String district;
	private String state;
	private int pincode;
	private String contactNo;
	private int addressID;

	public String getReferralName() {
		return referralName;
	}

	public void setReferralName(String referralName) {
		this.referralName = referralName;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	@Override
	public String toString() {
		return "ReferralAddress [referralName=" + referralName + ", address="
				+ address + ", district=" + district + ", state=" + state
				+ ", pincode=" + pincode + ", contactNo=" + contactNo
				+ ", addressID=" + addressID + "]";
	}
}
