package com.devinforest.vo;

public class Suggest {
	private int recruitNo;
	private String companyName;
	private String memberName;
	private String suggestContent;
	private String suggestType;
	private String lastUpdate;
	public int getRecruitNo() {
		return recruitNo;
	}
	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getSuggestContent() {
		return suggestContent;
	}
	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}
	public String getSuggestType() {
		return suggestType;
	}
	public void setSuggestType(String suggestType) {
		this.suggestType = suggestType;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Suggest [recruitNo=" + recruitNo + ", companyName=" + companyName + ", memberName=" + memberName
				+ ", suggestContent=" + suggestContent + ", suggestType=" + suggestType + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	
	
	
}
