package com.devinforest.vo;

public class LoginCompany {
	private String companyEmail;
	private String companyPw;
	private String companyKorName;
	private String companyEngName;
	private String companyAddress;
	private String companyPhone;
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyPw() {
		return companyPw;
	}
	public void setCompanyPw(String companyPw) {
		this.companyPw = companyPw;
	}
	public String getCompanyKorName() {
		return companyKorName;
	}
	public void setCompanyKorName(String companyKorName) {
		this.companyKorName = companyKorName;
	}
	public String getCompanyEngName() {
		return companyEngName;
	}
	public void setCompanyEngName(String companyEngName) {
		this.companyEngName = companyEngName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	@Override
	public String toString() {
		return "LoginCompany [companyEmail=" + companyEmail + ", companyPw=" + companyPw + ", companyKorName="
				+ companyKorName + ", companyEngName=" + companyEngName + ", companyAddress=" + companyAddress
				+ ", companyPhone=" + companyPhone + "]";
	}
	
}
