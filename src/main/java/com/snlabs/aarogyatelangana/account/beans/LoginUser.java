package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

public class LoginUser implements Serializable{

    private static final long serialVersionUID = 3637043732438320538L;

	public String userName;
	
	public String password;
	
	public String value_no;

	public String getValue_no() {
		return value_no;
	}

	public void setValue_no(String value_no) {
		this.value_no = value_no;
	}

	public LoginUser() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
