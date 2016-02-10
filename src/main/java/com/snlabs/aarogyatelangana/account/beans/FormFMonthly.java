package com.snlabs.aarogyatelangana.account.beans;

public class FormFMonthly implements Comparable<FormFMonthly>{
	
	private String formfTotal;
	private String mtpYes;
	private String mtpNo;
	private String firstChildfemaleNo;
	private String firstChildfemaleYes;
	private String pregnantDisorderYes;
	private String pregnantDisorderNo;
	private String state;
	private String district;
	private String month;
	private String year;
	
	public String getForfTotal() {
		return formfTotal;
	}
	public void setForfTotal(String forfTotal) {
		this.formfTotal = forfTotal;
	}
	public String getMtpYes() {
		return mtpYes;
	}
	public void setMtpYes(String mtpYes) {
		this.mtpYes = mtpYes;
	}
	public String getMtpNo() {
		return mtpNo;
	}
	public void setMtpNo(String mtpNo) {
		this.mtpNo = mtpNo;
	}
	public String getFormfTotal() {
		return formfTotal;
	}
	public void setFormfTotal(String formfTotal) {
		this.formfTotal = formfTotal;
	}
	public String getFirstChildfemaleNo() {
		return firstChildfemaleNo;
	}
	public void setFirstChildfemaleNo(String firstChildfemaleNo) {
		this.firstChildfemaleNo = firstChildfemaleNo;
	}
	public String getFirstChildfemaleYes() {
		return firstChildfemaleYes;
	}
	public void setFirstChildfemaleYes(String firstChildfemaleYes) {
		this.firstChildfemaleYes = firstChildfemaleYes;
	}
	public String getPregnantDisorderYes() {
		return pregnantDisorderYes;
	}
	public void setPregnantDisorderYes(String pregnantDisorderYes) {
		this.pregnantDisorderYes = pregnantDisorderYes;
	}
	public String getPregnantDisorderNo() {
		return pregnantDisorderNo;
	}
	public void setPregnantDisorderNo(String pregnantDisorderNo) {
		this.pregnantDisorderNo = pregnantDisorderNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public int compareTo(FormFMonthly obj) {
		return this.getDistrict().compareTo(obj.getDistrict());
	}
}
