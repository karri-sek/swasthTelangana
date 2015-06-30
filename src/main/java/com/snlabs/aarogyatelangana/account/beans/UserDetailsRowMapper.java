
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
            userDetails.setDistrict(rs.getString("F_DISTRICT"));
            userDetails.setState(rs.getString("F_STATE"));
		} catch (Exception e) {
			System.out.println(" Failed login:" + e.getMessage());
		}
		return userDetails;
	}
}