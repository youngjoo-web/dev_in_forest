package com.devinforest.vo;

public class Member {
	private String memberEmail;
	private String memberPassword;
	private String memberName;
	private String accountKind;
	private int memberReputation;
	private String memberLocation;
	private String memberPhone;
	private String memberLink;
	private String memberGender;
	private String memberAbout;
	private String memberBirth;
	private String memberDate;
	private String memberState;
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAccountKind() {
		return accountKind;
	}
	public void setAccountKind(String accountKind) {
		this.accountKind = accountKind;
	}
	public int getMemberReputation() {
		return memberReputation;
	}
	public void setMemberReputation(int memberReputation) {
		this.memberReputation = memberReputation;
	}
	public String getMemberLocation() {
		return memberLocation;
	}
	public void setMemberLocation(String memberLocation) {
		this.memberLocation = memberLocation;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberLink() {
		return memberLink;
	}
	public void setMemberLink(String memberLink) {
		this.memberLink = memberLink;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberAbout() {
		return memberAbout;
	}
	public void setMemberAbout(String memberAbout) {
		this.memberAbout = memberAbout;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}
	public String getMemberState() {
		return memberState;
	}
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}
	@Override
	public String toString() {
		return "Member [memberEmail=" + memberEmail + ", memberPassword=" + memberPassword + ", memberName="
				+ memberName + ", accountKind=" + accountKind + ", memberReputation=" + memberReputation
				+ ", memberLocation=" + memberLocation + ", memberPhone=" + memberPhone + ", memberLink=" + memberLink
				+ ", memberGender=" + memberGender + ", memberAbout=" + memberAbout + ", memberBirth=" + memberBirth
				+ ", memberDate=" + memberDate + ", memberState=" + memberState + "]";
	}
	
	
	
	
}
