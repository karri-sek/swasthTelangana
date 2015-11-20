/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class Address implements Serializable{
	
	private static final long serialVersionUID = -6362308865936704672L;
	private String villageTownCity;
	private String cityName;
	private String address;
	private String district;
	private String state;
	private String pincode;
	
	public String getVillageTownCity() {
		return villageTownCity;
	}
	public void setVillageTownCity(String villageTownCity) {
		this.villageTownCity = villageTownCity;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
