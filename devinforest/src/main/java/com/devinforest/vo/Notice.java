package com.devinforest.vo;

public class Notice {
	private int noticeNo;
	private String adminName;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private String noticeIp;
	
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
	
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", adminName=" + adminName + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", noticeIp=" + noticeIp + "]";
	}
}
