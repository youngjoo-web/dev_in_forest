package com.devinforest.vo;

public class Notice {
	private int noticeNo;
	private String adminName;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private String noticeIp;
	private String noticeKind;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeIp() {
		return noticeIp;
	}
	public void setNoticeIp(String noticeIp) {
		this.noticeIp = noticeIp;
	}
	public String getNoticeKind() {
		return noticeKind;
	}
	public void setNoticeKind(String noticeKind) {
		this.noticeKind = noticeKind;
	}
	
	@Override
	public String toString() {
		return "Notice \n[noticeNo=" + noticeNo + ",\n adminName=" + adminName + ",\n noticeTitle=" + noticeTitle
				+ ",\n noticeContent=" + noticeContent + ",\n noticeDate=" + noticeDate + ",\n noticeIp=" + noticeIp
				+ ",\n noticeKind=" + noticeKind + "]";
	}

}
