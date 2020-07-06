package com.devinforest.vo;

public class Inquiry {
	private int inquiryNo;
	private String memberName;
	private String inquiryTitle;
	private String inquiryContent;
	private String inquiryDate;
	private String inquiryKind;
	private String inquiryAnswer;
	private String inquiryState;
	
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getInquiryTitle() {
		return inquiryTitle;
	}
	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public String getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getInquiryKind() {
		return inquiryKind;
	}
	public void setInquiryKind(String inquiryKind) {
		this.inquiryKind = inquiryKind;
	}
	public String getInquiryAnswer() {
		return inquiryAnswer;
	}
	public void setInquiryAnswer(String inquiryAnswer) {
		this.inquiryAnswer = inquiryAnswer;
	}
	public String getInquiryState() {
		return inquiryState;
	}
	public void setInquiryState(String inquiryState) {
		this.inquiryState = inquiryState;
	}
	
	@Override
	public String toString() {
		return "Inquiry [inquiryNo=" + inquiryNo + ", memberName=" + memberName + ", inquiryTitle=" + inquiryTitle
				+ ", inquiryContent=" + inquiryContent + ", inquiryDate=" + inquiryDate + ", inquiryKind=" + inquiryKind
				+ ", inquiryAnswer=" + inquiryAnswer + ", inquiryState=" + inquiryState + "]";
	}
}
