package com.snlabs.aarogyatelangana.account.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.snlabs.aarogyatelangana.account.beans.FormFMonthly;

public class FormFMonthlyRowMapper<T> implements RowMapper {

	FormFMonthly formfMonthly = null;
	List<FormFMonthly> detailsList = new ArrayList<FormFMonthly>();

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			do {
				formfMonthly = new FormFMonthly();
				formfMonthly.setForfTotal(rs.getString("f_formf_total"));
				formfMonthly.setMtpYes(rs.getString("f_mtp_yes"));
				formfMonthly.setMtpNo(rs.getString("f_mtp_no"));
				formfMonthly.setFirstChildfemaleNo(rs.getString("f_first_female_child_no"));
				formfMonthly.setFirstChildfemaleYes(rs.getString("f_first_female_child_yes"));
				formfMonthly.setMonth(rs.getString("f_month_id"));
				formfMonthly.setYear(rs.getString("f_year"));
				formfMonthly.setDistrict(rs.getString("f_district_name"));
				formfMonthly.setPregnantDisorderYes(rs
						.getString("f_pregnant_disorder_yes"));
				formfMonthly.setPregnantDisorderNo(rs
						.getString("f_pregnant_disorder_no"));
				detailsList.add(formfMonthly);
			} while (rs.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsList;
	}
}
