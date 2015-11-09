/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class MTPDetails extends  User implements Serializable{
	
	private static final long serialVersionUID = -5892231468212870593L;
	
	private String weeksOfPregnancy;
	private String isMentallyIll = "NO";
	private String isMinor = "NO";
	private String isMarried = "NO";
	private String isFather;
	private String daughterOfWifeOf;
	private String guardianName;
	private String reasonForTermination;
	private String operation;
	private long patientID;
    private String patientName;
    
    private Patient patient;
    private ClinicAddress clinicAddress;
    
	public String getWeeksOfPregnancy() {
		return weeksOfPregnancy;
	}
	public void setWeeksOfPregnancy(String weeksOfPregnancy) {
		this.weeksOfPregnancy = weeksOfPregnancy;
	}
	public String getIsMentallyIll() {
		return isMentallyIll;
	}
	public void setIsMentallyIll(String isMentallyIll) {
		this.isMentallyIll = isMentallyIll;
	}
	public String getIsMinor() {
		return isMinor;
	}
	public void setIsMinor(String isMinor) {
		this.isMinor = isMinor;
	}
	public String getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}
	public String getIsFather() {
		return isFather;
	}
	public void setIsFather(String isFather) {
		this.isFather = isFather;
	}
	public String getDaughterOfWifeOf() {
		return daughterOfWifeOf;
	}
	public void setDaughterOfWifeOf(String daughterOfWifeOf) {
		this.daughterOfWifeOf = daughterOfWifeOf;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getReasonForTermination() {
		return reasonForTermination;
	}
	public void setReasonForTermination(String reasonForTermination) {
		this.reasonForTermination = reasonForTermination;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public ClinicAddress getClinicAddress() {
		return clinicAddress;
	}
	public void setClinicAddress(ClinicAddress clinicAddress) {
		this.clinicAddress = clinicAddress;
	}
	@Override
	public String toString() {
		return "MTPDetails [weeksOfPregnancy=" + weeksOfPregnancy
				+ ", isMentallyIll=" + isMentallyIll + ", isMinor=" + isMinor
				+ ", isMarried=" + isMarried + ", isFather=" + isFather
				+ ", daughterOfWifeOf=" + daughterOfWifeOf + ", guardianName="
				+ guardianName + ", reasonForTermination="
				+ reasonForTermination + ", operation=" + operation
				+ ", patientID=" + patientID + ", patientName=" + patientName
				+ ", patient=" + patient + ", clinicAddress=" + clinicAddress
				+ "]";
	}
	
}
