package com.devinforest.vo;

public class Restoration {
	private  String restorationTitle;
	private String restorationContent;
	public String getRestorationTitle() {
		return restorationTitle;
	}
	public void setRestorationTitle(String restorationTitle) {
		this.restorationTitle = restorationTitle;
	}
	public String getRestorationContent() {
		return restorationContent;
	}
	public void setRestorationContent(String restorationContent) {
		this.restorationContent = restorationContent;
	}
	@Override
	public String toString() {
		return "Restoration [restorationTitle=" + restorationTitle + ", restorationContent=" + restorationContent + "]";
	}
	
}
