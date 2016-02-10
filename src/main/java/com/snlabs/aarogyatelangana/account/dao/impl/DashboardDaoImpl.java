package com.snlabs.aarogyatelangana.account.dao.impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.snlabs.aarogyatelangana.account.beans.DashBoardDetails;
import com.snlabs.aarogyatelangana.account.beans.FormFMonthly;
import com.snlabs.aarogyatelangana.account.beans.dashboard.FormFStats;
import com.snlabs.aarogyatelangana.account.dao.DashboardDao;
import com.snlabs.aarogyatelangana.account.service.impl.FormFMonthlyRowMapper;
import com.snlabs.aarogyatelangana.account.utils.AppConstants;

public class DashboardDaoImpl implements DashboardDao{
	
	
	public static Map<String,Map<String,String>> districtStats = new HashMap<String,Map<String,String>>();
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public FormFStats getFormFMonthlyStats(String district, String state) {
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		StringBuilder sb = new StringBuilder();
		sb.append(year).append(state).append("formf");
		
		
		districtStats.put(sb.toString(),new HashMap<String,String>());
		FormFStats formFStats = new FormFStats();
		try {
			StringBuilder formfDetailsQuery = new StringBuilder();
			DashBoardDetails dashBoardDetails = new DashBoardDetails();
			dashBoardDetails.intializeMap(year, state);
			formfDetailsQuery
					.append("SELECT f_formf_total,f_mtp_yes, f_mtp_no, f_first_female_child_yes,")
					.append("f_first_female_child_no, f_pregnant_disorder_yes,f_pregnant_disorder_no,")
					.append("f_district_name, f_state_id, f_month_id, f_year FROM ")
					.append(AppConstants.MONTHLY_FORMF_STATS)
					.append(" WHERE f_month_id = ? AND f_state_id= ? AND f_year = ?")
					.append(" ORDER BY f_district_name ASC");
			Object[] args = { now.get(Calendar.MONTH) + 1, 1, now.get(Calendar.YEAR)};
			
			System.out.println(" Query "+formfDetailsQuery);
			System.out.println("month ID "+now.get(Calendar.MONTH)+" Year "+now.get(Calendar.YEAR));
			System.out.println("district "+district+ " state "+state);
			
			List<FormFMonthly> formFMonthlyList = null;
			
			try{
			formFMonthlyList = (List<FormFMonthly>) jdbcTemplate.queryForObject(
					formfDetailsQuery.toString(), args, new FormFMonthlyRowMapper());			
			} catch (EmptyResultDataAccessException ee) {
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			Collections.sort(formFMonthlyList);
			
			for (FormFMonthly formFMonthly : formFMonthlyList) {
				
				//formFStats.getDistrictLabel().add(DashboardUtils.getDistrictDisplayName(formFMonthly.getDistrict()));
				
				formFStats.getMtpIndicationYes().add(Long.parseLong(formFMonthly.getMtpYes() == null? "0" : formFMonthly.getMtpYes()));
				formFStats.getMtpIndicationNo().add(Long.parseLong(formFMonthly.getMtpNo() == null? "0" : formFMonthly.getMtpNo()));
				
				formFStats.getFirstChildfemaleNo().add(Long.parseLong(formFMonthly.getFirstChildfemaleNo() == null? "0" : formFMonthly.getFirstChildfemaleNo()));
				formFStats.getFirstChildfemaleYes().add(Long.parseLong(formFMonthly.getFirstChildfemaleYes() == null? "0" : formFMonthly.getFirstChildfemaleYes()));
				
				formFStats.getPregnantDisorderYes().add(Long.parseLong(formFMonthly.getPregnantDisorderYes() == null? "0" : formFMonthly.getPregnantDisorderYes()));
				formFStats.getPregnantDisorderNo().add(Long.parseLong(formFMonthly.getPregnantDisorderNo() == null? "0" : formFMonthly.getPregnantDisorderNo()));
				
				//formFStats.getEddInCurrentMonth().add(Long.parseLong(formFMonthly.get == null? "0" : formFMonthly.getMaleChild()));
				//formFStats.getFemaleChild().add(Long.parseLong(formFMonthly.getFemaleChild() == null? "0" : formFMonthly.getFemaleChild()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formFStats;
	}

	@Override
	public int populateDistrictData() {
		int result = jdbcTemplate.update("call p_populate_district_data()");
		return result;
	}

}
