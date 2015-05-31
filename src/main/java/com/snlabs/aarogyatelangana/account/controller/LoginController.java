
package com.snlabs.aarogyatelangana.account.controller;

import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.NewUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.service.AccountService;
import com.snlabs.aarogyatelangana.account.utils.AccountUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public AccountService accountService;

    private AccountUtils accountUtils = new AccountUtils();

    @RequestMapping(value = {"loginsubmission.action"}, method = RequestMethod.POST)
    public String loginsubmission(@RequestBody LoginUser loginUser, HttpSession session, ModelMap modelMap) {

        LOGGER.info("loginsubmission-> ", loginUser.userName + ":" + session.getId());
        LOGGER.debug("loginsubmission-> before hash ", loginUser.userName + ":" + session.getId());
        loginUser.setPassword(accountUtils.md5(loginUser.getPassword()));
        LOGGER.debug("loginsubmission-> After hash", loginUser.userName + ":" + session.getId());
        UserDetails userDetails = accountService.getAccountDetails(loginUser);
        if (userDetails != null) {
            session.setAttribute("userDetails", userDetails);
            return "workdesk";
        }
        return "home";
    }

    /*@RequestMapping(value = {"logout.action"} ,method = RequestMethod.POST)
    public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		return "home";

	}
	*/

    @RequestMapping(value = {"createaccountsubmission.action"}, method = RequestMethod.POST)
    public String createaccountsubmission(@RequestBody NewUser user, ModelMap model, HttpSession session) {
        //Show patient entry form, Log the request.

        String hashedPassword = accountUtils.md5(user.getPassword());
        user.setPassword(hashedPassword);

        UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");

        boolean result = accountService.createAccount(user, userDetails);

        String view = null;
        view = result ? "createaccountsubmissionsuccess" : "createaccountsubmissionfail";

        return view;
    }

    @RequestMapping(value = {"updateaccount.action"}, method = RequestMethod.POST)
    public String updateaccount(ModelMap model) {
        // Show patient entry form, Log the request.
        return "updateaccount";
    }

    @RequestMapping(value = {"updateaccountsubmission.action"}, method = RequestMethod.POST)
    public String updateaccountsubmission(@RequestBody NewUser user, ModelMap model) {
        //Show patient entry form, Log the request.

        String hashedPassword = accountUtils.md5(user.getPassword());
        user.setPassword(hashedPassword);

        boolean result = accountService.updateAccount(user);

        String view = null;
        view = result ? "updateaccountsubmissionsuccess" : "updateaccountsubmissionfail";

        return view;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public static void main(String[] args) {
        AccountUtils accUtils = new AccountUtils();
        String hashedPassword = accUtils.md5("Nag");
        System.out.println(hashedPassword);
    }

}