package com.snlabs.aarogyatelangana.account.controller;

import com.snlabs.aarogyatelangana.account.beans.ClinicAddress;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.service.FormService;
import com.snlabs.aarogyatelangana.account.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = {"enterPatientDetails.action"}, method = RequestMethod.POST)
    public String enterPatientDetails(HttpSession session, ModelMap model, String patientID) {
        if (patientID != null) {
            model.put("patient", formService.getPatientDetails(Integer.parseInt(patientID)));
        }
        model.put("loginID", UserDetails.getLoginId());
        return "patientForm";
    }

    @RequestMapping(value = {"savePatientDetails.action"}, method = RequestMethod.POST)
    public String savePatientDetails(@RequestBody Patient patient,
                                     HttpSession session, ModelMap model) {
        model.put("patient", patientService.createPatientRecord(patient));
        model.put("result", patient.getPatientName() + " details has been saved successfully...!");
        return "patientForm";
    }

    @RequestMapping(value = {"patientProfiles.action"}, method = RequestMethod.POST)
    public ModelAndView patientProfiles(HttpSession session, ModelMap model) {
        ModelAndView modelAndView = null;
        if (UserDetails.getLoginId() != null) {
            modelAndView = new ModelAndView();
            List<Patient> patientProfiles = patientService
                    .getPatientProfiles(UserDetails.getLoginId());
            try {
                if (patientProfiles != null) {
                    modelAndView.addObject("patientProfiles", patientProfiles);
                    modelAndView.addObject("result", patientProfiles.size() + " No of Profiles Found. Created by " + UserDetails.getLoginId());
                } else {
                    modelAndView.addObject("result", "No Profiles found.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            modelAndView.addObject("result", "Unable to get the login details");
        }
        modelAndView.setViewName("patientProfiles");
        return modelAndView;
    }

    @RequestMapping(value = {"savePatientDetailsAndContinue.action"}, method = RequestMethod.POST)
    public String savePatientDetailsAndContinue(@RequestBody Patient patient,
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
                return "clinicDetails";
            } else {
                session.setAttribute(
                        "saveResult",
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

    @RequestMapping(value = {"searchReportByPatientId.action"}, method = RequestMethod.POST)
    public String searchReportByPatientId(@RequestBody Patient patient,
                                          HttpSession session, ModelMap map) {
        Integer patientId = patient.getPatientID();
        Patient resultForm = patientService.searchPatientById(patientId);
        session.setAttribute("form", resultForm);
        session.setAttribute("patientId", patient.getPatientID());
        session.setAttribute("patientName", null);
        if (resultForm != null) {
            return "viewPatientResultform";
        } else {
            return "errorResultForm";
        }
    }

    @RequestMapping(value = {"searchReportByPatientName.action"}, method = RequestMethod.POST)
    public String searchReportByPatientName(@RequestBody Patient patient,
                                            HttpSession session, ModelMap map) {
        session.setAttribute("patientId", null);
        session.setAttribute("patientName", patient.getPatientName());
        Patient resultForm = patientService.searchPatientByName(patient
                .getPatientName());
        session.setAttribute("form", resultForm);
        System.out.println(resultForm);
        if (resultForm != null) {
            return "viewPatientResultform";
        } else {
            return "errorResultForm";
        }
    }

    @RequestMapping(value = {"listPatientProfilesByDate.action"}, method = RequestMethod.POST)
    public String listPatientProfilesByDate(HttpServletRequest request, HttpSession session, ModelMap model) {
        if (UserDetails.getLoginId() != null) {
            List<Patient> patientProfiles = patientService
                    .getPatientProfiles(UserDetails.getLoginId());
            try {
                if (patientProfiles != null) {
                    model.put("patientProfiles", patientProfiles);
                }
                model.put("result", patientProfiles.size() + " No of Profiles Found. Created by " + UserDetails.getLoginId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            model.put("result", "Unable to get the login details");
        }
        return "fromDateReport";
    }

    @RequestMapping(value = {"downLoadPatientProfile.action"}, method = RequestMethod.GET)
    public void downLoadPatientProfile(HttpServletRequest request, HttpSession session,
                                       HttpServletResponse response, ModelMap map, String filePath) {
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
}
