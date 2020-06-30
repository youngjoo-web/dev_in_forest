package com.devinforest.vo;

public class Answer {
	private int answerNo;
	private int questionNo;
	private String memberName;
	private String answerContent;
	private String answerCreatedate;
	private String answerUpdatedate;
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
	public String getAnswerCreatedate() {
		return answerCreatedate;
	}
	public void setAnswerCreatedate(String answerCreatedate) {
		this.answerCreatedate = answerCreatedate;
	}
	public String getAnswerUpdatedate() {
		return answerUpdatedate;
	}
	public void setAnswerUpdatedate(String answerUpdatedate) {
		this.answerUpdatedate = answerUpdatedate;
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
				+ ", answerContent=" + answerContent + ", answerCreatedate=" + answerCreatedate + ", answerUpdatedate="
				+ answerUpdatedate + ", answerIp=" + answerIp + "]";
	}
	
	
	
}
