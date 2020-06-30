package com.devinforest.vo;


public class QuestionBack {
	private int questionNo;
	private String memberName;
	private String questionTitle;
	private String questionContent;
	private String questionCreateDate;
	private String questionUpdateDate;
	private String questionIp;
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getQuestionCreateDate() {
		return questionCreateDate;
	}
	public void setQuestionCreateDate(String questionCreateDate) {
		this.questionCreateDate = questionCreateDate;
	}
	public String getQuestionUpdateDate() {
		return questionUpdateDate;
	}
	public void setQuestionUpdateDate(String questionUpdateDate) {
		this.questionUpdateDate = questionUpdateDate;
	}
	public String getQuestionIp() {
		return questionIp;
	}
	public void setQuestionIp(String questionIp) {
		this.questionIp = questionIp;
	}
	@Override
	public String toString() {
		return "QuestionCommentBack [questionNo=" + questionNo + ", memberName=" + memberName + ", questionTitle="
				+ questionTitle + ", questionContent=" + questionContent + ", questionCreateDate=" + questionCreateDate
				+ ", questionUpdateDate=" + questionUpdateDate + ", questionIp=" + questionIp + "]";
	}
	
	
}

