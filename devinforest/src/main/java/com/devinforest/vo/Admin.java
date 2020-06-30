package com.devinforest.vo;

public class Admin {
	private String adminEmail;
	private String adminPw;
	private String adminName;
	private String accountKind;
	private String adminDate;
	
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
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
	public String getAdminDate() {
		return adminDate;
	}
	public void setAdminDate(String adminDate) {
		this.adminDate = adminDate;
	}
	
	@Override
	public String toString() {
		return "Admin [adminEmail=" + adminEmail + ", adminPw=" + adminPw + ", adminName=" + adminName
				+ ", accountKind=" + accountKind + ", adminDate=" + adminDate + "]";
	}
}
