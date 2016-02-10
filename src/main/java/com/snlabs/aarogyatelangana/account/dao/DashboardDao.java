package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.dashboard.FormFStats;

public interface DashboardDao {
	
	public FormFStats getFormFMonthlyStats(String district, String state);
	
	public int populateDistrictData();

}
