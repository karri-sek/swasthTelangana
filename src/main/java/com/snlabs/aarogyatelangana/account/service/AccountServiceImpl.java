package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.LoginUser;
import com.snlabs.aarogyatelangana.account.beans.NewUser;
import com.snlabs.aarogyatelangana.account.beans.UserDetails;
import com.snlabs.aarogyatelangana.account.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

    public AccountDao accountDao;

    public AccountServiceImpl() {

    }

    @Override
    public boolean createAccount(NewUser user) {
        return accountDao.createAccount(user);
    }

    @Override
    public UserDetails getAccountDetails(LoginUser user) {

        return accountDao.getAccountDetails(user);
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


}
