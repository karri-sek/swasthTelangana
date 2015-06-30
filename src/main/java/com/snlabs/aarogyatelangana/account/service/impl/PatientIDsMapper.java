package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.Form;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatientIDsMapper implements RowMapper {
	Form form = null;
	List<Integer> patientIDs = new ArrayList<Integer>();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		do {
			patientIDs.add(rs.getInt("F_PATIENT_ID"));
		} while (rs.next());
		Collections.sort(patientIDs);
		return patientIDs;
	}
}
