package com.devinforest.vo;

public class BlackList {
	private String memberEmail;
	private String memberName;
	private String blackListReason;
	private String blackListDate;
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBlackListReason() {
		return blackListReason;
	}
	public void setBlackListReason(String blackListReason) {
		this.blackListReason = blackListReason;
	}
	public String getBlackListDate() {
		return blackListDate;
	}
	public void setBlackListDate(String blackListDate) {
		this.blackListDate = blackListDate;
	}
	
	@Override
	public String toString() {
		return "BlackList [memberEmail=" + memberEmail + ", memberName=" + memberName + ", blackListReason="
				+ blackListReason + ", blackListDate=" + blackListDate + "]";
	}
}
