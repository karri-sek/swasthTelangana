/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans.dashboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nbattula
 *
 */
public class FormFStats {
	
	private List<String> districtLabel = new ArrayList<String>(Arrays.asList("ADB","HYD", "KRN", "KHM", "MBN", "MDK", "NLG","NZB","RNR","WRG"));
	private List<Integer> yearLabel = new ArrayList<Integer>(Arrays.asList(2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016));
	
	private long formFTotal;
	
	private List<Long> mtpIndicationYes = new ArrayList<Long>();
	private List<Long> mtpIndicationNo = new ArrayList<Long>();
	
	private List<Long> firstChildfemaleYes = new ArrayList<Long>();
	private List<Long> firstChildfemaleNo = new ArrayList<Long>();
	
	private List<Long> pregnantDisorderYes = new ArrayList<Long>();
	private List<Long> pregnantDisorderNo = new ArrayList<Long>();
	
	private List<Long> eddInCurrentMonth = new ArrayList<Long>();
	private List<Long> eddNotInCurrentMonth = new ArrayList<Long>();
	
	public List<String> getDistrictLabel() {
		return districtLabel;
	}
	public void setDistrictLabel(List<String> districtLabel) {
		this.districtLabel = districtLabel;
	}
	public List<Integer> getYearLabel() {
		return yearLabel;
	}
	public void setYearLabel(List<Integer> yearLabel) {
		this.yearLabel = yearLabel;
	}
	public long getFormFTotal() {
		return formFTotal;
	}
	public void setFormFTotal(long formFTotal) {
		this.formFTotal = formFTotal;
	}
	public List<Long> getMtpIndicationYes() {
		return mtpIndicationYes;
	}
	public void setMtpIndicationYes(List<Long> mtpIndicationYes) {
		this.mtpIndicationYes = mtpIndicationYes;
	}
	public List<Long> getMtpIndicationNo() {
		return mtpIndicationNo;
	}
	public void setMtpIndicationNo(List<Long> mtpIndicationNo) {
		this.mtpIndicationNo = mtpIndicationNo;
	}
	public List<Long> getFirstChildfemaleYes() {
		return firstChildfemaleYes;
	}
	public void setFirstChildfemaleYes(List<Long> firstChildfemaleYes) {
		this.firstChildfemaleYes = firstChildfemaleYes;
	}
	public List<Long> getFirstChildfemaleNo() {
		return firstChildfemaleNo;
	}
	public void setFirstChildfemaleNo(List<Long> firstChildfemaleNo) {
		this.firstChildfemaleNo = firstChildfemaleNo;
	}
	public List<Long> getPregnantDisorderYes() {
		return pregnantDisorderYes;
	}
	public void setPregnantDisorderYes(List<Long> pregnantDisorderYes) {
		this.pregnantDisorderYes = pregnantDisorderYes;
	}
	public List<Long> getPregnantDisorderNo() {
		return pregnantDisorderNo;
	}
	public void setPregnantDisorderNo(List<Long> pregnantDisorderNo) {
		this.pregnantDisorderNo = pregnantDisorderNo;
	}
	public List<Long> getEddInCurrentMonth() {
		return eddInCurrentMonth;
	}
	public void setEddInCurrentMonth(List<Long> eddInCurrentMonth) {
		this.eddInCurrentMonth = eddInCurrentMonth;
	}
	public List<Long> getEddNotInCurrentMonth() {
		return eddNotInCurrentMonth;
	}
	public void setEddNotInCurrentMonth(List<Long> eddNotInCurrentMonth) {
		this.eddNotInCurrentMonth = eddNotInCurrentMonth;
	}
}
