package com.devinforest.vo;

public class AnswerComment {
	private int answerCommentNo;
	private int questionNo;
	private int answerNo;
	private String memberName;
	private String answerCommentContent;
	private String answerCommentDate;
	private String answerCommentIp;
	public int getAnswerCommentNo() {
		return answerCommentNo;
	}
	public void setAnswerCommentNo(int answerCommentNo) {
		this.answerCommentNo = answerCommentNo;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAnswerCommentContent() {
		return answerCommentContent;
	}
	public void setAnswerCommentContent(String answerCommentContent) {
		this.answerCommentContent = answerCommentContent;
	}
	public String getAnswerCommentDate() {
		return answerCommentDate;
	}
	public void setAnswerCommentDate(String answerCommentDate) {
		this.answerCommentDate = answerCommentDate;
	}
	public String getAnswerCommentIp() {
		return answerCommentIp;
	}
	public void setAnswerCommentIp(String answerCommentIp) {
		this.answerCommentIp = answerCommentIp;
	}
	@Override
	public String toString() {
		return "AnswerComment [answerCommentNo=" + answerCommentNo + ", questionNo=" + questionNo + ", answerNo="
				+ answerNo + ", memberName=" + memberName + ", answerCommentContent=" + answerCommentContent
				+ ", answerCommentDate=" + answerCommentDate + ", answerCommentIp=" + answerCommentIp + "]";
	}
}