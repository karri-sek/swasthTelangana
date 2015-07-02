package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.PatientAddress;
import com.snlabs.aarogyatelangana.account.beans.PatientCurrentAddress;
import com.snlabs.aarogyatelangana.account.beans.User;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientRowMapper implements RowMapper {

    Patient patient = null;
    List<User> detailsList = new ArrayList<User>();

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        do {
            patient = new Patient();
            patient.setPatientName(rs.getString("F_PATIENT_NAME"));
            patient.setPatientID(rs.getInt("F_PATIENT_ID"));
            patient.setCreatedTimestamp(rs.getDate("F_CREATED_TIMESTAMP"));
            patient.setAge(rs.getInt("F_AGE"));
            patient.setGender(rs.getString("F_GENDER"));
            patient.setCreatedBy(rs.getString("F_CREATED_BY"));
            patient.setFormFDownloadPath(rs.getString("F_DOWNLOAD_PATH"));
            patient.setAadharNo(rs.getString("F_AADHAR_NO"));
            patient.setUpdatedTimestamp(rs.getDate("F_UPDATED_TIMESTAMP"));

            PatientAddress patientAddress = new PatientAddress();

            patientAddress.setAddress(rs.getString("F_ADDRESS"));
            patientAddress.setContactno(rs.getString("F_CONTACT_NO"));
            patientAddress.setDistrict(rs.getString("F_DISTRICT"));
            patientAddress.setState(rs.getString("F_STATE"));
            patientAddress.setPincode(rs.getInt("F_PINCODE"));
            patient.setPatientAddress(patientAddress);
            
            PatientCurrentAddress patientCurrentAddress = new PatientCurrentAddress();
            patientCurrentAddress.setAddress(rs.getString("F_ADDRESS_CURRENT"));
            patientCurrentAddress.setCityName(rs.getString("F_CITY_CURRENT"));
            patientCurrentAddress.setDistrict(rs.getString("F_DISTRICT_CURRENT"));
            patientCurrentAddress.setPincode(rs.getInt("F_PINCODE_CURRENT"));
            patientCurrentAddress.setState(rs.getString("F_STATE_CURRENT"));
            patient.setPatientCurrentAddress(patientCurrentAddress);

            detailsList.add(patient);
        } while (rs.next());
        return detailsList;
    }
}