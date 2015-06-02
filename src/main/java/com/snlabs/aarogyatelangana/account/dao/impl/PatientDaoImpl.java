package com.snlabs.aarogyatelangana.account.dao.impl;

import com.snlabs.aarogyatelangana.account.beans.*;
import com.snlabs.aarogyatelangana.account.dao.PatientDao;
import com.snlabs.aarogyatelangana.account.service.impl.PatientProfileMapper;
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

public class PatientDaoImpl implements PatientDao {

    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Patient save(Patient patient) {
        StringBuilder insertPatientRecord = new StringBuilder();
        insertPatientRecord = insertPatientRecord.append("INSERT INTO ")
                .append(AppConstants.PATIENT_TABLE).append("(F_PATIENT_NAME,")
                .append(" F_PATIENT_ID,").append("F_AGE,").append("F_GENDER,").append("F_CREATED_BY,")
                .append("F_CREATED_TIMESTAMP,").append("F_AADHAR_NO)").append("VALUES(?,?,?,?,?,SYSDATE(),?)");
        Object[] args = {patient.getPatientName(), patient.getPatientID(),
                patient.getAge(), patient.getGender(), patient.getCreatedBy(), patient.getAadharNo()};
        try {
            if (jdbcTemplate.update(insertPatientRecord.toString(), args) > 0) {
                if (patient.getPatientAddress() != null) {
                    savePatientAddress(patient.getPatientID(), patient.getPatientAddress());
                }
                if (patient.getPatientCurrentAddress() != null) {
                    savePatientCurrentAddress(patient.getPatientID(), patient.getPatientCurrentAddress());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    private int savePatientAddress(int patientID, PatientAddress patientAddress) {
        StringBuilder insertPatientAddress = new StringBuilder();
        int result = 0;
        try {
            insertPatientAddress.append("INSERT INTO ").append(AppConstants.PATIENT_ADDRESS)
                    .append(" (F_PATIENT_ID,F_ADDRESS,F_CONTACT_NO,")
                    .append("F_DISTRICT,F_STATE,F_PINCODE,F_CITY)")
                    .append("VALUES(?,?,?,?,?,?,?)");
            Object[] args = {patientID, patientAddress.getAddress().trim(),
                    patientAddress.getContactno(), patientAddress.getDistrict(),
                    patientAddress.getState(), patientAddress.getPincode(),
                    patientAddress.getCityName()};
            result = jdbcTemplate.update(insertPatientAddress.toString(), args);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return result;
    }


    private int savePatientCurrentAddress(int patientID, PatientCurrentAddress patientAddress) {
        StringBuilder insertPatientAddress = new StringBuilder();
        insertPatientAddress.append("INSERT INTO ").append(AppConstants.PATIENT_CURRENT_ADDRESS)
                .append("(F_PATIENT_ID,F_ADDRESS,F_CONTACT_NO,")
                .append("F_DISTRICT,F_STATE,F_PINCODE,F_CITY,F_SAME_AS_PRESENT_ADDRESS)")
                .append("VALUES(?,?,?,?,?,?,?,?)");
        Object[] args = {patientID, patientAddress.getAddress().trim(),
                patientAddress.getContactno(), patientAddress.getDistrict(),
                patientAddress.getState(), patientAddress.getPincode(),
                patientAddress.getCityName(), patientAddress.getSameAsPresentAddress()};
        return jdbcTemplate.update(insertPatientAddress.toString(), args);
    }

    @Override
    public int update(Patient patient) {
        StringBuilder updatePatientRecord = new StringBuilder();
        updatePatientRecord.append("UPDATE ").append(AppConstants.PATIENT_TABLE).append(" SET F_PATIENT_NAME = ?,")
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
        StringBuilder patientRecord = new StringBuilder();
        patientRecord.append("SELECT * FROM ").append(AppConstants.PATIENT_TABLE)
                .append(" WHERE F_PATIENT_ID = ?");
        Object[] args = {patient.getPatientID()};
        try {
            final Patient record = new Patient();
            record.setPatientID(patient.getPatientID());
            jdbcTemplate.update(patientRecord.toString(), args, new RowMapper() {
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
    public Patient searchPatientById(int patientID, UserDetails userDetails) {
        Patient patient = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(AppConstants.PATIENT_TABLE).append(" PAT,")
                .append(AppConstants.PATIENT_ADDRESS).append(" ADDR ")
                .append("WHERE PAT.F_PATIENT_ID = ADDR.F_PATIENT_ID AND ")
                .append("PAT.F_PATIENT_ID = ? ");
        Object[] args = null;
        if ("HealthCenterUser" .equals(userDetails.getUserRole())) {
            sb.append("AND PAT.F_CREATED_BY = ?");
            args = new Object[]{patientID, userDetails.getLoginId()};
        } else if ("DistrictUser" .equals(userDetails.getUserRole())) {
            sb.append("AND ADDR.F_DISTRICT = ?");
            args = new Object[]{patientID, userDetails.getDistrict()};
        } else if ("StateUser" .equals(userDetails.getUserRole())) {
            sb.append("AND ADDR.F_STATE = ?");
            args = new Object[]{patientID, userDetails.getState()};
        } else if ("Administrator" .equals(userDetails.getUserRole())) {
            args = new Object[]{patientID};
        }

        try {
            @SuppressWarnings("unchecked")
            List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(sb.toString(), args,
                    new PatientRowMapper());
            for (User user : detailsList) {
                if (user instanceof Patient) {
                    patient = (Patient) user;
                }
            }
        } catch (EmptyResultDataAccessException ee) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient searchPatientByName(String patientName, UserDetails userDetails) {
        Patient patient = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM T_PATIENT PAT, T_PATIENT_ADDRESS ADDR WHERE ")
                .append("PAT.F_PATIENT_ID = ADDR.F_PATIENT_ID AND ")
                .append("PAT.F_PATIENT_NAME = ? ");

        Object[] args = null;

        if ("HealthCenterUser" .equals(userDetails.getUserRole())) {
            sb.append("AND PAT.F_CREATED_BY = ?");
            args = new Object[]{patientName, userDetails.getLoginId()};
        } else if ("DistrictUser" .equals(userDetails.getUserRole())) {
            sb.append("AND ADDR.F_DISTRICT = ?");
            args = new Object[]{patientName, userDetails.getDistrict()};
        } else if ("StateUser" .equals(userDetails.getUserRole())) {
            sb.append("AND ADDR.F_STATE = ?");
            args = new Object[]{patientName, userDetails.getState()};
        } else if ("Administrator" .equals(userDetails.getUserRole())) {
            args = new Object[]{patientName};
        }

        try {
            @SuppressWarnings("unchecked")
            List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(sb.toString(), args,
                    new PatientRowMapper());
            for (User user : detailsList) {
                if (user instanceof Patient) {
                    patient = (Patient) user;
                }
            }
        } catch (EmptyResultDataAccessException ee) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public List<Patient> searchPatientProfilesByCreator(UserDetails userDetails) {
        String createdBy = userDetails.getLoginId();

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
    public List<Patient> listPatientProfilesByDate(Date fromDate, Date toDate, UserDetails userDetails) {
        String createdBy = userDetails.getLoginId();
        if (createdBy != null) {
            StringBuilder searchPatientProfilesByDate = new StringBuilder();
            List<Patient> detailsList = null;
            searchPatientProfilesByDate.append("SELECT F_PATIENT_ID,")
                    .append("F_PATIENT_NAME,F_CREATED_TIMESTAMP")
                    .append("F_DOWNLOAD_PATH,F_AADHAR_NO,F_CREATED_BY")
                    .append(" FROM ").append(AppConstants.PATIENT_TABLE).append(" WHERE F_CREATED_BY=?")
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