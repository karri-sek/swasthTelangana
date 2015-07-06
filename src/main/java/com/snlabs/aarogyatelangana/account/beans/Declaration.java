package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;

public class Declaration {

	private Date declarationDate;
	private String doctorName;
	private String patientName;
	private long patientID;
	private String place;

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Declaration [declarationDate=" + declarationDate
				+ ", doctorName=" + doctorName + ", patientName=" + patientName
				+ ", patientID=" + patientID + ", place=" + place + "]";
	}

}
