/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans.registration;

import java.io.Serializable;

import com.snlabs.aarogyatelangana.account.beans.Address;

/**
 * @author nbattula
 *
 */
public class BasicInfo implements Serializable{
	
	private static final long serialVersionUID = -8981728870961428647L;
	
	private String applicantName;
	private Address adress;
	private String facilityType;
	
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	
	
}
