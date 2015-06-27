package com.snlabs.aarogyatelangana.account.controller;

import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ReportController {

    @RequestMapping(value = {"/", "logout.action"}, method = RequestMethod.POST)
    public String logout(ModelMap model, HttpSession session) {
        session.invalidate();
        return "loginredirect";
    }

    @RequestMapping(value = {"/", "home.action"}, method = RequestMethod.GET)
    public String loginpage(ModelMap model, HttpSession session) {
        if (session.getAttribute("userDetails") != null) {
            return "workdesk";
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

    @RequestMapping(value = {"patientNameReportDetails.action"}, method = RequestMethod.POST)
    public String viewPatientNameReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "patientNameReport";
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
    public String viewDateRangeReportOptions(@SessionParam(value = "userDetails") UserDetails userDetails, ModelMap map) {
        return "formDateReport";
    }

    @ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }
}