package com.snlabs.aarogyatelangana.account.dao.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.snlabs.aarogyatelangana.account.beans.ExcelRow;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.User;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.DownloadDao;
import com.snlabs.aarogyatelangana.account.service.impl.ExcelRowMapper;
import com.snlabs.aarogyatelangana.account.utils.AppConstants;

public class DownloadDaoImpl implements DownloadDao {

	private DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public File downloadExcelFile(HttpServletRequest request,
			HttpSession session, UserDetails userDetails, Patient patient) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("SELECT patient.F_PATIENT_NAME,")
				.append("patient.F_PATIENT_NAME,")
				.append("patient.F_CREATED_TIMESTAMP,")
				.append("patient.F_AGE,")
				.append("patient.F_TXN_ID,")
				.append("patient.F_GENDER,")
				.append("patient.F_CREATED_BY,")
				.append("patient.F_DOWNLOAD_PATH,")
				.append("patient.F_AADHAR_NO,")
				.append("patient.F_UPDATED_TIMESTAMP,")

				.append("patient_address.F_DISTRICT,")
				.append("patient_address.F_STATE,")
				.append("patient_address.F_PINCODE,")
				.append("patient_address.F_CONTACT_NO,")
				.append("patient_address.F_ADDRESS_ID,")
				.append("patient_address.F_ADDRESS,")
				.append("patient_address.F_CITY,")

				.append("patient_current_address.F_DISTRICT_CURRENT,")
				.append("patient_current_address.F_STATE_CURRENT,")
				.append("patient_current_address.F_PINCODE_CURRENT,")
				.append("patient_current_address.F_CONTACT_NO_CURRENT,")
				.append("patient_current_address.F_ADDRESS_ID,")
				.append("patient_current_address.F_ADDRESS_CURRENT,")
				.append("patient_current_address.F_CITY_CURRENT,")
				.append("patient_current_address.F_SAME_AS_PRESENT_ADDRESS,")

				.append("clinic_details.F_CLINIC_OWNER_NAME,")
				.append("clinic_details.F_TYPE,")
				.append("clinic_details.F_REG_NO,")
				.append("clinic_details.F_ADDRESS,")
				.append("clinic_details.F_DISTRICT,")
				.append("clinic_details.F_STATE,")
				.append("clinic_details.F_PINCODE,")
				.append("clinic_details.F_CONTACT_NO,")
				.append("clinic_details.F_CLINIC_NAME,")

				.append("form.F_NO_OF_CHILDREN,")
				.append("form.F_GUARDIAN_NAME,")
				.append("form.F_REFERRED_BY,")
				.append("form.F_SELF_REFERRED_BY,")
				.append("form.F_PATIENT_ADDRESS,")
				.append("form.F_REFERRAL_ADDRESS,")
				.append("form.F_LAST_MENSTRUAL_PERIOD,")
				.append("form.F_WEEKS_OF_PREGNANCY,")
				.append("form.F_CREATED_TIMESTAMP,")
				.append("form.F_NO_OF_MALE_KIDS,")
				.append("form.F_NO_OF_FEMALE_KIDS,")

				.append("non_invasive_procedures.F_PATIENT_NAME,")
				.append("non_invasive_procedures.F_DOCTOR_NAME,")
				.append("non_invasive_procedures.F_DIAGNOSIS_INDICATION,")
				.append("non_invasive_procedures.F_CARRIED_NON_INVASIVE_PROCEDURE,")
				.append("non_invasive_procedures.F_DECLARATION_DATE,")
				.append("non_invasive_procedures.F_PROCEDURE_CARRIED_DATE,")
				.append("non_invasive_procedures.F_PROCEDURE_RESULT,")
				.append("non_invasive_procedures.F_CONVEY_ID,")
				.append("non_invasive_procedures.F_MTP_INDICATION,")
				.append("non_invasive_procedures.F_DATE,")
				.append("non_invasive_procedures.F_PLACE,")
				.append("non_invasive_procedures.F_OTHER_DIAGNOSE,")
				.append("non_invasive_procedures.F_OTHER_PROCEDURE,")

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

