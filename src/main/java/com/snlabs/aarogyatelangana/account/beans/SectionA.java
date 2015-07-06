package com.snlabs.aarogyatelangana.account.beans;

import java.sql.Date;

public class SectionA {
	private int noOfChildren;
	private int noOfMaleKids;
	private int noOfFemaleKids;
	private String guardianName;
	private Date lastMenstrualPeriod;
	private int formID;
	private long patientID;
	private String patientName;
	
	private String referredBy;
	private String selfReferredBy;
	private int weeksOfPragnancy;

	private String operation;
    
    public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getSelfReferredBy() {
		return selfReferredBy;
	}

	public void setSelfReferredBy(String selfReferredBy) {
		this.selfReferredBy = selfReferredBy;
	}

	public int getWeeksOfPragnancy() {
		return weeksOfPragnancy;
	}

	public void setWeeksOfPragnancy(int weeksOfPragnancy) {
		this.weeksOfPragnancy = weeksOfPragnancy;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public int getNoOfMaleKids() {
		return noOfMaleKids;
	}

	public void setNoOfMaleKids(int noOfMaleKids) {
		this.noOfMaleKids = noOfMaleKids;
	}

	public int getNoOfFemaleKids() {
		return noOfFemaleKids;
	}

	public void setNoOfFemaleKids(int noOfFemaleKids) {
		this.noOfFemaleKids = noOfFemaleKids;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public Date getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}

	public void setLastMenstrualPeriod(Date lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
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

	@Override
	public String toString() {
		return "SectionA [noOfChildren=" + noOfChildren + ", noOfMaleKids="
				+ noOfMaleKids + ", noOfFemaleKids=" + noOfFemaleKids
				+ ", guardianName=" + guardianName + ", lastMenstrualPeriod="
				+ lastMenstrualPeriod + ", formID=" + formID + ", patientID="
				+ patientID + ", patientName=" + patientName + ", referredBy="
				+ referredBy + ", selfReferredBy=" + selfReferredBy
				+ ", weeksOfPragnancy=" + weeksOfPragnancy + ", operation="
				+ operation + "]";
	}

}
