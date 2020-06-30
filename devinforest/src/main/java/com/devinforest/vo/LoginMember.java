package com.devinforest.vo;

public class LoginMember {
	private String memberEmail;
	private String memberName;
	private String memberPassword;
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
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	@Override
	public String toString() {
		return "LoginMember [memberEmail=" + memberEmail + ", memberName=" + memberName + ", memberPassword="
				+ memberPassword + "]";
	}
}
