package com.devinforest.vo;

public class FAQ {
	private int faqNo;
	private String adminName;
	private String faqTitle;
	private String faqContent;
	private String faqDate;
	
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqDate() {
		return faqDate;
	}
	public void setFaqDate(String faqDate) {
		this.faqDate = faqDate;
	}
	
	@Override
	public String toString() {
		return "FAQ [faqNo=" + faqNo + ", adminName=" + adminName + ", faqTitle=" + faqTitle + ", faqContent="
				+ faqContent + ", faqDate=" + faqDate + "]";
	}
}
