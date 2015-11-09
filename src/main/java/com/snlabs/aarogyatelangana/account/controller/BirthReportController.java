/**
 * 
 */
package com.snlabs.aarogyatelangana.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

/**
 * @author nbattula
 *
 */
@Controller
public class BirthReportController {
	
	@RequestMapping(value = { "enterBirthReportDetails.action" }, method = RequestMethod.POST)
	public String viewFormIdReportOptions(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			ModelMap map) {
		return "formcpatient";
	}
}
