package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAcceptance {
	private String userAsked;
	private String qn;
	private String userReplied;
	private String answer;
	private ArrayList<String> comment;
	
	public PendingAcceptance(String userAsked, String qn, String userReplied,
			String answer, ArrayList<String> comment) {
		super();
		this.userAsked = userAsked;
		this.qn = qn;
		this.userReplied = userReplied;
		this.answer = answer;
		this.comment = comment;
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
	public ArrayList<String> getComment() {
		return comment;
	}
	public void setComment(ArrayList<String> comment) {
		this.comment = comment;
	}
	
}
