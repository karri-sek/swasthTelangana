package com.snlabs.aarogyatelangana.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.MTPDetails;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.SectionA;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.service.AccountService;
import com.snlabs.aarogyatelangana.account.service.MTPService;
import com.snlabs.aarogyatelangana.account.service.PatientService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

@Controller
public class MTPController {

	static Logger LOGGER = LoggerFactory.getLogger(MTPController.class);

	@Autowired
	public MTPService mtpService;

	@RequestMapping(value = { "enterAbortingPatientDetails.action" }, method = RequestMethod.POST)
	public String viewFormIdReportOptions(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			ModelMap map, @RequestBody Patient patient) {
		try {
			if (patient.getPatientID() > 0) {
				Patient pat = mtpService
						.searchPatientById(patient, userDetails);
				pat.setOperation("UPDATE");
				map.put("patient", pat);
			}
		} catch (Exception e) {
			LOGGER.debug("Exception:" + e.getMessage());
		}
		return "mtppatient";
	}

	@RequestMapping(value = { "saveAbortingPatientDetails.action" }, method = RequestMethod.POST)
	public String saveAbortingPatientDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap model, @RequestBody Patient patient) {
		try {
			patient.setCreatedBy(userDetails.getLoginId());
			Patient pat = mtpService.createPatientRecord(patient);

			if (pat != null) {
				pat.setOperation("UPDATE");
				model.put("patient", pat);
			} else {
				model.put("patient", patient);
				session.setAttribute(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "mtppatient";
	}

	@RequestMapping(value = { "saveAbortingPatientDetailsAndContinue.action" }, method = RequestMethod.POST)
	public String savePatientDetailsAndContinue(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody Patient patient, HttpSession session, ModelMap model) {
		try {
			patient.setCreatedBy(userDetails.getLoginId());
			if (mtpService.createPatientRecord(patient) != null) {
				ClinicAddress clinicAddress = mtpService
						.getClinicDetails(patient.getPatientID());
				if (clinicAddress != null) {
					clinicAddress.setOperation("UPDATE");
				} else {
					clinicAddress = new ClinicAddress();
					clinicAddress.setPatientID(patient.getPatientID());
					if (userDetails.getClinicAddress() != null) {
						clinicAddress.setClinicName(userDetails
								.getClinicAddress().getClinicName());
						clinicAddress.setRegistrationNo(userDetails
								.getClinicAddress().getRegistrationNo());
						clinicAddress.setContactNum(userDetails
								.getClinicAddress().getContactNum());
						clinicAddress.setAddress(userDetails.getClinicAddress()
								.getAddress());
						clinicAddress.setDistrict(userDetails
								.getClinicAddress().getDistrict());
						clinicAddress.setState(userDetails.getClinicAddress()
								.getState());
						clinicAddress.setPincode(userDetails.getClinicAddress()
								.getPincode());
					}
				}
				clinicAddress.setPatientName(patient.getPatientName());
				model.put("clinicAddress", clinicAddress);
				return "abortingclinicDetails";
			} else {
				session.setAttribute(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
				return "mtppatient";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "previousAbortingClinicDetails.action" }, method = RequestMethod.POST)
	public String previousClinicDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody Patient patient, HttpSession session, ModelMap model) {
		if (patient != null && patient.getPatientID() > 0) {
			Patient pat = mtpService.searchPatientById(patient, userDetails);
			pat.setOperation("UPDATE");
			model.put("patient", pat);
			return "mtppatient";
		} else {
			System.out.println("Unable to get the Details patientID:"
					+ patient.getPatientID());
			model.put("errorMessage", "Failed to get the Details");
		}
		return "mtppatient";
	}

	@RequestMapping(value = { "saveAbortingClinicDetails.action" }, method = RequestMethod.POST)
	public String saveClinicDetails(@RequestBody ClinicAddress clinicAddress,
			HttpSession session, ModelMap model) {
		ClinicAddress cadd = mtpService.saveClinicDetails(clinicAddress);

		if (cadd != null) {
			cadd.setOperation("UPDATE");
			model.put("clinicAddress", cadd);
		} else {
			model.put("clinicAddress", clinicAddress);
			session.setAttribute(
					"error",
					"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
		}
		return "abortingclinicDetails";
	}

	@RequestMapping(value = { "nextAbortingClinicDetails.action" }, method = RequestMethod.POST)
	public String nextClinicDetails(@RequestBody ClinicAddress clinicAddress,
			HttpSession session, ModelMap model) {
		model.clear();
		try {
			if (mtpService.saveClinicDetails(clinicAddress) != null) {

				MTPDetails mtpDetails = mtpService
						.getMtpOtherDetails(clinicAddress.getPatientID());

				if (mtpDetails != null) {
					mtpDetails.setOperation("UPDATE");
				} else {
					mtpDetails = new MTPDetails();
					mtpDetails.setPatientID(clinicAddress.getPatientID());
				}

				mtpDetails.setPatientName(clinicAddress.getPatientName());
				model.put("mtpDetails", mtpDetails);
				return "abortionDetails";
			} else {
				model.put("error", "Failed to Save Clinic Details");
				return "abortingclinicDetails";
			}
		} catch (Exception e) {
			LOGGER.debug("Error:" + e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = { "previousAbortionDetails.action" }, method = RequestMethod.POST)
	public String previousAbortionDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody Patient patient, HttpSession session, ModelMap model) {

		if (patient != null && patient.getPatientID() > 0) {
			ClinicAddress clinicAddress = mtpService.getClinicDetails(patient
					.getPatientID());
			if (clinicAddress != null) {
				clinicAddress.setPatientName(patient.getPatientName());
				clinicAddress.setOperation("UPDATE");
				model.put("clinicAddress", clinicAddress);
				return "abortingclinicDetails";
			} else {
				model.put("error", "unable to get the clinic details");
				return "abortionDetails";
			}
		} else {
			return "abortionDetails";
		}
	}

	@RequestMapping(value = { "saveAbortionDetails.action" }, method = RequestMethod.POST)
	public String saveAbortionDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap model,
			@RequestBody MTPDetails mtpDetails) {

		MTPDetails mtpDtl = mtpService.saveAbortionDetails(mtpDetails);

		if (mtpDtl != null) {
			mtpDtl.setOperation("UPDATE");
			model.put("mtpDetails", mtpDtl);
		} else {
			model.put("mtpDetails", mtpDtl);
			session.setAttribute("error",
					"Oh snap! Failed Please check the whether you Entered Details Correct or not.");
		}
		return "abortionDetails";
	}

	@RequestMapping(value = { "saveNextAbortionDetails.action" }, method = RequestMethod.POST)
	public String savNexteAbortionDetails(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			HttpSession session, ModelMap model,
			@RequestBody MTPDetails mtpDetails) {
		try {
			if (mtpService.saveAbortionDetails(mtpDetails) != null) {
				model.addAttribute("mtpDetails", mtpDetails);
				return "abortionDetailsDownload";
			} else {
				model.put("error", "Failed to save abortion details");
				return "abortionDetails";
			}
		} catch (Exception e) {
			LOGGER.debug("Error:" + e.getMessage());
		}
		return "abortionDetailsDownload";
	}

	public MTPService getMtpService() {
		return mtpService;
	}

	public void setMtpService(MTPService mtpService) {
		this.mtpService = mtpService;
	}

	@RequestMapping(value = { "mtpPatientSearchReport.action" }, method = RequestMethod.POST)
	public String patientSearchReport(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody Patient patient, HttpSession session, ModelMap map) {
		MTPDetails resultForm = mtpService.searchPatient(patient, userDetails,
				patient.getSearchType());
		session.setAttribute("form", resultForm);

		return "viewMTPPatientResultform";
	}
	
	@RequestMapping(value = { "listMTPPatientProfilesByDate.action" }, method = RequestMethod.POST)
	public String listMTPPatientProfilesByDate(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody Form form, HttpServletRequest request,
			HttpSession session, ModelMap model) {
		if (userDetails != null && userDetails.getLoginId() != null) {
			List<MTPDetails> patientProfiles = mtpService.getPatientProfiles(
					userDetails, form);
			try {
				if (patientProfiles != null) {
					model.put("patientProfiles", patientProfiles);
					model.put("result", patientProfiles.size()
							+ " No of Profiles Found. Created by "
							+ userDetails.getLoginId());
				} else {
					model.put("result", 0
							+ " No of Profiles Found. Created by "
							+ userDetails.getLoginId());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			model.put("result", "Unable to get the login details");
		}
		
		final long MILLIS_IN_A_DAY = 1000*60*60*24;
		
		java.sql.Date fDate = new java.sql.Date(form.getFromDate().getTime());
        java.sql.Date tDate = new java.sql.Date(form.getToDate().getTime() + MILLIS_IN_A_DAY);
		
		model.put("fromDate", fDate);
		model.put("toDate", tDate);		
		return "viewMTPPatientDateRangeResult";
	}
	
	@ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }

}
