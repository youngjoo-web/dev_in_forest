package com.devinforest.vo;

public class LoginAdmin {
	private String adminEmail;
	private String adminName;
	private String accountKind;
	
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAccountKind() {
		return accountKind;
	}
	public void setAccountKind(String accountKind) {
		this.accountKind = accountKind;
	}
	
	@Override
	public String toString() {
		return "LoginAdmin \n[adminEmail=" + adminEmail + ",\n adminName=" + adminName + ",\n accountKind=" + accountKind
				+ "]";
	}
}
