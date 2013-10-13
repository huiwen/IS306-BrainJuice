package com.example.brainjuice.entity;

public class AdultNotification {
	private String userAsked;
	private String qn;
	private String userReplied;
	private String answer;
	private boolean like;
	
	public AdultNotification(String userAsked, String qn, String userReplied,
			String answer, boolean like) {
		super();
		this.userAsked = userAsked;
		this.qn = qn;
		this.userReplied = userReplied;
		this.answer = answer;
		this.like = like;
	}
	
	public String getUserAsked() {
		return userAsked;
	}
	public void setUserAsked(String userAsked) {
		this.userAsked = userAsked;
	}
	public String getQn() {
		return qn;
	}
	public void setQn(String qn) {
		this.qn = qn;
	}
	public String getUserReplied() {
		return userReplied;
	}
	public void setUserReplied(String userReplied) {
		this.userReplied = userReplied;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	
	
}
