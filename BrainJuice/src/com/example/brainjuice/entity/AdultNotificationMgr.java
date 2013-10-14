package com.example.brainjuice.entity;

import java.util.ArrayList;

public class AdultNotificationMgr {
	ArrayList<AdultNotification> adultNotificationList;
	
	public AdultNotificationMgr(){
		adultNotificationList = new ArrayList<AdultNotification>();
		
		adultNotificationList.add(new AdultNotification("JonathanTan",
				"How does water get from the roots to the top of the tree?",
				"MelissaTan",
				"Transpiration is a key part to the transport system of a plant. Inside a tree, water is pulled from the roots up to the leaves through a network of microscopic tubes called xylem made up of dead cells that have holes at either ends that are joined together to make hollow tubes that water can flow through."));
		
		adultNotificationList.add(new AdultNotification("JonathanTan",
				"How does a circuit card work?",
				"JackyWong",
				"Wires carry electric current. A circuit card is just a place to put a lot of wires. Electricity must flow in a path from somewhere, to somewhere, like a circle. That is where the word “circuit” in “circuit card” comes from. The direction flow of the current is indicated by the positive sign (+) and negative sign (-) of a battery."));
		
		adultNotificationList.add(new AdultNotification("JudyChoo",
				"Why the sky is blue?",
				"JackyWong", 
				"A clear cloudless day-time sky is blue because molecules in the air scatter blue light from the sun more than they scatter red light.  When we look towards the sun at sunset, we see red and orange colours because the blue light has been scattered out and away from the line of sight."));
	}
	
	public void add(String userAsked, String qn, String userReplied, String answer){
		adultNotificationList.add(new AdultNotification(userAsked, qn, userReplied, answer));
	}
	
	public ArrayList<AdultNotification> retrieveAdultNotification(String userLogin){
		ArrayList<AdultNotification> an = new ArrayList<AdultNotification>();
		
		for(AdultNotification temp: adultNotificationList){
			if(temp.getUserReplied().equals(userLogin)){
				an.add(temp);
			}
		}
		return an;
	}
	
	public void delete(String userAsked, String qn, String userReplied, String answer){
		for(AdultNotification temp: adultNotificationList){
			if(temp.getQn().equals(qn) && temp.getAnswer().equals(answer) && temp.getUserAsked().equals(userAsked) && temp.getUserReplied().equals(userReplied)){
				adultNotificationList.remove(temp);
				break;
			}
			
		}
	}
}
