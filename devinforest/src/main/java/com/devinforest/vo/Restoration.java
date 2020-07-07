package com.devinforest.vo;

public class Restoration {
	private int restorationNo;
	private String restorationTitle;
	private String restorationContent;
	private String restorationDate;
	private String inquiryKind;
	
	public int getRestorationNo() {
		return restorationNo;
	}
	public void setRestorationNo(int restorationNo) {
		this.restorationNo = restorationNo;
	}
	public String getRestorationTitle() {
		return restorationTitle;
	}
	public void setRestorationTitle(String restorationTitle) {
		this.restorationTitle = restorationTitle;
	}
	public String getRestorationContent() {
		return restorationContent;
	}
	public void setRestorationContent(String restorationContent) {
		this.restorationContent = restorationContent;
	}
	public String getRestorationDate() {
		return restorationDate;
	}
	public void setRestorationDate(String restorationDate) {
		this.restorationDate = restorationDate;
	}
	public String getInquiryKind() {
		return inquiryKind;
	}
	public void setInquiryKind(String inquiryKind) {
		this.inquiryKind = inquiryKind;
	}
	
	@Override
	public String toString() {
		return "Restoration [restorationNo=" + restorationNo + ", restorationTitle=" + restorationTitle
				+ ", restorationContent=" + restorationContent + ", restorationDate=" + restorationDate
				+ ", inquiryKind=" + inquiryKind + "]";
	}
}
