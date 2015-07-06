package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;

public class ConveyDetails {
	private long patientID;
	private long conveyID;
	private String conveyedName;
	private Date conveyedDate;
	private int formID;
	private String type; //Invasive ot Non-invasive

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
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

	public long getConveyID() {
		return conveyID;
	}

	public void setConveyID(long conveyID) {
		this.conveyID = conveyID;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	@Override
	public String toString() {
		return "ConveyDetails [patientID=" + patientID + ", conveyID="
				+ conveyID + ", conveyedName=" + conveyedName
				+ ", conveyedDate=" + conveyedDate + ", formID=" + formID
				+ ", type=" + type + "]";
	}

}
