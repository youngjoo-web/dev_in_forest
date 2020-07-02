package com.devinforest.vo;

public class LoginCompany {
	private String companyEmail;
	private String companyPw;
	private String companyKorName;
	private String companyEngName;
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
	@Override
	public String toString() {
		return "LoginCompany [companyEmail=" + companyEmail + ", companyPw=" + companyPw + ", companyKorName="
				+ companyKorName + ", companyEngName=" + companyEngName + "]";
	}
}
