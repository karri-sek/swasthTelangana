package com.snlabs.aarogyatelangana.account.controller;

import java.util.Calendar;

import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.spring.SessionCounterListener;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReportController {

    @RequestMapping(value = {"/", "logout.action"}, method = RequestMethod.POST)
    public String logout(ModelMap model, HttpSession session) {
        session.invalidate();
        return "loginredirect";
    }

    @RequestMapping(value = {"/", "home.action"}, method = RequestMethod.GET)
    public String loginpage(ModelMap model, HttpServletRequest request) {
    	
        HttpSession session = request.getSession(false);
        if(session != null){
        	session.removeAttribute("loginError");
            if (session.getAttribute("userDetails") != null) {
                return "workdesk";
            }
        }
    	
        return "home";
    }

    @RequestMapping(value = {"patiantentry.action"}, method = RequestMethod.POST)
    public String patiantentry(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model, HttpSession session) {
        model.put("loginID", userDetails.getLoginId());
        return "patiententry";
    }
   
    @RequestMapping(value = {"totalfinancereport.action"}, method = RequestMethod.POST)
    public String totalfinancereport(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap modelMap) {
        return "totalfinancereport";
    }

    @RequestMapping(value = {"formf.action"}, method = RequestMethod.POST)
    public String formf(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "formf";
    }

    @RequestMapping(value = {"formfreport.action"}, method = RequestMethod.POST)
    public String formfreport(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "formfreport";
    }

    @RequestMapping(value = {"userAccounttab.action"}, method = RequestMethod.POST)
    public String userAccount(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "useraccountlhn";
    }

    @RequestMapping(value = {"accountmanagementtab.action"}, method = RequestMethod.POST)
    public String accountmanagement(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "accountmanagementlhn";
    }

    @RequestMapping(value = {"backtohome.action"}, method = RequestMethod.POST)
    public String backtohome(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "backtohome";
    }

    @RequestMapping(value = {"createaccount.action"}, method = RequestMethod.POST)
    public String createaccount(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "createaccount";
    }

    @RequestMapping(value = {"newpatiententrytab.action"}, method = RequestMethod.POST)
    public String newpatiententrytab(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "patiententrylhn";
    }

    @RequestMapping(value = {"formftab.action"}, method = RequestMethod.POST)
    public String formftab(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "formflhn";
    }

    @RequestMapping(value = {"underconstruction.action"}, method = RequestMethod.POST)
    public String underconstruction(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap model) {
        return "underconstruction";
    }

    @RequestMapping(value = {"mtpPatientNameReportDetails.action"}, method = RequestMethod.POST)
    public String viewMTPPatientNameReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "mtpPatientNameReport";
    }
    
    @RequestMapping(value = {"mtpPatientContactReportDetails.action"}, method = RequestMethod.POST)
    public String viewMTPPatientContactReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "mtpPatientContactReport";
    }
    
    @RequestMapping(value = {"mtpPatientAadharReportDetails.action"}, method = RequestMethod.POST)
    public String viewMTPPatientAadharReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "mtpPatientAadharReport";
    }

    @RequestMapping(value = {"mtpPatientIdReportDetails.action"}, method = RequestMethod.POST)
    public String viewMTPPatientIdReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "mtpPatientIdReport";
    }

    @RequestMapping(value = {"mtpFormIdReportDetails.action"}, method = RequestMethod.POST)
    public String viewMTPFormIdReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "formIdReport";
    }
    
    
    @RequestMapping(value = {"patientNameReportDetails.action"}, method = RequestMethod.POST)
    public String viewPatientNameReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "patientNameReport";
    }
    
    @RequestMapping(value = {"patientContactReportDetails.action"}, method = RequestMethod.POST)
    public String viewPatientContactReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "patientContactReport";
    }
    
    @RequestMapping(value = {"patientAadharReportDetails.action"}, method = RequestMethod.POST)
    public String viewPatientAadharReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "patientAadharReport";
    }

    @RequestMapping(value = {"patientIdReportDetails.action"}, method = RequestMethod.POST)
    public String viewPatientIdReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "patientIdReport";
    }

    @RequestMapping(value = {"formIdReportDetails.action"}, method = RequestMethod.POST)
    public String viewFormIdReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "formIdReport";
    }
    
    @RequestMapping(value = {"formDateReportDetails.action"}, method = RequestMethod.POST)
    public String viewDateRangeReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map, HttpSession session) {
    	java.util.Date utilDate = new java.util.Date();
        java.sql.Date toDate = new java.sql.Date(utilDate.getTime());
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        java.sql.Date fromDate = new java.sql.Date(cal.getTimeInMillis());
        
        session.setAttribute("fromDate", fromDate);
        session.setAttribute("toDate", toDate);
    	return "formDateReport";
    }
    
    @RequestMapping(value = {"mtpFormDateReportDetails.action"}, method = RequestMethod.POST)
    public String viewMTPDateRangeReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map, HttpSession session) {
    	java.util.Date utilDate = new java.util.Date();
        java.sql.Date toDate = new java.sql.Date(utilDate.getTime());
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        java.sql.Date fromDate = new java.sql.Date(cal.getTimeInMillis());
        
        session.setAttribute("fromDate", fromDate);
        session.setAttribute("toDate", toDate);
    	return "mtpFormDateReport";
    }
    
    @RequestMapping(value = {"birthReportNameReportDetails.action"}, method = RequestMethod.POST)
    public String viewBirthReportNameReportDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "birthreport/birthNameReport";
    }
    
    @RequestMapping(value = {"birthReportContactReportDetails.action"}, method = RequestMethod.POST)
    public String viewBirthReportContactReportDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "birthreport/birthContactReport";
    }
    
    @RequestMapping(value = {"birthReportAadharReportDetails.action"}, method = RequestMethod.POST)
    public String viewBirthReportAadharReportDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "birthreport/birthAadharReport";
    }

    @RequestMapping(value = {"birthReportIdReportDetails.action"}, method = RequestMethod.POST)
    public String viewBirthReportIdReportDetails(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "birthreport/birthIdReport";
    }
    
    @RequestMapping(value = {"birthReportsByDate.action"}, method = RequestMethod.POST)
    public String viewListBirthReportsByDate(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "birthreport/birthDateReport";
    }
    
    @RequestMapping(value = {"loggedInUserCount.action"}, method = RequestMethod.POST)
    public String getLoggedInUserCount(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
    	int loggedInUserCount = SessionCounterListener.getTotalActiveSession();
    	map.addAttribute("loggedInUserCount", loggedInUserCount);
        return "loggedInUserView";
    }
    
    @ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }
}