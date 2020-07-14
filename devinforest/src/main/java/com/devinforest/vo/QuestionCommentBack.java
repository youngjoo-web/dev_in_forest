package com.devinforest.vo;

public class QuestionCommentBack {
	private int questionCommentNo;
	private int questionNo;
	private String memberName;
	private String questionCommentContent;
	private String questionCommentDate;
	private String questionCommentBackDate;
	private String questionCommentIp;
	
	public int getQuestionCommentNo() {
		return questionCommentNo;
	}
	public void setQuestionCommentNo(int questionCommentNo) {
		this.questionCommentNo = questionCommentNo;
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
	public String getQuestionCommentContent() {
		return questionCommentContent;
	}
	public void setQuestionCommentContent(String questionCommentContent) {
		this.questionCommentContent = questionCommentContent;
	}
	public String getQuestionCommentDate() {
		return questionCommentDate;
	}
	public void setQuestionCommentDate(String questionCommentDate) {
		this.questionCommentDate = questionCommentDate;
	}
	public String getQuestionCommentBackDate() {
		return questionCommentBackDate;
	}
	public void setQuestionCommentBackDate(String questionCommentBackDate) {
		this.questionCommentBackDate = questionCommentBackDate;
	}
	public String getQuestionCommentIp() {
		return questionCommentIp;
	}
	public void setQuestionCommentIp(String questionCommentIp) {
		this.questionCommentIp = questionCommentIp;
	}
	
	@Override
	public String toString() {
		return "QuestionCommentBack [questionCommentNo=" + questionCommentNo + ", questionNo=" + questionNo
				+ ", memberName=" + memberName + ", questionCommentContent=" + questionCommentContent
				+ ", questionCommentDate=" + questionCommentDate + ", questionCommentBackDate="
				+ questionCommentBackDate + ", questionCommentIp=" + questionCommentIp + "]";
	}
}