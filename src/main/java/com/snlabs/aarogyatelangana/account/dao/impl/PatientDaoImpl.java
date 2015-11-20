package com.snlabs.aarogyatelangana.account.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.PatientAddress;
import com.snlabs.aarogyatelangana.account.beans.PatientCurrentAddress;
import com.snlabs.aarogyatelangana.account.beans.User;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.PatientDao;
import com.snlabs.aarogyatelangana.account.service.impl.PatientProfileMapper;
import com.snlabs.aarogyatelangana.account.service.impl.PatientRowMapper;
import com.snlabs.aarogyatelangana.account.utils.AppConstants;

public class PatientDaoImpl implements PatientDao {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Patient save(Patient patient) {
		StringBuilder insertPatientRecord = new StringBuilder();
		insertPatientRecord = insertPatientRecord
				.append("INSERT INTO ")
				.append(AppConstants.PATIENT_TABLE)
				.append("(F_PATIENT_NAME,F_AGE,F_GENDER,F_CREATED_BY,")
				.append("F_CREATED_TIMESTAMP,F_AADHAR_NO) ")
				.append("VALUES(?,?,?,?,SYSDATE(),?)");
		
		final String INSERT_SQL = insertPatientRecord.toString();
		final String patientName = patient.getPatientName();
		final int age = patient.getAge();
		final String gender = patient.getGender();
		final String createdBy = patient.getCreatedBy();
		final String adharNo = patient.getAadharNo();
		
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			 jdbcTemplate.update(
				    new PreparedStatementCreator() {
				    	@Override
				        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				            PreparedStatement ps =
				                connection.prepareStatement(INSERT_SQL, new String[] {"F_PATIENT_ID"});
				            ps.setString(1, patientName);
				            ps.setInt(2, age);
				            ps.setString(3, gender);
				            ps.setString(4, createdBy);
				            ps.setString(5, adharNo);
				            return ps;
				        }
				    }, keyHolder);
			long patientID = keyHolder.getKey().longValue();
			if(patientID > 0){
				patient.setPatientID(patientID);
				if (patient.getPatientAddress() != null) {
					//patient.getPatientAddress().setContactno(
					//patient.getContactno());
					savePatientAddress(patient.getPatientID(),
							patient.getPatientAddress());
				}
				if (patient.getPatientCurrentAddress() != null) {
					savePatientCurrentAddress(patient.getPatientID(),
							patient.getPatientCurrentAddress());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	private int savePatientAddress(long patientID, PatientAddress patientAddress) {
		StringBuilder insertPatientAddress = new StringBuilder();
		int result = 0;
		try {
			insertPatientAddress
					.append("INSERT INTO ")
					.append(AppConstants.PATIENT_ADDRESS)
					.append("(F_PATIENT_ID,F_ADDRESS,")
					.append("F_DISTRICT,F_STATE,F_PINCODE,F_CITY, F_CONTACT_NO) ")
					.append("VALUES(?,?,?,?,?,?,?)");
			Object[] args = { patientID, patientAddress.getAddress().trim(),
					patientAddress.getDistrict(), patientAddress.getState(),
					patientAddress.getPincode(), patientAddress.getCityName(),
					patientAddress.getContactno() };
			result = jdbcTemplate.update(insertPatientAddress.toString(), args);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return result;
	}

	private int savePatientCurrentAddress(long patientID,
			PatientCurrentAddress patientAddress) {
		StringBuilder insertPatientAddress = new StringBuilder();
		insertPatientAddress
				.append("INSERT INTO ")
				.append(AppConstants.PATIENT_CURRENT_ADDRESS)
				.append("(F_PATIENT_ID,F_ADDRESS_CURRENT,")
				.append("F_DISTRICT_CURRENT,F_STATE_CURRENT,F_PINCODE_CURRENT,F_CITY_CURRENT,F_SAME_AS_PRESENT_ADDRESS)")
				.append("VALUES(?,?,?,?,?,?,?)");
		Object[] args = { patientID, patientAddress.getAddress().trim(),
				patientAddress.getDistrict(), patientAddress.getState(),
				patientAddress.getPincode(), patientAddress.getCityName(),
				patientAddress.getSameAsPresentAddress() };
		return jdbcTemplate.update(insertPatientAddress.toString(), args);
	}

	@Override
	public int update(Patient patient) {
		StringBuilder updatePatientRecord = new StringBuilder();
		updatePatientRecord.append("UPDATE ")
				.append(AppConstants.PATIENT_TABLE)
				.append(" SET F_PATIENT_NAME = ?,")
				.append(" F_UPDATED_TIMESTAMP = SYSDATE(),")
				.append(" F_AGE = ?,").append(" F_GENDER = ?,")
				.append(" F_AADHAR_NO = ?,").append(" F_DOWNLOAD_PATH = ?")
				.append(" WHERE F_PATIENT_ID = ?");
		Object[] args = { patient.getPatientName(), patient.getAge(),
				patient.getGender(), patient.getAadharNo(),
				patient.getFormFDownloadPath(), patient.getPatientID() };
		int result = 0;
		try {
			result = jdbcTemplate.update(updatePatientRecord.toString(), args);
			if (result > 0) {
				PatientAddress padd = patient.getPatientAddress();
				padd.setPatientID(patient.getPatientID());
				result = updatePatientPermanentAddress(padd);
				if (result > 0) {
					PatientCurrentAddress pcadd = patient.getPatientCurrentAddress();
					pcadd.setPatientID(patient.getPatientID());
					result = updatePatientCurrentAddress(pcadd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private int updatePatientCurrentAddress(
			PatientCurrentAddress patientCurrentAddress) {
		StringBuilder updatePatientRecord = new StringBuilder();
		updatePatientRecord.append("UPDATE ")
				.append(AppConstants.PATIENT_CURRENT_ADDRESS)
				.append(" SET F_DISTRICT_CURRENT = ?,")
				.append(" F_STATE_CURRENT = ?,")
				.append(" F_PINCODE_CURRENT = ?,")
				.append(" F_ADDRESS_CURRENT = ?,")
				.append(" F_CITY_CURRENT = ?,")
				.append(" F_SAME_AS_PRESENT_ADDRESS = ?")
				.append(" WHERE F_PATIENT_ID = ?");
		Object[] args = { patientCurrentAddress.getDistrict(),
				patientCurrentAddress.getState(),
				patientCurrentAddress.getPincode(),
				patientCurrentAddress.getAddress(),
				patientCurrentAddress.getCityName(),
				patientCurrentAddress.getSameAsPresentAddress(),
				patientCurrentAddress.getPatientID()
				};
		int result = 0;
		try {
			result = jdbcTemplate.update(updatePatientRecord.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private int updatePatientPermanentAddress(PatientAddress patientAddress) {
		StringBuilder updatePatientRecord = new StringBuilder();
		updatePatientRecord.append("UPDATE ")
				.append(AppConstants.PATIENT_ADDRESS)
				.append(" SET F_DISTRICT = ?,").append(" F_STATE = ?,")
				.append(" F_PINCODE = ?,").append(" F_ADDRESS = ?,")
				.append(" F_CITY = ? ,").append(" F_CONTACT_NO = ?")
				.append(" WHERE F_PATIENT_ID = ?");
		Object[] args = { patientAddress.getDistrict(),
				patientAddress.getState(), patientAddress.getPincode(),
				patientAddress.getAddress(), patientAddress.getCityName(),
				patientAddress.getContactno(),patientAddress.getPatientID() };
		int result = 0;
		try {
			result = jdbcTemplate.update(updatePatientRecord.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
		patientRecord.append("SELECT * FROM ")
				.append(AppConstants.PATIENT_TABLE)
				.append(" WHERE F_PATIENT_ID = ?");
		Object[] args = { patient.getPatientID() };
		try {
			final Patient record = new Patient();
			record.setPatientID(patient.getPatientID());
			jdbcTemplate.update(patientRecord.toString(), args,
					new RowMapper() {
						@Override
						public Patient mapRow(ResultSet resultSet, int rowNumber)
								throws SQLException {
							record.setPatientName(resultSet
									.getString("F_PATIENT_NAME"));
							record.setPatientID(resultSet
									.getInt("F_PATIENT_ID"));
							record.setCreatedTimestamp(resultSet
									.getDate("F_CREATED_TIMESTAMP"));
							record.setAge(resultSet.getInt("F_AGE"));
							record.setGender(resultSet.getString("F_GENDER"));
							record.setCreatedBy(resultSet
									.getString("F_CREATED_BY"));
							record.setFormFDownloadPath(resultSet
									.getString("F_DOWNLOAD_PATH"));
							record.setAadharNo(resultSet
									.getString("F_AADHAR_NO"));
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
	public Patient searchPatientById(long patientID, UserDetails userDetails) {
		Patient patient = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(AppConstants.PATIENT_TABLE)
				.append(" PAT,").append(AppConstants.PATIENT_ADDRESS)
				.append(" ADDR, ").append(AppConstants.PATIENT_CURRENT_ADDRESS)
				.append(" CADD ")
				.append("WHERE PAT.F_PATIENT_ID = ADDR.F_PATIENT_ID AND ")
				.append("PAT.F_PATIENT_ID = CADD.F_PATIENT_ID AND ")
				.append("PAT.F_PATIENT_ID = ? ");
		Object[] args = null;
		if ("HealthCenterUser".equals(userDetails.getUserRole())) {
			sb.append("AND PAT.F_CREATED_BY = ?");
			args = new Object[] { patientID, userDetails.getLoginId() };
		} else if ("DistrictUser".equals(userDetails.getUserRole())) {
			sb.append("AND ADDR.F_DISTRICT = ?");
			args = new Object[] { patientID, userDetails.getDistrict() };
		} else if ("StateUser".equals(userDetails.getUserRole())) {
			sb.append("AND ADDR.F_STATE = ?");
			args = new Object[] { patientID, userDetails.getState() };
		} else if ("Administrator".equals(userDetails.getUserRole())) {
			args = new Object[] { patientID };
		}

		try {
			@SuppressWarnings("unchecked")
			List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
					sb.toString(), args, new PatientRowMapper());
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
	public Patient searchPatientByName(String patientName,
			UserDetails userDetails) {
		Patient patient = null;
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT * FROM " + AppConstants.PATIENT_TABLE + " PAT, "
						+ AppConstants.PATIENT_ADDRESS + " ADDR WHERE ")
				.append("PAT.F_PATIENT_ID = ADDR.F_PATIENT_ID AND ")
				.append("PAT.F_PATIENT_NAME = ? ");

		Object[] args = null;

		if ("HealthCenterUser".equals(userDetails.getUserRole())) {
			sb.append("AND PAT.F_CREATED_BY = ?");
			args = new Object[] { patientName, userDetails.getLoginId() };
		} else if ("DistrictUser".equals(userDetails.getUserRole())) {
			sb.append("AND ADDR.F_DISTRICT = ?");
			args = new Object[] { patientName, userDetails.getDistrict() };
		} else if ("StateUser".equals(userDetails.getUserRole())) {
			sb.append("AND ADDR.F_STATE = ?");
			args = new Object[] { patientName, userDetails.getState() };
		} else if ("Administrator".equals(userDetails.getUserRole())) {
			args = new Object[] { patientName };
		}

		try {
			@SuppressWarnings("unchecked")
			List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
					sb.toString(), args, new PatientRowMapper());
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
	public List<Patient> searchPatientProfilesByCreator(
			UserDetails userDetails, Form form) {
		List<Patient> patientList = new ArrayList<Patient>();
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT * FROM ").append(AppConstants.PATIENT_TABLE)
				.append(" PAT,").append(AppConstants.PATIENT_ADDRESS)
				.append(" ADDR, ").append(AppConstants.PATIENT_CURRENT_ADDRESS)
				.append(" CADD ")
				.append("WHERE PAT.F_PATIENT_ID = ADDR.F_PATIENT_ID AND ")
				.append("PAT.F_PATIENT_ID = CADD.F_PATIENT_ID ");

		Object[] args = null;

		final long MILLIS_IN_A_DAY = 1000*60*60*24;
		
		if (form != null) {
			
			java.sql.Date fDate = new java.sql.Date(form.getFromDate().getTime());
	        java.sql.Date tDate = new java.sql.Date(form.getToDate().getTime() + MILLIS_IN_A_DAY);
	        
			if ("HealthCenterUser".equals(userDetails.getUserRole())) {
				sb.append("AND PAT.F_CREATED_TIMESTAMP BETWEEN ? AND ? ")
						.append(" AND PAT.F_CREATED_BY = ?");
				args = new Object[] { fDate, tDate,
						userDetails.getLoginId() };
			} else if ("DistrictUser".equals(userDetails.getUserRole())) {
				sb.append("AND PAT.F_CREATED_TIMESTAMP BETWEEN ? AND ? ")
						.append(" AND ADDR.F_DISTRICT = ? ");
				args = new Object[] { fDate, tDate,
						userDetails.getDistrict() };
			} else if ("StateUser".equals(userDetails.getUserRole())) {
				sb.append("AND PAT.F_CREATED_TIMESTAMP BETWEEN ? AND ? ")
						.append(" AND ADDR.F_STATE = ? ");
				args = new Object[] { fDate, tDate,
						userDetails.getState() };
			} else if ("Administrator".equals(userDetails.getUserRole())) {
				sb.append("AND PAT.F_CREATED_TIMESTAMP BETWEEN ? AND ? ");
				args = new Object[] { fDate, tDate };
			}
		} else {
			if ("HealthCenterUser".equals(userDetails.getUserRole())) {
				sb.append("AND PAT.F_CREATED_BY = ? ");
				args = new Object[] { userDetails.getLoginId() };
			} else if ("DistrictUser".equals(userDetails.getUserRole())) {
				sb.append("AND ADDR.F_DISTRICT = ? ");
				args = new Object[] { userDetails.getDistrict() };
			} else if ("StateUser".equals(userDetails.getUserRole())) {
				sb.append("AND ADDR.F_STATE = ? ");
				args = new Object[] { userDetails.getState() };
			} else if ("Administrator".equals(userDetails.getUserRole())) {
				args = new Object[] {};
			}
		}
		
		sb.append("ORDER BY PAT.F_PATIENT_ID DESC ");
		
		try {
			@SuppressWarnings("unchecked")
			List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
					sb.toString(), args, new PatientRowMapper());
			for (User user : detailsList) {
				if (user instanceof Patient) {
					patientList.add((Patient) user);
				}
			}
		} catch (EmptyResultDataAccessException ee) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public Patient searchPatient(Patient pat, UserDetails userDetails,
			String searchType) {
		Patient patient = null;
		Object[] args = null;

		if ("Administrator".equals(userDetails.getUserRole())) {
			args = new Object[1];
		} else {
			args = new Object[2];
		}

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(AppConstants.PATIENT_TABLE)
				.append(" PAT,").append(AppConstants.PATIENT_ADDRESS)
				.append(" ADDR, ").append(AppConstants.PATIENT_CURRENT_ADDRESS)
				.append(" CADD ")
				.append("WHERE PAT.F_PATIENT_ID = ADDR.F_PATIENT_ID AND ")
				.append("PAT.F_PATIENT_ID = CADD.F_PATIENT_ID ");

		if ("ID".equals(searchType)) {
			sb.append("AND PAT.F_PATIENT_ID = ? ");
			args[0] = pat.getPatientID();
		} else if ("NAME".equals(searchType)) {
			sb.append("AND PAT.F_PATIENT_NAME = ? ");
			args[0] = pat.getPatientName();
		} else if ("CONTACTNO".equals(searchType)) {
			sb.append("AND ADDR.F_CONTACT_NO = ? ");
			args[0] = pat.getContactno();
		} else if ("AADHAR".equals(searchType)) {
			sb.append("AND PAT.F_AADHAR_NO = ? ");
			args[0] = pat.getAadharNo();
		}

		if ("HealthCenterUser".equals(userDetails.getUserRole())) {
			sb.append("AND PAT.F_CREATED_BY = ? ");
			args[1] = userDetails.getLoginId();
		} else if ("DistrictUser".equals(userDetails.getUserRole())) {
			sb.append("AND ADDR.F_DISTRICT = ? ");
			args[1] = userDetails.getDistrict();
		} else if ("StateUser".equals(userDetails.getUserRole())) {
			sb.append("AND ADDR.F_STATE = ? ");
			args[1] = userDetails.getState();
		}
		
		try {
			@SuppressWarnings("unchecked")
			List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
					sb.toString(), args, new PatientRowMapper());
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listPatientProfilesByDate(Date fromDate, Date toDate,
			UserDetails userDetails) {
		String createdBy = userDetails.getLoginId();
		if (createdBy != null) {
			StringBuilder searchPatientProfilesByDate = new StringBuilder();
			List<Patient> detailsList = null;
			searchPatientProfilesByDate.append("SELECT F_PATIENT_ID,")
					.append("F_PATIENT_NAME,F_CREATED_TIMESTAMP")
					.append("F_DOWNLOAD_PATH,F_AADHAR_NO,F_CREATED_BY")
					.append(" FROM ").append(AppConstants.PATIENT_TABLE)
					.append(" WHERE F_CREATED_BY=?")
					.append(" AND F_CREATED_TIMESTAMP BETWEEN")
					.append(" STR_TO_DATE('?','%Y-%m-%d')")
					.append(" AND STR_TO_DATE('?','%Y-%m-%d') ")
					.append("ORDER BY PAT.F_PATIENT_ID DESC");
			try {
				detailsList = (List<Patient>) jdbcTemplate.queryForObject(
						searchPatientProfilesByDate.toString(),
						new PatientProfileMapper());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return detailsList;
		}
		return null;
	}

}