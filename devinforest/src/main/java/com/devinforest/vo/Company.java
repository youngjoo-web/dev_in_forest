package com.devinforest.vo;

public class Company {
	private String companyEmail;
	private String companyPw;
	private String companyKorName;
	private String companyEngName;
	private String companyType;
	private String companyAddress;
	private String companyPhone;
	private String companyLicense;
	private String companyLink;
	private String companyCEO;
	private int companySales;
	private int companyEmployees;
	private String companyAbout;
	private String companyFoundation;
	private String companyDate;
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
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
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
	public String getCompanyLicense() {
		return companyLicense;
	}
	public void setCompanyLicense(String companyLicense) {
		this.companyLicense = companyLicense;
	}
	public String getCompanyLink() {
		return companyLink;
	}
	public void setCompanyLink(String companyLink) {
		this.companyLink = companyLink;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public int getCompanySales() {
		return companySales;
	}
	public void setCompanySales(int companySales) {
		this.companySales = companySales;
	}
	public int getCompanyEmployees() {
		return companyEmployees;
	}
	public void setCompanyEmployees(int companyEmployees) {
		this.companyEmployees = companyEmployees;
	}
	public String getCompanyAbout() {
		return companyAbout;
	}
	public void setCompanyAbout(String companyAbout) {
		this.companyAbout = companyAbout;
	}
	public String getCompanyFoundation() {
		return companyFoundation;
	}
	public void setCompanyFoundation(String companyFoundation) {
		this.companyFoundation = companyFoundation;
	}
	public String getCompanyDate() {
		return companyDate;
	}
	public void setCompanyDate(String companyDate) {
		this.companyDate = companyDate;
	}
	@Override
	public String toString() {
		return "Company [companyEmail=" + companyEmail + ", companyPw=" + companyPw + ", companyKorName="
				+ companyKorName + ", companyEngName=" + companyEngName + ", companyType=" + companyType
				+ ", companyAddress=" + companyAddress + ", companyPhone=" + companyPhone + ", companyLicense="
				+ companyLicense + ", companyLink=" + companyLink + ", companyCEO=" + companyCEO + ", companySales="
				+ companySales + ", companyEmployees=" + companyEmployees + ", companyAbout=" + companyAbout
				+ ", companyFoundation=" + companyFoundation + ", companyDate=" + companyDate + "]";
	}
}
