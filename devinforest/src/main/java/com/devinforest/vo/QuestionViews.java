package com.devinforest.vo;

public class QuestionViews {
	private int questionViewsNo;
	private int questionNo;
	private String memberNo;
	public int getQuestionViewsNo() {
		return questionViewsNo;
	}
	public void setQuestionViewsNo(int questionViewsNo) {
		this.questionViewsNo = questionViewsNo;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "QuestionViews [questionViewsNo=" + questionViewsNo + ", questionNo=" + questionNo + ", memberNo="
				+ memberNo + "]";
	}
	
}
