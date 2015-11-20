/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author nbattula
 *
 */
public class BirthLegalInfo implements Serializable {

	private static final long serialVersionUID = 4677529791429870942L;

	private long birthId;
	private Date dateOfBirth;
	private String sex;
	private String childName;
	private String fatherName;
	private String motherName;
	private String motherAadhaar;
	private String motherContact;
	private String birthPlace;
	private String hospitalName;
	private String informantsName;
	private String informantsAddress;
	private String createdBy;
	
	private String operation;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherAadhaar() {
		return motherAadhaar;
	}

	public void setMotherAadhaar(String motherAadhaar) {
		this.motherAadhaar = motherAadhaar;
	}

	public String getMotherContact() {
		return motherContact;
	}

	public void setMotherContact(String motherContact) {
		this.motherContact = motherContact;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getInformantsName() {
		return informantsName;
	}

	public void setInformantsName(String informantsName) {
		this.informantsName = informantsName;
	}

	public String getInformantsAddress() {
		return informantsAddress;
	}

	public void setInformantsAddress(String informantsAddress) {
		this.informantsAddress = informantsAddress;
	}

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

	@Override
	public String toString() {
		return "BirthLegalInfo [birthId=" + birthId + ", dateOfBirth="
				+ dateOfBirth + ", sex=" + sex + ", childName=" + childName
				+ ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", motherAadhaar=" + motherAadhaar + ", motherContact="
				+ motherContact + ", birthPlace=" + birthPlace
				+ ", hospitalName=" + hospitalName + ", informantsName="
				+ informantsName + ", informantsAddress=" + informantsAddress
				+ ", operation=" + operation + "]";
	}
	
}
