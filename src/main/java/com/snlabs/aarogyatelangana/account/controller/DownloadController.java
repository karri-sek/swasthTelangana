package com.snlabs.aarogyatelangana.account.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.beans.dashboard.FormFStats;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.service.DashboardService;
import com.snlabs.aarogyatelangana.account.service.DownloadService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

@Controller
public class DownloadController {
	/**
	 * This class is created to have only download functionality, but Adding all the
	 * anonymous actions to this class now, don't get confused with the name.
	 */
	@Autowired
	DownloadService downloadService;
	
	@Autowired
    DashboardService dashboardService;

	private static final int BUFFER_SIZE = 4096;

	@RequestMapping(value = { "dashboard.action" })
	public String downLoadReport(@SessionParam(value = "userDetails") UserDetails userDetails,HttpServletRequest request, HttpSession session,
			HttpServletResponse response, ModelMap map) {
		 //FormFMonthly formFMonthly = dashboardService.getFormFMonthlyStats(userDetails.getDistrict(),userDetails.getState());
		FormFStats formFStats = dashboardService.getFormFMonthlyStats(userDetails.getDistrict(),userDetails.getState());
		//return "dashboardView";
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = new String();
		try {
			jsonInString = mapper.writeValueAsString(formFStats);
		} catch (IOException e) {
			e.printStackTrace();
		}
		map.put("results", jsonInString.toString());
		map.put("formFTotal", formFStats.getFormFTotal());
		return "dashboardtemp";
	}
	
	@RequestMapping(value = { "populateDistrictData.action" })
	public String populateDistrictData(@SessionParam(value = "userDetails") UserDetails userDetails,HttpServletRequest request, HttpSession session,
			HttpServletResponse response, ModelMap map) {
		
		dashboardService.populateDistrictData();
		
		return "emptypage";
	}
	
	
	@RequestMapping(value = {"formFDashboardDetails.action"}, method = RequestMethod.POST)
    public String viewFormFDashboardDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "viewFormFDashboar";
    }
    
    @RequestMapping(value = {"mtpDashboardDetails.action"}, method = RequestMethod.POST)
    public String viewMtpDashboardDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "viewMtpDashboard";
    }
    
    @RequestMapping(value = {"birtReporthDashboardDetails.action"}, method = RequestMethod.POST)
    public String viewBirthReportDashboardDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "viewBirthReportDashboard";
    }
    
    @RequestMapping(value = {"orphanFormFDashboardDetails.action"}, method = RequestMethod.POST)
    public String viewOrphanFormFDashboardDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "viewOrphanFormFDashboard";
    }

	public DownloadService getDownloadService() {
		return downloadService;
	}

	public void setDownloadService(DownloadService downloadService) {
		this.downloadService = downloadService;
	}
	
	@ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }
}
