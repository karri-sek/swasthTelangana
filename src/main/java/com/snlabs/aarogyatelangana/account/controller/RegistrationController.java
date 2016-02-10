/**
 * 
 */
package com.snlabs.aarogyatelangana.account.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.service.AccountService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;
import com.snlabs.aarogyatelangana.account.utils.AccountUtils;

/**
 * @author nbattula
 *
 */
@Controller
public class RegistrationController {
	static Logger logger = LoggerFactory.getLogger(LoginController.class);

	/*
	 * @Autowired public RegistrationService registrationService;
	 */

	@RequestMapping(value = { "regBasicInfo.action" }, method = RequestMethod.POST)
	public String regBasicInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			ModelMap model, HttpSession session) {
		model.put("loginID", userDetails.getLoginId());
		return "registration/regBasicInfo";
	}

	@RequestMapping(value = { "saveRegbasicInfo.action" }, method = RequestMethod.POST)
	public String saveRegbasicInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regBasicInfo";
	}

	@RequestMapping(value = { "continueRegbasicInfo.action" }, method = RequestMethod.POST)
	public String continueRegbasicInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreAddress";
	}

	@RequestMapping(value = { "saveRegCentreAddress.action" }, method = RequestMethod.POST)
	public String saveCentreAddress(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreAddress";
	}

	@RequestMapping(value = { "nextRegCentreAddress.action" }, method = RequestMethod.POST)
	public String continueRegCentreAddress(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreDetails";
	}

	@RequestMapping(value = { "previousRegCentreAddress.action" }, method = RequestMethod.POST)
	public String previousRegCentreAddress(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regBasicInfo";
	}

	@RequestMapping(value = { "previousRegCentreDetails.action" }, method = RequestMethod.POST)
	public String previousRegCentreDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreAddress";
	}

	@RequestMapping(value = { "saveRegCentreDetails.action" }, method = RequestMethod.POST)
	public String saveRegCentreDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreDetails";
	}

	@RequestMapping(value = { "nextRegCentreDetails.action" }, method = RequestMethod.POST)
	public String nextRegCentreDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regOtherDetails";
	}

	@RequestMapping(value = { "previousRegOtherDetails.action" }, method = RequestMethod.POST)
	public String previousRegOtherDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreAddress";
	}

	@RequestMapping(value = { "saveRegOtherDetails.action" }, method = RequestMethod.POST)
	public String saveRegOtherDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regCentreDetails";
	}

	@RequestMapping(value = { "nextRegOtherDetails.action" }, method = RequestMethod.POST)
	public String nextRegOtherDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {

		return "registration/regDeclaration";
	}

	@RequestMapping(value = { "saveRegDeclaration.action" }, method = RequestMethod.POST)
	public String saveRegDeclaration(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap modelMap) {
		modelMap.put("result", "Registration declaration saved successfully.");
		return "registration/regDeclaration";
	}

	@ExceptionHandler(LoginRequiredException.class)
	public String handleLoginRequiredException(LoginRequiredException ex) {
		return "loginredirect";
	}

}
