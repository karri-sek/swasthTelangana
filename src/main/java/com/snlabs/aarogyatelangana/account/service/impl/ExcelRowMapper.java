package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.AdditionalTests;
import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.ConveyDetails;
import com.snlabs.aarogyatelangana.account.beans.DiagnoseDetails;
import com.snlabs.aarogyatelangana.account.beans.DiagnosisBasis;
import com.snlabs.aarogyatelangana.account.beans.DiagnosisIndication;
import com.snlabs.aarogyatelangana.account.beans.ExcelRow;
import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.Invasive;
import com.snlabs.aarogyatelangana.account.beans.InvasiveProcedures;
import com.snlabs.aarogyatelangana.account.beans.NonInvasive;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.PatientAddress;
import com.snlabs.aarogyatelangana.account.beans.PatientCurrentAddress;
import com.snlabs.aarogyatelangana.account.beans.Procedures;
import com.snlabs.aarogyatelangana.account.beans.SectionA;
import com.snlabs.aarogyatelangana.account.beans.User;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelRowMapper implements RowMapper {
	ExcelRow excelRow = null;
	List<User> excelRowList = new ArrayList<User>();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			do {
				if (rs != null) {
					excelRow = new ExcelRow();
					// Patient
					Patient patient = new Patient();
					patient = new Patient();
					patient.setPatientName(rs.getString("F_PATIENT_NAME"));
					patient.setPatientID(rs.getInt("F_PATIENT_ID"));
					patient.setCreatedTimestamp(rs
							.getDate("F_CREATED_TIMESTAMP"));
					patient.setAge(rs.getInt("F_AGE"));
					patient.setGender(rs.getString("F_GENDER"));
					patient.setCreatedBy(rs.getString("F_CREATED_BY"));
					patient.setFormFDownloadPath(rs
							.getString("F_DOWNLOAD_PATH"));
					patient.setAadharNo(rs.getString("F_AADHAR_NO"));
					patient.setUpdatedTimestamp(rs
							.getDate("F_UPDATED_TIMESTAMP"));

					PatientAddress patientAddress = new PatientAddress();
					patientAddress.setAddress(rs.getString("F_ADDRESS"));
					patientAddress.setContactno(rs.getString("F_CONTACT_NO"));
					patientAddress.setDistrict(rs.getString("F_DISTRICT"));
					patientAddress.setState(rs.getString("F_STATE"));
					patientAddress.setPincode(rs.getInt("F_PINCODE"));
					patientAddress.setCityName(rs.getString("F_CITY"));
					patientAddress.setPatientID(patient.getPatientID());
					patient.setPatientAddress(patientAddress);

					PatientCurrentAddress patientCurrentAddress = new PatientCurrentAddress();
					patientCurrentAddress.setAddress(rs
							.getString("F_ADDRESS_CURRENT"));
					patientCurrentAddress.setCityName(rs
							.getString("F_CITY_CURRENT"));
					patientCurrentAddress.setDistrict(rs
							.getString("F_DISTRICT_CURRENT"));
					patientCurrentAddress.setPincode(rs
							.getInt("F_PINCODE_CURRENT"));
					patientCurrentAddress.setState(rs
							.getString("F_STATE_CURRENT"));
					patientCurrentAddress.setSameAsPresentAddress(rs
							.getString("F_SAME_AS_PRESENT_ADDRESS"));
					patientCurrentAddress.setPatientID(patient.getPatientID());
					patient.setPatientCurrentAddress(patientCurrentAddress);

					excelRow.setPatient(patient);

					// Clinic Address
					ClinicAddress clinicAddress = new ClinicAddress();
					clinicAddress.setPatientID(rs.getInt("F_PATIENT_ID"));
					clinicAddress.setOwnerName(rs
							.getString("F_CLINIC_OWNER_NAME"));
					clinicAddress.setType(rs.getString("F_TYPE"));
					clinicAddress.setAddress(rs.getString("F_ADDRESS"));
					clinicAddress.setDistrict(rs.getString("F_DISTRICT"));
					clinicAddress.setClinicName(rs.getString("F_CLINIC_NAME"));
					clinicAddress.setState(rs.getString("F_STATE"));
					clinicAddress.setContactNum(rs.getString("F_CONTACT_NO"));
					clinicAddress.setPincode(rs.getInt("F_PINCODE"));
					clinicAddress.setRegistrationNo(rs.getString("F_REG_NO"));

					excelRow.setClinicAddress(clinicAddress);

					// SectionA
					SectionA sectionA = new SectionA();
					sectionA.setPatientID(rs.getInt("F_PATIENT_ID"));
					sectionA.setNoOfChildren(rs.getInt("F_NO_OF_CHILDREN"));
					sectionA.setLastMenstrualPeriod(rs
							.getDate("F_LAST_MENSTRUAL_PERIOD"));
					sectionA.setWeeksOfPragnancy(rs
							.getInt("F_WEEKS_OF_PREGNANCY"));
					sectionA.setNoOfMaleKids(rs.getInt("F_NO_OF_MALE_KIDS"));
					sectionA.setNoOfFemaleKids(rs.getInt("F_NO_OF_FEMALE_KIDS"));
					sectionA.setGuardianName(rs.getString("F_GUARDIAN_NAME"));
					sectionA.setReferredBy(rs.getString("F_REFERRED_BY"));
					sectionA.setSelfReferredBy(rs
							.getString("F_SELF_REFERRED_BY"));

					excelRow.setSectionA(sectionA);

					// Non-invasive
					NonInvasive nonInvasive = new NonInvasive();
					nonInvasive.setPatientID(rs.getLong("F_PATIENT_ID"));
					nonInvasive.setPatientName(rs.getString("F_PATIENT_NAME"));
					nonInvasive.setDoctorName(rs.getString("F_DOCTOR_NAME"));
					nonInvasive.setDiagnosisIndication(rs
							.getString("F_DIAGNOSIS_INDICATION"));
					nonInvasive.setDeclarationDate(rs
							.getDate("F_DECLARATION_DATE"));
					nonInvasive.setProcedureCarriedDate(rs
							.getDate("F_PROCEDURE_CARRIED_DATE"));
					nonInvasive.setProcedureResult(rs
							.getString("F_PROCEDURE_RESULT"));
					nonInvasive.setConveyID(rs.getLong("F_CONVEY_ID"));
					nonInvasive.setMtpIndication(rs
							.getString("F_MTP_INDICATION"));
					nonInvasive.setDate(rs.getDate("F_DATE"));
					nonInvasive.setOtherDiagnoseDetails(rs
							.getString("F_OTHER_DIAGNOSE"));
					nonInvasive.setOtherProcedure(rs
							.getString("F_OTHER_PROCEDURE"));

					Procedures procedures = new Procedures();
					procedures.setUltrasound(rs
							.getString("F_CARRIED_NON_INVASIVE_PROCEDURE"));
					nonInvasive.setProcedures(procedures);

					ConveyDetails conveyDetails = new ConveyDetails();
					conveyDetails.setPatientID(rs.getInt("F_PATIENT_ID"));
					conveyDetails.setConveyID(rs.getLong("F_CONVEY_ID"));
					conveyDetails
							.setConveyedName(rs.getString("F_CONVEY_NAME"));
					conveyDetails.setConveyedDate(rs.getDate("F_CONVEY_DATE"));
					conveyDetails.setType(rs.getString("F_TYPE"));
					nonInvasive.setConveyDetails(conveyDetails);

					DiagnoseDetails diagnoseDetails = new DiagnoseDetails();
					diagnoseDetails.setPatientID(rs.getInt("F_PATIENT_ID"));
					diagnoseDetails.setGestational(rs
							.getString("F_GESTATIONAL"));
					diagnoseDetails.setIntrauterine(rs
							.getString("F_INTRAUTERINE"));
					diagnoseDetails.setChorionicity(rs
							.getString("F_CHORIONICITY"));
					diagnoseDetails.setVaginalbleeding(rs
							.getString("F_VAGINAL_BLEEDING"));
					diagnoseDetails.setAbortion(rs.getString("F_ABORTION"));
					diagnoseDetails.setIucdInSitu(rs
							.getString("F_IUCD_IN_SITU"));
					diagnoseDetails.setAssessmentOfCervical(rs
							.getString("F_ASSESSMENT_OF_CERVICAL"));
					diagnoseDetails.setUterineSizeAmenorrhea(rs
							.getString("F_UTERINESIZE_AMENORRHEA"));
					diagnoseDetails.setSuspectedAdenexal(rs
							.getString("F_SUSPECTED_ADENEXAL"));
					diagnoseDetails.setChromosomalAbnormalities(rs
							.getString("F_CHROMOSOMAL_ABNORMALITIES"));
					diagnoseDetails.setFetalPosition(rs
							.getString("F_FETAL_POSITION"));
					diagnoseDetails.setLiquorAmnii(rs
							.getString("F_LIQUOR_AMNII"));
					diagnoseDetails.setPretermLabor(rs
							.getString("F_PRETERM_LABOR"));
					diagnoseDetails.setPlacentalPosition(rs
							.getString("F_PLACENTAL_POSITION"));
					diagnoseDetails.setUmbilicalCord(rs
							.getString("F_UMBILICAL_CORD"));
					diagnoseDetails.setPreviousCaesarean(rs
							.getString("F_PREVIOUS_CAESAREAN"));
					diagnoseDetails.setFetalGrowth(rs
							.getString("F_FETAL_GROWTH"));
					diagnoseDetails.setDuplexDoppler(rs
							.getString("F_DUPLEX_DOPPLER"));
					diagnoseDetails.setTerminationOfPregnancy(rs
							.getString("F_TERMINATION_OF_PREGNANCY"));
					diagnoseDetails.setChorionicVillus(rs
							.getString("F_CHORIONIC_VILLUS"));
					diagnoseDetails.setIntraPartumEvents(rs
							.getString("F_INTRA_PARTUM_EVENTS"));
					diagnoseDetails.setComplicatingPregnancy(rs
							.getString("F_COMPLICATING_PREGNANCY"));
					diagnoseDetails.setResearchScientific(rs
							.getString("F_RESEARCH_SCIENTIFIC"));
					nonInvasive.setDiagnoseDetails(diagnoseDetails);
					excelRow.setNonInvasive(nonInvasive);

					// Invasive
					Invasive invasive = new Invasive();
					invasive.setDoctorName(rs.getString("F_DOCTOR_NAME"));
					invasive.setHistoryOfGeneticDisease(rs.getString("F_HISTORY_OF_GENETIC_DISEASE"));
					invasive.setAdvancedMaternalAge(rs.getString("F_ADVANCED_MATERNAL_AGE"));
					invasive.setGeneticDisease(rs.getString("F_GENETIC_DISEASE"));
					invasive.setPreviousComplication(rs.getString("F_PREVIOUS_COMPLICATION"));
					invasive.setFormGDate(rs.getDate("F_FORM_G_DATE"));
					invasive.setComplication(rs.getString("F_COMPLICATIONS"));
					invasive.setProcedureResult(rs.getString("F_PROCEDURE_RESULT"));
					invasive.setProcedureCarriedDate(rs.getDate("F_PROCEDURE_CARRIED_DATE"));
					//invasive.setMtpIndication(rs.getString(""));

					ConveyDetails invConveyDetails = new ConveyDetails();
					invConveyDetails.setConveyedName(rs.getString("F_CONVEY_NAME"));
					invConveyDetails.setConveyedDate(rs.getDate("F_CONVEY_DATE"));
					invasive.setConveyDetails(invConveyDetails);

					DiagnosisBasis diagnosisBasis = new DiagnosisBasis();
					diagnosisBasis.setBiochemical(rs.getString("F_BIOCHEMICAL"));
					diagnosisBasis.setClinical(rs.getString("F_CLINICAL"));
					diagnosisBasis.setCytogenetic(rs.getString("F_CYTOGENETIC"));
					diagnosisBasis.setOther(rs.getString("F_ANY_OTHER"));
					invasive.setDiagnosisBasis(diagnosisBasis);

					DiagnosisIndication diagnosisIndication = new DiagnosisIndication();
					diagnosisIndication.setAnyOther(rs.getString("F_ANY_OTHER"));
					diagnosisIndication.setChromosomalDisorders(rs.getString("F_CHROMOSOMAL_DISORDERS"));
					diagnosisIndication.setCongenitalAnomaly(rs.getString("F_CONGENITAL_ANOMALY"));
					diagnosisIndication.setHaemoglobinopathy(rs.getString("F_HAEMOGLOBINOPATHY"));
					diagnosisIndication.setMentalRetardation(rs.getString("F_MENTAL_RETARDATION"));
					diagnosisIndication.setMetabolicDisorders(rs.getString("F_METABOLIC_DISORDERS"));
					diagnosisIndication.setSexLinkedDisorders(rs.getString("F_SEXLINKED_DISORDERS"));
					diagnosisIndication.setSingleGeneDisorder(rs.getString("F_SINGLEGENE_DISORDER"));
					invasive.setDiagnosisIndication(diagnosisIndication);

					InvasiveProcedures invasiveProcedures = new InvasiveProcedures();
					invasiveProcedures.setAmniocentesis(rs.getString("F_AMNIOCENTESIS"));
					invasiveProcedures.setChorionicVilli(rs.getString("F_CHORIONIC_VILLI"));
					invasiveProcedures.setCordocentesis(rs.getString("F_CORDOCENTESIS"));
					invasiveProcedures.setFetalBiopsy(rs.getString("F_FETAL_BIOPSY"));
					invasiveProcedures.setOthers(rs.getString("F_ANY_OTHER"));
					invasive.setInvasiveProcedures(invasiveProcedures);

					AdditionalTests additionalTests = new AdditionalTests();
					additionalTests.setBiochemicalStudies(rs.getString("F_BIOCHEMICAL_STUDIES"));
					additionalTests.setChromosomalStudies(rs.getString("F_CHROMOSOMAL_STUDIES"));
					additionalTests.setMolecularStudies(rs.getString("F_MOLECULAR_STUDIES"));
					additionalTests.setOthers(rs.getString("F_ANY_OTHER"));
					additionalTests.setPreImplantationGender(rs.getString("F_PREIMPLANTATION_GENDER"));
					invasive.setAdditionalTests(additionalTests);

					excelRow.setInvasive(invasive);

					excelRowList.add(excelRow);
				}
			} while (rs.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelRowList;
	}
}
