package Weekopdracht02Yahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Speler> spelers = new ArrayList<>();
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
	
	ScoreChecker scoreChecker = new ScoreChecker();
	Scorekaart scorekaart = new Scorekaart();
	
	int[] blokkeerArray = {0,0,0,0,0};
	int iteratorBlokkeerArray;
	boolean doorspelen = true;
	int maxAantalBeurten = 6;
	
	YahtzeeSpel(){
		for(int i = 0; i < 5; i++){
			dobbelstenen.add(new Dobbelsteen());
		}
	}
		
	void spelen(){
		toevoegenSpelers();
	
		while(doorspelen) {	
			outerloop:
			for(int beurtenIndex = 0; beurtenIndex <= maxAantalBeurten; beurtenIndex++){
				if(beurtenIndex == maxAantalBeurten){
					doorspelen = false;
					break outerloop;
				}
				for(int spelerIndex = 0; spelerIndex < spelers.size(); spelerIndex++){
					spelers.get(spelerIndex).aantalWorpen = 0;
					while(spelers.get(spelerIndex).aantalWorpen < Speler.maxAantalWorpen){
						if(spelers.get(spelerIndex).aantalWorpen == 2){
							laatsteWorp(spelerIndex, beurtenIndex);
						} else {
							vervolgWorp(spelerIndex, beurtenIndex);
							String invoer = sc.next();
							if(invoer.equals("p")){
								opslaanWorp(spelerIndex);
								spelers.get(spelerIndex).aantalWorpen = 3;
								System.out.println("");
							} else if (invoer.equals("q")){
								System.out.println("Spel beëindigd");
								doorspelen = false;
								break outerloop;
							} else {
								vasthouden(invoer);
							}						
						}
					}
				}	
			}		
		}
		toonEindScores();
		scorekaart.vulBasisKaart(spelers);
		scorekaart.toonKaart(spelers);
		opnieuwSpelen();
	}
	
	void vasthouden(String invoerVasthouden) {
		for(int i = 0; i < invoerVasthouden.length(); i++){
			int blokkeerIndex = Integer.parseInt(Character.toString(invoerVasthouden.charAt(i)));  //Character.toString om parseInt(string) werkend te krijgen
			if(blokkeerIndex > 0 && blokkeerIndex < 6){
				blokkeerArray[blokkeerIndex-1] = 1;
			} 
		}
	}
	
	void resetBlokkeerArray(){
		iteratorBlokkeerArray = 0;
		for(int x = 0; x < blokkeerArray.length; x++){
			blokkeerArray[x] = 0;
		}
	}
	
	void opslaanWorp(int a){
		Worp worp = new Worp();
		for(int q = 0; q < dobbelstenen.size(); q++){
			worp.setWorpUitslag(dobbelstenen.get(q).ogenWorp, q);
		}
		spelers.get(a).setWorpGeschiedenis(worp);
	}
	
	void werpDobbelstenen(int a, int b) {
		spelers.get(a).aantalWorpen++;
		System.out.println("\nWorp " + spelers.get(a).aantalWorpen + "/3 van beurt " + (b + 1) + "/" + maxAantalBeurten + " van " + spelers.get(a).naam + ":");
		for(Dobbelsteen dobbelsteen : dobbelstenen){
			if(blokkeerArray[iteratorBlokkeerArray] == 0){
				dobbelsteen.werpen();
				System.out.print(dobbelsteen);
				iteratorBlokkeerArray++;
			} else {
				System.out.print(dobbelsteen);
				iteratorBlokkeerArray++;
			}
		}
		resetBlokkeerArray();
	}
		
	void toevoegenSpelers(){
		System.out.println("Welkom bij Yahtzee!\n\nHoeveel spelers wil je toevoegen?");
		int aantalSpelers = sc.nextInt();
		sc.nextLine();
		for(int x = 0; x < aantalSpelers; x++){
			System.out.println("Speler " + (x+1) + " voer je naam in: ");
			Speler speler = new Speler();
			speler.naam = sc.nextLine();
			spelers.add(speler);
		}
	}
	
	void toonEindScores(){
		System.out.println("Dit is de worpgeschiedenis van alle spelers:");
		for(int i = 0; i < spelers.size(); i++){
			spelers.get(i).toonWorpGeschiedenis(i);
			System.out.println("");
		}
	}
	
	void opnieuwSpelen(){
		System.out.println("\n\nWil je opnieuw spelen?\nDruk 'j' voor ja.\nDruk 'n' om af te sluiten.");
		String invoerOpnieuw = sc.next();
		if(invoerOpnieuw.equals("j")){
			spelers.clear();
			doorspelen = true;
			System.out.println("\n\n\n");
			spelen();
		} else if (invoerOpnieuw.equals("n")){
			System.out.println("Spel afgesloten");
		}
	}	
	
	void toonScoreChecker(){
		scoreChecker.vulScoreChecker(dobbelstenen);
		scoreChecker.toonScoreCategorie();
	}
	
	void vervolgWorp(int a, int b){
		werpDobbelstenen(a, b);
		toonScoreChecker();
		System.out.println("\nDruk op 'p' om de worp op te slaan.\n");
		System.out.println("of selecteer welke dobbelstenen je wilt vasthouden.\nType '0' voor geen, anders bijvoorbeeld positie '13'");
		System.out.println("\nDruk op 'q' om af te sluiten.");
	}
	
	void laatsteWorp(int a, int b){
		werpDobbelstenen(a, b);
		toonScoreChecker();
		opslaanWorp(a);
		spelers.get(a).aantalWorpen = 3;
		System.out.println("");
	}
}		

