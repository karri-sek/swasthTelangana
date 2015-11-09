package com.snlabs.aarogyatelangana.account.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.ConveyDetails;
import com.snlabs.aarogyatelangana.account.beans.Declaration;
import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.Invasive;
import com.snlabs.aarogyatelangana.account.beans.NonInvasive;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.SectionA;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.service.DownloadService;
import com.snlabs.aarogyatelangana.account.service.FormService;
import com.snlabs.aarogyatelangana.account.service.PatientService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

@Controller
public class FormController {

    @Autowired
    public FormService formService;

    @Autowired
    DownloadService downloadService;

    @Autowired
    PatientService patientService;

    @RequestMapping(value = {"enterFormDetails.action"}, method = RequestMethod.POST)
    public String enterFormDetails(HttpSession session) {
        session.setAttribute("saveResult", null);
        ArrayList<Integer> patientIDs = new ArrayList<Integer>();
        session.setAttribute("patientIDs", patientIDs);
        return "form";
    }

    @RequestMapping(value = {"previousClinicDetails.action"}, method = RequestMethod.POST)
    public String previousClinicDetails(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Patient patient,
                                        HttpSession session, ModelMap model) {
        if (patient != null && patient.getPatientID() > 0) {
        	Patient pat = patientService.searchPatient(patient, userDetails, "ID");
        	pat.setOperation("UPDATE");
            model.put("patient", pat);
            return "patientForm";
        } else {
            System.out.println("Unable to get the Details patientID:" + patient.getPatientID());
            model.put("errorMessage", "Failed to get the Details");
        }
        return "clinicDetails";
    }

