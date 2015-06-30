package com.snlabs.aarogyatelangana.account.controller;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.service.FormService;
import com.snlabs.aarogyatelangana.account.service.PatientService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
public class PatientController {

    private static final int BUFFER_SIZE = 4096;

    @Autowired
    public PatientService patientService;

    @Autowired
    public FormService formService;

    @RequestMapping(value = {"savePatientDetails.action"}, method = RequestMethod.POST)
    public String savePatientDetails(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Patient patient,
                                     HttpSession session, ModelMap model) {
        Patient resultPatient;
        try {
            if (session.getAttribute("userDetails") == null) {
                model.put("error", "Unable to get userDetails from session");
            }
            String createdBy = ((UserDetails) userDetails).getLoginId();
            resultPatient = patientService.createPatientRecord(patient);
            if (resultPatient != null) {
                patient.setCreatedBy(createdBy);
                model.put("patient", resultPatient);
                model.put("result", patient.getPatientName() + " details has been saved successfully...!");
            } else {
                model.put("error", "Unable to save Patient Details");
            }
        } catch (Exception e) {
            System.out.print("error:" + e);
        }
        return "patientForm";

    }

    @RequestMapping(value = {"enterPatientDetails.action"}, method = RequestMethod.POST)
    public String enterPatientDetails(@SessionParam(value = "userDetails") UserDetails userDetails, HttpSession session, ModelMap model, String patientID) {
        try {
            model.clear();
            System.out.println("Patient ID" + patientID);
            if (patientID != null) {
                model.put("patient", formService.getPatientDetails(Integer.parseInt(patientID)));
            }
            if (userDetails != null) {
                model.put("loginID", userDetails.getLoginId());
            } else {
                model.put("error", "unable to get user session Details");
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        } finally {
            return "patientForm";
        }
    }

    @RequestMapping(value = {"patientProfiles.action"}, method = RequestMethod.POST)
    public ModelAndView patientProfiles(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Form form, HttpSession session, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        model.clear();
        try {
            if (userDetails != null && userDetails.getLoginId() != null) {
                List<Patient> patientProfiles = patientService.getPatientProfiles(userDetails, form);
                try {
                    if (patientProfiles != null) {
                        modelAndView.addObject("patientProfiles", patientProfiles);
                        modelAndView.addObject("result", patientProfiles.size() + " Profiles Found. Created by " + userDetails.getLoginId());
                    } else {
                        model.put("error", "No Profiles found.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                model.put("error", "Unable to get the login details");
            }
            modelAndView.setViewName("patientProfiles");
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        } finally {
            return modelAndView;
        }
    }

    @RequestMapping(value = {"savePatientDetailsAndContinue.action"}, method = RequestMethod.POST)
    public String savePatientDetailsAndContinue(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Patient patient,
                                                HttpSession session, ModelMap model) {
        try {
            if (patientService.createPatientRecord(patient) != null) {
                ClinicAddress clinicAddress = formService.getClinicDetails(patient.getPatientID());
                if (clinicAddress == null) {
                    clinicAddress = new ClinicAddress();
                    clinicAddress.setPatientID(patient.getPatientID());
                }
                clinicAddress.setPatientName(patient.getPatientName());
                model.put("clinicAddress", clinicAddress);
                model.put("formName", "Clinic");
                model.put("formSubName", "Address");
                return "clinicDetails";
            } else {
                session.setAttribute(
                        "error",
                        "Oh snap! Failed Please check the whether you Entered Details Correctly or not.");
                return "patientForm";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    
    @RequestMapping(value = {"patientSearchReport.action"}, method = RequestMethod.POST)
    public String patientSearchReport(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Patient patient,
                                          HttpSession session, ModelMap map) {
        Patient resultForm = patientService.searchPatient(patient, userDetails, patient.getSearchType());
        session.setAttribute("form", resultForm);
        
        return "viewPatientResultform";
    }

    @RequestMapping(value = {"listPatientProfilesByDate.action"}, method = RequestMethod.POST)
    public String listPatientProfilesByDate(@SessionParam(value = "userDetails") UserDetails userDetails, @RequestBody Form form, HttpServletRequest request, HttpSession session, ModelMap model) {
        if (userDetails != null && userDetails.getLoginId() != null) {
            List<Patient> patientProfiles = patientService
                    .getPatientProfiles(userDetails, form);
            try {
                if (patientProfiles != null) {
                    model.put("patientProfiles", patientProfiles);
                    model.put("result",
                            patientProfiles.size()
                                    + " No of Profiles Found. Created by "
                                    + userDetails.getLoginId());
                } else {
                    model.put("result", 0 + " No of Profiles Found. Created by " + userDetails.getLoginId());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            model.put("result", "Unable to get the login details");
        }
        return "viewPatientDateRangeResult";
    }

    @RequestMapping(value = {"downLoadPatientProfile.action"}, method = RequestMethod.POST)
    public void downLoadPatientProfile(HttpServletRequest request, HttpSession session, HttpServletResponse response, ModelMap map, String filePath) {
        FileInputStream inputStream = null;
        ServletContext context = null;
        File file = null;
        OutputStream outputStream = null;
        try {
            if (filePath != null && !filePath.isEmpty()) {
                file = new File(filePath);
                inputStream = new FileInputStream(file);
                context = request.getServletContext();
                String type = context.getMimeType(file.getAbsolutePath());
                response.setContentType(type != null ? type : "application/octet-stream");
                response.setContentLength((int) file.length());
                String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
                response.setHeader("Content-Disposition", headerValue);
                outputStream = response.getOutputStream();
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } else {
                System.out.print("Unable to download file, empty filePath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }
}