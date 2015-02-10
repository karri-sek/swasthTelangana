package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.Patient;
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
            detailsList.add(patient);
        } while (rs.next());
        return detailsList;
    }
}
