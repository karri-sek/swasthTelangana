package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;
import java.util.Date;

public class Patient extends User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String patientName;
    private int formId;
    private long patientID;
    private Date createdTimestamp;
    private int age = 12;
    private int txnID;
    private String gender;
    private int patientAddressID;
    private PatientAddress patientAddress;
    private String createdBy;
    private String formFDownloadPath;
    private String aadharNo;
    private PatientCurrentAddress patientCurrentAddress;
   
    //As per the design standerds this field should not be here, but to make search easy going with this option.
    private String searchType;
    private String operation;
    
    public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    private String contactno;

    public PatientCurrentAddress getPatientCurrentAddress() {
        return patientCurrentAddress;
    }

    public void setPatientCurrentAddress(PatientCurrentAddress patientCurrentAddress) {
        this.patientCurrentAddress = patientCurrentAddress;
    }


    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    private Date updatedTimestamp;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    private String fatherName;

    public int getNumner() {
        return numner;
    }

    public void setNumner(int numner) {
        this.numner = numner;
    }

    private int numner;

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public int getTxnID() {
        return txnID;
    }

    public void setTxnID(int txnID) {
        this.txnID = txnID;
    }

    public int getPatientAddressID() {
        return patientAddressID;
    }

    public void setPatientAddressID(int patientAddressID) {
        this.patientAddressID = patientAddressID;
    }

    public PatientAddress getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(PatientAddress patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getFormFDownloadPath() {
        return formFDownloadPath;
    }

    public void setFormFDownloadPath(String formFDownloadPath) {
        this.formFDownloadPath = formFDownloadPath;
    }

	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", formId=" + formId
				+ ", patientID=" + patientID + ", createdTimestamp="
				+ createdTimestamp + ", age=" + age + ", txnID=" + txnID
				+ ", gender=" + gender + ", patientAddressID="
				+ patientAddressID + ", patientAddress=" + patientAddress
				+ ", createdBy=" + createdBy + ", formFDownloadPath="
				+ formFDownloadPath + ", aadharNo=" + aadharNo
				+ ", patientCurrentAddress=" + patientCurrentAddress
				+ ", searchType=" + searchType + ", operation=" + operation
				+ ", contactno=" + contactno + ", updatedTimestamp="
				+ updatedTimestamp + ", fatherName=" + fatherName + ", numner="
				+ numner + "]";
	}

}
