package com.devinforest.vo;

public class AnswerBack {
	private int answerNo;
	private int memberName;
	private String answerTitle;
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
	public int getMemberName() {
		return memberName;
	}
	public void setMemberName(int memberName) {
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
	public String getAnswerIp() {
		return answerIp;
	}
	public void setAnswerIp(String answerIp) {
		this.answerIp = answerIp;
	}
	@Override
	public String toString() {
		return "AnswerBack [answerNo=" + answerNo + ", memberName=" + memberName + ", answerTitle=" + answerTitle
				+ ", answerContent=" + answerContent + ", answerCreatedate=" + answerCreatedate + ", answerUpdatedate="
				+ answerUpdatedate + ", answerIp=" + answerIp + "]";
	}
	
	
}
