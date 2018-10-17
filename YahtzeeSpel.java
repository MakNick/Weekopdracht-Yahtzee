package Weekopdracht02Yahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
	ArrayList<Speler> spelers = new ArrayList<>();
	int[] blokkeerArray = {0,0,0,0,0};
	int iteratorBlokkeerArray;
	Speler speler = new Speler();
	boolean doorspelen = true;
	
	YahtzeeSpel(){
		for(int i = 0; i < 5; i++){
			dobbelstenen.add(new Dobbelsteen());
		}
	}
	
	void spelen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Welkom bij Yahtzee!\nDruk op enter om te spelen, druk op 'q' om te stoppen.");
		String invoer = sc.nextLine();
			if(invoer.equals("q")){
				doorspelen = false;
			}

		while(doorspelen) {	
			while(speler.aantalWorpen < speler.maxAantalWorpen){
				werpDobbelstenen();
				System.out.println("\nDruk op 'p' om de worp op te slaan.\n");
				System.out.println("of selecteer welke dobbelstenen je wilt vasthouden.\nType '0' voor geen, anders bijvoorbeeld positie '13'");
				invoer = sc.next();
				if(invoer.equals("p")){
					opslaanWorp();
					speler.toonWorpGeschiedenis();
					speler.aantalWorpen = 0;
					System.out.println("");
				} else {
					vasthouden(invoer);
				}
			}
			opslaanWorp();
			speler.toonWorpGeschiedenis();
			speler.aantalWorpen = 0;
			System.out.println("");
		}		
	}
	
	
	void vasthouden(String invoerVasthouden) {
		resetBlokkeerArray();
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
	
	void opslaanWorp(){
		Worp worp = new Worp();
		for(int q = 0; q < dobbelstenen.size(); q++){
			worp.setWorpUitslag(dobbelstenen.get(q).ogenWorp, q);
		}
		speler.setWorpGeschiedenis(worp);
	}
	
	void werpDobbelstenen() {
		speler.aantalWorpen++;
		System.out.println("Worp " + speler.aantalWorpen + ":");
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
		iteratorBlokkeerArray = 0;
	}
}		

