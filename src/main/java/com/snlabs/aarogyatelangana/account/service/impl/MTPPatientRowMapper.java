package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.MTPDetails;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.PatientAddress;
import com.snlabs.aarogyatelangana.account.beans.PatientCurrentAddress;
import com.snlabs.aarogyatelangana.account.beans.User;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MTPPatientRowMapper implements RowMapper {

	List<MTPDetails> detailsList = new ArrayList<MTPDetails>();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		do {
			Patient patient = new Patient();
			patient.setPatientName(rs.getString("F_PATIENT_NAME"));
			patient.setPatientID(rs.getInt("F_PATIENT_ID"));
			patient.setCreatedTimestamp(rs.getDate("F_CREATED_TIMESTAMP"));
			patient.setAge(rs.getInt("F_AGE"));
			patient.setGender(rs.getString("F_GENDER"));
			patient.setCreatedBy(rs.getString("F_CREATED_BY"));
			patient.setFormFDownloadPath(rs.getString("F_DOWNLOAD_PATH"));
			patient.setAadharNo(rs.getString("F_AADHAR_NO"));
			patient.setPatientStatus(rs.getString("F_STATUS"));
			patient.setUpdatedTimestamp(rs.getDate("F_UPDATED_TIMESTAMP"));

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
			patientCurrentAddress.setAddress(rs.getString("F_ADDRESS_CURRENT"));
			patientCurrentAddress.setCityName(rs.getString("F_CITY_CURRENT"));
			patientCurrentAddress.setDistrict(rs
					.getString("F_DISTRICT_CURRENT"));
			patientCurrentAddress.setPincode(rs.getInt("F_PINCODE_CURRENT"));
			patientCurrentAddress.setState(rs.getString("F_STATE_CURRENT"));
			patientCurrentAddress.setSameAsPresentAddress(rs
					.getString("F_SAME_AS_PRESENT_ADDRESS"));
			patientCurrentAddress.setPatientID(patient.getPatientID());
			patient.setPatientCurrentAddress(patientCurrentAddress);

			MTPDetails mtpDtl = new MTPDetails();
			mtpDtl.setPatientID(rs.getInt("F_PATIENT_ID"));
			mtpDtl.setWeeksOfPregnancy(rs.getString("F_WEEKS_OF_PREGNANCY"));
			mtpDtl.setIsMentallyIll(rs.getString("F_IS_MENTALLY_ILL"));
			mtpDtl.setIsMinor(rs.getString("F_IS_A_MINOR"));
			mtpDtl.setIsMarried(rs.getString("F_IS_A_MARRIED"));
			mtpDtl.setIsFather(rs.getString("F_IS_FATHER"));
			mtpDtl.setDaughterOfWifeOf(rs.getString("F_DAUGHTER_OF_WIFE_OF"));
			mtpDtl.setGuardianName(rs.getString("F_GUARDIAN_NAME"));
			mtpDtl.setReasonForTermination(rs
					.getString("F_REASON_FOR_TERMINATION"));
			mtpDtl.setPatient(patient);

			ClinicAddress clinicAddress = new ClinicAddress();
			clinicAddress.setPatientID(rs.getInt("F_PATIENT_ID"));
			clinicAddress.setOwnerName(rs.getString("F_CLINIC_OWNER_NAME"));
			clinicAddress.setType(rs.getString("F_TYPE"));
			clinicAddress.setAddress(rs.getString("F_ADDRESS"));
			clinicAddress.setDistrict(rs.getString("F_DISTRICT"));
			clinicAddress.setClinicName(rs.getString("F_CLINIC_NAME"));
			clinicAddress.setState(rs.getString("F_STATE"));
			clinicAddress.setContactNum(rs.getString("F_CONTACT_NO"));
			clinicAddress.setPincode(rs.getInt("F_PINCODE"));
			clinicAddress.setRegistrationNo(rs.getString("F_REG_NO"));

			mtpDtl.setClinicAddress(clinicAddress);

			detailsList.add(mtpDtl);
			
		} while (rs.next());
		return detailsList;
	}
}