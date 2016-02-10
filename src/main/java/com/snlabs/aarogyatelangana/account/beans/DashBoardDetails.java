package com.snlabs.aarogyatelangana.account.beans;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DashBoardDetails {
	
	public static Map<String,DashboardDistrictDeails> districtsMap = new HashMap<String,DashboardDistrictDeails>();
		
	public static LinkedList<String> mapKeys = new LinkedList<String>(){{
		add("FormF");
		add("MtpYes");
		add("MtpNo");
		add("MaleChild");
		add("FeMaleChild");
		add("DisorderYes");
		add("DisorderNo");
	}};	
			
	public void intializeMap(String year, String state){
		StringBuilder sb = new StringBuilder();
		sb.append(year).append(state);
		int startIndex = sb.length();
		for(String keys:mapKeys){			
			districtsMap.put(sb.replace(startIndex, sb.length(), keys).toString(), new DashboardDistrictDeails());
		}		
	}
}
