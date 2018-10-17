package Weekopdracht02Yahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
	int[] blokkeerArray = {0,0,0,0,0};
	int iteratorBlokkeerArray;
	Speler speler = new Speler();
	
	YahtzeeSpel(){
		for(int i = 0; i < 5; i++){
			dobbelstenen.add(new Dobbelsteen());
		}
	}
	
	void spelen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Druk op enter om te spelen, druk op 'q' om te stoppen.");
		
		while(sc.hasNextLine()) {
			String invoer = sc.nextLine();
			if(invoer.equals("q")) {
				System.out.println("Het spel wordt afgesloten.");
				break;
			}
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
			vasthouden();
			opslaanWorp();	
			System.out.println("Druk op enter om opnieuw te werpen, druk op 'q' om te stoppen.");			speler.toonWorpGeschiedenis();
		}
	}
	
	void vasthouden() {
		resetBlokkeerArray();
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWelke posities wil je vasthouden?\nType '0' voor geen, anders bijvoorbeeld positie '13'");
		String invoerVasthouden = scan.nextLine();
	
		for(int i = 0; i < invoerVasthouden.length(); i++){
			int blokkeerIndex = Integer.parseInt(Character.toString(invoerVasthouden.charAt(i)));  //Character.toString om parseInt(string) werkend te krijgen
			if(blokkeerIndex > 0 && blokkeerIndex < 5){
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
}		

