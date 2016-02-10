package com.snlabs.aarogyatelangana.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.snlabs.aarogyatelangana.account.beans.FormFMonthly;
import com.snlabs.aarogyatelangana.account.beans.dashboard.FormFStats;
import com.snlabs.aarogyatelangana.account.dao.BirthReportDao;
import com.snlabs.aarogyatelangana.account.dao.DashboardDao;
import com.snlabs.aarogyatelangana.account.dao.MTPDao;
import com.snlabs.aarogyatelangana.account.service.DashboardService;

public class DashboardServiceImpl implements DashboardService{
	
	@Autowired
	public DashboardDao dashboardDao;

	public DashboardDao getDashboardDao() {
		return dashboardDao;
	}

	public void setDashboardDao(DashboardDao dashboardDao) {
		this.dashboardDao = dashboardDao;
	}	
	
	@Override
	public FormFStats getFormFMonthlyStats(String district, String state) {
		return dashboardDao.getFormFMonthlyStats(district, state);
	}

	@Override
	public int populateDistrictData() {
		return dashboardDao.populateDistrictData();
	}
}
