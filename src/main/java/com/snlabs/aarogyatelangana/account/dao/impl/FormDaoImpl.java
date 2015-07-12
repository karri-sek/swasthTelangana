package com.snlabs.aarogyatelangana.account.dao.impl;

import com.snlabs.aarogyatelangana.account.beans.*;
import com.snlabs.aarogyatelangana.account.dao.FormDao;
import com.snlabs.aarogyatelangana.account.service.impl.FormRowMapper;
import com.snlabs.aarogyatelangana.account.service.impl.InvasiveRowMapper;
import com.snlabs.aarogyatelangana.account.service.impl.NonInvasiveRowMapper;
import com.snlabs.aarogyatelangana.account.service.impl.PatientIDsMapper;
import com.snlabs.aarogyatelangana.account.service.impl.PatientRowMapper;
import com.snlabs.aarogyatelangana.account.utils.AppConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class FormDaoImpl implements FormDao {

	private DataSource dataSource;

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientDetails(long patientID) {
		Patient patient = null;
		try {
			StringBuilder patientDetailsQuery = new StringBuilder();
			patientDetailsQuery
					.append("SELECT patient.F_PATIENT_NAME,")
					.append("patient.F_PATIENT_ID, patient.F_AGE, patient.F_GENDER, patient.F_AADHAR_NO, address.F_CONTACT_NO,")
					.append("address.F_DISTRICT, address.F_STATE, address.F_PINCODE, address.F_ADDRESS, address.F_CITY,")
					.append("current_address.F_DISTRICT_CURRENT,current_address.F_STATE_CURRENT,current_address.F_PINCODE_CURRENT,current_address.F_ADDRESS_CURRENT,")
					.append("current_address.F_CITY_CURRENT, current_address.F_SAME_AS_PRESENT_ADDRESS")
					.append(" FROM ")
					.append(AppConstants.PATIENT_TABLE)
					.append(" patient,")
					.append(AppConstants.PATIENT_ADDRESS)
					.append(" address,")
					.append(AppConstants.PATIENT_CURRENT_ADDRESS)
					.append(" current_address ")
					.append("WHERE patient.F_PATIENT_ID = ?")
					.append(" AND address.F_PATIENT_ID = patient.F_PATIENT_ID")
					.append(" AND current_address.F_PATIENT_ID = patient.F_PATIENT_ID");

			Object[] args = { patientID };

			patient = (Patient) jdbcTemplate.query(
					patientDetailsQuery.toString(), args,
					new PatientRowMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(AppConstants.CLINIC_DETAILS)
				.append(" (F_PATIENT_ID,").append("F_CLINIC_OWNER_NAME,")
				.append("F_TYPE,").append("F_ADDRESS,").append("F_DISTRICT,")
				.append("F_STATE,").append("F_PINCODE,").append("F_REG_NO,")
				.append("F_CONTACT_NO,").append("F_CLINIC_NAME)");
		sb.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
		Object[] args = new Object[] { clinicAddress.getPatientID(),
				clinicAddress.getOwnerName(), clinicAddress.getType(),
				clinicAddress.getAddress(), clinicAddress.getDistrict(),
				clinicAddress.getState(), clinicAddress.getPincode(),
				clinicAddress.getRegistrationNo(),
				clinicAddress.getContactNum(), clinicAddress.getClinicName() };
		try {
			return jdbcTemplate.update(sb.toString(), args) > 0 ? clinicAddress
					: null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Form form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClinicDetails(ClinicAddress clinicAddress) {
		StringBuilder updateClinicRecord = new StringBuilder();
		try {
			updateClinicRecord.append("UPDATE ")
					.append(AppConstants.CLINIC_DETAILS)
					.append(" SET F_CLINIC_OWNER_NAME = ?,")
					.append(" F_TYPE = ?,").append(" F_ADDRESS  = ?,")
					.append(" F_DISTRICT = ?,").append(" F_STATE = ?,")
					.append(" F_PINCODE = ?,").append(" F_CONTACT_NO = ?,")
					.append(" F_CLINIC_NAME = ?,").append(" F_REG_NO = ?")
					.append(" WHERE F_PATIENT_ID = ?");
			Object[] args = { clinicAddress.getOwnerName(),
					clinicAddress.getType(), clinicAddress.getAddress(),
					clinicAddress.getDistrict(), clinicAddress.getState(),
					clinicAddress.getPincode(), clinicAddress.getContactNum(),
					clinicAddress.getClinicName(),
					clinicAddress.getRegistrationNo(),
					clinicAddress.getPatientID() };
			return jdbcTemplate.update(updateClinicRecord.toString(), args) > 0 ? true
					: false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateSectionA(SectionA sectionA) {
		StringBuilder updateFormRecord = new StringBuilder();
		updateFormRecord
				.append("UPDATE " + AppConstants.FORM
						+ " SET F_NO_OF_CHILDREN = ?,")
				.append(" F_GUARDIAN_NAME = ?,")
				.append(" F_NO_OF_MALE_KIDS  = ?,")
				.append(" F_NO_OF_FEMALE_KIDS = ?,")
				.append(" F_LAST_MENSTRUAL_PERIOD = ?,")
				.append(" F_REFERRED_BY = ?,")
				.append(" F_SELF_REFERRED_BY = ?,")
				.append(" F_WEEKS_OF_PREGNANCY = ?")
				.append(" WHERE F_PATIENT_ID = ?");
		Object[] args = { sectionA.getNoOfChildren(),
				sectionA.getGuardianName(), sectionA.getNoOfMaleKids(),
				sectionA.getNoOfFemaleKids(),
				sectionA.getLastMenstrualPeriod(), sectionA.getReferredBy(),
				sectionA.getSelfReferredBy(), sectionA.getWeeksOfPragnancy(),
				sectionA.getPatientID() };
		try {
			return jdbcTemplate.update(updateFormRecord.toString(), args) > 0 ? true
					: false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateNonInvasiveDetails(NonInvasive nonInvasive) {
		StringBuilder updateNonInvasiveRecord = new StringBuilder();
		updateNonInvasiveRecord
				.append("UPDATE " + AppConstants.NON_INVASIVE_PROCEDURES
						+ " SET F_DOCTOR_NAME = ?,")
				.append(" F_DIAGNOSIS_INDICATION = ?,")
				.append(" F_CARRIED_NON_INVASIVE_PROCEDURE  = ?,")
				.append(" F_DECLARATION_DATE = ?,")
				.append(" F_PROCEDURE_CARRIED_DATE = ?,")
				.append(" F_PROCEDURE_RESULT = ?,").append(" F_CONVEY_ID = ?,")
				.append(" F_MTP_INDICATION = ?,").append(" F_DATE = ?,")
				.append(" F_OTHER_DIAGNOSE = ?,")
				.append(" F_CARRIED_NON_INVASIVE_PROCEDURE = ?,")
				.append(" F_PLACE = ?").append(" WHERE F_PATIENT_ID = ?");
		Object[] args = {
				nonInvasive.getDoctorName(),
				nonInvasive.getDiagnosisIndication(),
				nonInvasive.getCarriedNonInvasiveProcedure(),
				nonInvasive.getDeclarationDate(),
				nonInvasive.getProcedureCarriedDate(),
				nonInvasive.getProcedureResult(),
				nonInvasive.getConveyID(),
				nonInvasive.getMtpIndication(),
				nonInvasive.getDate(),
				nonInvasive.getOtherDiagnoseDetails(),
				nonInvasive.getProcedures() == null ? null : nonInvasive
						.getProcedures().getUltrasound(),
				nonInvasive.getPlace(), nonInvasive.getPatientID() };

		int result = jdbcTemplate.update(updateNonInvasiveRecord.toString(),
				args);

		if (result > 0) {
			nonInvasive.getConveyDetails().setPatientID(
					nonInvasive.getPatientID());
			if(nonInvasive.getDiagnoseDetails() == null){
				nonInvasive.setDiagnoseDetails(new DiagnoseDetails());
			}
			
			nonInvasive.getDiagnoseDetails().setPatientID(
					nonInvasive.getPatientID());
			
			if(nonInvasive.getConveyDetails() == null){
				nonInvasive.setConveyDetails(new ConveyDetails());
			}
			
			nonInvasive.getConveyDetails().setPatientID(nonInvasive.getPatientID());
			result = updateConveyDetails(nonInvasive.getConveyDetails());
			if (result > 0) {
				result = updateDiagnoseDetails(nonInvasive.getDiagnoseDetails());
			}
			return result > 0 ? true : false;
		} else
			return false;
	}

	private int updateConveyDetails(ConveyDetails conveyDetails) {
		StringBuilder updatePatientAddress = new StringBuilder();
		int result = 0;
		try {
			updatePatientAddress.append("UPDATE ")
					.append(AppConstants.CONVEY_DETAILS)
					.append(" SET F_CONVEY_NAME = ?,")
					.append("F_CONVEY_DATE = ? ")
					.append(" WHERE F_PATIENT_ID = ? AND F_TYPE = ? ");
			Object[] args = { conveyDetails.getConveyedName(),
					conveyDetails.getConveyedDate(),
					conveyDetails.getPatientID(), conveyDetails.getType() };
			result = jdbcTemplate.update(updatePatientAddress.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private int updateDiagnoseDetails(DiagnoseDetails diagnoseDetails) {
		StringBuilder updateDiagnoseDetails = new StringBuilder();
		int result = 0;
		try {
			updateDiagnoseDetails.append("UPDATE ")
					.append(AppConstants.DIAGNOSE_DETAILS)
					.append(" SET F_GESTATIONAL = ?,")
					.append("F_INTRAUTERINE = ?,")
					.append("F_CHORIONICITY = ?,")
					.append("F_VAGINAL_BLEEDING = ?,")
					.append("F_ABORTION = ?,").append("F_IUCD_IN_SITU = ?,")
					.append("F_ASSESSMENT_OF_CERVICAL = ?,")
					.append("F_UTERINESIZE_AMENORRHEA = ?,")
					.append("F_SUSPECTED_ADENEXAL = ?,")
					.append("F_CHROMOSOMAL_ABNORMALITIES = ?,")
					.append("F_FETAL_POSITION = ?,")
					.append("F_LIQUOR_AMNII = ?,")
					.append("F_PRETERM_LABOR = ?,")
					.append("F_PLACENTAL_POSITION = ?,")
					.append("F_UMBILICAL_CORD = ?,")
					.append("F_PREVIOUS_CAESAREAN = ?,")
					.append("F_FETAL_GROWTH = ?,")
					.append("F_DUPLEX_DOPPLER = ?,")
					.append("F_TERMINATION_OF_PREGNANCY = ?,")
					.append("F_CHORIONIC_VILLUS = ?,")
					.append("F_INTRA_PARTUM_EVENTS = ?,")
					.append("F_COMPLICATING_PREGNANCY = ?,")
					.append("F_RESEARCH_SCIENTIFIC = ? ")
					.append(" WHERE F_PATIENT_ID = ?");
			Object[] args = { diagnoseDetails.getGestational(),
					diagnoseDetails.getIntrauterine(),
					diagnoseDetails.getChorionicity(),
					diagnoseDetails.getVaginalbleeding(),
					diagnoseDetails.getAbortion(),
					diagnoseDetails.getIucdInSitu(),
					diagnoseDetails.getAssessmentOfCervical(),
					diagnoseDetails.getUterineSizeAmenorrhea(),
					diagnoseDetails.getSuspectedAdenexal(),
					diagnoseDetails.getChromosomalAbnormalities(),
					diagnoseDetails.getFetalPosition(),
					diagnoseDetails.getLiquorAmnii(),
					diagnoseDetails.getPretermLabor(),
					diagnoseDetails.getPlacentalPosition(),
					diagnoseDetails.getUmbilicalCord(),
					diagnoseDetails.getPreviousCaesarean(),
					diagnoseDetails.getFetalGrowth(),
					diagnoseDetails.getDuplexDoppler(),
					diagnoseDetails.getTerminationOfPregnancy(),
					diagnoseDetails.getChorionicVillus(),
					diagnoseDetails.getIntraPartumEvents(),
					diagnoseDetails.getComplicatingPregnancy(),
					diagnoseDetails.getResearchScientific(),
					diagnoseDetails.getPatientID() };
			result = jdbcTemplate
					.update(updateDiagnoseDetails.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateInvasiveDetails(Invasive invasive) {
		StringBuilder updateInvasiveRecord = new StringBuilder();
		updateInvasiveRecord
				.append("UPDATE " + AppConstants.INVASIVE_PROCEDURES + " SET ")
				.append("F_DOCTOR_NAME = ? , F_HISTORY_OF_GENETIC_DISEASE = ? , ")
				.append(" F_ADVANCED_MATERNAL_AGE = ? , F_GENETIC_DISEASE = ? , ")
				.append(" F_PREVIOUS_COMPLICATION = ? , F_FORM_G_DATE = ? , ")
				.append(" F_COMPLICATIONS = ? , F_PROCEDURE_RESULT = ? , ")
				.append(" F_PROCEDURE_CARRIED_DATE = ? , ")
				.append(" F_MTP_INDICATION = ? ")
				.append("WHERE F_PATIENT_ID = ? ");
		Object[] args = new Object[] { invasive.getDoctorName(),
				invasive.getHistoryOfGeneticDisease(),
				invasive.getAdvancedMaternalAge(),
				invasive.getGeneticDisease(),
				invasive.getPreviousComplication(), invasive.getFormGDate(),
				invasive.getComplication(), invasive.getProcedureResult(),
				invasive.getProcedureCarriedDate(),
				invasive.getMtpIndication(), invasive.getPatientID() };

		int result = 0;

		try {
			result = jdbcTemplate.update(updateInvasiveRecord.toString(), args);

			invasive.getConveyDetails().setPatientID(invasive.getPatientID());

			result *= updateConveyDetails(invasive.getConveyDetails());
			result *= updateDiagnosisBasis(invasive);
			result *= updateDiagnosisIndication(invasive);
			result *= updateInvasiveProcedures(invasive);
			result *= updateAdditionalTests(invasive);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result > 0;
	}

	@Override
	public Form findByFormId(long formId) {
		Form form = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM " + AppConstants.FORM + " WHERE F_FORM_ID=")
				.append(formId);
		try {
			/*
			 * List<User> detailsList =
			 * jdbcTemplate.queryForObject(sb.toString(), new FormRowMapper());
			 * for (User user : detailsList) { if (user instanceof Form) { form
			 * = (Form) user; } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}

	@Override
	public boolean delete(Form form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Form findByFromName(String formName) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Form searchFormByDateRange(Date fromDate, Date toDate) {
		Form form = null;
		// Date format should be YYYY-MONTH-DATE
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT F_PATIENT_ID FROM " + AppConstants.PATIENT_TABLE
						+ " WHERE F_CREATED_TIMESTAMP BETWEEN ")
				.append("STR_TO_DATE('").append(fromDate)
				.append("','%Y-%m-%d') AND STR_TO_DATE('").append(toDate)
				.append("','%Y-%m-%d')");
		try {
			@SuppressWarnings("unchecked")
			List<Integer> patientIDs = (List<Integer>) jdbcTemplate
					.queryForObject(sb.toString(), new PatientIDsMapper());
			if (patientIDs.size() > 0) {
				StringBuilder getResult = new StringBuilder();
				getResult.append("SELECT PATIENT.F_PATIENT_NAME,"
						+ "PATIENT.F_PATIENT_ID," + "PATIENT.F_AGE,"
						+ "patient.F_GENDER," + "FORMF.F_NO_OF_CHILDREN");
				getResult
						.append(" FROM "
								+ AppConstants.FORM
								+ " FORMF,"
								+ AppConstants.PATIENT_TABLE
								+ " PATIENT WHERE patient.f_patient_id = formf.f_patient_id AND "
								+ "patient.f_patient_id>=" + patientIDs.get(0)
								+ " AND patient.f_patient_id <= "
								+ patientIDs.get(patientIDs.size() - 1));
				@SuppressWarnings("unchecked")
				List<User> formBeans = (List<User>) jdbcTemplate
						.queryForObject(getResult.toString(),
								new FormRowMapper());
				form = new Form();
				form.setFormbeans(formBeans);
				return form;

			} else {
				form.setFormbeans(null);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public SectionA saveSectionA(SectionA section) {
		StringBuilder sectionADetails = new StringBuilder();
		sectionADetails.append("INSERT INTO " + AppConstants.FORM + "(")
				.append("F_PATIENT_ID," + "F_NO_OF_CHILDREN,"
						+ "F_NO_OF_MALE_KIDS," + "F_NO_OF_FEMALE_KIDS,"
						+ "F_REFERRED_BY," + "F_SELF_REFERRED_BY,"
						+ "F_WEEKS_OF_PREGNANCY," + "F_GUARDIAN_NAME,"
						+ "F_LAST_MENSTRUAL_PERIOD)");
		sectionADetails.append("VALUES(?,?,?,?,?,?,?,?,?)");
		Object[] args = new Object[] { section.getPatientID(),
				section.getNoOfChildren(), section.getNoOfMaleKids(),
				section.getNoOfFemaleKids(), section.getReferredBy(),
				section.getSelfReferredBy(), section.getWeeksOfPragnancy(),
				section.getGuardianName(), section.getLastMenstrualPeriod() };
		return jdbcTemplate.update(sectionADetails.toString(), args) > 0 ? section
				: null;
	}

	@Override
	public NonInvasive saveNonInvasive(NonInvasive nonInvasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.NON_INVASIVE_PROCEDURES + "(")
				.append("F_PATIENT_ID, F_PATIENT_NAME, F_DOCTOR_NAME,"
						+ "F_DIAGNOSIS_INDICATION,"
						+ "F_CARRIED_NON_INVASIVE_PROCEDURE,"
						+ "F_DECLARATION_DATE," + "F_PROCEDURE_CARRIED_DATE,"
						+ "F_OTHER_DIAGNOSE," + "F_OTHER_PROCEDURE,"
						+ "F_PROCEDURE_RESULT," + "F_MTP_INDICATION")
				.append(")VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		Object[] args = new Object[] {
				nonInvasive.getPatientID(),
				nonInvasive.getPatientName(),
				nonInvasive.getDoctorName(),
				nonInvasive.getDiagnosisIndication(),
				nonInvasive.getProcedures() == null ? null : nonInvasive
						.getProcedures().getUltrasound(),
				nonInvasive.getDeclarationDate(),
				nonInvasive.getProcedureCarriedDate(),
				nonInvasive.getOtherDiagnoseDetails(),
				nonInvasive.getOtherProcedure(),
				nonInvasive.getProcedureResult(),
				nonInvasive.getMtpIndication() };

		int nonInvasiveResult = 0, conveyResult = 0, diagnoseResult = 0;
		try {
			nonInvasiveResult = jdbcTemplate.update(sb.toString(), args);
			if(nonInvasive.getDiagnoseDetails() == null){
				nonInvasive.setDiagnoseDetails(new DiagnoseDetails());
			}
			
			diagnoseResult = saveDiagnoseDetails(nonInvasive);

			if(nonInvasive.getConveyDetails() == null){
				nonInvasive.setConveyDetails(new ConveyDetails());
			}
			
			nonInvasive.getConveyDetails().setPatientID(
					nonInvasive.getPatientID());
			conveyResult = saveConveyDetails(nonInvasive.getConveyDetails());

			if (nonInvasiveResult > 0 && conveyResult > 0 && diagnoseResult > 0) {
				return nonInvasive;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private int saveConveyDetails(ConveyDetails conveyDetails) {
		StringBuilder insertPatientAddress = new StringBuilder();
		int result = 0;
		try {
			insertPatientAddress.append("INSERT INTO ")
					.append(AppConstants.CONVEY_DETAILS)
					.append("(F_PATIENT_ID,F_CONVEY_NAME,")
					.append("F_CONVEY_DATE,F_TYPE) ").append("VALUES(?,?,?,?)");
			Object[] args = { conveyDetails.getPatientID(),
					conveyDetails.getConveyedName(),
					conveyDetails.getConveyedDate(), conveyDetails.getType() };
			result = jdbcTemplate.update(insertPatientAddress.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private int saveDiagnoseDetails(NonInvasive nonInvasive) {
		StringBuilder insertPatientAddress = new StringBuilder();
		int result = 0;
		try {
			insertPatientAddress
					.append("INSERT INTO ")
					.append(AppConstants.DIAGNOSE_DETAILS)
					.append("(F_PATIENT_ID,")
					.append("F_GESTATIONAL,")
					.append("F_INTRAUTERINE,")
					.append("F_CHORIONICITY,")
					.append("F_VAGINAL_BLEEDING,")
					.append("F_ABORTION,")
					.append("F_IUCD_IN_SITU,")
					.append("F_ASSESSMENT_OF_CERVICAL,")
					.append("F_UTERINESIZE_AMENORRHEA,")
					.append("F_SUSPECTED_ADENEXAL,")
					.append("F_CHROMOSOMAL_ABNORMALITIES,")
					.append("F_FETAL_POSITION,")
					.append("F_LIQUOR_AMNII,")
					.append("F_PRETERM_LABOR,")
					.append("F_PLACENTAL_POSITION,")
					.append("F_UMBILICAL_CORD,")
					.append("F_PREVIOUS_CAESAREAN,")
					.append("F_FETAL_GROWTH,")
					.append("F_DUPLEX_DOPPLER,")
					.append("F_TERMINATION_OF_PREGNANCY,")
					.append("F_CHORIONIC_VILLUS,")
					.append("F_INTRA_PARTUM_EVENTS,")
					.append("F_COMPLICATING_PREGNANCY,")
					.append("F_RESEARCH_SCIENTIFIC) ")
					.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				Object[] args = {
						nonInvasive.getPatientID(),
						nonInvasive.getDiagnoseDetails().getGestational(),
						nonInvasive.getDiagnoseDetails().getIntrauterine(),
						nonInvasive.getDiagnoseDetails().getChorionicity(),
						nonInvasive.getDiagnoseDetails().getVaginalbleeding(),
						nonInvasive.getDiagnoseDetails().getAbortion(),
						nonInvasive.getDiagnoseDetails().getIucdInSitu(),
						nonInvasive.getDiagnoseDetails()
								.getAssessmentOfCervical(),
						nonInvasive.getDiagnoseDetails()
								.getUterineSizeAmenorrhea(),
						nonInvasive.getDiagnoseDetails().getSuspectedAdenexal(),
						nonInvasive.getDiagnoseDetails()
								.getChromosomalAbnormalities(),
						nonInvasive.getDiagnoseDetails().getFetalPosition(),
						nonInvasive.getDiagnoseDetails().getLiquorAmnii(),
						nonInvasive.getDiagnoseDetails().getPretermLabor(),
						nonInvasive.getDiagnoseDetails().getPlacentalPosition(),
						nonInvasive.getDiagnoseDetails().getUmbilicalCord(),
						nonInvasive.getDiagnoseDetails().getPreviousCaesarean(),
						nonInvasive.getDiagnoseDetails().getFetalGrowth(),
						nonInvasive.getDiagnoseDetails().getDuplexDoppler(),
						nonInvasive.getDiagnoseDetails()
								.getTerminationOfPregnancy(),
						nonInvasive.getDiagnoseDetails().getChorionicVillus(),
						nonInvasive.getDiagnoseDetails().getIntraPartumEvents(),
						nonInvasive.getDiagnoseDetails()
								.getComplicatingPregnancy(),
						nonInvasive.getDiagnoseDetails()
								.getResearchScientific() };

			result = jdbcTemplate.update(insertPatientAddress.toString(),
					args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Invasive saveInvasive(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.INVASIVE_PROCEDURES + "(")
				.append("F_PATIENT_ID, F_DOCTOR_NAME, F_HISTORY_OF_GENETIC_DISEASE,")
				.append(" F_ADVANCED_MATERNAL_AGE, F_GENETIC_DISEASE,")
				.append(" F_PREVIOUS_COMPLICATION, F_FORM_G_DATE,")
				.append(" F_COMPLICATIONS, F_PROCEDURE_RESULT,")
				.append(" F_PROCEDURE_CARRIED_DATE,")
				.append(" F_MTP_INDICATION")
				.append(")VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		Object[] args = new Object[] { invasive.getPatientID(),
				invasive.getDoctorName(),
				invasive.getHistoryOfGeneticDisease(),
				invasive.getAdvancedMaternalAge(),
				invasive.getGeneticDisease(),
				invasive.getPreviousComplication(), invasive.getFormGDate(),
				invasive.getComplication(), invasive.getProcedureResult(),
				invasive.getProcedureCarriedDate(), invasive.getMtpIndication() };

		int invasiveResult = 0, diagnosisBasisResult = 0;
		int diagnosisIndicationResult = 0, invasiveProceduresResult = 0;
		int additionalTestsResult = 0, conveyResult = 0;
		try {
			invasiveResult = jdbcTemplate.update(sb.toString(), args);
			
			if(invasive.getConveyDetails() == null){
				invasive.setConveyDetails(new ConveyDetails());
			}

			invasive.getConveyDetails().setPatientID(invasive.getPatientID());

			if(invasive.getDiagnosisBasis() == null){
				invasive.setDiagnosisBasis(new DiagnosisBasis());
			}
			if(invasive.getDiagnosisIndication() == null){
				invasive.setDiagnosisIndication(new DiagnosisIndication());
			}
			if(invasive.getInvasiveProcedures() == null){
				invasive.setInvasiveProcedures(new InvasiveProcedures());
			}
			if(invasive.getAdditionalTests() == null){
				invasive.setAdditionalTests(new AdditionalTests());
			}
			conveyResult = saveConveyDetails(invasive.getConveyDetails());
			diagnosisBasisResult = saveDiagnosisBasis(invasive);
			diagnosisIndicationResult = saveDiagnosisIndication(invasive);
			invasiveProceduresResult = saveInvasiveProcedures(invasive);
			additionalTestsResult = saveAdditionalTests(invasive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (invasiveResult > 0 && diagnosisBasisResult > 0
				&& diagnosisIndicationResult > 0
				&& invasiveProceduresResult > 0 && additionalTestsResult > 0
				&& conveyResult > 0) {
			return invasive;
		} else {
			return null;
		}
	}

	public int saveDiagnosisBasis(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.DIAGNOSIS_BASIS + "(")
				.append("F_PATIENT_ID, F_CLINICAL,")
				.append(" F_BIOCHEMICAL, F_CYTOGENETIC,")
				.append(" F_ANY_OTHER").append(")VALUES(?,?,?,?,?)");
		Object[] args = new Object[] { invasive.getPatientID(),
				invasive.getDiagnosisBasis().getClinical(),
				invasive.getDiagnosisBasis().getBiochemical(),
				invasive.getDiagnosisBasis().getCytogenetic(),
				invasive.getDiagnosisBasis().getOther() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int updateDiagnosisBasis(Invasive invasive) {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + AppConstants.DIAGNOSIS_BASIS + " SET")
				.append(" F_CLINICAL = ?, ")
				.append(" F_BIOCHEMICAL = ?, F_CYTOGENETIC = ?, ")
				.append(" F_ANY_OTHER = ?").append("WHERE F_PATIENT_ID = ?");
		Object[] args = new Object[] {
				invasive.getDiagnosisBasis().getClinical(),
				invasive.getDiagnosisBasis().getBiochemical(),
				invasive.getDiagnosisBasis().getCytogenetic(),
				invasive.getDiagnosisBasis().getOther(),
				invasive.getPatientID() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int saveDiagnosisIndication(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.DIAGNOSIS_INDICATION + "(")
				.append("F_PATIENT_ID, F_CHROMOSOMAL_DISORDERS,")
				.append(" F_METABOLIC_DISORDERS, F_CONGENITAL_ANOMALY,")
				.append(" F_SINGLEGENE_DISORDER, F_MENTAL_RETARDATION,")
				.append(" F_HAEMOGLOBINOPATHY, F_SEXLINKED_DISORDERS,")
				.append(" F_ANY_OTHER").append(")VALUES(?,?,?,?,?,?,?,?,?)");

		if (invasive.getDiagnosisIndication() == null) {
			// invasive.setDiagnosisIndication(new DiagnosisIndication());
			return 1;
		}

		Object[] args = new Object[] { invasive.getPatientID(),
				invasive.getDiagnosisIndication().getChromosomalDisorders(),
				invasive.getDiagnosisIndication().getMetabolicDisorders(),
				invasive.getDiagnosisIndication().getCongenitalAnomaly(),
				invasive.getDiagnosisIndication().getSingleGeneDisorder(),
				invasive.getDiagnosisIndication().getMentalRetardation(),
				invasive.getDiagnosisIndication().getHaemoglobinopathy(),
				invasive.getDiagnosisIndication().getSexLinkedDisorders(),
				invasive.getDiagnosisIndication().getAnyOther() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int updateDiagnosisIndication(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + AppConstants.DIAGNOSIS_INDICATION + " SET ")
				.append("F_CHROMOSOMAL_DISORDERS = ?, ")
				.append("F_METABOLIC_DISORDERS = ?, F_CONGENITAL_ANOMALY = ?, ")
				.append("F_SINGLEGENE_DISORDER = ?, F_MENTAL_RETARDATION = ?, ")
				.append("F_HAEMOGLOBINOPATHY = ?, F_SEXLINKED_DISORDERS = ?, ")
				.append("F_ANY_OTHER = ? ").append("WHERE F_PATIENT_ID = ?");

		Object[] args = new Object[] {
				invasive.getDiagnosisIndication().getChromosomalDisorders(),
				invasive.getDiagnosisIndication().getMetabolicDisorders(),
				invasive.getDiagnosisIndication().getCongenitalAnomaly(),
				invasive.getDiagnosisIndication().getSingleGeneDisorder(),
				invasive.getDiagnosisIndication().getMentalRetardation(),
				invasive.getDiagnosisIndication().getHaemoglobinopathy(),
				invasive.getDiagnosisIndication().getSexLinkedDisorders(),
				invasive.getDiagnosisIndication().getAnyOther(),
				invasive.getPatientID() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int saveInvasiveProcedures(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.INVASIVE_PRO + "(")
				.append("F_PATIENT_ID, F_AMNIOCENTESIS,")
				.append(" F_CHORIONIC_VILLI, F_FETAL_BIOPSY,")
				.append("F_CORDOCENTESIS,").append(" F_ANY_OTHER")
				.append(")VALUES(?,?,?,?,?,?)");

		if (invasive.getInvasiveProcedures() == null) {
			// invasive.setInvasiveProcedures(new InvasiveProcedures());
			return 1;
		}

		Object[] args = new Object[] { invasive.getPatientID(),
				invasive.getInvasiveProcedures().getAmniocentesis(),
				invasive.getInvasiveProcedures().getChorionicVilli(),
				invasive.getInvasiveProcedures().getFetalBiopsy(),
				invasive.getInvasiveProcedures().getCordocentesis(),
				invasive.getInvasiveProcedures().getOthers() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int updateInvasiveProcedures(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + AppConstants.INVASIVE_PRO + " SET ")
				.append("F_AMNIOCENTESIS = ?, ")
				.append("F_CHORIONIC_VILLI = ?, F_FETAL_BIOPSY = ?, ")
				.append("F_CORDOCENTESIS = ?, ").append("F_ANY_OTHER = ? ")
				.append("WHERE F_PATIENT_ID = ?");

		if (invasive.getInvasiveProcedures() == null) {
			// invasive.setInvasiveProcedures(new InvasiveProcedures());
			return 1;
		}

		Object[] args = new Object[] {
				invasive.getInvasiveProcedures().getAmniocentesis(),
				invasive.getInvasiveProcedures().getChorionicVilli(),
				invasive.getInvasiveProcedures().getFetalBiopsy(),
				invasive.getInvasiveProcedures().getCordocentesis(),
				invasive.getInvasiveProcedures().getOthers(),
				invasive.getPatientID() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int saveAdditionalTests(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.ADDITIONAL_TESTS + "(")
				.append("F_PATIENT_ID, F_CHROMOSOMAL_STUDIES,")
				.append(" F_BIOCHEMICAL_STUDIES, F_MOLECULAR_STUDIES,")
				.append("F_PREIMPLANTATION_GENDER,").append(" F_ANY_OTHER")
				.append(")VALUES(?,?,?,?,?,?)");

		if (invasive.getAdditionalTests() == null) {
			// invasive.setInvasiveProcedures(new InvasiveProcedures());
			return 1;
		}

		Object[] args = new Object[] { invasive.getPatientID(),
				invasive.getAdditionalTests().getChromosomalStudies(),
				invasive.getAdditionalTests().getBiochemicalStudies(),
				invasive.getAdditionalTests().getMolecularStudies(),
				invasive.getAdditionalTests().getPreImplantationGender(),
				invasive.getAdditionalTests().getOthers() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	public int updateAdditionalTests(Invasive invasive) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + AppConstants.ADDITIONAL_TESTS + " SET ")
				.append("F_CHROMOSOMAL_STUDIES = ?, ")
				.append("F_BIOCHEMICAL_STUDIES = ?, F_MOLECULAR_STUDIES = ?, ")
				.append("F_PREIMPLANTATION_GENDER = ?,")
				.append("F_ANY_OTHER = ? ").append("WHERE F_PATIENT_ID = ? ");

		if (invasive.getAdditionalTests() == null) {
			// invasive.setInvasiveProcedures(new InvasiveProcedures());
			return 1;
		}

		Object[] args = new Object[] {
				invasive.getAdditionalTests().getChromosomalStudies(),
				invasive.getAdditionalTests().getBiochemicalStudies(),
				invasive.getAdditionalTests().getMolecularStudies(),
				invasive.getAdditionalTests().getPreImplantationGender(),
				invasive.getAdditionalTests().getOthers(),
				invasive.getPatientID() };
		return jdbcTemplate.update(sb.toString(), args);
	}

	@Override
	public Declaration saveDeclaration(Declaration declaration) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + AppConstants.DOCTOR_DECLARATION + "(")
				.append("F_PATIENT_ID," + "F_DOCTOR_NAME," + "F_PLACE,"
						+ "F_PATIENT_NAME," + "F_DATE)")
				.append(" VALUES(?,?,?,?,SYSDATE())");
		Object[] args = new Object[] { declaration.getPatientID(),
				declaration.getDoctorName(), declaration.getPlace(),
				declaration.getPatientName() };
		int result = 0;
		result = jdbcTemplate.update(sb.toString(), args);
		result = result * updatePatientStats(declaration);
		return result > 0 ? declaration : null;
	}

	private int updatePatientStats(Declaration declaration) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + AppConstants.PATIENT_TABLE + " SET ").append(
				"F_STATUS = 'COMPLETED', F_UPDATED_TIMESTAMP = SYSDATE()");
		sb.append(" WHERE F_PATIENT_ID=?");
		Object[] args = new Object[] { declaration.getPatientID() };
		try {
			if (jdbcTemplate.update(sb.toString(), args) > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SectionA getSectionADetails(long patientID) {
		StringBuilder patientDetailsQuery = new StringBuilder();
		patientDetailsQuery
				.append("SELECT * FROM " + AppConstants.FORM + " sectionA")
				.append(" WHERE sectionA.F_PATIENT_ID=").append(patientID);
		SectionA sectionA = null;
		try {
			sectionA = (SectionA) jdbcTemplate.queryForObject(
					patientDetailsQuery.toString(), new RowMapper() {
						@Override
						public SectionA mapRow(ResultSet resultSet,
								int rowNumber) throws SQLException {
							SectionA sectionA = new SectionA();
							sectionA.setPatientID(resultSet
									.getInt("F_PATIENT_ID"));
							sectionA.setNoOfChildren(resultSet
									.getInt("F_NO_OF_CHILDREN"));
							sectionA.setLastMenstrualPeriod(resultSet
									.getDate("F_LAST_MENSTRUAL_PERIOD"));
							sectionA.setWeeksOfPragnancy(resultSet
									.getInt("F_WEEKS_OF_PREGNANCY"));
							sectionA.setNoOfMaleKids(resultSet
									.getInt("F_NO_OF_MALE_KIDS"));
							sectionA.setNoOfFemaleKids(resultSet
									.getInt("F_NO_OF_FEMALE_KIDS"));
							sectionA.setGuardianName(resultSet
									.getString("F_GUARDIAN_NAME"));

							sectionA.setReferredBy(resultSet
									.getString("F_REFERRED_BY"));
							sectionA.setSelfReferredBy(resultSet
									.getString("F_SELF_REFERRED_BY"));
							return sectionA;
						}
					});
		} catch (EmptyResultDataAccessException ee) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sectionA;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClinicAddress getClinicDetails(long patientID) {
		StringBuilder clinicDetailsQuery = new StringBuilder();
		clinicDetailsQuery.append("SELECT * FROM ")
				.append(AppConstants.CLINIC_DETAILS).append(" clinic")
				.append(" WHERE clinic.F_PATIENT_ID = ?");
		ClinicAddress clinicAddress = null;
		Object[] args = new Object[] { patientID };
		try {
			clinicAddress = (ClinicAddress) jdbcTemplate.queryForObject(
					clinicDetailsQuery.toString(), args, new RowMapper() {
						@Override
						public ClinicAddress mapRow(ResultSet resultSet,
								int rowNumber) throws SQLException {
							ClinicAddress clinicAddress = new ClinicAddress();
							clinicAddress.setPatientID(resultSet
									.getInt("F_PATIENT_ID"));
							clinicAddress.setOwnerName(resultSet
									.getString("F_CLINIC_OWNER_NAME"));
							clinicAddress.setType(resultSet.getString("F_TYPE"));
							clinicAddress.setAddress(resultSet
									.getString("F_ADDRESS"));
							clinicAddress.setDistrict(resultSet
									.getString("F_DISTRICT"));
							clinicAddress.setClinicName(resultSet
									.getString("F_CLINIC_NAME"));
							clinicAddress.setState(resultSet
									.getString("F_STATE"));
							clinicAddress.setContactNum(resultSet
									.getString("F_CONTACT_NO"));
							clinicAddress.setPincode(resultSet
									.getInt("F_PINCODE"));
							clinicAddress.setRegistrationNo(resultSet
									.getString("F_REG_NO"));
							return clinicAddress;
						}
					});
		} catch (EmptyResultDataAccessException ee) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clinicAddress;
	}

	@Override
	public NonInvasive getNonInvasiveDetails(long patientID) {
		StringBuilder nonInvasiveDetailsQuery = new StringBuilder();
		nonInvasiveDetailsQuery
				.append("SELECT * FROM " + AppConstants.NON_INVASIVE_PROCEDURES
						+ " nonInvasive, ")
				.append(AppConstants.CONVEY_DETAILS + " convey, ")
				.append(AppConstants.DIAGNOSE_DETAILS + " diagnose ")
				.append("WHERE nonInvasive.F_PATIENT_ID = ?")
				.append(" AND convey.F_PATIENT_ID =  nonInvasive.F_PATIENT_ID")
				.append(" AND diagnose.F_PATIENT_ID =  nonInvasive.F_PATIENT_ID");

		NonInvasive nonInvasive = null;
		Object[] args = new Object[] { patientID };
		try {
			@SuppressWarnings("unchecked")
			List<NonInvasive> nonInvasiveList = (List<NonInvasive>) jdbcTemplate
					.queryForObject(nonInvasiveDetailsQuery.toString(), args,
							new NonInvasiveRowMapper());
			for (NonInvasive nonInv : nonInvasiveList) {
				if (nonInv instanceof NonInvasive) {
					nonInvasive = (NonInvasive) nonInv;
				}
			}
		} catch (EmptyResultDataAccessException ee) {
			// ignore;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nonInvasive;
	}

	@Override
	public Invasive getInvasiveDetails(long patientID) {
		StringBuilder invasiveDetailsQuery = new StringBuilder();
		invasiveDetailsQuery
				.append("SELECT ")
				.append("patient.F_PATIENT_ID,")
				.append("patient.F_PATIENT_NAME,")

				.append("invasive_procedures.F_DOCTOR_NAME,")
				.append("invasive_procedures.F_HISTORY_OF_GENETIC_DISEASE,")
				.append("invasive_procedures.F_ADVANCED_MATERNAL_AGE,")
				.append("invasive_procedures.F_GENETIC_DISEASE,")
				.append("invasive_procedures.F_PREVIOUS_COMPLICATION,")
				.append("invasive_procedures.F_FORM_G_DATE,")
				.append("invasive_procedures.F_COMPLICATIONS,")
				.append("invasive_procedures.F_PROCEDURE_RESULT,")
				.append("invasive_procedures.F_PROCEDURE_CARRIED_DATE,")
				.append("invasive_procedures.F_MTP_INDICATION,")

				.append("diagno_basics.F_CLINICAL,")
				.append("diagno_basics.F_BIOCHEMICAL,")
				.append("diagno_basics.F_CYTOGENETIC,")
				.append("diagno_basics.F_ANY_OTHER AS F_DB_OTHER,")

				.append("inv_convey_dtl.F_CONVEY_NAME,")
				.append("inv_convey_dtl.F_CONVEY_DATE,")
				.append("inv_convey_dtl.F_TYPE,")

				.append("diagno_indication.F_PATIENT_ID,")
				.append("diagno_indication.F_CHROMOSOMAL_DISORDERS,")
				.append("diagno_indication.F_METABOLIC_DISORDERS,")
				.append("diagno_indication.F_CONGENITAL_ANOMALY,")
				.append("diagno_indication.F_SINGLEGENE_DISORDER,")
				.append("diagno_indication.F_MENTAL_RETARDATION,")
				.append("diagno_indication.F_HAEMOGLOBINOPATHY,")
				.append("diagno_indication.F_SEXLINKED_DISORDERS,")
				.append("diagno_indication.F_ANY_OTHER AS F_DI_OTHER,")

				.append("invasive_pro.F_AMNIOCENTESIS,")
				.append("invasive_pro.F_CHORIONIC_VILLI,")
				.append("invasive_pro.F_FETAL_BIOPSY,")
				.append("invasive_pro.F_CORDOCENTESIS,")
				.append("invasive_pro.F_ANY_OTHER AS F_IP_OTHER,")

				.append("additional_tests.F_CHROMOSOMAL_STUDIES,")
				.append("additional_tests.F_BIOCHEMICAL_STUDIES,")
				.append("additional_tests.F_MOLECULAR_STUDIES,")
				.append("additional_tests.F_PREIMPLANTATION_GENDER,")
				.append("additional_tests.F_ANY_OTHER AS F_AT_OTHER")

				.append(" FROM " + AppConstants.PATIENT_TABLE + " patient,")
				.append(AppConstants.INVASIVE_PROCEDURES
						+ " invasive_procedures,")
				.append(AppConstants.INVASIVE_PRO + " invasive_pro,")
				.append(AppConstants.CONVEY_DETAILS + " inv_convey_dtl,")
				.append(AppConstants.DIAGNOSIS_INDICATION
						+ " diagno_indication,")
				.append(AppConstants.ADDITIONAL_TESTS + " additional_tests,")
				.append(AppConstants.DIAGNOSIS_BASIS + " diagno_basics")

				.append(" WHERE")
				.append(" patient.F_PATIENT_ID = invasive_procedures.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = invasive_pro.F_PATIENT_ID")
				.append(" AND  inv_convey_dtl.F_TYPE = 'INVASIVE'")
				.append(" AND  patient.F_PATIENT_ID = inv_convey_dtl.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = diagno_indication.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = additional_tests.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = diagno_basics.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = ? ");

		Invasive invasive = null;

		Object[] args = new Object[] { patientID };

		try {
			@SuppressWarnings("unchecked")
			List<Invasive> invasiveList = (List<Invasive>) jdbcTemplate
					.queryForObject(invasiveDetailsQuery.toString(), args,
							new InvasiveRowMapper());

			for (Invasive inv : invasiveList) {
				if (inv instanceof Invasive) {
					invasive = inv;
				}
			}

		} catch (EmptyResultDataAccessException ee) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invasive;
	}

}
