
package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.NewUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;

public interface AccountDao {


    public boolean createAccount(NewUser user, UserDetails userDetails);

	public UserDetails getAccountDetails(LoginUser user);

    public boolean updateAccount(NewUser user);

}
