package com.devinforest.vo;


public class QuestionBack {
	private int questionNo;
	private String memberName;
	private String questionTitle;
	private String questionContent;
	private String questionReputation;
	private String questionCreateDate;
	private String questionUpdateDate;
	private String questionContentBackDate;
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
	public String getQuestionReputation() {
		return questionReputation;
	}
	public void setQuestionReputation(String questionReputation) {
		this.questionReputation = questionReputation;
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
	public String getQuestionContentBackDate() {
		return questionContentBackDate;
	}
	public void setQuestionContentBackDate(String questionContentBackDate) {
		this.questionContentBackDate = questionContentBackDate;
	}
	public String getQuestionIp() {
		return questionIp;
	}
	public void setQuestionIp(String questionIp) {
		this.questionIp = questionIp;
	}
	
	@Override
	public String toString() {
		return "QuestionBack [questionNo=" + questionNo + ", memberName=" + memberName + ", questionTitle="
				+ questionTitle + ", questionContent=" + questionContent + ", questionReputation=" + questionReputation
				+ ", questionCreateDate=" + questionCreateDate + ", questionUpdateDate=" + questionUpdateDate
				+ ", questionContentBackDate=" + questionContentBackDate + ", questionIp=" + questionIp + "]";
	}
}