    @RequestMapping(value = {"saveClinicDetails.action"}, method = RequestMethod.POST)
    public String saveClinicDetails(@RequestBody ClinicAddress clinicAddress,
                                    HttpSession session, ModelMap model) {
    	ClinicAddress cadd = formService.saveClinicDetails(clinicAddress);
    	
    	if(cadd != null){
    		cadd.setOperation("UPDATE");
    		model.put("clinicAddress", cadd);
    	}else{
    		model.put("clinicAddress", clinicAddress);
    		session.setAttribute(
    				"error",
    				"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
    	}
        return "clinicDetails";
    }

    @RequestMapping(value = {"nextClinicDetails.action"}, method = RequestMethod.POST)
    public String nextClinicDetails(@RequestBody ClinicAddress clinicAddress,
                                    HttpSession session, ModelMap model) {
        model.clear();
        try {
            if (formService.saveClinicDetails(clinicAddress) != null) {
                
            	SectionA sectionA = formService.getSectionADetails(clinicAddress.getPatientID());
            	
            	if(sectionA != null){
            		sectionA.setOperation("UPDATE");
            	}else{
            		sectionA = new SectionA();
            		sectionA.setPatientID(clinicAddress.getPatientID());
            	}
            	
                sectionA.setPatientName(clinicAddress.getPatientName());
                model.put("sectionA", sectionA);
                return "sectionA";
            } else {
                model.put("error","Failed to Save Clinic Details");
                return "clinicDetails";
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
        return null;
    }


    @RequestMapping(value = {"previousSectionA.action"}, method = RequestMethod.POST)
    public String previousSectionA(@RequestBody Patient patient,
                                   HttpSession session, ModelMap model) {
    	if (patient != null && patient.getPatientID() > 0) {
            ClinicAddress clinicAddress = formService.getClinicDetails(patient.getPatientID());
            if (clinicAddress != null) {
            	clinicAddress.setPatientName(patient.getPatientName());
            	clinicAddress.setOperation("UPDATE");
                model.put("clinicAddress", clinicAddress);
                return "clinicDetails";
            } else {
                model.put("error", "unable to get the clinic details");
                return "sectionA";
            }
        } else {
            return "sectionA";
        }
    }

    @RequestMapping(value = {"saveSectionA.action"}, method = RequestMethod.POST)
    public String saveSectionADetails(@RequestBody SectionA sectionA,
                                      HttpSession session, ModelMap model) {
    	
    	SectionA secA = formService.saveSectionA(sectionA);
        if(secA != null){
        	secA.setOperation("UPDATE");
        	model.put("sectionA", secA);
        }else {
        	model.put("sectionA", sectionA);
        	session.setAttribute(
					"error",
					"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
        }
        
        return "sectionA";
    }

    @RequestMapping(value = {"nextSectionA.action"}, method = RequestMethod.POST)
    public String nextSectionADetails(@RequestBody SectionA sectionA,
                                      HttpSession session, ModelMap model) {
        if (formService.saveSectionA(sectionA) != null) {
        	
        	NonInvasive nonInvasive = formService.getNonInvasiveDetails(sectionA.getPatientID());
        	if(nonInvasive != null){
        		nonInvasive.setOperation("UPDATE");
        	}else {
        		 nonInvasive = new NonInvasive();
                 nonInvasive.setPatientID(sectionA.getPatientID());
                 nonInvasive.setPatientName(sectionA.getPatientName());
                 nonInvasive.setProcedureResult("Negetive");
                 
                 java.util.Date utilDate = new java.util.Date();
                 java.sql.Date curDate = new java.sql.Date(utilDate.getTime());
                 
                 nonInvasive.setDeclarationDate(curDate);
                 nonInvasive.setProcedureCarriedDate(curDate);
                 
                 ConveyDetails conveyDetails = new ConveyDetails();
                 conveyDetails.setConveyedDate(curDate);
                 
                 nonInvasive.setConveyDetails(conveyDetails);
        	}
            model.put("nonInvasive", nonInvasive);
            
            return "nonInvasive";
        } else {
            return "sectionA";
        }
    }

    @RequestMapping(value = {"previousNonInvasiveDetails.action"}, method = RequestMethod.POST)
    public String previousNonInvasiveDetails(@RequestBody NonInvasive nonInvasive,
                                             HttpSession session, ModelMap model) {
    	SectionA sectionA = formService.getSectionADetails(nonInvasive.getPatientID());
    	if (sectionA != null) {
    		sectionA.setOperation("UPDATE");
            model.put("sectionA", sectionA);
            return "sectionA";
        } else {
            return "nonInvasive";
        }
    }
 
    @RequestMapping(value = {"saveNonInvasiveDetails.action"}, method = RequestMethod.POST)
    public String saveNonInvasiveDetails(@RequestBody NonInvasive nonInvasive,
                                         HttpSession session, ModelMap model) {
    	NonInvasive nonInv = formService.saveNonInvasiveDetails(nonInvasive);
        
        if(nonInv != null){
        	nonInv.setDeclarationDate(new java.sql.Date(nonInv.getDeclarationDate().getTime()));
        	nonInv.setProcedureCarriedDate(new java.sql.Date(nonInv.getProcedureCarriedDate().getTime()));
        	nonInv.getConveyDetails().setConveyedDate(new java.sql.Date(nonInv.getConveyDetails().getConveyedDate().getTime()));
        	nonInv.setOperation("UPDATE");
        	model.put("nonInvasive", nonInv);
        }else{
        	model.put("nonInvasive", nonInvasive);
        	session.setAttribute(
    				"error",
    				"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
        }
        return "nonInvasive";
    }

    @RequestMapping(value = {"nextNonInvasiveDetails.action"}, method = RequestMethod.POST)
    public String nextNonInvasiveDetails(@RequestBody NonInvasive nonInvasive,
                                         HttpSession session, ModelMap model) {

        if (formService.saveNonInvasiveDetails(nonInvasive) != null) {
        	Invasive invasive = formService.getInvasiveDetails(nonInvasive.getPatientID());
        	
        	if(invasive != null){
        		invasive.setOperation("UPDATE");
        	}else {
        		invasive = new Invasive();
                invasive.setPatientName(nonInvasive.getPatientName());
                invasive.setPatientID(nonInvasive.getPatientID());
                
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date curDate = new java.sql.Date(utilDate.getTime());
                
                invasive.setFormGDate(curDate);
                invasive.setProcedureCarriedDate(curDate);
                ConveyDetails conveyDetails = new ConveyDetails();
                conveyDetails.setConveyedDate(curDate);
                invasive.setConveyDetails(conveyDetails);
        	}
        	
        	model.put("invasive", invasive);
        	
            return "invasive";
        } else {
            return "nonInvasive";
        }
    }

    @RequestMapping(value = {"previousInvasiveDetails.action"}, method = RequestMethod.POST)
    public String previousInvasiveDetails(@RequestBody Patient patient,
                                          HttpSession session, ModelMap model) {
    	NonInvasive nonInvasive = formService.getNonInvasiveDetails(patient.getPatientID());
        if (nonInvasive != null) {
        	nonInvasive.setOperation("UPDATE");
            model.put("nonInvasive", nonInvasive);
            return "nonInvasive";
        } else {
            return "invasive";
        }
    }

    @RequestMapping(value = {"saveInvasiveDetails.action"}, method = RequestMethod.POST)
    public String saveInvasiveDetails(@RequestBody Invasive invasive,
                                      HttpSession session, ModelMap model) {
    	Invasive inv = formService.saveInvasiveDetails(invasive);
        
        if(inv != null){
        	inv.setFormGDate(new java.sql.Date(inv.getFormGDate().getTime()));
        	inv.setProcedureCarriedDate(new java.sql.Date(inv.getProcedureCarriedDate().getTime()));
        	inv.getConveyDetails().setConveyedDate(new java.sql.Date(inv.getConveyDetails().getConveyedDate().getTime()));
        	inv.setOperation("UPDATE");
        	model.put("invasive", inv);
        }else {
        	model.put("invasive", invasive);
        	session.setAttribute(
    				"error",
    				"Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
        }
        return "invasive";
    }


    @RequestMapping(value = {"nextInvasiveDetails.action"}, method = RequestMethod.POST)
    public String nextInvasiveDetails(@RequestBody Invasive invasive,
                                      HttpSession session, ModelMap model) {
        try {
            if (formService.saveInvasiveDetails(invasive) != null) {
                model.put("patientID", invasive.getPatientID());
                model.put("patientName", invasive.getPatientName());
                model.put("doctorName", invasive.getDoctorName());
            } else {
                model.put(
                        "saveResult",
                        "Oh snap! Failed Please check the whether you created Patient Form for this Patient Name.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "declaration";
    }

    @RequestMapping(value = {"searchReportByFormId.action"}, method = RequestMethod.POST)
    public String searchReportByFormId(@RequestBody Form form,
                                       HttpSession session, ModelMap map) {
        int formId = Integer.parseInt(form.getSearchFormId());
        session.setAttribute("formId", formId);
        session.setAttribute("patientId", null);
        session.setAttribute("patientName", null);
        Form resultForm = formService.searchForm(formId);
        session.setAttribute("form", resultForm);
        if (resultForm != null) {
            return "viewFormResultform";
        } else {
            return "errorResultForm";
        }
    }

    @RequestMapping(value = {"searchReportByDateRange.action"}, method = RequestMethod.POST)
    public String searchReportByDateRange(@RequestBody Form form,
                                          HttpSession session, ModelMap map) {
        Form resultForm = formService.searchFormByDateRange(form.fromDate,
                form.toDate);
        if (resultForm != null) {
            return "viewFormDateRangeResultform";
        } else {
            map.put("Failed", "No Records Found Between These Dates");
            return "formDateReport";
        }
    }

    @RequestMapping(value = {"viewFormDetails.action"}, method = RequestMethod.POST)
    public String viewFormDetails(@RequestBody Form form, HttpSession session,
                                  ModelMap model) {
        Form resultForm = formService.searchForm(Integer.parseInt(form
                .getSearchFormId()));
        session.setAttribute("form", resultForm);
        if (resultForm != null) {
            return "viewResultform";
        } else {
            return "errorResultForm";
        }
    }

    @RequestMapping(value = {"saveDeclarationDetails.action"}, method = RequestMethod.POST)
    public String saveDeclaration(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Declaration declaration,
                                  HttpSession session, ModelMap model, HttpServletRequest request) {
        if (declaration.getPatientID() > 0) {
            if (formService.saveDeclarationDetails(declaration) != null) {
            	model.put("downloadUrl", "/account/downLoadForm.action?patientID=" + declaration.getPatientID());
                model.put("result", "Patient Details saved successfully");
            } else {
                model.put("result", "Failed to save the Patient Details");
            }
        } else {
            model.put("result", "Unable to Save the Declaration for the patient name " + declaration.getPatientName());
        }
        return "declaration";
    }
    
    public FormService getFormService() {
        return formService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
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
