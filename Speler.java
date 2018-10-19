package Weekopdracht02Yahtzee;

import java.util.ArrayList;

public class Speler {
	ArrayList<Worp> worpGeschiedenis = new ArrayList<Worp>();
	String naam;
	int aantalWorpen;
	final static int maxAantalWorpen = 3;
		
	void toonWorpGeschiedenis(int a){
		for(int x = 0; x < worpGeschiedenis.size(); x++){
			System.out.print("\n" + YahtzeeSpel.spelers.get(a).naam + ", beurt " + (x + 1) + ":");
			for(int j = 0; j < 5; j++){
				System.out.print("\t" + worpGeschiedenis.get(x).worpUitslag[j]);
			}
		}
		System.out.println("");
	}
	
	void setWorpGeschiedenis(Worp worp){
		worpGeschiedenis.add(worp);
	}
}
