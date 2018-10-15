package Weekopdracht02Yahtzee;

import java.util.Scanner;

public class YahtzeeSpel {

	void spelen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Druk enter om te dobbelen.");
		
		while(sc.hasNextLine()) {
			String invoer = sc.nextLine();
			if(invoer.equals("q")) {
				break;
			}
			System.out.println("Dobbelsteen 1, Dobbelsteen 2, etc..");
		}
	}
}
