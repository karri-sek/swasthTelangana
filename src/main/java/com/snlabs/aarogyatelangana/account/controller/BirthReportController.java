/**
 * 
 */
package com.snlabs.aarogyatelangana.account.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snlabs.aarogyatelangana.account.beans.BirthFamilyInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthHealthInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthLegalInfo;
import com.snlabs.aarogyatelangana.account.beans.BirthReportAddress;
import com.snlabs.aarogyatelangana.account.beans.BirthReportDetails;
import com.snlabs.aarogyatelangana.account.beans.BirthReportSearchBean;
import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.MTPDetails;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.service.BirthReportService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

/**
 * @author nbattula
 *
 */
@Controller
public class BirthReportController {

	@Autowired
	public BirthReportService birthReportService;

	@RequestMapping(value = { "enterBirthReportDetails.action" }, method = RequestMethod.POST)
	public String viewFormIdReportOptions(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthLegalInfo birthLegalInfo, ModelMap model) {

		try {
			// model.clear();
			if (birthLegalInfo.getBirthId() > 0) {
				BirthLegalInfo legalInfo = birthReportService
						.searchBirthReportLegalInfo(birthLegalInfo,
								userDetails, "ID");
				birthLegalInfo.setOperation("UPDATE");
				model.put("birthLegalInfo", legalInfo);
			} else {
				/*// TESTING-DATA - Comment-out once testing is done.
				BirthLegalInfo legalInfo = new BirthLegalInfo();

				legalInfo.setBirthPlace("HOSPITAL");
				legalInfo.setChildName("Aroan");

				java.util.Date utilDate = new java.util.Date();
				java.sql.Date curDate = new java.sql.Date(utilDate.getTime());
				legalInfo.setDateOfBirth(curDate);

				legalInfo.setFatherName("Rithesh Deshmkh");
				legalInfo.setHospitalName("Apollo Hospitals");
				legalInfo.setInformantsAddress("Hyderabad");
				legalInfo.setInformantsName("DR.Nag");
				legalInfo.setMotherAadhaar("564321654321");
				legalInfo.setMotherContact("9865327410");
				legalInfo.setMotherName("Genelia D'souza");
				legalInfo.setSex("MALE");

				model.put("birthLegalInfo", legalInfo);*/
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

		return "birthreport/birthLegalInfoView";
	}

	@RequestMapping(value = { "saveBirthLegalInfo.action" }, method = RequestMethod.POST)
	public String saveBirthLegalInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthLegalInfo birthLegalInfo, ModelMap model,
			HttpSession session) {

		try {

			birthLegalInfo.setCreatedBy(userDetails.getLoginId());

			BirthLegalInfo legalInfo = birthReportService
					.createBirthReportLegalInfo(birthLegalInfo);

			if (legalInfo != null) {
				legalInfo.setOperation("UPDATE");
				model.put("birthLegalInfo", legalInfo);
			} else {
				model.put("birthLegalInfo", birthLegalInfo);
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "birthreport/birthLegalInfoView";
	}

	@RequestMapping(value = { "continueBirthLegalInfo.action" }, method = RequestMethod.POST)
	public String continueBirthLegalInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthLegalInfo birthLegalInfo, ModelMap model,
			HttpSession session) {

		try {
			birthLegalInfo.setCreatedBy(userDetails.getLoginId());
			if (birthReportService.createBirthReportLegalInfo(birthLegalInfo) != null) {

				BirthReportAddress birthReportAddress = birthReportService
						.getBirthReportAddress(birthLegalInfo, userDetails, "ID");
				
				if (birthReportAddress != null) {
					birthReportAddress.setOperation("UPDATE");
				} else {
					birthReportAddress = new BirthReportAddress();
				}
				
				birthReportAddress.setBirthId(birthLegalInfo.getBirthId());
				
				model.put("birthReportAddress", birthReportAddress);

				return "birthreport/birthAdressView";
				
			} else {
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
				return "birthreport/birthLegalInfoView";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "birthreport/birthAdressView";
	}

	@RequestMapping(value = { "previousBirthReportAdress.action" }, method = RequestMethod.POST)
	public String previousBirthReportAdress(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthLegalInfo birthLegalInfo, ModelMap model) {
		
		if (birthLegalInfo != null && birthLegalInfo.getBirthId() > 0) {
			BirthLegalInfo legalInfo = birthReportService.searchBirthReportLegalInfo(birthLegalInfo, userDetails, "ID");
			legalInfo.setOperation("UPDATE");
            model.put("birthLegalInfo", legalInfo);
            return "birthreport/birthLegalInfoView";
        } else {
            System.out.println("Unable to get the Details BirthId:" + birthLegalInfo.getBirthId());
            model.put("errorMessage", "Failed to get the Details");
        }
		
		return "birthreport/birthAdressView";
	}

	@RequestMapping(value = { "saveBirthReportAdress.action" }, method = RequestMethod.POST)
	public String saveBirthReportAdress(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthReportAddress birthReportAddress, ModelMap model, HttpSession session) {
		
		try {

			BirthReportAddress brAddress = birthReportService
					.createBirthReportAddress(birthReportAddress);

			if (brAddress != null) {
				brAddress.setOperation("UPDATE");
				model.put("birthReportAddress", brAddress);
			} else {
				model.put("birthReportAddress", birthReportAddress);
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "birthreport/birthAdressView";
	}

	@RequestMapping(value = { "continueBirthReportAdress.action" }, method = RequestMethod.POST)
	public String continueBirthReportAdress(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthReportAddress birthReportAddress, ModelMap model) {
		
		try {
			if (birthReportService.createBirthReportAddress(birthReportAddress) != null) {

				BirthFamilyInfo birthFamilyInfo = birthReportService
						.getBirthFamilyInfo(birthReportAddress, userDetails, "ID");
				
				if (birthFamilyInfo != null) {
					birthFamilyInfo.setOperation("UPDATE");
				} else {
					birthFamilyInfo = new BirthFamilyInfo();
				}
				
				birthFamilyInfo.setBirthId(birthReportAddress.getBirthId());
				
				model.put("familyInfo", birthFamilyInfo);

				return "birthreport/familyInfoView";
				
			} else {
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
				return "birthreport/birthLegalInfoView";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "birthreport/familyInfoView";
	}

	@RequestMapping(value = { "previousFamilyInfo.action" }, method = RequestMethod.POST)
	public String previousFamilyInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthFamilyInfo birthFamilyInfo, ModelMap model) {
		
		BirthLegalInfo birthLegalInfo = new BirthLegalInfo();
		birthLegalInfo.setBirthId(birthFamilyInfo.getBirthId());
		
		BirthReportAddress birthReportAddress = birthReportService
				.getBirthReportAddress(birthLegalInfo, userDetails, "ID");
		
		if (birthReportAddress != null) {
			birthReportAddress.setOperation("UPDATE");
		} else {
			birthReportAddress = new BirthReportAddress();
			System.out.println("Unable to get the Details BirthId:" + birthFamilyInfo.getBirthId());
            model.put("errorMessage", "Failed to get the Details");
		}
		
		birthReportAddress.setBirthId(birthLegalInfo.getBirthId());
		
		model.put("birthReportAddress", birthReportAddress);
		
		return "birthreport/birthAdressView";
	}

	@RequestMapping(value = { "saveFamilyInfo.action" }, method = RequestMethod.POST)
	public String saveFamilyInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthFamilyInfo birthFamilyInfo, ModelMap model) {
		
		try {

			BirthFamilyInfo bFamilyInfo = birthReportService
					.createBirthFamilyInfo(birthFamilyInfo);

			if (bFamilyInfo != null) {
				bFamilyInfo.setOperation("UPDATE");
				model.put("familyInfo", bFamilyInfo);
			} else {
				model.put("familyInfo", bFamilyInfo);
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "birthreport/familyInfoView";
	}

	@RequestMapping(value = { "continueFamilyInfo.action" }, method = RequestMethod.POST)
	public String continueFamilyInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthFamilyInfo birthFamilyInfo, ModelMap model) {
		
		try {
			if (birthReportService.createBirthFamilyInfo(birthFamilyInfo) != null) {

				BirthHealthInfo birthHealthInfo = birthReportService
						.getBirthHealthInfo(birthFamilyInfo, userDetails, "ID");
				
				if (birthHealthInfo != null) {
					birthHealthInfo.setOperation("UPDATE");
				} else {
					birthHealthInfo = new BirthHealthInfo();
					birthHealthInfo.setBirthId(birthFamilyInfo.getBirthId());
				}
				
				model.put("healthInfo", birthHealthInfo);

				return "birthreport/healthInfoView";
				
			} else {
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
				return "birthreport/familyInfoView";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "birthreport/healthInfoView";
	}

	@RequestMapping(value = { "previousHealthInfo.action" }, method = RequestMethod.POST)
	public String previousHealthInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthHealthInfo birthHealthInfo, ModelMap model) {
		
		if (birthHealthInfo != null && birthHealthInfo.getBirthId() > 0) {
			
			BirthFamilyInfo birthFamilyInfo = new BirthFamilyInfo();
			birthFamilyInfo.setBirthId(birthHealthInfo.getBirthId());
			
			BirthFamilyInfo familyInfo = birthReportService.searchBirthReportFamilyInfo(birthFamilyInfo, userDetails, "ID");
			
			familyInfo.setOperation("UPDATE");
            model.put("familyInfo", familyInfo);
            
            return "birthreport/familyInfoView";
        } else {
            System.out.println("Unable to get the Details BirthId:" + birthHealthInfo.getBirthId());
            model.put("errorMessage", "Failed to get the Details");
        }
		
		return "birthreport/familyInfoView";
	}

	@RequestMapping(value = { "saveHealthInfo.action" }, method = RequestMethod.POST)
	public String saveHealthInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthHealthInfo birthHealthInfo, ModelMap model) {
		
		try {

			BirthHealthInfo bHealthInfo = birthReportService.createBirthHealthInfo(birthHealthInfo);

			if (bHealthInfo != null) {
				bHealthInfo.setOperation("UPDATE");
				model.put("healthInfo", bHealthInfo);
			} else {
				model.put("healthInfo", bHealthInfo);
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "birthreport/healthInfoView";
	}

	@RequestMapping(value = { "continueHealthInfo.action" }, method = RequestMethod.POST)
	public String continueHealthInfo(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthHealthInfo birthHealthInfo, ModelMap model) {
		
		try {
			if (birthReportService.createBirthHealthInfo(birthHealthInfo) != null) {
				model.put("healthInfo", birthHealthInfo);
				return "birthreport/birthReportDownload";
			} else {
				model.put(
						"error",
						"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
				return "birthreport/healthInfoView";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "birthreport/birthReportDownload";
		
	}
	
	
	@RequestMapping(value = { "searchBirthReportDetails.action" }, method = RequestMethod.POST)
	public String patientSearchReport(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthReportSearchBean birthReportSearchBean, HttpSession session, ModelMap map) {
		BirthReportDetails birthReportDetails = birthReportService.searchBirthReportDetails(birthReportSearchBean, userDetails,
				birthReportSearchBean.getSearchType());
		session.setAttribute("birthReportDetails", birthReportDetails);

		return "birthreport/viewBirthReportResult";
	}
	
	@RequestMapping(value = { "listBirthReportsByDate.action" }, method = RequestMethod.POST)
	public String listMTPPatientProfilesByDate(
			@SessionParam(value = "userDetails") UserDetails userDetails,
			@RequestBody BirthReportSearchBean birthReportSearchBean, HttpServletRequest request,
			HttpSession session, ModelMap model) {
		if (userDetails != null && userDetails.getLoginId() != null) {
			List<BirthReportDetails> birthReportList = birthReportService.listBirthReportsByDate(
					userDetails, birthReportSearchBean);
			try {
				if (birthReportList != null) {
					model.put("birthReportList", birthReportList);
					model.put("result", birthReportList.size()
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
		
		model.put("fromDate", birthReportSearchBean.getFromDate());
		model.put("toDate", birthReportSearchBean.getToDate());		

		return "viewMTPPatientDateRangeResult";
	}
	
	@ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }

	public BirthReportService getBirthReportService() {
		return birthReportService;
	}

	public void setBirthReportService(BirthReportService birthReportService) {
		this.birthReportService = birthReportService;
	}

}
