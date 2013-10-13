package com.example.brainjuice.entity;

import java.util.ArrayList;

public class AdultNotificationMgr {
	ArrayList<AdultNotification> adultNotificationList;
	
	public AdultNotificationMgr(){
		adultNotificationList = new ArrayList<AdultNotification>();
		
		adultNotificationList.add(new AdultNotification("JonathanTan",
				"How does water get from the roots to the top of the tree?",
				"MelissaTan",
				"Transpiration is a key part to the transport system of a plant. Inside a tree, water is pulled from the roots up to the leaves through a network of microscopic tubes called xylem made up of dead cells that have holes at either ends that are joined together to make hollow tubes that water can flow through.",
				true));
		
		adultNotificationList.add(new AdultNotification("JonathanTan",
				"Why does metal sink and ice float when place in a water?",
				"MelissaTan",
				"This is due to the density of substances. The denser the substance, the lower it will be located. In your case, there are three matters, mainly the metal, ice and water. Metal is the densest and therefore, it sinks. For ice, it is the least dense, that is why it floats on water. ",
				false));
		
		adultNotificationList.add(new AdultNotification("JonathanTan",
				"Why the dog licks?",
				"JackyWong",
				"The dog feel they are dirty.",
				false));
		
		adultNotificationList.add(new AdultNotification("JudyChoo",
				"Why the sky is blue?",
				"JackyWong", 
				"A clear cloudless day-time sky is blue because molecules in the air scatter blue light from the sun more than they scatter red light.  When we look towards the sun at sunset, we see red and orange colours because the blue light has been scattered out and away from the line of sight.", 
				true));
	}
	
	public void add(String userAsked, String qn, String userReplied, String answer, boolean like){
		adultNotificationList.add(new AdultNotification(userAsked, qn, userReplied, answer, like));
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
