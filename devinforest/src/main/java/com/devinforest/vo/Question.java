package com.devinforest.vo;

public class Question {
	private int questionNo;
	private String memberName;
	private String questionTitle;
	private String questionContent;
	private int questionReputation;
	private String questionCreateDate;
	private String questionUpdateDate;
	private int questionViews;
	private int questionNumOfAnswers;
	private int questionNumOfVotes;
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
	public int getQuestionReputation() {
		return questionReputation;
	}
	public void setQuestionReputation(int questionReputation) {
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
	public int getQuestionViews() {
		return questionViews;
	}
	public void setQuestionViews(int questionViews) {
		this.questionViews = questionViews;
	}
	public int getQuestionNumOfAnswers() {
		return questionNumOfAnswers;
	}
	public void setQuestionNumOfAnswers(int questionNumOfAnswers) {
		this.questionNumOfAnswers = questionNumOfAnswers;
	}
	public int getQuestionNumOfVotes() {
		return questionNumOfVotes;
	}
	public void setQuestionNumOfVotes(int questionNumOfVotes) {
		this.questionNumOfVotes = questionNumOfVotes;
	}
	public String getQuestionIp() {
		return questionIp;
	}
	public void setQuestionIp(String questionIp) {
		this.questionIp = questionIp;
	}
	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", memberName=" + memberName + ", questionTitle=" + questionTitle
				+ ", questionContent=" + questionContent + ", questionReputation=" + questionReputation
				+ ", questionCreateDate=" + questionCreateDate + ", questionUpdateDate=" + questionUpdateDate
				+ ", questionViews=" + questionViews + ", questionNumOfAnswers=" + questionNumOfAnswers
				+ ", questionNumOfVotes=" + questionNumOfVotes + ", questionIp=" + questionIp + "]";
	}
}
