package com.devinforest.vo;

public class Report {
	private int reportNo;
	private String memberName;
	private String reportMemberName;
	private int questionNo;
	private int questionCommentNo;
	private int answerNo;
	private int answerCommentNo;
	private String reportKind;
	private String reportTitle;
	private String reportContent;
	private String reportDate;
	private String reportState;
	
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getReportMemberName() {
		return reportMemberName;
	}
	public void setReportMemberName(String reportMemberName) {
		this.reportMemberName = reportMemberName;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public int getQuestionCommentNo() {
		return questionCommentNo;
	}
	public void setQuestionCommentNo(int questionCommentNo) {
		this.questionCommentNo = questionCommentNo;
	}
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public int getAnswerCommentNo() {
		return answerCommentNo;
	}
	public void setAnswerCommentNo(int answerCommentNo) {
		this.answerCommentNo = answerCommentNo;
	}
	public String getReportKind() {
		return reportKind;
	}
	public void setReportKind(String reportKind) {
		this.reportKind = reportKind;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportState() {
		return reportState;
	}
	public void setReportState(String reportState) {
		this.reportState = reportState;
	}
	
	@Override
	public String toString() {
		return "Report [\nreportNo=" + reportNo + ",\n memberName=" + memberName + ",\n reportMemberName=" + reportMemberName
				+ ",\n questionNo=" + questionNo + ",\n questionCommentNo=" + questionCommentNo + ",\n answerNo=" + answerNo
				+ ",\n answerCommentNo=" + answerCommentNo + ",\n reportKind=" + reportKind + ",\n reportTitle=" + reportTitle
				+ ",\n reportContent=" + reportContent + ",\n reportDate=" + reportDate + ",\n reportState=" + reportState
				+ "]";
	}
}
