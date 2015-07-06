/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

/**
 * @author nbattula
 *
 */
public class AdditionalTests {
	private String chromosomalStudies;
	private String biochemicalStudies;
	private String molecularStudies;
	private String preImplantationGender;
	private String others = "NA";
	public String getChromosomalStudies() {
		return chromosomalStudies;
	}
	public void setChromosomalStudies(String chromosomalStudies) {
		this.chromosomalStudies = chromosomalStudies;
	}
	public String getBiochemicalStudies() {
		return biochemicalStudies;
	}
	public void setBiochemicalStudies(String biochemicalStudies) {
		this.biochemicalStudies = biochemicalStudies;
	}
	public String getMolecularStudies() {
		return molecularStudies;
	}
	public void setMolecularStudies(String molecularStudies) {
		this.molecularStudies = molecularStudies;
	}
	public String getPreImplantationGender() {
		return preImplantationGender;
	}
	public void setPreImplantationGender(String preImplantationGender) {
		this.preImplantationGender = preImplantationGender;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	@Override
	public String toString() {
		return "AdditionalTests [chromosomalStudies=" + chromosomalStudies
				+ ", biochemicalStudies=" + biochemicalStudies
				+ ", molecularStudies=" + molecularStudies
				+ ", preImplantationGender=" + preImplantationGender
				+ ", others=" + others + "]";
	}

}
