package com.devinforest.vo;

public class Statistics {
	private int date;
	private int count;
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Statistics [date=" + date + ", count=" + count + "]";
	}
}
