/**
 * 
 */
package com.snlabs.aarogyatelangana.account.utils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author nbattula
 *
 */
public class DashboardUtils {
	
	public static Map<String, String> districtDisplayNameMap = new TreeMap<String, String>();
	
	public static Map<String, String> getDistrictMap(){
		if(districtDisplayNameMap.size() == 0){
			districtDisplayNameMap.put("Hyderabad","HYD");
			districtDisplayNameMap.put("Rangareddy","RNR");
			districtDisplayNameMap.put("Karimnagar","KRN");
			districtDisplayNameMap.put("Warangal","WRG");
			districtDisplayNameMap.put("Adilabad","ADB");
			districtDisplayNameMap.put("Khammam","KHM");
			districtDisplayNameMap.put("Mahaboobnagar","MBN");
			districtDisplayNameMap.put("Medak","MDK");
			districtDisplayNameMap.put("Nalgonda","NLG");
			districtDisplayNameMap.put("Nizamabad","NZB");
		}
		return districtDisplayNameMap;
	}
	
	public static String getDistrictDisplayName(String distName){
		return districtDisplayNameMap.get(distName);
	}
	
}
