package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAnswerMgr {
	ArrayList<PendingAnswer> pendingAnswerList;
	
	public PendingAnswerMgr(){
		pendingAnswerList = new ArrayList<PendingAnswer>();
		
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why do people need to sleep?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why are gifts being exchanged during Christmas?"));
		pendingAnswerList.add(new PendingAnswer("JudyChoo", "Where does the baby come from?"));
		pendingAnswerList.add(new PendingAnswer("JudyChoo",	"Why does the moon seem to follow me wherever I go?"));
		pendingAnswerList.add(new PendingAnswer("JudyChoo", "Why I cannot remember my dream?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Where does the sun rise?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why does metal sink and ice float when place in a water?"));
		pendingAnswerList.add(new PendingAnswer("JonathanTan", "Why the dog licks?"));

	}
	
	//new user ask a qn
	public void addNew(String username, String qn){
		pendingAnswerList.add(new PendingAnswer(username, qn));
	}
	
	//the qn is answered
	public void delete(String username, String qn){
		int position = -1;
		int positionToRemove = -1;
		for(int i = 0; i < pendingAnswerList.size(); i++){
			PendingAnswer pendingAnswer = pendingAnswerList.get(i);
			if(pendingAnswer.getUserAsked().equals(username) && pendingAnswer.getQn().equals(qn)){
				position = i;
				break;
			}
		}
		
		if(position == 0){
			positionToRemove = pendingAnswerList.size() - 1;
		} else {
			positionToRemove = position - 1;
		}
		
		pendingAnswerList.remove(positionToRemove);
	}
	
	public void delete(){
		if(pendingAnswerList.size() == 1){
			pendingAnswerList.remove(0);
		}
	}
	
	//initialize the first qn to user
	public PendingAnswer answer(String userLogin){
		if(pendingAnswerList.size() != 0){
			return pendingAnswerList.get(0);
		}
		return null;
	}
	
	
	public void add(PendingAnswer pa){
		pendingAnswerList.add(pa);
	}
	
	//Ask for another qn
	public PendingAnswer anotherQn(String userAsked, String qn){
		if(pendingAnswerList.size() != 0){
			int position = -1;
			for(int i = 0; i < pendingAnswerList.size(); i++){
				PendingAnswer pa = pendingAnswerList.get(i);
				if(pa.getUserAsked().equals(userAsked) && pa.getQn().equals(qn)){
					position = i;
					break;
				}
			}
			if(position != pendingAnswerList.size()-1){
				return pendingAnswerList.get(position+1);
			} else if(position == pendingAnswerList.size() - 1){
				return pendingAnswerList.get(0);
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
