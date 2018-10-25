package Weekopdracht02Yahtzee;

public class Worp {
	int[] worpUitslag = new int[5];
	
	void setWorpUitslag(int waarde, int q) {
		for(int j = 0; j < worpUitslag.length; j++){
			worpUitslag[q] = waarde;
		}
	}
}


