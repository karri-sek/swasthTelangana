package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invasive extends FormF {

	private int invasiveID;
	private String doctorName;
	private String dignosisBasics;
	private String advancedMaternalAge;
	private String geneticDisease;
	private Date contestDate;
	private String carriedInvasiveProcedure;
	private String compilication;
	private String additionalTest;
	private String procedureResult;
	private Date procedureCarriedDate;
	private String mtpIndication;
	private String historyOfGeneticDisease;
	private ConveyDetails conveyDetails;
	private int patientID;
	private String patientName;



    public void setDiagnosisIndications(String diagnosisIndications) {
        this.diagnosisIndications = diagnosisIndications;
    }

    public String getDiagnosisIndications() {
        return diagnosisIndications;
    }

    private String diagnosisIndications;

	private static Map<Integer, String> invasiveProcedures = new HashMap<Integer, String>();
	private static Map<Integer, String> diagnosisBasis = new HashMap<Integer, String>();
	private static Map<Integer, String> diagnosisIndication = new HashMap<Integer, String>();

	static {
		diagnosisBasis.put(1, "Clinical");
		diagnosisBasis.put(2, "Bio-chemical");
		diagnosisBasis.put(3, "Cytogenetic");
		diagnosisBasis.put(4, "Other(e.g.radiological,ultrasonography)");

		diagnosisIndication.put(1, "Chromosomal disorders");
		diagnosisIndication.put(2, "Metabolic disorders");
		diagnosisIndication.put(3, "Congenital anomaly");
		diagnosisIndication.put(4, "Mental Disability");
		diagnosisIndication.put(5, "Haemoglobinopathy");
		diagnosisIndication.put(6, "Sex linked disorders");
		diagnosisIndication.put(7, "Single gene disorder");
		diagnosisIndication.put(8, "Single gene disorder");

		invasiveProcedures.put(1, "Amniocentesis");
		invasiveProcedures.put(2, "Chorionic Villi aspiration");
		invasiveProcedures.put(3, "Fetal biopsy");
		invasiveProcedures.put(4, "Cordocentesis");

	}

	public int getInvasiveID() {
		return invasiveID;
	}

	public void setInvasiveID(int invasiveID) {
		this.invasiveID = invasiveID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDignosisBasics() {
		return dignosisBasics;
	}

	public void setDignosisBasics(String dignosisBasics) {
		this.dignosisBasics = dignosisBasics;
	}

	public String getAdvancedMaternalAge() {
		return advancedMaternalAge;
	}

	public void setAdvancedMaternalAge(String advancedMaternalAge) {
		this.advancedMaternalAge = advancedMaternalAge;
	}

	public String getGeneticDisease() {
		return geneticDisease;
	}

	public void setGeneticDisease(String geneticDisease) {
		this.geneticDisease = geneticDisease;
	}

	public Date getContestDate() {
		return contestDate;
	}

	public void setContestDate(Date contestDate) {
		this.contestDate = contestDate;
	}

	public String getCarriedInvasiveProcedure() {
		return carriedInvasiveProcedure;
	}

	public void setCarriedInvasiveProcedure(String carriedInvasiveProcedure) {
		this.carriedInvasiveProcedure = carriedInvasiveProcedure;
	}

	public String getCompilication() {
		return compilication;
	}

	public void setCompilication(String compilication) {
		this.compilication = compilication;
	}

	public String getAdditionalTest() {
		return additionalTest;
	}

	public void setAdditionalTest(String additionalTest) {
		this.additionalTest = additionalTest;
	}

	public String getProcedureResult() {
		return procedureResult;
	}

	public void setProcedureResult(String procedureResult) {
		this.procedureResult = procedureResult;
	}

	public Date getProcedureCarriedDate() {
		return procedureCarriedDate;
	}

	public void setProcedureCarriedDate(Date procedureCarriedDate) {
		this.procedureCarriedDate = procedureCarriedDate;
	}

	public String getMtpIndication() {
		return mtpIndication;
	}

	public void setMtpIndication(String mtpIndication) {
		this.mtpIndication = mtpIndication;
	}

	public String getHistoryOfGeneticDisease() {
		return historyOfGeneticDisease;
	}

	public void setHistoryOfGeneticDisease(String historyOfGeneticDisease) {
		this.historyOfGeneticDisease = historyOfGeneticDisease;
	}

	public static Map<Integer, String> getDiagnosisBasis() {
		return diagnosisBasis;
	}

	public static void setDiagnosisBasis(Map<Integer, String> diagnosisBasis) {
		Invasive.diagnosisBasis = diagnosisBasis;
	}

	public static Map<Integer, String> getDiagnosisIndication() {
		return diagnosisIndication;
	}

	public static void setDiagnosisIndication(
			Map<Integer, String> diagnosisIndication) {
		Invasive.diagnosisIndication = diagnosisIndication;
	}

	public ConveyDetails getConveyDetails() {
		return conveyDetails;
	}

	public void setConveyDetails(ConveyDetails conveyDetails) {
		this.conveyDetails = conveyDetails;
	}

	public static Map<Integer, String> getInvasiveProcedures() {
		return invasiveProcedures;
	}

	public static void setInvasiveProcedures(
			Map<Integer, String> invasiveProcedures) {
		Invasive.invasiveProcedures = invasiveProcedures;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Override
	public String toString() {
		return "Invasive [invasiveID=" + invasiveID + ", doctorName="
				+ doctorName + ", dignosisBasics=" + dignosisBasics
				+ ", advancedMaternalAge=" + advancedMaternalAge
				+ ", geneticDisease=" + geneticDisease + ", contestDate="
				+ contestDate + ", carriedInvasiveProcedure="
				+ carriedInvasiveProcedure + ", compilication=" + compilication
				+ ", additionalTest=" + additionalTest + ", procedureResult="
				+ procedureResult + ", procedureCarriedDate="
				+ procedureCarriedDate + ", mtpIndication=" + mtpIndication
				+ "]";
	}
}
