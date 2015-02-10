package com.snlabs.aarogyatelangana.account.controller;

import com.snlabs.aarogyatelangana.account.beans.*;
import com.snlabs.aarogyatelangana.account.service.DownloadService;
import com.snlabs.aarogyatelangana.account.service.FormService;
import com.snlabs.aarogyatelangana.account.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;

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
    public String previousClinicDetails(@RequestBody ClinicAddress clinicAddress,
                                        HttpSession session, ModelMap model) {
        if (clinicAddress != null && clinicAddress.getPatientID() > 0) {
            if (formService.saveClinicDetails(clinicAddress) != null) {
                model.put("patient", formService.getPatientDetails(clinicAddress.getPatientID()));
                return "patientForm";
            }
        } else {
            System.out.println("Unable to get the Details patientID:" + clinicAddress.getPatientID());
            model.put("errorMessage", "Failed to get the Details");
        }
        return "clinicDetails";
    }

    @RequestMapping(value = {"saveClinicDetails.action"}, method = RequestMethod.POST)
    public String saveClinicDetails(@RequestBody ClinicAddress clinicAddress,
                                    HttpSession session, ModelMap model) {
        model.put("clinicAddress", formService.saveClinicDetails(clinicAddress));
        return "clinicDetails";
    }

    @RequestMapping(value = {"nextClinicDetails.action"}, method = RequestMethod.POST)
    public String nextClinicDetails(@RequestBody ClinicAddress clinicAddress,
                                    HttpSession session, ModelMap model) {
        try {
            if (formService.saveClinicDetails(clinicAddress) != null) {
                SectionA sectionA = new SectionA();
                sectionA.setPatientID(clinicAddress.getPatientID());
                sectionA.setPatientName(clinicAddress.getPatientName());
                model.put("sectionA", sectionA);
                return "sectionA";
            } else {
                return "clinicDetails";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = {"previousSectionA.action"}, method = RequestMethod.POST)
    public String previousSectionA(@RequestBody SectionA sectionA,
                                   HttpSession session, ModelMap model) {
        if (formService.saveSectionA(sectionA) != null) {
            ClinicAddress clinicAddress = formService.getClinicDetails(sectionA.getPatientID());
            if (clinicAddress != null) {
                clinicAddress.setPatientName(sectionA.getPatientName());
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
        model.put("sectionA", formService.saveSectionA(sectionA));
        return "sectionA";
    }

    @RequestMapping(value = {"nextSectionA.action"}, method = RequestMethod.POST)
    public String nextSectionADetails(@RequestBody SectionA sectionA,
                                      HttpSession session, ModelMap model) {
        if (formService.saveSectionA(sectionA) != null) {
            NonInvasive nonInvasive = new NonInvasive();
            nonInvasive.setPatientID(sectionA.getPatientID());
            nonInvasive.setPatientName(sectionA.getPatientName());
            model.put("nonInvasive", nonInvasive);
            model.put("diagnoseDetails", NonInvasive.getDiagnoseDetails());
            model.put("procedures", NonInvasive.getProcedures());
            return "nonInvasive";
        } else {
            return "sectionA";
        }
    }

    @RequestMapping(value = {"previousNonInvasiveDetails.action"}, method = RequestMethod.POST)
    public String previousNonInvasiveDetails(@RequestBody NonInvasive nonInvasive,
                                             HttpSession session, ModelMap model) {
        if (formService.saveNonInvasiveDetails(nonInvasive) != null) {
            model.put("sectionA", formService.getSectionADetails(nonInvasive.getPatientID()));
            return "sectionA";
        } else {
            return "nonInvasive";
        }
    }


    @RequestMapping(value = {"saveNonInvasiveDetails.action"}, method = RequestMethod.POST)
    public String saveNonInvasiveDetails(@RequestBody NonInvasive nonInvasive,
                                         HttpSession session, ModelMap model) {
        model.put("nonInvasive", formService.saveNonInvasiveDetails(nonInvasive));
        return "nonInvasive";
    }

    @RequestMapping(value = {"nextNonInvasiveDetails.action"}, method = RequestMethod.POST)
    public String nextNonInvasiveDetails(@RequestBody NonInvasive nonInvasive,
                                         HttpSession session, ModelMap model) {

        if (formService.saveNonInvasiveDetails(nonInvasive) != null) {
            Invasive invasive = new Invasive();
            invasive.setPatientName(nonInvasive.getPatientName());
            invasive.setPatientID(nonInvasive.getPatientID());
            model.put("diagnosisBasis", Invasive.getDiagnosisBasis());
            model.put("diagnosisIndication",
                    Invasive.getDiagnosisIndication());
            model.put("invasiveProcedures",
                    Invasive.getInvasiveProcedures());
            model.put("invasive", invasive);
            return "invasive";
        } else {
            return "nonInvasive";
        }
    }

    @RequestMapping(value = {"previousInvasiveDetails.action"}, method = RequestMethod.POST)
    public String previousInvasiveDetails(@RequestBody Invasive invasive,
                                          HttpSession session, ModelMap model) {
        if (formService.saveInvasiveDetails(invasive) != null) {
            model.put("nonInvasive", formService.getNonInvasiveDetails(invasive.getPatientID()));
            return "nonInvasive";
        } else {
            return "invasive";
        }
    }

    @RequestMapping(value = {"saveInvasiveDetails.action"}, method = RequestMethod.POST)
    public String saveInvasiveDetails(@RequestBody Invasive invasive,
                                      HttpSession session, ModelMap model) {
        model.put("invasive", formService.saveInvasiveDetails(invasive));
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
    public String saveDeclaration(@RequestBody Declaration declaration,
                                  HttpSession session, ModelMap model, HttpServletRequest request) {
        if (declaration.getPatientID() > 0) {
            if (formService.saveDeclarationDetails(declaration) != null) {
                File patientExcelFile = downloadService.downloadForm(declaration.getPatientID(), request, session);
                if (patientExcelFile != null) {
                    Patient patient = patientService.searchPatientById(declaration.getPatientID());
                    if (patient != null) {
                        patient.setFormFDownloadPath(patientExcelFile.getAbsolutePath());
                        patientService.createPatientRecord(patient);
                    } else {
                        model.put("result", "Failed to get the Patient Details...");
                    }
                    model.put("result", "Saved Patient Details in the Excel File Successfully");
                } else {
                    model.put("result", "Failed to Save Patient Details in the Excel File...");
                }
            } else {
                model.put("result", "Failed in saving the Patient Details ");
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
}
