package com.snlabs.aarogyatelangana.account.dao.impl;

import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.PatientAddress;
import com.snlabs.aarogyatelangana.account.beans.User;
import com.snlabs.aarogyatelangana.account.dao.PatientDao;
import com.snlabs.aarogyatelangana.account.service.impl.PatientProfileMapper;
import com.snlabs.aarogyatelangana.account.service.impl.PatientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PatientDaoImpl implements PatientDao {

    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Patient save(Patient patient) {
        String insertPatientQuery = "INSERT INTO T_PATIENT("
                + "F_PATIENT_NAME," + "F_PATIENT_ID," + "F_AGE," + "F_GENDER,"
                + "F_CREATED_BY," + "F_CREATED_TIMESTAMP," + "F_AADHAR_NO" + ") "
                + "VALUES(?,?,?,?,?,SYSDATE(),?)";
        Object[] args = {patient.getPatientName(), patient.getPatientID(),
                patient.getAge(), patient.getGender(), patient.getCreatedBy(), patient.getAadharNo()};
        try {
            if (jdbcTemplate.update(insertPatientQuery, args) > 0) {
                if (patient.getPatientAddress() != null) {
                    return savePatientAddress(patient.getPatientID(), patient.getPatientAddress()) > 0 ? patient : null;
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int savePatientAddress(int patientID, PatientAddress patientAddress) {
        String insertPatientAddress = "INSERT INTO T_PATIENT_ADDRESS("
                + "F_PATIENT_ID," + "F_ADDRESS," + "F_CONTACT_NO,"
                + "F_DISTRICT," + "F_STATE," + "F_PINCODE," + "F_CURRENT_ADDRESS" + ") " + "VALUES"
                + "(?,?,?,?,?,?,?)";
        Object[] args = {patientID, patientAddress.getAddress().trim(),
                patientAddress.getContactno(), patientAddress.getDistrict(),
                patientAddress.getState(), patientAddress.getPincode(), patientAddress.getCurrentAddress().trim()};
        return jdbcTemplate.update(insertPatientAddress, args);
    }

    @Override
    public int update(Patient patient) {
        StringBuilder updatePatientRecord = new StringBuilder();
        updatePatientRecord.append("UPDATE T_PATIENT SET F_PATIENT_NAME = ?,")
                .append(" F_UPDATED_TIMESTAMP = SYSDATE(),").append(" F_AGE = ?,")
                .append(" F_GENDER = ?,").append(" F_AADHAR_NO = ?,")
                .append(" F_DOWNLOAD_PATH = ?")
                .append(" WHERE F_PATIENT_ID = ?");
        Object[] args = {patient.getPatientName(), patient.getAge(), patient.getGender(),
                patient.getAadharNo(), patient.getFormFDownloadPath(), patient.getPatientID()};
        try {
            return jdbcTemplate.update(updatePatientRecord.toString(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Patient findByPatientName(String patient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Patient patient) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Patient findByPatientId(Patient patient) {
        String patientRecord = "SELECT * FROM T_PATIENT WHERE F_PATIENT_ID = ?";
        Object[] args = {patient.getPatientID()};
        try {
            final Patient record = new Patient();
            record.setPatientID(patient.getPatientID());
            jdbcTemplate.update(patientRecord, args, new RowMapper() {
                @Override
                public Patient mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
                    record.setPatientName(resultSet.getString("F_PATIENT_NAME"));
                    record.setPatientID(resultSet.getInt("F_PATIENT_ID"));
                    record.setCreatedTimestamp(resultSet.getDate("F_CREATED_TIMESTAMP"));
                    record.setAge(resultSet.getInt("F_AGE"));
                    record.setGender(resultSet.getString("F_GENDER"));
                    record.setCreatedBy(resultSet.getString("F_CREATED_BY"));
                    record.setFormFDownloadPath(resultSet.getString("F_DOWNLOAD_PATH"));
                    record.setAadharNo(resultSet.getString("F_AADHAR_NO"));
                    return record;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Patient searchPatientById(int patientID) {
        Patient patient = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM T_PATIENT WHERE F_PATIENT_ID=").append(
                patientID);
        try {
            List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(sb.toString(),
                    new PatientRowMapper());
            for (User user : detailsList) {
                if (user instanceof Patient) {
                    patient = (Patient) user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient searchPatientByName(String patientName) {
        Patient patient = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM T_PATIENT WHERE F_PATIENT_NAME='")
                .append(patientName).append("'");
        try {
            List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(sb.toString(),
                    new PatientRowMapper());
            for (User user : detailsList) {
                if (user instanceof Patient) {
                    patient = (Patient) user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public List<Patient> searchPatientProfilesByCreator(String createdBy) {
        if (createdBy != null) {
            StringBuilder sb = new StringBuilder();
            List<Patient> detailsList = null;
            sb.append("SELECT patient.F_PATIENT_ID, patient.F_PATIENT_NAME,")
                    .append(" address.F_CONTACT_NO, patient.F_DOWNLOAD_PATH")
                    .append(" FROM T_PATIENT patient, T_PATIENT_ADDRESS address")
                    .append(" WHERE patient.F_CREATED_BY=?")
                    .append(" AND patient.F_PATIENT_ID=address.F_PATIENT_ID");
            Object[] args = new Object[]{createdBy};
            try {
                detailsList = (List<Patient>) jdbcTemplate.queryForObject(sb.toString(),
                        new PatientProfileMapper());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return detailsList;
        }
        return null;
    }

    @Override
    public List<Patient> listPatientProfilesByDate(Date fromDate, Date toDate, String createdBy) {
        if (createdBy != null) {
            StringBuilder searchPatientProfilesByDate = new StringBuilder();
            List<Patient> detailsList = null;
            searchPatientProfilesByDate.append("SELECT F_PATIENT_ID,")
                    .append("F_PATIENT_NAME,F_CREATED_TIMESTAMP")
                    .append("F_DOWNLOAD_PATH,F_AADHAR_NO,F_CREATED_BY")
                    .append(" FROM T_PATIENT WHERE F_CREATED_BY=?")
                    .append(" AND F_CREATED_TIMESTAMP BETWEEN")
                    .append(" STR_TO_DATE('?','%Y-%m-%d')")
                    .append(" AND STR_TO_DATE('?','%Y-%m-%d')");
            try {
                detailsList = (List<Patient>) jdbcTemplate.queryForObject(searchPatientProfilesByDate.toString(),
                        new PatientProfileMapper());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return detailsList;
        }
        return null;
    }

}
