package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;

public class ConveyDetails {
	private int patientID;
	private int conveyID;
	private String conveyedName;
	private Date conveyedDate;
	private int formID;

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getConveyedName() {
		return conveyedName;
	}

	public void setConveyedName(String conveyedName) {
		this.conveyedName = conveyedName;
	}

	public Date getConveyedDate() {
		return conveyedDate;
	}

	public void setConveyedDate(Date conveyedDate) {
		this.conveyedDate = conveyedDate;
	}

	public int getConveyID() {
		return conveyID;
	}

	public void setConveyID(int conveyID) {
		this.conveyID = conveyID;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}
}
