package com.devinforest.vo;

public class Report {
	private int reportNo;
	private String memberName;
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
		return "Report [reportNo=" + reportNo + ", memberName=" + memberName + ", reportKind=" + reportKind
				+ ", reportTitle=" + reportTitle + ", reportContent=" + reportContent + ", reportDate=" + reportDate
				+ ", reportState=" + reportState + "]";
	}
}
