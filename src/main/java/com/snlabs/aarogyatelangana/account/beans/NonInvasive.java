package com.snlabs.aarogyatelangana.account.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NonInvasive extends FormF {
	private int nonInvasiveID;
	private int patientID;
	private String doctorName;
	private String diagnosisIndication;
	private String carriedNonInvasiveProcedure;
	private Date declarationDate;
	private Date procedureCarriedDate;
	private String procedureResult;
	private int conveyID;
	private String mtpIndication;
	private Date date;
	private String place;
	private String otherDiagnoseDetails;
	private String otherProcedure;
	private static Map<Integer, String> procedures = new HashMap<Integer, String>();
	private static Map<Integer, String> diagnoseDetails = new HashMap<Integer, String>();
	private ConveyDetails conveyDetails;
	private String selectedDiagnoseDetails;
	private String selectedProcedures;
	private String patientName;

	static {
		diagnoseDetails
				.put(1,
						"To diagnose intra-uterine and/or ectopic pregnancy and confirm viability");
		diagnoseDetails.put(2, "Estimation of gestational age (dating)");
		diagnoseDetails.put(3,
				"Detection of number of fetuses and their chorionicity");
		/*
		 * diagnoseDetails .put(4,
		 * "Suspected pregnancy with IUCD in-situ or suspected pregnancy following contraceptive failure/MTP failure"
		 * );
		 */
		diagnoseDetails.put(4, "Vaginal bleeding/leaking.");
		diagnoseDetails.put(5, "Follow-up of cases of abortion");
		/*
		 * * diagnoseDetails.put(6,
		 * "Assessment of cervical canal and diameter of internal os");
		 * diagnoseDetails.put(7,
		 * "Discrepancy between uterine size and period of amenorrhea");
		 * diagnoseDetails.put(8,
		 * "Any suspected adenexal or uterine pathology/abnormality");
		 * diagnoseDetails .put(9,
		 * "Detection of chromosomal abnormalities, fetal structural defects and other abnormalities and their follow-up"
		 * ); diagnoseDetails.put(10,
		 * "To evaluate fetal presentation and position");
		 */

		procedures.put(1, "Ultrasound");

	}

	public int getNonInvasiveID() {
		return nonInvasiveID;
	}

	public void setNonInvasiveID(int nonInvasiveID) {
		this.nonInvasiveID = nonInvasiveID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
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

	public int getConveyID() {
		return conveyID;
	}

	public void setConveyID(int conveyID) {
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

	public static Map<Integer, String> getProcedures() {
		return procedures;
	}

	public static void setProcedures(Map<Integer, String> procedures) {
		NonInvasive.procedures = procedures;
	}

	public static Map<Integer, String> getDiagnoseDetails() {
		return diagnoseDetails;
	}

	public static void setDiagnoseDetails(Map<Integer, String> diagnoseDetails) {
		NonInvasive.diagnoseDetails = diagnoseDetails;
	}

	public ConveyDetails getConveyDetails() {
		return conveyDetails;
	}

	public void setConveyDetails(ConveyDetails conveyDetails) {
		this.conveyDetails = conveyDetails;
	}

	public String getSelectedDiagnoseDetails() {
		return selectedDiagnoseDetails;
	}

	public void setSelectedDiagnoseDetails(String selectedDiagnoseDetails) {
		this.selectedDiagnoseDetails = selectedDiagnoseDetails;
	}

	public String getSelectedProcedures() {
		return selectedProcedures;
	}

	public void setSelectedProcedures(String selectedProcedures) {
		this.selectedProcedures = selectedProcedures;
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
				+ conveyDetails + ", selectedDiagnoseDetails="
				+ selectedDiagnoseDetails + ", selectedProcedures="
				+ selectedProcedures + ", patientName=" + patientName + "]";
	}
}
