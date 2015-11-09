package com.snlabs.aarogyatelangana.account.beans;
import java.io.Serializable;
public class NewUser implements Serializable {

    private static final long serialVersionUID = -6643127944902034726L;
    public String loginId;
    public String displayName;
    public String userRole;
    public String password;
    public String conPassword;
    public String mobileNumber;
    public String district;
    public String state;
    
    private String type;
    private ClinicAddress clinicAddress;
    
    public boolean isPasswordsSame(){
    	return password.equals(conPassword);
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ClinicAddress getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(ClinicAddress clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	@Override
	public String toString() {
		return "NewUser [loginId=" + loginId + ", displayName=" + displayName
				+ ", userRole=" + userRole + ", password=" + password
				+ ", conPassword=" + conPassword + ", mobileNumber="
				+ mobileNumber + ", district=" + district + ", state=" + state
				+ ", type=" + type + ", clinicAddress=" + clinicAddress + "]";
	}

}