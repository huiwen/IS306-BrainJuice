package com.example.brainjuice.entity;

import java.util.ArrayList;

public class PendingAcceptanceMgr {
	ArrayList<PendingAcceptance> pendingAcceptanceList;
	
	public PendingAcceptanceMgr(){
		pendingAcceptanceList = new ArrayList<PendingAcceptance>();
		
		pendingAcceptanceList.add(new PendingAcceptance("JonathanTan", 
				"What is the phase of the moon?", 
				"MelissaTan", 
				"The changing shape of the bright part of the Moon that we see is called its phase."));
		
		pendingAcceptanceList.add(new PendingAcceptance("JonathanTan", 
				"What causes part of the Moon to be lit up?", 
				"JackyWong", 
				"The moon is illuminated because it reflects the light from the sun. The part of the moon facing the sun is lit up. The part facing away from the sun is in darkness."));
		
		pendingAcceptanceList.add(new PendingAcceptance("JudyChoo", 
				"What causes the different phases of the Moon?", 
				"MelissaTan", 
				"The phases of the Moon depend on its position in relation to the Sun and Earth. As the Moon makes its way around the Earth, we see the bright parts of the Moon's surface at different angles. These are called 'phases' of the Moon."));	
	}
	
	public ArrayList<PendingAcceptance> retrievePAcListAdult(String userLogin){
		ArrayList<PendingAcceptance> pAc = new ArrayList<PendingAcceptance>();
		for(PendingAcceptance temp: pendingAcceptanceList){
			if(temp.getUserReplied().equals(userLogin)){
				pAc.add(temp);
			}
		}
		return pAc;
	}
	
	public ArrayList<PendingAcceptance> retrievePAcListChild(String userLogin){
		ArrayList<PendingAcceptance> pAc = new ArrayList<PendingAcceptance>();
		for(PendingAcceptance temp: pendingAcceptanceList){
			if(temp.getUserAsked().equals(userLogin)){
				pAc.add(temp);
			}
		}
		return pAc;
	}
	
	public void add(String userAsked, String qn, String userReplied, String answer){
		pendingAcceptanceList.add(new PendingAcceptance(userAsked, qn, userReplied, answer));
	}
	
	public void add(PendingAnswer pa, String userReplied, String answer){
		add(pa.getUserAsked(), pa.getQn(), userReplied, answer);
	}
	
	public void delete(String userAsked, String qn, String userReplied, String answer){
		for(PendingAcceptance temp: pendingAcceptanceList){
			if(temp.getQn().equals(qn) && temp.getAnswer().equals(answer) && temp.getUserAsked().equals(userAsked) && temp.getUserReplied().equals(userReplied)){
				pendingAcceptanceList.remove(temp);
				break;
			}
		}
	}
}
