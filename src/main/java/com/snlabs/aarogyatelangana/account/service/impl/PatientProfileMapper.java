package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.PatientAddress;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientProfileMapper implements RowMapper {
    Patient patient = null;
    List<Patient> patientProfiles = new ArrayList<Patient>();

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        do {
            patient = new Patient();
            PatientAddress patientAddress = new PatientAddress();
            patient.setPatientID(rs.getInt("F_PATIENT_ID"));
            patient.setPatientName(rs.getString("F_PATIENT_NAME"));
            patientAddress.setContactno(rs.getInt("F_CONTACT_NO"));
            patient.setFormFDownloadPath(rs.getString("F_DOWNLOAD_PATH"));
            patient.setPatientAddress(patientAddress);
            patientProfiles.add(patient);
        } while (rs.next());
        return patientProfiles;
    }
}
