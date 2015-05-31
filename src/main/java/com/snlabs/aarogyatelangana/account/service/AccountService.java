
package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.NewUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;


public interface AccountService {
	
	public boolean createAccount(NewUser user, UserDetails userDetails);
	
	public UserDetails getAccountDetails(LoginUser user);

    public boolean updateAccount(NewUser user);
	
	
}
