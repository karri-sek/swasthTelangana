package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormRowMapper implements RowMapper {
	Form form = null;
	List<User> detailsList = new ArrayList<User>();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			do {
				form = new Form();
				form.setPatientName(rs.getString("F_PATIENT_NAME"));
				form.setFormID(rs.getInt("F_PATIENT_ID"));
				form.setAge(rs.getInt("F_AGE"));
				form.setGender(rs.getString("F_GENDER"));
				form.setNoOfChildren(rs.getInt("F_NO_OF_CHILDREN"));
				detailsList.add(form);
			} while (rs.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsList;
	}
}
