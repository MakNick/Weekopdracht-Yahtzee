package Weekopdracht02Yahtzee;

import java.util.ArrayList;

public class Speler {
	ArrayList<Worp> worpGeschiedenis = new ArrayList<Worp>();
	int aantalWorpen;
	final int maxAantalWorpen = 3;
	
	void toonWorpGeschiedenis(){
		System.out.println("");
		for(int x = 0; x < worpGeschiedenis.size(); x++){
			System.out.print("Geschiedenis, worp " + (x + 1) + ": ");
			for(int j = 0; j < 5; j++){
				System.out.print("\t" + worpGeschiedenis.get(x).worpUitslag[j]);
			}
			System.out.println("");
		}
	}
	
	void setWorpGeschiedenis(Worp worp){
		worpGeschiedenis.add(worp);
	}
}
