package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nbattula
 *
 */
public class Invasive extends FormF {

	private int invasiveID;
	private String doctorName = "DR. ";
	private String historyOfGeneticDisease = "No";
	private String advancedMaternalAge = "No";
	private String geneticDisease = "No";
	private String previousComplication = "No";
	private Date formGDate;
	private String complication = "No";
	private String procedureResult = "Negetive";
	private Date procedureCarriedDate;
	private String mtpIndication = "No";
	
	private long patientID;
	private String patientName;
	
	private ConveyDetails conveyDetails;
	private DiagnosisBasis diagnosisBasis;
	private DiagnosisIndication diagnosisIndication;
	private InvasiveProcedures invasiveProcedures;
    private AdditionalTests additionalTests;
    
    private String operation;
    
    public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getComplication() {
		return complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	public AdditionalTests getAdditionalTests() {
		return additionalTests;
	}

	public void setAdditionalTests(AdditionalTests additionalTests) {
		this.additionalTests = additionalTests;
	}

	public Date getFormGDate() {
		return formGDate;
	}

	public void setFormGDate(Date formGDate) {
		this.formGDate = formGDate;
	}

	public DiagnosisBasis getDiagnosisBasis() {
		return diagnosisBasis;
	}

	public void setDiagnosisBasis(DiagnosisBasis diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}

	public DiagnosisIndication getDiagnosisIndication() {
		return diagnosisIndication;
	}

	public void setDiagnosisIndication(DiagnosisIndication diagnosisIndication) {
		this.diagnosisIndication = diagnosisIndication;
	}

	public InvasiveProcedures getInvasiveProcedures() {
		return invasiveProcedures;
	}

	public void setInvasiveProcedures(InvasiveProcedures invasiveProcedures) {
		this.invasiveProcedures = invasiveProcedures;
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

	public String getHistoryOfGeneticDisease() {
		return historyOfGeneticDisease;
	}

	public void setHistoryOfGeneticDisease(String historyOfGeneticDisease) {
		this.historyOfGeneticDisease = historyOfGeneticDisease;
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

	public String getPreviousComplication() {
		return previousComplication;
	}

	public void setPreviousComplication(String previousComplication) {
		this.previousComplication = previousComplication;
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

	public ConveyDetails getConveyDetails() {
		return conveyDetails;
	}

	public void setConveyDetails(ConveyDetails conveyDetails) {
		this.conveyDetails = conveyDetails;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}
