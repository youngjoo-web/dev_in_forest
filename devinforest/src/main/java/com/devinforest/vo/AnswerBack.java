package com.devinforest.vo;

public class AnswerBack {
	private int answerNo;
	private String memberName;
	private String answerTitle;
	private String answerContent;
	private String answerCreatedate;
	private String answerUpdatedate;
	private String answerBackDate;
	
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
	public String getAnswerTitle() {
		return answerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
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
	public String getAnswerBackDate() {
		return answerBackDate;
	}
	public void setAnswerBackDate(String answerBackDate) {
		this.answerBackDate = answerBackDate;
	}
	
	@Override
	public String toString() {
		return "AnswerBack [answerNo=" + answerNo + ", memberName=" + memberName + ", answerTitle=" + answerTitle
				+ ", answerContent=" + answerContent + ", answerCreatedate=" + answerCreatedate + ", answerUpdatedate="
				+ answerUpdatedate + ", answerBackDate=" + answerBackDate + "]";
	}
}
