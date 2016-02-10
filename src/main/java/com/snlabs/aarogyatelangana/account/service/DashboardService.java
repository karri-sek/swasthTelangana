package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.dashboard.FormFStats;

public interface DashboardService {
	
	
	//public FormFMonthly getFormFMonthlyStats(String string, String string2);
	
	public FormFStats getFormFMonthlyStats(String string, String string2);
	
	public int populateDistrictData();
}