				.append("diagno_dtls.F_GESTATIONAL,")
				.append("diagno_dtls.F_INTRAUTERINE,")
				.append("diagno_dtls.F_CHORIONICITY,")
				.append("diagno_dtls.F_VAGINAL_BLEEDING,")
				.append("diagno_dtls.F_ABORTION,")
				.append("diagno_dtls.F_IUCD_IN_SITU,")
				.append("diagno_dtls.F_ASSESSMENT_OF_CERVICAL,")
				.append("diagno_dtls.F_UTERINESIZE_AMENORRHEA,")
				.append("diagno_dtls.F_SUSPECTED_ADENEXAL,")
				.append("diagno_dtls.F_CHROMOSOMAL_ABNORMALITIES,")
				.append("diagno_dtls.F_FETAL_POSITION,")
				.append("diagno_dtls.F_LIQUOR_AMNII,")
				.append("diagno_dtls.F_PRETERM_LABOR,")
				.append("diagno_dtls.F_PLACENTAL_POSITION,")
				.append("diagno_dtls.F_UMBILICAL_CORD,")
				.append("diagno_dtls.F_PREVIOUS_CAESAREAN,")
				.append("diagno_dtls.F_FETAL_GROWTH,")
				.append("diagno_dtls.F_DUPLEX_DOPPLER,")
				.append("diagno_dtls.F_TERMINATION_OF_PREGNANCY,")
				.append("diagno_dtls.F_CHORIONIC_VILLUS,")
				.append("diagno_dtls.F_INTRA_PARTUM_EVENTS,")
				.append("diagno_dtls.F_COMPLICATING_PREGNANCY,")
				.append("diagno_dtls.F_RESEARCH_SCIENTIFIC,")
				.append("invasive_pro.F_AMNIOCENTESIS,")
				.append("invasive_pro.F_CHORIONIC_VILLI,")
				.append("invasive_pro.F_FETAL_BIOPSY,")
				.append("invasive_pro.F_CORDOCENTESIS,")
				.append("invasive_pro.F_ANY_OTHER,")

				.append("inv_convey_dtl.F_CONVEY_NAME,")
				.append("inv_convey_dtl.F_CONVEY_DATE,")
				.append("inv_convey_dtl.F_TYPE,")

				.append("F_CLINICAL,")
				.append("F_BIOCHEMICAL,")
				.append("F_CYTOGENETIC,")
				.append("diagno_basics.F_ANY_OTHER,")

				.append("diagno_indication.F_PATIENT_ID,")
				.append("diagno_indication.F_CHROMOSOMAL_DISORDERS,")
				.append("diagno_indication.F_METABOLIC_DISORDERS,")
				.append("diagno_indication.F_CONGENITAL_ANOMALY,")
				.append("diagno_indication.F_SINGLEGENE_DISORDER,")
				.append("diagno_indication.F_MENTAL_RETARDATION,")
				.append("diagno_indication.F_HAEMOGLOBINOPATHY,")
				.append("diagno_indication.F_SEXLINKED_DISORDERS,")
				.append("diagno_indication.F_ANY_OTHER,")

				.append("additional_tests.F_PATIENT_ID,")
				.append("additional_tests.F_CHROMOSOMAL_STUDIES,")
				.append("additional_tests.F_BIOCHEMICAL_STUDIES,")
				.append("additional_tests.F_MOLECULAR_STUDIES,")
				.append("additional_tests.F_PREIMPLANTATION_GENDER,")
				.append("additional_tests.F_ANY_OTHER,")

				.append("doctor_declaration.F_DOCTOR_NAME ,")
				.append("doctor_declaration.F_DATE")

