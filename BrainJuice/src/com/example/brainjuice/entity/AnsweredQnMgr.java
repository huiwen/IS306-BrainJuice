package com.example.brainjuice.entity;

import java.util.ArrayList;

import android.util.Log;

public class AnsweredQnMgr {
	ArrayList<AnsweredQn> answeredQnList;
	
	public AnsweredQnMgr(){
		answeredQnList = new ArrayList<AnsweredQn>();
		
		answeredQnList.add(new AnsweredQn("JonathanTan",
				"How does water get from the roots to the top of the tree?",
				"MelissaTan",
				"Transpiration is a key part to the transport system of a plant. Inside a tree, water is pulled from the roots up to the leaves through a network of microscopic tubes called xylem made up of dead cells that have holes at either ends that are joined together to make hollow tubes that water can flow through.",
				true));
		
		answeredQnList.add(new AnsweredQn("JonathanTan",
				"Why does metal sink and ice float when place in a water?",
				"MelissaTan",
				"This is due to the density of substances. The denser the substance, the lower it will be located. In your case, there are three matters, mainly the metal, ice and water. Metal is the densest and therefore, it sinks. For ice, it is the least dense, that is why it floats on water. ",
				false));
		
		answeredQnList.add(new AnsweredQn("JonathanTan",
				"Why the dog licks?",
				"JackyWong",
				"The dog feel they are dirty.",
				false));
		
		answeredQnList.add(new AnsweredQn("JonathanTan",
				"How does a circuit card work?",
				"JackyWong",
				"Wires carry electric current. A circuit card is just a place to put a lot of wires. Electricity must flow in a path from somewhere, to somewhere, like a circle. That is where the word “circuit” in “circuit card” comes from. The direction flow of the current is indicated by the positive sign (+) and negative sign (-) of a battery.",
				true));
		
		answeredQnList.add(new AnsweredQn("JonathanTan",
				"My shoes get worn out after walking for more than six months. How did it happen?",
				"JackyWong",
				"Friction is the force resisting the relative motion of solid surfaces (can be fluid layers etc.). Your shoes and the ground is the relative lateral motion of two solid surfaces in contact. As such, your shoes get worn out.", 
				true));
		
		answeredQnList.add(new AnsweredQn("JonathanTan",
				"My shoes get worn out after walking for more than six months. How did it happen?",
				"MelissaTan",
				"Your shoe is not in good quality", 
				false));
		
		answeredQnList.add(new AnsweredQn("JudyChoo",
				"What is a biological lifecycle? Do you have an example?", 
				"MelissaTan", 
				"The definition of biological lifecycle is the series of changes in the life of an organism, including reproduction. In layman terms, it shows the different stages of a living thing from the day it is born to the day it dies in a repeated cycle.", 
				true));
		
		answeredQnList.add(new AnsweredQn("JudyChoo",
				"Why the sky is blue?",
				"JackyWong", 
				"A clear cloudless day-time sky is blue because molecules in the air scatter blue light from the sun more than they scatter red light.  When we look towards the sun at sunset, we see red and orange colours because the blue light has been scattered out and away from the line of sight.", 
				true));
	}
	
	public void add(String userAsked, String qn, String userReplied, String answer, boolean like){
		answeredQnList.add(new AnsweredQn(userAsked, qn, userReplied, answer, like));
	}
	
	public ArrayList<AnsweredQn> retrieveQnBank(String userLogin){
		ArrayList<AnsweredQn> aq = new ArrayList<AnsweredQn>();
		for(AnsweredQn temp: answeredQnList){
			if(temp.getUserAsked().equals(userLogin)){
				aq.add(temp);
			}
		}
		return aq;
	}
	
	public ArrayList<AnsweredQn> retrieveAcceptedAnswerBank(String userLogin){
		ArrayList<AnsweredQn> aq = new ArrayList<AnsweredQn>();
		
		for(AnsweredQn temp: answeredQnList){
			if(temp.getUserReplied().equals(userLogin) && temp.isLike()){
				aq.add(temp);
			}
		}
		return aq;
	}
	
	public ArrayList<AnsweredQn> retrieveRejectAnswerBank(String userLogin){
		ArrayList<AnsweredQn> aq = new ArrayList<AnsweredQn>();
		
		for(AnsweredQn temp: answeredQnList){
			if(temp.getUserReplied().equals(userLogin) && !temp.isLike()){
				aq.add(temp);
			}
		}
		return aq;
	}
}
