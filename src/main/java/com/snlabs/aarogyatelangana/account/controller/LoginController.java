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

import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.NewUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.exceptions.LoginRequiredException;
import com.snlabs.aarogyatelangana.account.service.AccountService;
import com.snlabs.aarogyatelangana.account.spring.SessionParam;
import com.snlabs.aarogyatelangana.account.utils.AccountUtils;

@Controller
public class LoginController {

    static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public AccountService accountService;

    private AccountUtils accountUtils = new AccountUtils();

    @RequestMapping(value = {"loginsubmission.action"} ,method = RequestMethod.POST)
    public String loginsubmission(@RequestBody LoginUser loginUser, HttpSession session, ModelMap modelMap) {

        LOGGER.info("loginsubmission-> ", loginUser.getUserName() +":"+session.getId());

        loginUser.setPassword(accountUtils.md5(loginUser.getPassword()));

        UserDetails userDetails = accountService.getAccountDetails(loginUser);

        session.setAttribute("userDetails", userDetails);

        if(userDetails != null){
            session.setAttribute("userDetails", userDetails);
            return "workdeskfirstlogin";
        }
        session.setAttribute("userName", loginUser.getUserName());
        //session.setAttribute("loginError", " Invalid ID or password, please try again.");
        return "homeerror";
    }

    @RequestMapping(value = {"createaccountsubmission.action"} ,method = RequestMethod.POST)
    public String createaccountsubmission(@SessionParam(value="userDetails") UserDetails userDetails, @RequestBody NewUser user, ModelMap model, HttpSession session) {
        //Show patient entry form, Log the request.

        String hashedPassword = accountUtils.md5(user.getPassword());
        user.setPassword(hashedPassword);

        boolean result = accountService.createAccount(user, userDetails);

        String view = null;
        view = result?"createaccountsubmissionsuccess":"createaccountsubmissionfail";

        return view;
    }

    @RequestMapping(value = {"updateaccount.action"} ,method = RequestMethod.POST)
    public String updateaccount(@SessionParam(value="userDetails") UserDetails userDetails, ModelMap model) {
        //Show patient entry form, Log the request.
        return "updateaccount";
    }

    @RequestMapping(value = {"updateaccountsubmission.action"} ,method = RequestMethod.POST)
    public String updateaccountsubmission(@SessionParam(value="userDetails") UserDetails userDetails, @RequestBody NewUser user, ModelMap model) {
        //Show patient entry form, Log the request.

        String hashedPassword = accountUtils.md5(user.getPassword());
        user.setPassword(hashedPassword);

        boolean result = accountService.updateAccount(user);

        String view = null;
        view = result?"updateaccountsubmissionsuccess":"updateaccountsubmissionfail";

        return view;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @ExceptionHandler(LoginRequiredException.class)
    public String handleLoginRequiredException(LoginRequiredException ex) {
        return "loginredirect";
    }

    public static void main(String[] args) {
        AccountUtils accUtils = new AccountUtils();
        String hashedPassword = accUtils.md5("Nag");
        System.out.println(hashedPassword);
    }

}