				.append(" FROM " + AppConstants.PATIENT_TABLE + " patient,")
				.append(AppConstants.PATIENT_ADDRESS + " patient_address,")
				.append(AppConstants.PATIENT_CURRENT_ADDRESS
						+ " patient_current_address,")
				.append(AppConstants.NON_INVASIVE_PROCEDURES
						+ " non_invasive_procedures,")
				.append(AppConstants.INVASIVE_PROCEDURES
						+ " invasive_procedures,")
				.append(AppConstants.CLINIC_DETAILS + " clinic_details,")
				.append(AppConstants.FORM + " form,")
				.append(AppConstants.DIAGNOSE_DETAILS + " diagno_dtls,")
				.append(AppConstants.INVASIVE_PRO + " invasive_pro,")
				.append(AppConstants.CONVEY_DETAILS + " inv_convey_dtl,")
				.append(AppConstants.DIAGNOSIS_INDICATION
						+ " diagno_indication,")
				.append(AppConstants.ADDITIONAL_TESTS + " additional_tests,")
				.append(AppConstants.DIAGNOSIS_BASIS + " diagno_basics,")

				.append(AppConstants.DOCTOR_DECLARATION + " doctor_declaration")
				.append(" WHERE")
				.append(" patient.F_PATIENT_ID = patient_address.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = patient_current_address.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = non_invasive_procedures.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = invasive_procedures.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = clinic_details.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = form.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = diagno_dtls.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = invasive_pro.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = inv_convey_dtl.F_PATIENT_ID")
				.append(" AND  inv_convey_dtl.F_TYPE = 'INVASIVE'")
				.append(" AND  patient.F_PATIENT_ID = doctor_declaration.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = inv_convey_dtl.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = diagno_indication.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = additional_tests.F_PATIENT_ID")
				.append(" AND  patient.F_PATIENT_ID = diagno_basics.F_PATIENT_ID")
				.append(" AND  patient.F_STATUS = 'COMPLETED'");

		Object[] args = null;
		int i = 0;
		
		if (patient.getSearchType() != null
				&& "dateRange".equals(patient.getSearchType())) {
			
			final long MILLIS_IN_A_DAY = 1000*60*60*24;
			
			java.sql.Date fDate = new java.sql.Date(patient.getFromDate().getTime());
	        java.sql.Date tDate = new java.sql.Date(patient.getToDate().getTime() + MILLIS_IN_A_DAY);
			
			queryBuilder.append(" AND patient.F_CREATED_TIMESTAMP BETWEEN ? AND ?");
			args = new Object[3];
			args[i++] = fDate;
			args[i++] = tDate;
		} else {
			queryBuilder.append(" AND  patient.F_PATIENT_ID = ?");
			args = new Object[2];
			args[i++] = patient.getPatientID();
		}

		if ("HealthCenterUser".equals(userDetails.getUserRole())) {
			queryBuilder.append(" AND patient.F_CREATED_BY = ?");
			args[i++] = userDetails.getLoginId();
		} else if ("DistrictUser".equals(userDetails.getUserRole())) {
			queryBuilder.append(" AND patient_address.F_DISTRICT = ?");
			args[i++] = userDetails.getDistrict();
		} else if ("StateUser".equals(userDetails.getUserRole())) {
			queryBuilder.append(" AND patient_address.F_STATE = ?");
			args[i++] = userDetails.getState();
		}else{
			queryBuilder.append(" AND 1 = ?");
			args[i++] = 1;
		}

