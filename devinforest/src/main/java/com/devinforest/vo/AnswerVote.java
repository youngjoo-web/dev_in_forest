package com.devinforest.vo;

public class AnswerVote {
	private int answerVoteNo;
	private int answerNo;
	private String memberName;
	private int votePoint;
	public int getAnswerVoteNo() {
		return answerVoteNo;
	}
	public void setAnswerVoteNo(int answerVoteNo) {
		this.answerVoteNo = answerVoteNo;
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
		return "AnswerVote [answerVoteNo=" + answerVoteNo + ", answerNo=" + answerNo + ", memberName=" + memberName
				+ ", votePoint=" + votePoint + "]";
	}
}
