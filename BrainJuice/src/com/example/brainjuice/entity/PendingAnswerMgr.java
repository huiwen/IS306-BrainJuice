package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAnswerMgr {
	ArrayList<PendingAnswer> pendingAnswerList;
	
	public PendingAnswerMgr(){
		pendingAnswerList = new ArrayList<PendingAnswer>();
		
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why do people need to sleep?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why are gifts being exchanged during Christmas?"));
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("MelissaTan");
		pendingAnswerList.add(new PendingAnswer("JudyChoo", "Where does the baby come from?"));
		pendingAnswerList.add(new PendingAnswer("JudyChoo",	"Why does the moon seem to follow me wherever I go?"));
		pendingAnswerList.add(new PendingAnswer("JudyChoo", "Why I cannot remember my dream?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Where does the sun rise?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why does metal sink and ice float when place in a water?", temp));
		temp.remove(0);
		temp.add("JackWong");
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why the dog licks?", temp));

	}
	
	//new user ask a qn
	public void addNew(String username, String qn){
		pendingAnswerList.add(new PendingAnswer(username, qn));
	}
	
	//the qn is answered
	public void delete(String username, String qn){
		for(int i = 0; i < pendingAnswerList.size(); i++){
			PendingAnswer pendingAnswer = pendingAnswerList.get(i);
			if(pendingAnswer.getUserAsked().equals(username) && pendingAnswer.getQn().equals(qn)){
				pendingAnswerList.remove(i);
				break;
			}
		}
	}
	
	//the person has answered this qn and being rejected
	public boolean canAnswer(String userAsked, String qn, String userLogin){
		PendingAnswer pa = null;
		for(PendingAnswer temp: pendingAnswerList){
			if(temp.getUserAsked().equals(userAsked) && temp.getQn().equals(qn)){
				pa = temp;
				break;
			}
		}
		
		if(pa != null){
			ArrayList<String> userRejectedList = pa.getComment();
			for(String user: userRejectedList){
				if(user.equals(userLogin)){
					return false;
				}
			}
		}
		return true;
	}
	
	//initialize the first qn to user
	public PendingAnswer answer(String userLogin){
		for(PendingAnswer pa: pendingAnswerList){
			if(canAnswer(pa.getUserAsked(),pa.getQn(),userLogin)){
				return pa;
			}
		}
		return null;
	}
	
	//The answer for this qn has been rejected, this qn need to be added back to pending answer list.
	public void beingRejected(String userAsked, String qn, String userReplied, ArrayList<String> comment){
		comment.add(userReplied);
		pendingAnswerList.add(new PendingAnswer(userAsked, qn, comment));
	}
	
	public void add(PendingAnswer pa){
		pendingAnswerList.add(pa);
	}
	
	//Ask for another qn
	public PendingAnswer anotherQn(String userAsked, String qn, String userLogin){
		int position = -1;
		for(int i = 0; i < pendingAnswerList.size(); i++){
			PendingAnswer pa = pendingAnswerList.get(i);
			if(pa.getUserAsked().equals(userAsked) && pa.getQn().equals(qn)){
				position = i;
				break;
			}
		}
		if(position != -1){
			for(int i = position + 1; i < pendingAnswerList.size();i++){
				PendingAnswer pa = pendingAnswerList.get(i);
				if(canAnswer(pa.getUserAsked(), pa.getQn(), userLogin)){
					return pa;
				}
			}
		}
		return null;
	}
	
	//retrieve penging answer list for the login user
	public ArrayList<PendingAnswer> retrievePAList(String userLogin){
		ArrayList<PendingAnswer> paList = new ArrayList<PendingAnswer>();
		for(PendingAnswer pa: pendingAnswerList){
			if(pa.getUserAsked().equals(userLogin)){
				paList.add(pa);
			}
		}
		return paList;
	}
}
