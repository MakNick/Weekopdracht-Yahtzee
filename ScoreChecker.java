package Weekopdracht02Yahtzee;

import java.util.ArrayList;

public class ScoreChecker {
	ArrayList <Integer> enen = new ArrayList<Integer>();  
	ArrayList <Integer> tweeen = new ArrayList<Integer>(); 
	ArrayList <Integer> drieen = new ArrayList<Integer>(); 
	ArrayList <Integer> vieren = new ArrayList<Integer>(); 
	ArrayList <Integer> vijfen = new ArrayList<Integer>(); 
	ArrayList <Integer> zessen = new ArrayList<Integer>();
	
	boolean categorieCheck;
		
	void vulScoreChecker(ArrayList<Dobbelsteen> dobbelsteen){
		enen.clear();
		tweeen.clear();
		drieen.clear();
		vieren.clear();
		vijfen.clear();
		zessen.clear();
		categorieCheck = true;
		for(int i = 0; i < dobbelsteen.size(); i++) {
			if(dobbelsteen.get(i).ogenWorp == 1) {
				enen.add(1);
			}
			else if(dobbelsteen.get(i).ogenWorp == 2) {
				tweeen.add(1);
			}
			else if(dobbelsteen.get(i).ogenWorp == 3) {
				drieen.add(1);
			}
			else if(dobbelsteen.get(i).ogenWorp == 4) {
				vieren.add(1);
			}
			else if(dobbelsteen.get(i).ogenWorp == 5) {
				vijfen.add(1);
			}
			else if(dobbelsteen.get(i).ogenWorp == 6) {
				zessen.add(1);
			}
		}
	}
	
	String setScore(){
		Scorekaart.scorekaart[1][1] = Integer.toString((enen.size() * 1));
		return Integer.toString((enen.size() * 1));
	}

	
	void toonScoreCategorie(ArrayList<Speler> spelers){
		System.out.println();
		//Scores tweede categorie
				if(enen.size() >= 3 || tweeen.size() >= 3 || drieen.size() >= 3 || vieren.size() >= 3 || vijfen.size() >= 3 || zessen.size() >= 3) {
					System.out.println("Three of a kind!");
					categorieCheck = false;
					spelers.get(0).scores.add((enen.size()*1) + (tweeen.size()*2) + (drieen.size()*3) + (vieren.size()*4) + (vijfen.size()*5) + (zessen.size())*6);
				}	
				
				if(enen.size() >= 4 || tweeen.size() >= 4 || drieen.size() >= 4 || vieren.size() >= 4 || vijfen.size() >= 4 || zessen.size() >= 4) {
					System.out.println("Four of a kind!");
					categorieCheck = false;
					spelers.get(0).scores.add((enen.size()*1) + (tweeen.size()*2) + (drieen.size()*3) + (vieren.size()*4) + (vijfen.size()*5) + (zessen.size())*6);
				}
			
				if(enen.size() == 5 || tweeen.size() == 5 || drieen.size() == 5 || vieren.size() == 5 || vijfen.size() == 5 || zessen.size() == 5) {
					System.out.println("Yahtzee!");
					categorieCheck = false;
					spelers.get(0).scores.add(50);
				}
				
				if(enen.size() == 3 || tweeen.size() == 3 || drieen.size() == 3 || vieren.size() == 3 || vijfen.size() == 3 || zessen.size() == 3) {
					if(enen.size() == 2 || tweeen.size() == 2 || drieen.size() == 2 || vieren.size() == 2 || vijfen.size() == 2 || zessen.size() == 2) {	
						System.out.println("Full house!");
						categorieCheck = false;
						spelers.get(0).scores.add(25);

					}
				}	
				
				if(enen.size() == 1 && tweeen.size() == 1 && drieen.size() == 1 && vieren.size() == 1 && vijfen.size() == 1){
					System.out.println("Grote straat!");
					categorieCheck = false;
					spelers.get(0).scores.add(40);
				}
				else if(tweeen.size() == 1 && drieen.size() == 1 && vieren.size() == 1 && vijfen.size() == 1 && zessen.size() == 1) {
					System.out.println("Grote straat!");
					categorieCheck = false;
					spelers.get(0).scores.add(40);
				}
				
				if(enen.size() >= 1 && tweeen.size() >= 1 && drieen.size() >= 1 && vieren.size() >= 1) {
					System.out.println("Kleine straat!");
					categorieCheck = false;
					spelers.get(0).scores.add(30);
				}
				else if(tweeen.size() >= 1 && drieen.size() >= 1 && vieren.size() >= 1 && vijfen.size() >= 1) {
					System.out.println("Kleine straat!");			
					categorieCheck = false;
					spelers.get(0).scores.add(30);
				}
				else if(drieen.size() >= 1 && vieren.size() >= 1 && vijfen.size() >= 1 && zessen.size() >= 1) {
					System.out.println("Kleine straat!");
					categorieCheck = false;
					spelers.get(0).scores.add(30);
			}
		//Scores eerste categorie
		if(categorieCheck){
			if(enen.size() > 0){
				System.out.println("Score enen  : " + (enen.size() * 1));
			}
			if(tweeen.size() > 0){
				System.out.println("Score tweeen: " + (tweeen.size() * 2));
			}
			if(drieen.size() > 0){
				System.out.println("Score drieen: " + (drieen.size() * 3));
			}
			if(vieren.size() > 0){
				System.out.println("Score vieren: " + (vieren.size() * 4));
			}
			if(vijfen.size() > 0){
				System.out.println("Score vijfen: " + (vijfen.size() * 5));
			}
			if(zessen.size() > 0){
				System.out.println("Score zessen: " + (zessen.size() * 6));
			}
		}
	}
}