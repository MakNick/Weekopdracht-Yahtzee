package Weekopdracht02Yahtzee;

import java.util.ArrayList;

public class ScoreChecker {
	ArrayList <Integer> enen = new ArrayList<Integer>();  
	ArrayList <Integer> tweeen = new ArrayList<Integer>(); 
	ArrayList <Integer> drieen = new ArrayList<Integer>(); 
	ArrayList <Integer> vieren = new ArrayList<Integer>(); 
	ArrayList <Integer> vijfen = new ArrayList<Integer>(); 
	ArrayList <Integer> zessen = new ArrayList<Integer>();
	
	boolean categorieCheck = false;
		
	void vulScoreChecker(ArrayList<Dobbelsteen> dobbelsteen){
		enen.clear();
		tweeen.clear();
		drieen.clear();
		vieren.clear();
		vijfen.clear();
		zessen.clear();
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

	
	void toonScoreCategorie(){
		System.out.println();
		//Scores eerste categorie
		if(enen.size() > 0){
			System.out.println("Score enen:   " + (enen.size() * 1));
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
		//Scores tweede categorie
		if(enen.size() >= 3 || tweeen.size() >= 3 || drieen.size() >= 3 || vieren.size() >= 3 || vijfen.size() >= 3 || zessen.size() >= 3) {
			System.out.println("Three of a kind!");
		}	
		
		if(enen.size() >= 4 || tweeen.size() >= 4 || drieen.size() >= 4 || vieren.size() >= 4 || vijfen.size() >= 4 || zessen.size() >= 4) {
			System.out.println("Four of a kind!");
		}
	
		if(enen.size() == 5 || tweeen.size() == 5 || drieen.size() == 5 || vieren.size() == 5 || vijfen.size() == 5 || zessen.size() == 5) {
			System.out.println("Yahtzee!");
		}
		
		if(enen.size() == 3 || tweeen.size() == 3 || drieen.size() == 3 || vieren.size() == 3 || vijfen.size() == 3 || zessen.size() == 3) {
			if(enen.size() == 2 || tweeen.size() == 2 || drieen.size() == 2 || vieren.size() == 2 || vijfen.size() == 2 || zessen.size() == 2) {	
			}
			System.out.println("Full house!");	
		}	
		
		if(enen.size() == 1 && tweeen.size() == 1 && drieen.size() == 1 && vieren.size() == 1 && vijfen.size() == 1){
			System.out.println("Grote straat!");
		}
		else if(tweeen.size() == 1 && drieen.size() == 1 && vieren.size() == 1 && vijfen.size() == 1 && zessen.size() == 1) {
			System.out.println("Grote straat!");
		}
		
		
		if(enen.size() >= 1 && tweeen.size() >= 1 && drieen.size() >= 1 && vieren.size() >= 1) {
			System.out.println("Kleine straat!");
		}
		else if(tweeen.size() >= 1 && drieen.size() >= 1 && vieren.size() >= 1 && vijfen.size() >= 1) {
			System.out.println("Kleine straat!");
		}
		else if(drieen.size() >= 1 && vieren.size() >= 1 && vijfen.size() >= 1 && zessen.size() >= 1) {
			System.out.println("Kleine straat!");
		}
	}
}