package com.example.brainjuice.entity;

import java.util.ArrayList;

public class ChildNotificationMgr {
	ArrayList<ChildNotification> childNotificationList;
	
	public ChildNotificationMgr(){
		childNotificationList = new ArrayList<ChildNotification>();
		
		childNotificationList.add(new ChildNotification("JonathanTan", 
				"What is the phase of the moon?", 
				"MelissaTan", 
				"The changing shape of the bright part of the Moon that we see is called its phase."));
		
		childNotificationList.add(new ChildNotification("JonathanTan", 
				"What causes part of the Moon to be lit up?", 
				"JackyWong", 
				"The moon is illuminated because it reflects the light from the sun. The part of the moon facing the sun is lit up. The part facing away from the sun is in darkness."));
		
		childNotificationList.add(new ChildNotification("JudyChoo", 
				"What causes the different phases of the Moon?", 
				"MelissaTan", 
				"The phases of the Moon depend on its position in relation to the Sun and Earth. As the Moon makes its way around the Earth, we see the bright parts of the Moon's surface at different angles. These are called 'phases' of the Moon."));
	}
	
	public void add(String userAsked, String qn, String userReplied, String answer){
		childNotificationList.add(new ChildNotification(userAsked, qn, userReplied, answer));
	}
	
	public ArrayList<ChildNotification> retrieveChildNotification(String userLogin){
		ArrayList<ChildNotification> cn = new ArrayList<ChildNotification>();
		
		for(ChildNotification temp: childNotificationList){
			if(temp.getUserAsked().equals(userLogin)){
				cn.add(temp);
			}
		}
		return cn;
	}
	
	public void delete(String userAsked, String qn, String userReplied, String answer){
		for(ChildNotification temp: childNotificationList){
			if(temp.getQn().equals(qn) && temp.getAnswer().equals(answer) && temp.getUserAsked().equals(userAsked) && temp.getUserReplied().equals(userReplied)){
				childNotificationList.remove(temp);
				break;
			}
			
		}
	}
}
