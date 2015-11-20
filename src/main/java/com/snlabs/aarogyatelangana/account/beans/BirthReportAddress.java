/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class BirthReportAddress implements Serializable{
	
	private static final long serialVersionUID = -8197613969527799585L;
	
	private long birthId;
	private String operation;
	private String sameAsBirthAddress;
	
	private Address birthPlaceAddress;
	private Address permanentAddress;
	
	public long getBirthId() {
		return birthId;
	}
	public void setBirthId(long birthId) {
		this.birthId = birthId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Address getBirthPlaceAddress() {
		return birthPlaceAddress;
	}
	public void setBirthPlaceAddress(Address birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
	}
	public Address getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getSameAsBirthAddress() {
		return sameAsBirthAddress;
	}
	public void setSameAsBirthAddress(String sameAsBirthAddress) {
		this.sameAsBirthAddress = sameAsBirthAddress;
	}
		
}
