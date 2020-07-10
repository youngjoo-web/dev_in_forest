package com.devinforest.vo;

public class Answer {
	private int answerNo;
	private int questionNo;
	private String memberName;
	private String answerContent;
	private String answerCreateDate;
	private String answerUpdateDate;
	private String answerIp;
	
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
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
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerCreateDate() {
		return answerCreateDate;
	}
	public void setAnswerCreateDate(String answerCreateDate) {
		this.answerCreateDate = answerCreateDate;
	}
	public String getAnswerUpdateDate() {
		return answerUpdateDate;
	}
	public void setAnswerUpdateDate(String answerUpdateDate) {
		this.answerUpdateDate = answerUpdateDate;
	}
	public String getAnswerIp() {
		return answerIp;
	}
	public void setAnswerIp(String answerIp) {
		this.answerIp = answerIp;
	}
	
	@Override
	public String toString() {
		return "Answer [answerNo=" + answerNo + ", questionNo=" + questionNo + ", memberName=" + memberName
				+ ", answerContent=" + answerContent + ", answerCreateDate=" + answerCreateDate + ", answerUpdateDate="
				+ answerUpdateDate + ", answerIp=" + answerIp + "]";
	}
}
