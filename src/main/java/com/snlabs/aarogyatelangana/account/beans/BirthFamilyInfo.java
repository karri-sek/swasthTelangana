/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class BirthFamilyInfo implements Serializable{

	private static final long serialVersionUID = -1708770735375802431L;

	private long birthId;
	private String religion;
	private String fatherEducation;
	private String motherEducation;
	private String fatherOccupation;
	private String motherOccupation;
	private int motherAgeAtMrg;
	private int motherAge;
	private int noOfChildren;
	private String operation;
	public long getBirthId() {
		return birthId;
	}
	public void setBirthId(long birthId) {
		this.birthId = birthId;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getFatherEducation() {
		return fatherEducation;
	}
	public void setFatherEducation(String fatherEducation) {
		this.fatherEducation = fatherEducation;
	}
	public String getMotherEducation() {
		return motherEducation;
	}
	public void setMotherEducation(String motherEducation) {
		this.motherEducation = motherEducation;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}
	public int getMotherAgeAtMrg() {
		return motherAgeAtMrg;
	}
	public void setMotherAgeAtMrg(int motherAgeAtMrg) {
		this.motherAgeAtMrg = motherAgeAtMrg;
	}
	public int getMotherAge() {
		return motherAge;
	}
	public void setMotherAge(int motherAge) {
		this.motherAge = motherAge;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
