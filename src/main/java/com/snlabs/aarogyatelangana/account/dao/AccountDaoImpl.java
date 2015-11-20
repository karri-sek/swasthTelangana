package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.NewUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.beans.UserDetailsRowMapper;
import com.snlabs.aarogyatelangana.account.utils.AppConstants;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class AccountDaoImpl implements AccountDao {

	static org.slf4j.Logger LOGGER = LoggerFactory
			.getLogger(AccountDaoImpl.class);

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails getAccountDetails(LoginUser user) {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("DTL.F_LOGIN_ID, ");
		sb.append("DTL.F_DISPLAY_NAME, ");
		sb.append("DTL.F_MOBILE_NUMBER, ");
		sb.append("ADDS.F_DISTRICT, ");
		sb.append("ADDS.F_STATE, ");
		sb.append("RLS.F_ROLE, ");
		sb.append("CDL.F_CLINIC_OWNER_NAME, ");
		sb.append("CDL.F_TYPE, ");
		sb.append("CDL.F_REG_NO, ");
		sb.append("CDL.F_ADDRESS, ");
		sb.append("CDL.F_DISTRICT, ");
		sb.append("CDL.F_STATE, ");
		sb.append("CDL.F_PINCODE, ");
		sb.append("CDL.F_CONTACT_NO, ");
		sb.append("CDL.F_CLINIC_NAME ");
		sb.append("FROM ");
		sb.append(AppConstants.USER_DETAILS + " DTL, ");
		sb.append(AppConstants.USER_ADDRESS + " ADDS, ");
		sb.append(AppConstants.USER_ROLES + " RLS, ");
		sb.append(AppConstants.USER_CLINIC_DETAILS + " CDL ");
		sb.append("WHERE ");
		sb.append("DTL.F_LOGIN_ID = ADDS.F_LOGIN_ID ");
		sb.append("AND DTL.F_LOGIN_ID = RLS.F_LOGIN_ID ");
		sb.append("AND DTL.F_LOGIN_ID = CDL.F_LOGIN_ID ");
		sb.append("AND DTL.F_IS_ENABLED = 'true' ");
		sb.append("AND DTL.F_LOGIN_ID = ? ");
		sb.append("AND DTL.F_PASSWORD = ? ");

		String query = sb.toString();

		Object[] args = new Object[] { user.getUserName(), user.getPassword() };

		try {

			@SuppressWarnings("unchecked")
			UserDetails userDetails = (UserDetails) jdbcTemplate
					.queryForObject(query, args, new UserDetailsRowMapper());
			return userDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean createAccount(NewUser user, UserDetails userDetails) {

		String queryDtl = "INSERT INTO "
				+ AppConstants.USER_DETAILS
				+ " (F_LOGIN_ID, F_PASSWORD, F_IS_ENABLED, F_DISPLAY_NAME, F_MOBILE_NUMBER, F_CREATED_BY, F_CREATION_DATE) VALUES (?, ?, ?, ?, ?, ?, SYSDATE())";
		Object[] argsDtl = new Object[] { user.getLoginId(),
				user.getPassword(), new String("true"), user.getDisplayName(),
				user.getMobileNumber(), userDetails.getLoginId() };

		String queryAddress = "INSERT INTO " + AppConstants.USER_ADDRESS
				+ "(F_LOGIN_ID,F_DISTRICT,F_STATE)VALUES(?,?,?)";
		Object[] argsAddress = new Object[] { user.getLoginId(),
				user.getDistrict(), user.getState() };

		String queryRole = "INSERT INTO " + AppConstants.USER_ROLES
				+ "(F_LOGIN_ID, F_ROLE)VALUES(?,?)";
		Object[] argsRole = new Object[] { user.getLoginId(),
				user.getUserRole() };

		String queryClinicDetails = "INSERT INTO "
				+ AppConstants.USER_CLINIC_DETAILS
				+ "(F_LOGIN_ID, F_CLINIC_OWNER_NAME, F_TYPE, F_REG_NO, F_ADDRESS, F_DISTRICT, F_STATE, F_PINCODE, F_CONTACT_NO, F_CLINIC_NAME)VALUES(?,?,?,?,?,?,?,?,?,?)";

		Object[] argsClinicDetails = null;

		if ("HealthCenterUser".equals(user.getUserRole())) {
			argsClinicDetails = new Object[] { user.getLoginId(),
					user.getClinicAddress().getOwnerName(),
					user.getClinicAddress().getType(),
					user.getClinicAddress().getRegistrationNo(),
					user.getClinicAddress().getAddress(),
					user.getClinicAddress().getDistrict(),
					user.getClinicAddress().getState(),
					user.getClinicAddress().getPincode(),
					user.getClinicAddress().getContactNum(),
					user.getClinicAddress().getClinicName() };
		} else {
			argsClinicDetails = new Object[] { user.getLoginId(), "NON_END_USER",
					"NON_END_USER", "NON_END_USER", "NON_END_USER",
					"NON_END_USER", "NON_END_USER", 666666, "9999999999",
					"NON_END_USER" };
		}

		try {
			int outDtl = jdbcTemplate.update(queryDtl, argsDtl);
			int outAddress = jdbcTemplate.update(queryAddress, argsAddress);
			int outRole = jdbcTemplate.update(queryRole, argsRole);
			int outClinicDtl = jdbcTemplate.update(queryClinicDetails,
					argsClinicDetails);

			int resultFlag = outDtl * outAddress * outRole * outClinicDtl;

			if (resultFlag != 0) {
				LOGGER.debug("Account saved with id=" + user.getLoginId());
				return true;
			} else {
				LOGGER.debug("Account save failed with id = "
						+ user.getLoginId());
				return false;
			}
		} catch (Exception e) {
			LOGGER.debug("Account save failed with  exception id = "
					+ user.getLoginId() + "Exception -> " + e.getMessage());
			return false;
		}

	}

	@Override
	public boolean updateAccount(NewUser user) {
		// TODO Auto-generated method stub
		String query = "UPDATE " + AppConstants.USER_DETAILS
				+ " SET F_PASSWORD = ? WHERE F_LOGIN_ID = ?";
		Object[] args = new Object[] { user.getPassword(), user.getLoginId() };
		int out = jdbcTemplate.update(query, args);

		if (out != 0) {
			LOGGER.debug("Existing account saved with id=" + user.getLoginId());
			return true;
		} else {
			LOGGER.debug("Existing account save failed with id="
					+ user.getLoginId());
			return false;
		}
	}

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
}
