package com.snlabs.aarogyatelangana.account.beans;


public class UserDetails {

    private String loginId;
    private String displayName;
    private String userRole;
    private String lastlogin;
    private String mobileNumber;
    private String district;
    private String state;
    
    private ClinicAddress clinicAddress;

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

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ClinicAddress getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(ClinicAddress clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	@Override
	public String toString() {
		return "UserDetails [loginId=" + loginId + ", displayName="
				+ displayName + ", userRole=" + userRole + ", lastlogin="
				+ lastlogin + ", mobileNumber=" + mobileNumber + ", district="
				+ district + ", state=" + state + ", clinicAddress="
				+ clinicAddress + "]";
	}

}