		try {
			ServletContext context = request.getServletContext();
			String appPath = context.getRealPath("");
			System.out.println(" application path: " + appPath);
			File downloadFile = null;
			if(patient.getPatientID() > 0){
				downloadFile = new File("FORMF_" + patient.getPatientID()
						+ ".xls");
			}else{
				downloadFile = new File("FORMF.xls");
			}
			
			@SuppressWarnings("unchecked")
			List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
					queryBuilder.toString(), args, new ExcelRowMapper());
			return prepareExcelSheet(detailsList, downloadFile);
		} catch (EmptyResultDataAccessException ee) {
			return null;
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public File downloadExcelForm(HttpServletRequest request,
			HttpSession session) {
		return null;
	}

	private File prepareExcelSheet(List<User> detailsList, File downloadFile) {
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet("Details");
			int rownum = 0;
			ExcelRow excelRow = null;
			Patient pe = null;
			// setWorkBookStyles(workBook);
			prepareHeader(sheet.createRow(rownum), workBook);
			for (User user : detailsList) {
				Row row = sheet.createRow(++rownum);
				int colnum = 0;
				Cell cell = null;
				if (user instanceof ExcelRow) {
					excelRow = (ExcelRow) user;
					cell = row.createCell(colnum);
					cell.setCellValue(excelRow.getPatient().getPatientID());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getPatient()
							.getPatientName());
					cell = row.createCell(++colnum);
					cell.setCellValue(excelRow.getPatient().getAadharNo());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getPatient()
							.getPatientAddress().getContactno());
					cell = row.createCell(++colnum);
					cell.setCellValue(excelRow.getPatient().getAge());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getPatient()
							.getPatientAddress().getCityName()
							+ " "
							+ excelRow.getPatient().getPatientAddress()
									.getAddress()
							+ " "
							+ excelRow.getPatient().getPatientAddress()
									.getDistrict());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getPatient()
							.getPatientCurrentAddress().getCityName()
							+ " "
							+ excelRow.getPatient().getPatientCurrentAddress()
									.getAddress()
							+ " "
							+ excelRow.getPatient().getPatientCurrentAddress()
									.getDistrict());
					cell = row.createCell(++colnum);
					cell.setCellValue(excelRow.getClinicAddress()
							.getClinicName());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getClinicAddress()
							.getRegistrationNo());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getClinicAddress()
							.getContactNum());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getClinicAddress()
							.getAddress()
							+ " "
							+ excelRow.getClinicAddress().getDistrict()
							+ " "
							+ excelRow.getClinicAddress().getPincode());

					cell = row.createCell(++colnum);
					cell.setCellValue(excelRow.getSectionA()
							.getWeeksOfPragnancy());
					cell = row.createCell(++colnum);
					cell.setCellValue(excelRow.getSectionA().getNoOfChildren());
					cell = row.createCell(++colnum);
					cell.setCellValue(excelRow.getSectionA().getNoOfMaleKids()
							+ ":" + excelRow.getSectionA().getNoOfFemaleKids());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getSectionA()
							.getGuardianName());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getSectionA()
							.getReferredBy());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getSectionA()
							.getSelfReferredBy());

					// cell = row.createCell(++colnum);
					// cell.setCellValue((String)
					// excelRow.getNonInvasive().getDiagnosisIndication());//INDICATIONS
					// FOR DIAGNOSIS PROCEDURE
					cell = row.createCell(++colnum);
					cell.setCellValue((Date)excelRow.getNonInvasive()
							.getDeclarationDate());
					cell = row.createCell(++colnum);
					cell.setCellValue((Date)excelRow.getNonInvasive()
							.getProcedureCarriedDate());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getNonInvasive()
							.getProcedureResult());

					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getDoctorName());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getHistoryOfGeneticDisease());
					// cell = row.createCell(++colnum);
					// cell.setCellValue((String)
					// excelRow.getInvasive().getDiagnosisBasis());
					// cell = row.createCell(++colnum);
					// cell.setCellValue((String)
					// excelRow.getInvasive().getInvasiveProcedures());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getAdvancedMaternalAge());
					// cell = row.createCell(++colnum);
					// cell.setCellValue(excelRow.getInvasive().getGeneticDisease());
					cell = row.createCell(++colnum);
					cell.setCellValue((Date)excelRow.getInvasive().getFormGDate());
					// cell = row.createCell(++colnum);
					// cell.setCellValue((String)
					// excelRow.getInvasive().getInvasiveProcedures());

					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getComplication());
					// cell = row.createCell(++colnum);
					// cell.setCellValue((String)
					// excelRow.getInvasive().getAdditionalTests());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getProcedureResult());
					cell = row.createCell(++colnum);
					cell.setCellValue((Date) excelRow.getInvasive()
							.getProcedureCarriedDate());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getConveyDetails().getConveyedName());
					cell = row.createCell(++colnum);
					cell.setCellValue((Date) excelRow.getInvasive()
							.getConveyDetails().getConveyedDate());
					cell = row.createCell(++colnum);
					cell.setCellValue((String) excelRow.getInvasive()
							.getMtpIndication());
				}
			}
			FileOutputStream fos = new FileOutputStream(downloadFile);
			workBook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return downloadFile;
	}

	@Override
	public File downloadDetails(int patientID, HttpServletRequest request,
			HttpSession session) {
		File patientFile = null;
		return patientFile;
	}

	private void prepareHeader(Row row, HSSFWorkbook workBook) {
		int colNum = 0;
		CellStyle style = workBook.createCellStyle();
		try {
			row.createCell(colNum).setCellValue("PATIENT ID");
			row.createCell(++colNum).setCellValue("PATIENT NAME");
			row.createCell(++colNum).setCellValue("AADHAR NO");
			row.createCell(++colNum).setCellValue("CONTACT NO");
			row.createCell(++colNum).setCellValue("AGE");

			row.createCell(++colNum).setCellValue("PERMANENT ADDRESS");
			row.createCell(++colNum).setCellValue("CURRENT ADDRESS");

			row.createCell(++colNum).setCellValue("CLINIC NAME");
			row.createCell(++colNum).setCellValue("CLINIC REG NO");
			row.createCell(++colNum).setCellValue("CLINIC CONTACT NO");
			row.createCell(++colNum).setCellValue("CLINIC ADDRESS");

			row.createCell(++colNum).setCellValue("WEEKS OF PREGNANCY");
			row.createCell(++colNum).setCellValue("NUMBER OF CHILDREN");
			row.createCell(++colNum).setCellValue("SONS : DAUGHTERS");
			row.createCell(++colNum).setCellValue("GUARDIAN NAME");
			row.createCell(++colNum).setCellValue("REFERRED BY");
			row.createCell(++colNum).setCellValue("SELF-REFERRAL BY");

			// row.createCell(++colNum).setCellValue("non-invasive Doctor Name");
			// row.createCell(++colNum).setCellValue("INDICATIONS FOR DIAGNOSIS PROCEDURE");
			row.createCell(++colNum).setCellValue("DECLARATION OBTAINED DATE");
			row.createCell(++colNum).setCellValue("PROCEDURE CARRIED DATE");
			row.createCell(++colNum).setCellValue("PROCEDURE RESULT");

			row.createCell(++colNum).setCellValue("DOCTOR NAME");
			row.createCell(++colNum)
					.setCellValue(
							"HISTORY OF GENETIC/MEDICAL DISEASE IN THE FAMILY (SPECIFY)");
			// row.createCell(++colNum).setCellValue("BASIS OF DIAGNOSIS");
			// row.createCell(++colNum).setCellValue("INDICATION/S FOR THE DIAGNOSIS PROCEDURE(PREVIOUS CHILD/CHILDREN WITH)");
			row.createCell(++colNum).setCellValue(
					"ADVANCED MATERNAL AGE(35 YEARS)");
			// row.createCell(++colNum).setCellValue("MOTHER/FATHER/SIBLING HAS GENETIC DISEASE (SPECIFY)");
			row.createCell(++colNum).setCellValue("FORM G OBTAINED DATE");
			// row.createCell(++colNum).setCellValue("INVASIVE PROCEDURES CARRIED OUT");
			row.createCell(++colNum).setCellValue("ANY COMPLICATION/S");
			// row.createCell(++colNum).setCellValue("ADDITIONAL TESTS RECOMMENDED");
			row.createCell(++colNum).setCellValue("RESULT OF THE PROCEDURES");
			row.createCell(++colNum)
					.setCellValue("PROCEDURES CARRIED OUT DATE");
			row.createCell(++colNum).setCellValue("CONVEYED TO NAME");
			row.createCell(++colNum).setCellValue("CONVEYED ON DATE");
			row.createCell(++colNum).setCellValue("MTP INDICATION");

			style.setFillBackgroundColor(IndexedColors.DARK_BLUE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setAlignment(CellStyle.ALIGN_CENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
