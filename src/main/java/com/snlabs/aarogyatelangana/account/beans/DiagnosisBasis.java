/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

/**
 * @author nbattula
 *
 */
public class DiagnosisBasis {

	private String clinical = "YES";
	private String biochemical;
	private String cytogenetic;
	private String other = "NA";
	public String getClinical() {
		return clinical;
	}
	public void setClinical(String clinical) {
		this.clinical = clinical;
	}
	public String getBiochemical() {
		return biochemical;
	}
	public void setBiochemical(String biochemical) {
		this.biochemical = biochemical;
	}
	public String getCytogenetic() {
		return cytogenetic;
	}
	public void setCytogenetic(String cytogenetic) {
		this.cytogenetic = cytogenetic;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "DiagnosisBasis [clinical=" + clinical + ", biochemical="
				+ biochemical + ", cytogenetic=" + cytogenetic + ", other="
				+ other + "]";
	}
}
