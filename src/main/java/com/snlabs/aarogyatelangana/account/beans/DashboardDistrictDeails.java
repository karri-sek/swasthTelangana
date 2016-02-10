package com.snlabs.aarogyatelangana.account.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardDistrictDeails {
	
	public List<String> districts = new ArrayList<String>(Arrays.asList("ADB","HYD", "KRN", "KHM", "MBN", "MDK", "NLG","NZB","RNR","WRG"));
	
	public List<String> getDistricts() {
		return districts;
	}
	public void setDistricts(List<String> districts) {
		this.districts = districts;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public List<String> values = new ArrayList<String>();
	
}
