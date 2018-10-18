package Weekopdracht02Yahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
	static ArrayList<Speler> spelers = new ArrayList<>();
	int[] blokkeerArray = {0,0,0,0,0};
	int iteratorBlokkeerArray;
	boolean doorspelen = true;
	int maxAantalBeurten = 13;
	
	YahtzeeSpel(){
		for(int i = 0; i < 5; i++){
			dobbelstenen.add(new Dobbelsteen());
		}
	}
		
	void spelen(){
		toevoegenSpelers();
//		System.out.println("\nDruk op enter om te spelen, druk op 'q' om te stoppen.");
//		String invoer = sc.nextLine();
//			if(invoer.equals("q")){
//				doorspelen = false;
//			}

		while(doorspelen) {	
			for(int beurtenIndex = 0; beurtenIndex < maxAantalBeurten; beurtenIndex++){
				for(int spelerIndex = 0; spelerIndex < spelers.size(); spelerIndex++){
					spelers.get(spelerIndex).aantalWorpen = 0;
					System.out.println(">" + spelers.get(0).aantalWorpen);
					System.out.println(">" + spelers.get(1).aantalWorpen);

					while(spelers.get(spelerIndex).aantalWorpen < spelers.get(spelerIndex).maxAantalWorpen){
						System.out.println("X" + spelers.get(0).aantalWorpen);
						System.out.println("X" + spelers.get(1).aantalWorpen);
						if(spelers.get(spelerIndex).aantalWorpen == 2){
							werpDobbelstenen(spelerIndex, beurtenIndex);
							opslaanWorp(spelerIndex);
							spelers.get(spelerIndex).toonWorpGeschiedenis(spelerIndex, beurtenIndex);
							spelers.get(spelerIndex).aantalWorpen = 3;
							System.out.println("");
						} else {
							werpDobbelstenen(spelerIndex, beurtenIndex);
							System.out.println("\nDruk op 'p' om de worp op te slaan.\n");
							System.out.println("of selecteer welke dobbelstenen je wilt vasthouden.\nType '0' voor geen, anders bijvoorbeeld positie '13'");
							String invoer = sc.next();
							if(invoer.equals("p")){
								opslaanWorp(spelerIndex);
								spelers.get(spelerIndex).toonWorpGeschiedenis(spelerIndex, beurtenIndex);
								spelers.get(spelerIndex).aantalWorpen = 3;
								System.out.println("");
							} else {
								vasthouden(invoer);
							}
						}
					}
				}
			}
		}		
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
		for(int x = 0; x < aantalSpelers; x++){
			System.out.println("Speler " + (x+1) + " voer je naam in: ");
			Speler speler = new Speler();
			speler.naam = sc.next();
			spelers.add(speler);
		}
	}
}		

