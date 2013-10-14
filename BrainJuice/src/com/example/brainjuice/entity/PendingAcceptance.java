package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAcceptance {
	private String userAsked;
	private String qn;
	private String userReplied;
	private String answer;
	
	public PendingAcceptance(String userAsked, String qn, String userReplied,
			String answer) {
		super();
		this.userAsked = userAsked;
		this.qn = qn;
		this.userReplied = userReplied;
		this.answer = answer;
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
}
