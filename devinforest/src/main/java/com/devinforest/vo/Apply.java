package com.devinforest.vo;

public class Apply {
	private int recruitNo;
	private String memberEmail;
	private String companyEmail;
	private String applyDate;
	public int getRecruitNo() {
		return recruitNo;
	}
	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	@Override
	public String toString() {
		return "Apply [recruitNo=" + recruitNo + ", memberEmail=" + memberEmail + ", companyEmail=" + companyEmail
				+ ", applyDate=" + applyDate + "]";
	}
	
	
}
