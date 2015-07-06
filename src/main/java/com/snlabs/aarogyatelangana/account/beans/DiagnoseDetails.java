/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class DiagnoseDetails implements Serializable{
	
	private static final long serialVersionUID = -762967681100963219L;
	
	private long patientID;
	private String gestational;
	private String intrauterine;
	private String chorionicity;
	private String vaginalbleeding;
	private String abortion;
	private String iucdInSitu;
	private String assessmentOfCervical;
	private String uterineSizeAmenorrhea;
	
	private String suspectedAdenexal;
	private String chromosomalAbnormalities;
	private String fetalPosition;
	private String liquorAmnii;
	private String pretermLabor;
	private String placentalPosition;
	private String umbilicalCord;
	private String previousCaesarean;
	
	private String fetalGrowth;
	private String duplexDoppler;
	private String terminationOfPregnancy;
	private String chorionicVillus;
	private String intraPartumEvents;
	private String complicatingPregnancy;
	private String researchScientific;
	
	public long getPatientID() {
		return patientID;
	}
	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}
	public String getIucdInSitu() {
		return iucdInSitu;
	}
	public void setIucdInSitu(String iucdInSitu) {
		this.iucdInSitu = iucdInSitu;
	}
	public String getAssessmentOfCervical() {
		return assessmentOfCervical;
	}
	public void setAssessmentOfCervical(String assessmentOfCervical) {
		this.assessmentOfCervical = assessmentOfCervical;
	}
	public String getUterineSizeAmenorrhea() {
		return uterineSizeAmenorrhea;
	}
	public void setUterineSizeAmenorrhea(String uterineSizeAmenorrhea) {
		this.uterineSizeAmenorrhea = uterineSizeAmenorrhea;
	}
	public String getSuspectedAdenexal() {
		return suspectedAdenexal;
	}
	public void setSuspectedAdenexal(String suspectedAdenexal) {
		this.suspectedAdenexal = suspectedAdenexal;
	}
	public String getChromosomalAbnormalities() {
		return chromosomalAbnormalities;
	}
	public void setChromosomalAbnormalities(String chromosomalAbnormalities) {
		this.chromosomalAbnormalities = chromosomalAbnormalities;
	}
	public String getFetalPosition() {
		return fetalPosition;
	}
	public void setFetalPosition(String fetalPosition) {
		this.fetalPosition = fetalPosition;
	}
	public String getLiquorAmnii() {
		return liquorAmnii;
	}
	public void setLiquorAmnii(String liquorAmnii) {
		this.liquorAmnii = liquorAmnii;
	}
	public String getPretermLabor() {
		return pretermLabor;
	}
	public void setPretermLabor(String pretermLabor) {
		this.pretermLabor = pretermLabor;
	}
	public String getPlacentalPosition() {
		return placentalPosition;
	}
	public void setPlacentalPosition(String placentalPosition) {
		this.placentalPosition = placentalPosition;
	}
	public String getUmbilicalCord() {
		return umbilicalCord;
	}
	public void setUmbilicalCord(String umbilicalCord) {
		this.umbilicalCord = umbilicalCord;
	}
	public String getPreviousCaesarean() {
		return previousCaesarean;
	}
	public void setPreviousCaesarean(String previousCaesarean) {
		this.previousCaesarean = previousCaesarean;
	}
	public String getFetalGrowth() {
		return fetalGrowth;
	}
	public void setFetalGrowth(String fetalGrowth) {
		this.fetalGrowth = fetalGrowth;
	}
	public String getDuplexDoppler() {
		return duplexDoppler;
	}
	public void setDuplexDoppler(String duplexDoppler) {
		this.duplexDoppler = duplexDoppler;
	}
	public String getTerminationOfPregnancy() {
		return terminationOfPregnancy;
	}
	public void setTerminationOfPregnancy(String terminationOfPregnancy) {
		this.terminationOfPregnancy = terminationOfPregnancy;
	}
	public String getChorionicVillus() {
		return chorionicVillus;
	}
	public void setChorionicVillus(String chorionicVillus) {
		this.chorionicVillus = chorionicVillus;
	}
	public String getIntraPartumEvents() {
		return intraPartumEvents;
	}
	public void setIntraPartumEvents(String intraPartumEvents) {
		this.intraPartumEvents = intraPartumEvents;
	}
	public String getComplicatingPregnancy() {
		return complicatingPregnancy;
	}
	public void setComplicatingPregnancy(String complicatingPregnancy) {
		this.complicatingPregnancy = complicatingPregnancy;
	}
	public String getResearchScientific() {
		return researchScientific;
	}
	public void setResearchScientific(String researchScientific) {
		this.researchScientific = researchScientific;
	}
	public String getGestational() {
		return gestational;
	}
	public void setGestational(String gestational) {
		this.gestational = gestational;
	}
	public String getIntrauterine() {
		return intrauterine;
	}
	public void setIntrauterine(String intrauterine) {
		this.intrauterine = intrauterine;
	}
	public String getChorionicity() {
		return chorionicity;
	}
	public void setChorionicity(String chorionicity) {
		this.chorionicity = chorionicity;
	}
	public String getVaginalbleeding() {
		return vaginalbleeding;
	}
	public void setVaginalbleeding(String vaginalbleeding) {
		this.vaginalbleeding = vaginalbleeding;
	}
	public String getAbortion() {
		return abortion;
	}
	public void setAbortion(String abortion) {
		this.abortion = abortion;
	}
	@Override
	public String toString() {
		return "DiagnoseDetails [patientID=" + patientID + ", gestational="
				+ gestational + ", intrauterine=" + intrauterine
				+ ", chorionicity=" + chorionicity + ", vaginalbleeding="
				+ vaginalbleeding + ", abortion=" + abortion + ", iucdInSitu="
				+ iucdInSitu + ", assessmentOfCervical=" + assessmentOfCervical
				+ ", uterineSizeAmenorrhea=" + uterineSizeAmenorrhea
				+ ", suspectedAdenexal=" + suspectedAdenexal
				+ ", chromosomalAbnormalities=" + chromosomalAbnormalities
				+ ", fetalPosition=" + fetalPosition + ", liquorAmnii="
				+ liquorAmnii + ", pretermLabor=" + pretermLabor
				+ ", placentalPosition=" + placentalPosition
				+ ", umbilicalCord=" + umbilicalCord + ", previousCaesarean="
				+ previousCaesarean + ", fetalGrowth=" + fetalGrowth
				+ ", duplexDoppler=" + duplexDoppler
				+ ", terminationOfPregnancy=" + terminationOfPregnancy
				+ ", chorionicVillus=" + chorionicVillus
				+ ", intraPartumEvents=" + intraPartumEvents
				+ ", complicatingPregnancy=" + complicatingPregnancy
				+ ", researchScientific=" + researchScientific + "]";
	}
	
}
