package Weekopdracht02Yahtzee;

import java.util.Random;

public class Dobbelsteen {
	int ogenWorp;

	int werpen(){
		Random rand = new Random();
		this.ogenWorp = rand.nextInt(6) + 1;
		return ogenWorp;
	}
	@Override
	public String toString() {
		return "" + ogenWorp + "\t";
	}
	
}
