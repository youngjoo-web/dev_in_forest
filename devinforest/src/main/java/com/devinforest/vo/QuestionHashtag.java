package com.devinforest.vo;

public class QuestionHashtag {
	private int questionNo;
	private String hashtagName;
	private String memberName;
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getHashtagName() {
		return hashtagName;
	}
	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "QuestionHashtag [questionNo=" + questionNo + ", hashtagName=" + hashtagName + ", memberName="
				+ memberName + "]";
	}
	
	
}
