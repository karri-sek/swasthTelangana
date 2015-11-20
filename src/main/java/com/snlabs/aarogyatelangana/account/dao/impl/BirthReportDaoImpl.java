/**
 * 
 */
package com.snlabs.aarogyatelangana.account.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.snlabs.aarogyatelangana.account.beans.Address;
import com.snlabs.aarogyatelangana.account.beans.BirthFamilyInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthHealthInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthLegalInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthReportAddress;
import com.snlabs.aarogyatelangana.account.beans.BirthReportDetails;
import com.snlabs.aarogyatelangana.account.beans.BirthReportSearchBean;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.BirthReportDao;
import com.snlabs.aarogyatelangana.account.service.impl.BirthReportDetailsRowMapper;
import com.snlabs.aarogyatelangana.account.utils.AppConstants;

/**
 * @author nbattula
 *
 */
public class BirthReportDaoImpl implements BirthReportDao {
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BirthLegalInfo searchBirthReportLegalInfo(
			BirthLegalInfo birthLegalInfo, UserDetails userDetails,
			String searchType) {

		StringBuilder birthReportLegalInfoQuery = new StringBuilder();
		birthReportLegalInfoQuery.append("SELECT * FROM ")
				.append(AppConstants.BR_LEGAL_INFO)
				.append(" WHERE F_BR_ID = ?");
		Object[] args = { birthLegalInfo.getBirthId() };

		BirthLegalInfo legalInfo = null;
		try {
			legalInfo = (BirthLegalInfo)jdbcTemplate.queryForObject(
					birthReportLegalInfoQuery.toString(), args,
					new RowMapper() {
						@Override
						public BirthLegalInfo mapRow(ResultSet resultSet,
								int rowNumber) throws SQLException {

							BirthLegalInfo legalInfo = new BirthLegalInfo();

							legalInfo.setBirthId(resultSet.getLong("F_BR_ID"));
							legalInfo.setDateOfBirth(resultSet
									.getDate("F_DATE_OF_BIRTH"));
							legalInfo.setSex(resultSet.getString("F_SEX"));
							legalInfo.setChildName(resultSet
									.getString("F_CHILD_NAME"));
							legalInfo.setFatherName(resultSet
									.getString("F_FATHER_NAME"));
							legalInfo.setMotherName(resultSet
									.getString("F_MOTHER_NAME"));
							legalInfo.setBirthPlace(resultSet
									.getString("F_PLACE_OF_BIRTH"));
							legalInfo.setMotherContact(resultSet
									.getString("F_CONTACT_NO"));
							legalInfo.setHospitalName(resultSet
									.getString("F_HOSPITAL_NAME"));
							legalInfo.setMotherAadhaar(resultSet
									.getString("F_MOTHER_AADHAR_N0"));
							legalInfo.setInformantsName(resultSet
									.getString("F_INFORMANTS_NAME"));
							legalInfo.setInformantsAddress(resultSet
									.getString("F_INFORMANTS_ADDRESS"));
							return legalInfo;
						}
					});
		} catch (EmptyResultDataAccessException ere) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}
		return legalInfo;
	}

	@Override
	public BirthLegalInfo updateBirthReportLegalInfo(
			BirthLegalInfo birthLegalInfo) {
		StringBuilder updateBRLegalInfoQuery = new StringBuilder();
		updateBRLegalInfoQuery
				.append("UPDATE ")
				.append(AppConstants.BR_LEGAL_INFO)
				.append(" SET F_DATE_OF_BIRTH = ?, F_SEX = ?, F_CHILD_NAME = ?, F_FATHER_NAME = ?, ")
				.append(" F_MOTHER_NAME = ?, F_PLACE_OF_BIRTH = ?, F_CONTACT_NO = ?, F_HOSPITAL_NAME = ?, ")
				.append(" F_MOTHER_AADHAR_N0 = ?, F_INFORMANTS_NAME = ?, F_INFORMANTS_ADDRESS = ?, ")
				.append(" F_UPDATED_TIMESTAMP = SYSDATE()")
				.append(" WHERE F_BR_ID = ?");
		Object[] args = { birthLegalInfo.getDateOfBirth(),
				birthLegalInfo.getSex(), birthLegalInfo.getChildName(),
				birthLegalInfo.getFatherName(),
				birthLegalInfo.getMotherAadhaar(),
				birthLegalInfo.getBirthPlace(),
				birthLegalInfo.getMotherContact(),
				birthLegalInfo.getHospitalName(),
				birthLegalInfo.getMotherAadhaar(),
				birthLegalInfo.getInformantsName(),
				birthLegalInfo.getInformantsAddress(),
				birthLegalInfo.getBirthId() };
		int result = 0;
		try {
			result = (int)jdbcTemplate.update(updateBRLegalInfoQuery.toString(),
					args);
			if (result > 0) {
				return birthLegalInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BirthLegalInfo saveBirthReportLegalInfo(BirthLegalInfo birthLegalInfo) {
		StringBuilder insertPatientRecord = new StringBuilder();
		insertPatientRecord = insertPatientRecord
				.append("INSERT INTO ")
				.append(AppConstants.BR_LEGAL_INFO)
				.append("(F_DATE_OF_BIRTH, F_SEX, F_CHILD_NAME, F_FATHER_NAME, ")
				.append(" F_MOTHER_NAME, F_PLACE_OF_BIRTH, F_CONTACT_NO, F_HOSPITAL_NAME, ")
				.append(" F_MOTHER_AADHAR_N0, F_INFORMANTS_NAME, F_INFORMANTS_ADDRESS, F_CREATED_BY, ")
				.append("F_CREATED_TIMESTAMP, F_UPDATED_TIMESTAMP) ")
				.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE(),SYSDATE())");

		final String INSERT_SQL = insertPatientRecord.toString();

		final Date dateOfBirth = new Date(birthLegalInfo.getDateOfBirth()
				.getTime());
		final String sex = birthLegalInfo.getSex();
		final String childName = birthLegalInfo.getChildName();
		final String fatherName = birthLegalInfo.getFatherName();
		final String motherName = birthLegalInfo.getMotherName();
		final String motherAadhaar = birthLegalInfo.getMotherAadhaar();
		final String motherContact = birthLegalInfo.getMotherContact();
		final String birthPlace = birthLegalInfo.getBirthPlace();
		final String hospitalName = birthLegalInfo.getHospitalName();
		final String informantsName = birthLegalInfo.getInformantsName();
		final String informantsAddress = birthLegalInfo.getInformantsAddress();
		final String createdBy = birthLegalInfo.getCreatedBy();

		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(
							INSERT_SQL, new String[] { "F_BR_ID" });
					ps.setDate(1, dateOfBirth);
					ps.setString(2, sex);
					ps.setString(3, childName);
					ps.setString(4, fatherName);
					ps.setString(5, motherName);
					ps.setString(6, birthPlace);
					ps.setString(7, motherContact);
					ps.setString(8, hospitalName);
					ps.setString(9, motherAadhaar);
					ps.setString(10, informantsName);
					ps.setString(11, informantsAddress);
					ps.setString(12, createdBy);
					return ps;
				}
			}, keyHolder);
			long birthId = keyHolder.getKey().longValue();
			if (birthId > 0) {
				birthLegalInfo.setBirthId(birthId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return birthLegalInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BirthReportAddress searchBirthReportAddress(
			BirthLegalInfo birthLegalInfo, UserDetails userDetails,
			String searchType) {
		StringBuilder birthReportLegalInfoQuery = new StringBuilder();
		birthReportLegalInfoQuery
				.append("SELECT ")
				.append("BIRTH.F_BR_ID, ")
				.append("BIRTH.F_ADDRESS, ")
				.append("BIRTH.F_CITY, ")
				.append("BIRTH.F_DISTRICT, ")
				.append("BIRTH.F_STATE, ")
				.append("BIRTH.F_PINCODE, ")
				.append("PERM.F_IS_VILLAGE_TOWN_CITY, ")
				.append("PERM.F_ADDRESS_PERMANENT, ")
				.append("PERM.F_CITY_PERMANENT, ")
				.append("PERM.F_DISTRICT_PERMANENT, ")
				.append("PERM.F_STATE_PERMANENT, ")
				.append("PERM.F_PINCODE_PERMANENT ")
				.append("FROM T_BR_BIRTH_ADDRESS BIRTH, T_BR_PERMANENT_ADDRESS PERM ")
				.append("WHERE BIRTH.F_BR_ID = PERM.F_BR_ID AND BIRTH.F_BR_ID = ? ");
		Object[] args = { birthLegalInfo.getBirthId() };

		BirthReportAddress brAddress = null;
		try {
			brAddress = (BirthReportAddress)jdbcTemplate.queryForObject(
					birthReportLegalInfoQuery.toString(), args,
					new RowMapper() {
						@Override
						public BirthReportAddress mapRow(ResultSet resultSet,
								int rowNumber) throws SQLException {

							BirthReportAddress brAddress = new BirthReportAddress();
							Address birth = new Address();
							Address permanent = new Address();

							brAddress.setBirthId(resultSet
									.getLong("BIRTH.F_BR_ID"));
							birth.setAddress(resultSet
									.getString("BIRTH.F_ADDRESS"));
							birth.setCityName(resultSet
									.getString("BIRTH.F_CITY"));
							birth.setDistrict(resultSet
									.getString("BIRTH.F_DISTRICT"));
							birth.setPincode(resultSet
									.getString("BIRTH.F_PINCODE"));
							birth.setState(resultSet.getString("BIRTH.F_STATE"));

							permanent.setAddress(resultSet
									.getString("PERM.F_ADDRESS_PERMANENT"));
							permanent.setCityName(resultSet
									.getString("PERM.F_CITY_PERMANENT"));
							permanent.setDistrict(resultSet
									.getString("PERM.F_DISTRICT_PERMANENT"));
							permanent.setPincode(resultSet
									.getString("PERM.F_PINCODE_PERMANENT"));
							permanent.setState(resultSet
									.getString("PERM.F_STATE_PERMANENT"));
							permanent.setVillageTownCity(resultSet
									.getString("PERM.F_IS_VILLAGE_TOWN_CITY"));

							brAddress.setBirthPlaceAddress(birth);
							brAddress.setPermanentAddress(permanent);

							return brAddress;
						}
					});
		} catch (EmptyResultDataAccessException ere) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}

		return brAddress;
	}

	@Override
	public BirthReportAddress saveBirthReportAdress(
			BirthReportAddress birthReportAddress) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(AppConstants.BR_BIRTH_ADDRESS)
				.append(" (F_BR_ID,").append(" F_ADDRESS, ")
				.append(" F_CITY, ").append(" F_DISTRICT, ")
				.append(" F_STATE, ").append(" F_PINCODE ) ");
		sb.append(" VALUES(?,?,?,?,?,?)");
		Object[] args = new Object[] { birthReportAddress.getBirthId(),
				birthReportAddress.getBirthPlaceAddress().getAddress(),
				birthReportAddress.getBirthPlaceAddress().getCityName(),
				birthReportAddress.getBirthPlaceAddress().getDistrict(),
				birthReportAddress.getBirthPlaceAddress().getState(),
				birthReportAddress.getBirthPlaceAddress().getPincode() };
		try {
			int result = (int)jdbcTemplate.update(sb.toString(), args);
			result *= savePermanentAddress(birthReportAddress);
			return result > 0 ? birthReportAddress : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private int savePermanentAddress(BirthReportAddress birthReportAddress) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(AppConstants.BR_PERMANENT_ADDRESS)
				.append(" (F_BR_ID,").append(" F_IS_VILLAGE_TOWN_CITY,")
				.append(" F_ADDRESS_PERMANENT, ").append(" F_CITY_PERMANENT, ")
				.append(" F_DISTRICT_PERMANENT, ")
				.append(" F_STATE_PERMANENT, ")
				.append(" F_PINCODE_PERMANENT ) ");
		sb.append(" VALUES(?,?,?,?,?,?,?) ");
		Object[] args = new Object[] { birthReportAddress.getBirthId(),
				birthReportAddress.getPermanentAddress().getVillageTownCity(),
				birthReportAddress.getPermanentAddress().getAddress(),
				birthReportAddress.getPermanentAddress().getCityName(),
				birthReportAddress.getPermanentAddress().getDistrict(),
				birthReportAddress.getPermanentAddress().getState(),
				birthReportAddress.getPermanentAddress().getPincode() };
		try {
			return jdbcTemplate.update(sb.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public BirthReportAddress updateBirthReportAddress(
			BirthReportAddress birthReportAddress) {
		StringBuilder updateBRLegalInfoQuery = new StringBuilder();
		updateBRLegalInfoQuery.append("UPDATE ")
				.append(AppConstants.BR_BIRTH_ADDRESS)
				.append(" SET F_ADDRESS = ?, F_CITY = ?, F_DISTRICT = ?, ")
				.append(" F_STATE = ?, F_PINCODE = ? ")
				.append(" WHERE F_BR_ID = ?");
		Object[] args = {
				birthReportAddress.getBirthPlaceAddress().getAddress(),
				birthReportAddress.getBirthPlaceAddress().getCityName(),
				birthReportAddress.getBirthPlaceAddress().getDistrict(),
				birthReportAddress.getBirthPlaceAddress().getState(),
				birthReportAddress.getBirthPlaceAddress().getPincode(),
				birthReportAddress.getBirthId() };
		int result = 0;
		try {
			result = (int)jdbcTemplate.update(updateBRLegalInfoQuery.toString(),
					args);
			result *= updatePermanentAddress(birthReportAddress);
			if (result > 0) {
				return birthReportAddress;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private int updatePermanentAddress(BirthReportAddress birthReportAddress) {

		StringBuilder updateBRLegalInfoQuery = new StringBuilder();
		updateBRLegalInfoQuery
				.append("UPDATE ")
				.append(AppConstants.BR_PERMANENT_ADDRESS)
				.append(" SET F_IS_VILLAGE_TOWN_CITY = ?, F_ADDRESS_PERMANENT = ?, F_CITY_PERMANENT = ?, F_DISTRICT_PERMANENT = ?, ")
				.append(" F_STATE_PERMANENT = ?, F_PINCODE_PERMANENT = ? ")
				.append(" WHERE F_BR_ID = ?");
		Object[] args = new Object[] {
				birthReportAddress.getPermanentAddress().getVillageTownCity(),
				birthReportAddress.getPermanentAddress().getAddress(),
				birthReportAddress.getPermanentAddress().getCityName(),
				birthReportAddress.getPermanentAddress().getDistrict(),
				birthReportAddress.getPermanentAddress().getState(),
				birthReportAddress.getPermanentAddress().getPincode(),
				birthReportAddress.getBirthId() };
		try {
			return jdbcTemplate.update(updateBRLegalInfoQuery.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BirthFamilyInfo searchBirthReportFamilyInfo(
			BirthFamilyInfo birthFamilyInfo, UserDetails userDetails,
			String searchType) {
		StringBuilder birthReportLegalInfoQuery = new StringBuilder();
		birthReportLegalInfoQuery.append("SELECT ").append("FAMILY.F_BR_ID, ")
				.append("FAMILY.F_RELIGION, ")
				.append("FAMILY.F_FATHER_EDUCATION, ")
				.append("FAMILY.F_MOTHER_EDUCATION, ")
				.append("FAMILY.F_FATHER_OCCUPATION, ")
				.append("FAMILY.F_MOTHER_OCCUPATION, ")
				.append("FAMILY.F_MOTHER_AGE, ")
				.append("FAMILY.F_MOTHER_AGE_AT_MRG, ")
				.append("FAMILY.F_NO_OF_CHILDREN ")
				.append("FROM T_BR_STATS_FAMILY_INFO FAMILY ")
				.append("WHERE FAMILY.F_BR_ID = ? ");
		Object[] args = { birthFamilyInfo.getBirthId() };

		BirthFamilyInfo familyInfo = null;
		try {
			familyInfo = (BirthFamilyInfo)jdbcTemplate.queryForObject(
					birthReportLegalInfoQuery.toString(), args,
					new RowMapper() {
						@Override
						public BirthFamilyInfo mapRow(ResultSet resultSet,
								int rowNumber) throws SQLException {

							BirthFamilyInfo familyInfo = new BirthFamilyInfo();

							familyInfo.setBirthId(resultSet
									.getLong("FAMILY.F_BR_ID"));
							familyInfo.setReligion(resultSet
									.getString("FAMILY.F_RELIGION"));
							familyInfo.setFatherEducation(resultSet
									.getString("FAMILY.F_FATHER_EDUCATION"));
							familyInfo.setMotherEducation(resultSet
									.getString("FAMILY.F_MOTHER_EDUCATION"));
							familyInfo.setFatherOccupation(resultSet
									.getString("FAMILY.F_FATHER_OCCUPATION"));
							familyInfo.setMotherOccupation(resultSet
									.getString("FAMILY.F_MOTHER_OCCUPATION"));
							familyInfo.setMotherAge(resultSet
									.getInt("FAMILY.F_MOTHER_AGE"));
							familyInfo.setMotherAgeAtMrg(resultSet
									.getInt("FAMILY.F_MOTHER_AGE_AT_MRG"));
							familyInfo.setNoOfChildren(resultSet
									.getInt("FAMILY.F_NO_OF_CHILDREN"));

							return familyInfo;
						}
					});
		} catch (EmptyResultDataAccessException ere) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}
		return familyInfo;
	}

	@Override
	public BirthFamilyInfo updateBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo) {

		StringBuilder updateFamilyInfoQuery = new StringBuilder();
		updateFamilyInfoQuery
				.append("UPDATE ")
				.append(AppConstants.BR_STATS_FAMILY_INFO)
				.append(" SET F_RELIGION = ?, F_FATHER_EDUCATION = ?, F_MOTHER_EDUCATION = ?, ")
				.append(" F_FATHER_OCCUPATION = ?, F_MOTHER_OCCUPATION = ?, ")
				.append(" F_MOTHER_AGE = ?, F_MOTHER_AGE_AT_MRG = ? , F_NO_OF_CHILDREN = ?")
				.append(" WHERE F_BR_ID = ?");
		Object[] args = { birthFamilyInfo.getReligion(),
				birthFamilyInfo.getFatherEducation(),
				birthFamilyInfo.getMotherEducation(),
				birthFamilyInfo.getFatherOccupation(),
				birthFamilyInfo.getMotherOccupation(),
				birthFamilyInfo.getMotherAge(),
				birthFamilyInfo.getMotherAgeAtMrg(),
				birthFamilyInfo.getNoOfChildren(), birthFamilyInfo.getBirthId() };
		int result = 0;
		try {
			result = (int)jdbcTemplate
					.update(updateFamilyInfoQuery.toString(), args);
			if (result > 0) {
				return birthFamilyInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public BirthFamilyInfo saveBirthFamilyInfo(BirthFamilyInfo birthFamilyInfo) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(AppConstants.BR_STATS_FAMILY_INFO)
				.append(" (F_BR_ID,").append(" F_RELIGION, ")
				.append(" F_FATHER_EDUCATION, ")
				.append(" F_MOTHER_EDUCATION, ")
				.append(" F_FATHER_OCCUPATION, ")
				.append(" F_MOTHER_OCCUPATION, ").append(" F_MOTHER_AGE, ")
				.append(" F_MOTHER_AGE_AT_MRG, ")
				.append(" F_NO_OF_CHILDREN ) ");
		sb.append(" VALUES(?,?,?,?,?,?,?,?,?)");
		Object[] args = new Object[] { birthFamilyInfo.getBirthId(),
				birthFamilyInfo.getReligion(),
				birthFamilyInfo.getFatherEducation(),
				birthFamilyInfo.getMotherEducation(),
				birthFamilyInfo.getFatherOccupation(),
				birthFamilyInfo.getMotherOccupation(),
				birthFamilyInfo.getMotherAge(),
				birthFamilyInfo.getMotherAgeAtMrg(),
				birthFamilyInfo.getNoOfChildren() };
		try {
			int result = (int)jdbcTemplate.update(sb.toString(), args);
			return result > 0 ? birthFamilyInfo : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BirthHealthInfo updateBirthHealthInfo(BirthHealthInfo birthHealthInfo) {
		// TODO Auto-generated method stub
		StringBuilder updateFamilyInfoQuery = new StringBuilder();
		updateFamilyInfoQuery
				.append("UPDATE ")
				.append(AppConstants.BR_STATS_HEALTH_INFO)
				.append(" SET F_ATTENTION_AT_DELIVERY = ?, F_DELIVERY_METHOD = ?, ")
				.append(" F_BIRTH_WEIGHT = ?, F_PRAGNANCY_DURATION = ?")
				.append(" WHERE F_BR_ID = ?");
		Object[] args = { birthHealthInfo.getAttentionAtDelivery(),
				birthHealthInfo.getDeliveryMethod(),
				birthHealthInfo.getBirthWeight(),
				birthHealthInfo.getPregnancyDuration(),
				birthHealthInfo.getBirthId() };
		int result = 0;
		try {
			result = (int)jdbcTemplate
					.update(updateFamilyInfoQuery.toString(), args);
			if (result > 0) {
				return birthHealthInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public BirthHealthInfo saveBirthHealthInfo(BirthHealthInfo birthHealthInfo) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(AppConstants.BR_STATS_HEALTH_INFO)
				.append(" (F_BR_ID,").append(" F_ATTENTION_AT_DELIVERY, ")
				.append(" F_DELIVERY_METHOD, ").append(" F_BIRTH_WEIGHT, ")
				.append(" F_PRAGNANCY_DURATION ) ");
		sb.append(" VALUES(?,?,?,?,?)");
		Object[] args = new Object[] { birthHealthInfo.getBirthId(),
				birthHealthInfo.getAttentionAtDelivery(),
				birthHealthInfo.getDeliveryMethod(),
				birthHealthInfo.getBirthWeight(),
				birthHealthInfo.getPregnancyDuration() };
		try {
			int result = (int)jdbcTemplate.update(sb.toString(), args);
			return result > 0 ? birthHealthInfo : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BirthHealthInfo searchBirthHealthInfo(
			BirthFamilyInfo birthFamilyInfo, UserDetails userDetails,
			String searchType) {
		StringBuilder birthReportLegalInfoQuery = new StringBuilder();
		birthReportLegalInfoQuery.append("SELECT ").append("HEALTH.F_BR_ID, ")
				.append("HEALTH.F_ATTENTION_AT_DELIVERY, ")
				.append("HEALTH.F_DELIVERY_METHOD, ")
				.append("HEALTH.F_BIRTH_WEIGHT, ")
				.append("HEALTH.F_PRAGNANCY_DURATION ")
				.append("FROM T_BR_STATS_HEALTH_INFO HEALTH ")
				.append("WHERE HEALTH.F_BR_ID = ? ");
		Object[] args = { birthFamilyInfo.getBirthId() };

		BirthHealthInfo bHealthInfo = null;
		try {
			bHealthInfo = (BirthHealthInfo)jdbcTemplate.queryForObject(
					birthReportLegalInfoQuery.toString(), args,
					new RowMapper() {
						@Override
						public BirthHealthInfo mapRow(ResultSet resultSet,
								int rowNumber) throws SQLException {

							BirthHealthInfo bHealthInfo = new BirthHealthInfo();

							bHealthInfo.setBirthId(resultSet
									.getLong("HEALTH.F_BR_ID"));
							bHealthInfo.setAttentionAtDelivery(resultSet
									.getString("HEALTH.F_ATTENTION_AT_DELIVERY"));
							bHealthInfo.setDeliveryMethod(resultSet
									.getString("HEALTH.F_DELIVERY_METHOD"));
							bHealthInfo.setBirthWeight(resultSet
									.getInt("HEALTH.F_BIRTH_WEIGHT"));
							bHealthInfo.setPregnancyDuration(resultSet
									.getInt("HEALTH.F_PRAGNANCY_DURATION"));

							return bHealthInfo;
						}
					});
		} catch (EmptyResultDataAccessException ere) {
			// Ignore
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bHealthInfo;
	}

	@Override
	public BirthReportDetails searchBirthReportDetails(
			BirthReportSearchBean birthReportSearchBean,
			UserDetails userDetails, String searchType) {

		BirthReportDetails brDetails = null;
		Object[] args = null;

		if ("Administrator".equals(userDetails.getUserRole())) {
			args = new Object[1];
		} else {
			args = new Object[2];
		}

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(AppConstants.BR_LEGAL_INFO)
				.append(" LEGAL,").append(AppConstants.BR_BIRTH_ADDRESS)
				.append(" BIRTHADD, ")
				.append(AppConstants.BR_PERMANENT_ADDRESS).append(" PERMADD, ")
				.append(AppConstants.BR_STATS_FAMILY_INFO).append(" FAMILY, ")
				.append(AppConstants.BR_STATS_HEALTH_INFO).append(" HEALTH ")
				.append("WHERE BIRTHADD.F_BR_ID = LEGAL.F_BR_ID ")
				.append("AND PERMADD.F_BR_ID = LEGAL.F_BR_ID ")
				.append("AND FAMILY.F_BR_ID = LEGAL.F_BR_ID ")
				.append("AND HEALTH.F_BR_ID = LEGAL.F_BR_ID ");

		if ("ID".equals(searchType)) {
			sb.append("AND LEGAL.F_BR_ID = ? ");
			args[0] = birthReportSearchBean.getBirthId();
		} else if ("NAME".equals(searchType)) {
			sb.append("AND LEGAL.F_MOTHER_NAME = ? ");
			args[0] = birthReportSearchBean.getMotherName();
		} else if ("CONTACTNO".equals(searchType)) {
			sb.append("AND LEGAL.F_CONTACT_NO = ? ");
			args[0] = birthReportSearchBean.getContactno();
		} else if ("AADHAR".equals(searchType)) {
			sb.append("AND LEGAL.F_MOTHER_AADHAR_N0 = ? ");
			args[0] = birthReportSearchBean.getAadharNo();
		}

		if ("HealthCenterUser".equals(userDetails.getUserRole())) {
			sb.append("AND LEGAL.F_CREATED_BY = ? ");
			args[1] = userDetails.getLoginId();
		} else if ("DistrictUser".equals(userDetails.getUserRole())) {
			sb.append("AND PERMADD.F_DISTRICT_PERMANENT = ? ");
			args[1] = userDetails.getDistrict();
		} else if ("StateUser".equals(userDetails.getUserRole())) {
			sb.append("AND PERMADD.F_STATE_PERMANENT = ? ");
			args[1] = userDetails.getState();
		}

		try {
			@SuppressWarnings("unchecked")
			List<BirthReportDetails> detailsList = (List<BirthReportDetails>) jdbcTemplate
					.queryForObject(sb.toString(), args,
							new BirthReportDetailsRowMapper());
			for (BirthReportDetails birthReportDetails : detailsList) {
				if (birthReportDetails instanceof BirthReportDetails) {
					brDetails = (BirthReportDetails) birthReportDetails;
				}
			}
		} catch (EmptyResultDataAccessException ee) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brDetails;
	}

	@Override
	public List<BirthReportDetails> listBirthReportsByDate(
			BirthReportSearchBean birthReportSearchBean, UserDetails userDetails) {

		List<BirthReportDetails> brDetailsList = new ArrayList<BirthReportDetails>();
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT * FROM ").append(AppConstants.BR_LEGAL_INFO)
				.append(" LEGAL,").append(AppConstants.BR_BIRTH_ADDRESS)
				.append(" BIRTHADD, ")
				.append(AppConstants.BR_PERMANENT_ADDRESS).append(" PERMADD, ")
				.append(AppConstants.BR_STATS_FAMILY_INFO).append(" FAMILY, ")
				.append(AppConstants.BR_STATS_HEALTH_INFO).append(" HEALTH ")
				.append("WHERE BIRTHADD.F_BR_ID = LEGAL.F_BR_ID ")
				.append("AND PERMADD.F_BR_ID = LEGAL.F_BR_ID ")
				.append("AND FAMILY.F_BR_ID = LEGAL.F_BR_ID ")
				.append("AND HEALTH.F_BR_ID = LEGAL.F_BR_ID ");
		Object[] args = null;

		final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

		if (birthReportSearchBean != null) {

			java.sql.Date fDate = new java.sql.Date(birthReportSearchBean
					.getFromDate().getTime());
			java.sql.Date tDate = new java.sql.Date(birthReportSearchBean
					.getToDate().getTime() + MILLIS_IN_A_DAY);

			if ("HealthCenterUser".equals(userDetails.getUserRole())) {
				sb.append("AND LEGAL.F_CREATED_TIMESTAMP BETWEEN ? AND ? ")
						.append(" AND LEGAL.F_CREATED_BY = ?");
				args = new Object[] { fDate, tDate, userDetails.getLoginId() };
			} else if ("DistrictUser".equals(userDetails.getUserRole())) {
				sb.append("AND LEGAL.F_CREATED_TIMESTAMP BETWEEN ? AND ? ")
						.append(" AND PERMADD.F_DISTRICT_PERMANENT = ? ");
				args = new Object[] { fDate, tDate, userDetails.getDistrict() };
			} else if ("StateUser".equals(userDetails.getUserRole())) {
				sb.append("AND LEGAL.F_CREATED_TIMESTAMP BETWEEN ? AND ? ")
						.append(" AND PERMADD.F_STATE_PERMANENT = ? ");
				args = new Object[] { fDate, tDate, userDetails.getState() };
			} else if ("Administrator".equals(userDetails.getUserRole())) {
				sb.append("AND LEGAL.F_CREATED_TIMESTAMP BETWEEN ? AND ? ");
				args = new Object[] { fDate, tDate };
			}
		} else {
			if ("HealthCenterUser".equals(userDetails.getUserRole())) {
				sb.append("AND LEGAL.F_CREATED_BY = ? ");
				args = new Object[] { userDetails.getLoginId() };
			} else if ("DistrictUser".equals(userDetails.getUserRole())) {
				sb.append("AND PERMADD.F_DISTRICT_PERMANENT = ? ");
				args = new Object[] { userDetails.getDistrict() };
			} else if ("StateUser".equals(userDetails.getUserRole())) {
				sb.append("AND PERMADD.F_STATE_PERMANENT = ? ");
				args = new Object[] { userDetails.getState() };
			} else if ("Administrator".equals(userDetails.getUserRole())) {
				args = new Object[] {};
			}
		}

		sb.append("ORDER BY LEGAL.F_BR_ID DESC ");

		try {
			@SuppressWarnings("unchecked")
			List<BirthReportDetails> detailsList = (List<BirthReportDetails>) jdbcTemplate
					.queryForObject(sb.toString(), args,
							new BirthReportDetailsRowMapper());
			for (BirthReportDetails birthReportDetails : detailsList) {
				if (birthReportDetails instanceof BirthReportDetails) {
					brDetailsList.add((BirthReportDetails) birthReportDetails);
				}
			}
		} catch (EmptyResultDataAccessException ee) {
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brDetailsList;
	}
}
