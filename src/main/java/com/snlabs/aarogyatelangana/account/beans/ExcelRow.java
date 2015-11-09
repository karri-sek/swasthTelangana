package com.snlabs.aarogyatelangana.account.beans;
import java.util.Date;

public class ExcelRow extends User{
	private Patient patient;
	private ClinicAddress clinicAddress;
	private SectionA sectionA;
	private NonInvasive nonInvasive;
    private Invasive invasive;
    private String doctorName;
    private Date doctorDeclarationDate;
    
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
	public SectionA getSectionA() {
		return sectionA;
	}
	public void setSectionA(SectionA sectionA) {
		this.sectionA = sectionA;
	}
	public NonInvasive getNonInvasive() {
		return nonInvasive;
	}
	public void setNonInvasive(NonInvasive nonInvasive) {
		this.nonInvasive = nonInvasive;
	}
	public Invasive getInvasive() {
		return invasive;
	}
	public void setInvasive(Invasive invasive) {
		this.invasive = invasive;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Date getDoctorDeclarationDate() {
		return doctorDeclarationDate;
	}
	public void setDoctorDeclarationDate(Date doctorDeclarationDate) {
		this.doctorDeclarationDate = doctorDeclarationDate;
	}
    
}
