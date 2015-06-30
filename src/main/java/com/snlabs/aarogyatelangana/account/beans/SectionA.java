package com.snlabs.aarogyatelangana.account.beans;

public class SectionA {
	private int noOfChildren;
	private int noOfMaleKids;
	private int noOfFemaleKids;
	private String guardianName;
	private int menstrualPeriod;
	private int formID;
	private int patientID;
	private String patientName;

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

	public int getMenstrualPeriod() {
		return menstrualPeriod;
	}

	public void setMenstrualPeriod(int menstrualPeriod) {
		this.menstrualPeriod = menstrualPeriod;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
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
				+ ", guardianName=" + guardianName + ", menstrualPeriod="
				+ menstrualPeriod + "]";
	}
}
