/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

/**
 * @author nbattula
 *
 */
public class DiagnosisIndication {

	private String chromosomalDisorders;
	private String metabolicDisorders;
	private String congenitalAnomaly;
	private String singleGeneDisorder;
	private String mentalRetardation;
	private String haemoglobinopathy;
	private String sexLinkedDisorders;
	private String anyOther = "NA";
	public String getChromosomalDisorders() {
		return chromosomalDisorders;
	}
	public void setChromosomalDisorders(String chromosomalDisorders) {
		this.chromosomalDisorders = chromosomalDisorders;
	}
	public String getMetabolicDisorders() {
		return metabolicDisorders;
	}
	public void setMetabolicDisorders(String metabolicDisorders) {
		this.metabolicDisorders = metabolicDisorders;
	}
	public String getCongenitalAnomaly() {
		return congenitalAnomaly;
	}
	public void setCongenitalAnomaly(String congenitalAnomaly) {
		this.congenitalAnomaly = congenitalAnomaly;
	}
	public String getSingleGeneDisorder() {
		return singleGeneDisorder;
	}
	public void setSingleGeneDisorder(String singleGeneDisorder) {
		this.singleGeneDisorder = singleGeneDisorder;
	}
	public String getMentalRetardation() {
		return mentalRetardation;
	}
	public void setMentalRetardation(String mentalRetardation) {
		this.mentalRetardation = mentalRetardation;
	}
	public String getHaemoglobinopathy() {
		return haemoglobinopathy;
	}
	public void setHaemoglobinopathy(String haemoglobinopathy) {
		this.haemoglobinopathy = haemoglobinopathy;
	}
	public String getSexLinkedDisorders() {
		return sexLinkedDisorders;
	}
	public void setSexLinkedDisorders(String sexLinkedDisorders) {
		this.sexLinkedDisorders = sexLinkedDisorders;
	}
	public String getAnyOther() {
		return anyOther;
	}
	public void setAnyOther(String anyOther) {
		this.anyOther = anyOther;
	}
	@Override
	public String toString() {
		return "DiagnosisIndication [chromosomalDisorders="
				+ chromosomalDisorders + ", metabolicDisorders="
				+ metabolicDisorders + ", congenitalAnomaly="
				+ congenitalAnomaly + ", singleGeneDisorder="
				+ singleGeneDisorder + ", mentalRetardation="
				+ mentalRetardation + ", haemoglobinopathy="
				+ haemoglobinopathy + ", sexLinkedDisorders="
				+ sexLinkedDisorders + ", anyOther=" + anyOther + "]";
	}
	
}
