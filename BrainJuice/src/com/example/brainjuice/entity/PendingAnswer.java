package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAnswer {
	private String userAsked;
	private String qn;
	

	public PendingAnswer(String userAsked, String qn) {
		super();
		this.userAsked = userAsked;
		this.qn = qn;
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
	
}
