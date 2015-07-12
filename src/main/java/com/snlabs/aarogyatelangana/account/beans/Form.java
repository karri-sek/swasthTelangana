package com.snlabs.aarogyatelangana.account.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Section A:To be filled in for all Diagnostic Procedures/Tests
 */
public class Form extends User {

	int formID;
	int clinicID;
	int regID;
	public Patient patient;
	private int clinicAddressID;
	public int age;
	private String gender;
	public String patientAddress;
	private int referralAddressID;
	public String medicalDisease;
	public String parentalDiagnosis;
	public String gynecologistDetails;
	public Date toDate;
	public Date fromDate;
	public List<User> formbeans = new ArrayList<User>();
	private ReferralAddress referralAddress;
	private ClinicAddress clinicAddress;
	public static List<String> procedures = new ArrayList<String>();
	public String searchFormId;
	private String patientName;
    private int noOfChildren;
    private long patientID;    

    public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	static {
		procedures.add("Ultrasound");
		procedures.add("Any other (specify)");
	}

	public String getSearchFormId() {
		return searchFormId;
	}

	public void setSearchFormId(String searchFormId) {
		this.searchFormId = searchFormId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getMedicalDisease() {
		return medicalDisease;
	}

	public void setMedicalDisease(String medicalDisease) {
		this.medicalDisease = medicalDisease;
	}

	public String getParentalDiagnosis() {
		return parentalDiagnosis;
	}

	public void setParentalDiagnosis(String parentalDiagnosis) {
		this.parentalDiagnosis = parentalDiagnosis;
	}

	public String getGynecologistDetails() {
		return gynecologistDetails;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	public void setGynecologistDetails(String gynecologistDetails) {
		this.gynecologistDetails = gynecologistDetails;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public List<User> getFormbeans() {
		return formbeans;
	}

	public void setFormbeans(List<User> formbeans) {
		this.formbeans = formbeans;
	}

	public int getClinicID() {
		return clinicID;
	}

	public void setClinicID(int clinicID) {
		this.clinicID = clinicID;
	}

	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
	}

	public static List<String> getProcedures() {
		return procedures;
	}

	public static void setProcedures(List<String> procedures) {
		Form.procedures = procedures;
	}

	public int getReferralAddressID() {
		return referralAddressID;
	}

	public void setReferralAddressID(int referralAddressID) {
		this.referralAddressID = referralAddressID;
	}

	public void setClinicAddress(ClinicAddress clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public ClinicAddress getClinicAddress() {
		return clinicAddress;
	}

	public void setReferralAddress(ReferralAddress referralAddress) {
		this.referralAddress = referralAddress;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getClinicAddressID() {
		return clinicAddressID;
	}

	public void setClinicAddressID(int clinicAddressID) {
		this.clinicAddressID = clinicAddressID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public ReferralAddress getReferralAddress() {
		return referralAddress;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	@Override
	public String toString() {
		return "Form [formID=" + formID + ", clinicID=" + clinicID + ", regID="
				+ regID + ", patient=" + patient + ", clinicAddressID="
				+ clinicAddressID + ", age=" + age + ", patientAddress="
				+ patientAddress + ", referralAddressID=" + referralAddressID
				+ ", medicalDisease=" + medicalDisease + ", parentalDiagnosis="
				+ parentalDiagnosis + ", gynecologistDetails="
				+ gynecologistDetails + ", toDate=" + toDate + ", fromDate="
				+ fromDate + ", formbeans=" + formbeans + ", referralAddress="
				+ referralAddress + ", clinicAddress=" + clinicAddress
				+ ", searchFormId=" + searchFormId + "]";
	}

}
