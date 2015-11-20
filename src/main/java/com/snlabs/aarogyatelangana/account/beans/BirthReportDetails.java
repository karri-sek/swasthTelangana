/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class BirthReportDetails implements Serializable{
	
	private static final long serialVersionUID = 3169756570433717591L;
	
	private BirthFamilyInfo birthFamilyInfo;
	private BirthHealthInfo birthHealthInfo;
	private BirthLegalInfo birthLegalInfo;
	private BirthReportAddress birthReportAddress;
	
	public BirthFamilyInfo getBirthFamilyInfo() {
		return birthFamilyInfo;
	}
	public void setBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo) {
		this.birthFamilyInfo = birthFamilyInfo;
	}
	public BirthHealthInfo getBirthHealthInfo() {
		return birthHealthInfo;
	}
	public void setBirthHealthInfo(BirthHealthInfo birthHealthInfo) {
		this.birthHealthInfo = birthHealthInfo;
	}
	public BirthLegalInfo getBirthLegalInfo() {
		return birthLegalInfo;
	}
	public void setBirthLegalInfo(BirthLegalInfo birthLegalInfo) {
		this.birthLegalInfo = birthLegalInfo;
	}
	public BirthReportAddress getBirthReportAddress() {
		return birthReportAddress;
	}
	public void setBirthReportAddress(BirthReportAddress birthReportAddress) {
		this.birthReportAddress = birthReportAddress;
	}
	
}
