/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author nbattula
 *
 */
public class BirthReportSearchBean implements Serializable{
	
	private static final long serialVersionUID = 2923460643588777475L;
	
	private long birthId;
	private String motherName;
	private String contactno;
	private String aadharNo;
	
	private String searchType;
	private Date toDate;
	private Date fromDate;
	
	public long getBirthId() {
		return birthId;
	}
	public void setBirthId(long birthId) {
		this.birthId = birthId;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	
}
