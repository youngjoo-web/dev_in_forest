package com.devinforest.vo;

public class Hashtag {
	private int hashtagNo;
	private String hashtagName;
	private String hashtagContent;
	private String hashtagDate;
	public int getHashtagNo() {
		return hashtagNo;
	}
	public void setHashtagNo(int hashtagNo) {
		this.hashtagNo = hashtagNo;
	}
	public String getHashtagName() {
		return hashtagName;
	}
	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}
	public String getHashtagContent() {
		return hashtagContent;
	}
	public void setHashtagContent(String hashtagContent) {
		this.hashtagContent = hashtagContent;
	}
	public String getHashtagDate() {
		return hashtagDate;
	}
	public void setHashtagDate(String hashtagDate) {
		this.hashtagDate = hashtagDate;
	}
	@Override
	public String toString() {
		return "Hashtag [hashtagNo=" + hashtagNo + ", hashtagName=" + hashtagName + ", hashtagContent=" + hashtagContent
				+ ", hashtagDate=" + hashtagDate + "]";
	}
	
	
}
