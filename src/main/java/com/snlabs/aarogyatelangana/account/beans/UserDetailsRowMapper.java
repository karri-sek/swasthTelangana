package com.snlabs.aarogyatelangana.account.beans;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails userDetails = null;
		try {
			userDetails = new UserDetails();
			userDetails.setLoginId(rs.getString("F_LOGIN_ID"));
			userDetails.setMobileNumber(rs.getString("F_MOBILE_NUMBER"));
			userDetails.setDisplayName(rs.getString("F_DISPLAY_NAME"));
			userDetails.setUserRole(rs.getString("F_ROLE"));
			userDetails.setDistrict(rs.getString("ADDS.F_DISTRICT"));
			userDetails.setState(rs.getString("ADDS.F_STATE"));

			ClinicAddress clinicAddress = new ClinicAddress();
			clinicAddress.setOwnerName(rs.getString("CDL.F_CLINIC_OWNER_NAME"));
			clinicAddress.setType(rs.getString("CDL.F_TYPE"));
			clinicAddress.setRegistrationNo(rs.getString("CDL.F_REG_NO"));
			clinicAddress.setAddress(rs.getString("CDL.F_ADDRESS"));
			clinicAddress.setDistrict(rs.getString("CDL.F_DISTRICT"));
			clinicAddress.setState(rs.getString("CDL.F_STATE"));
			clinicAddress.setPincode(rs.getInt("CDL.F_PINCODE"));
			clinicAddress.setContactNum(rs.getString("CDL.F_CONTACT_NO"));
			clinicAddress.setClinicName(rs.getString("CDL.F_CLINIC_NAME"));
			
			userDetails.setClinicAddress(clinicAddress);

		} catch (Exception e) {
			throw e;
		}
		return userDetails;
	}
}