package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NonInvasive extends FormF {
	private long nonInvasiveID;
	private long patientID;
	private String doctorName = "DR. ";
	private String diagnosisIndication;
	private String carriedNonInvasiveProcedure;
	private Date declarationDate;
	private Date procedureCarriedDate;
	private String procedureResult;
	private long conveyID;
	private String mtpIndication;
	private Date date;
	private String place;
	private String otherDiagnoseDetails = "No";
	private String otherProcedure = "No";
	private ConveyDetails conveyDetails;
	private String patientName;
	private Date edd; 
	
	private String operation;
    
	private DiagnoseDetails diagnoseDetails;
	private Procedures procedures; 
	
	public Date getEdd() {
		return edd;
	}

	public void setEdd(Date edd) {
		this.edd = edd;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public long getNonInvasiveID() {
		return nonInvasiveID;
	}

	public void setNonInvasiveID(long nonInvasiveID) {
		this.nonInvasiveID = nonInvasiveID;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDiagnosisIndication() {
		return diagnosisIndication;
	}

	public void setDiagnosisIndication(String diagnosisIndication) {
		this.diagnosisIndication = diagnosisIndication;
	}

	public String getCarriedNonInvasiveProcedure() {
		return carriedNonInvasiveProcedure;
	}

	public void setCarriedNonInvasiveProcedure(
			String carriedNonInvasiveProcedure) {
		this.carriedNonInvasiveProcedure = carriedNonInvasiveProcedure;
	}

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}

	public Date getProcedureCarriedDate() {
		return procedureCarriedDate;
	}

	public void setProcedureCarriedDate(Date procedureCarriedDate) {
		this.procedureCarriedDate = procedureCarriedDate;
	}

	public String getProcedureResult() {
		return procedureResult;
	}

	public void setProcedureResult(String procedureResult) {
		this.procedureResult = procedureResult;
	}

	public long getConveyID() {
		return conveyID;
	}

	public void setConveyID(long conveyID) {
		this.conveyID = conveyID;
	}

	public String getMtpIndication() {
		return mtpIndication;
	}

	public void setMtpIndication(String mtpIndication) {
		this.mtpIndication = mtpIndication;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getOtherDiagnoseDetails() {
		return otherDiagnoseDetails;
	}

	public void setOtherDiagnoseDetails(String otherDiagnoseDetails) {
		this.otherDiagnoseDetails = otherDiagnoseDetails;
	}

	public String getOtherProcedure() {
		return otherProcedure;
	}

	public void setOtherProcedure(String otherProcedure) {
		this.otherProcedure = otherProcedure;
	}

	public Procedures getProcedures() {
		return procedures;
	}

	public void setProcedures(Procedures procedures) {
		this.procedures = procedures;
	}

	public DiagnoseDetails getDiagnoseDetails() {
		return diagnoseDetails;
	}

	public void setDiagnoseDetails(DiagnoseDetails diagnoseDetails) {
		this.diagnoseDetails = diagnoseDetails;
	}

	public ConveyDetails getConveyDetails() {
		return conveyDetails;
	}

	public void setConveyDetails(ConveyDetails conveyDetails) {
		this.conveyDetails = conveyDetails;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Override
	public String toString() {
		return "NonInvasive [nonInvasiveID=" + nonInvasiveID + ", patientID="
				+ patientID + ", doctorName=" + doctorName
				+ ", diagnosisIndication=" + diagnosisIndication
				+ ", carriedNonInvasiveProcedure="
				+ carriedNonInvasiveProcedure + ", declarationDate="
				+ declarationDate + ", procedureCarriedDate="
				+ procedureCarriedDate + ", procedureResult=" + procedureResult
				+ ", conveyID=" + conveyID + ", mtpIndication=" + mtpIndication
				+ ", date=" + date + ", place=" + place
				+ ", otherDiagnoseDetails=" + otherDiagnoseDetails
				+ ", otherProcedure=" + otherProcedure + ", conveyDetails="
				+ conveyDetails + ", patientName=" + patientName + ", edd="
				+ edd + ", operation=" + operation + ", diagnoseDetails="
				+ diagnoseDetails + ", procedures=" + procedures + "]";
	}

}
