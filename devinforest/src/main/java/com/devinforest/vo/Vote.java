package com.devinforest.vo;

public class Vote {
	private int voteNo;
	private int questionNo;
	private int answerNo;
	private String memberName;
	private int votePoint;
	public int getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
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
	public int getVotePoint() {
		return votePoint;
	}
	public void setVotePoint(int votePoint) {
		this.votePoint = votePoint;
	}
	@Override
	public String toString() {
		return "Vote [voteNo=" + voteNo + ", questionNo=" + questionNo + ", answerNo=" + answerNo + ", memberName="
				+ memberName + ", votePoint=" + votePoint + "]";
	}
	
	
}
