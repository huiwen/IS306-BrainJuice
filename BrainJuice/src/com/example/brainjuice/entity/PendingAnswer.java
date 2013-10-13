package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAnswer {
	private String userAsked;
	private String qn;
	private ArrayList<String> comment;
	
	public PendingAnswer(String userAsked, String qn, ArrayList<String> comment) {
		super();
		this.userAsked = userAsked;
		this.qn = qn;
		this.comment = comment;
	}

	public PendingAnswer(String userAsked, String qn) {
		super();
		this.userAsked = userAsked;
		this.qn = qn;
		this.comment = new ArrayList<String>();
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

	public ArrayList<String> getComment() {
		return comment;
	}

	public void setComment(ArrayList<String> comment) {
		this.comment = comment;
	}
	
	public void addComment(String userRejected){
		comment.add(userRejected);
	}
	
}
