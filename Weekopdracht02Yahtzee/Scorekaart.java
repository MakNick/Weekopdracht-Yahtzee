/*
//
//	Testopzet voor een scorekaart, moet nog gevuld worden.
//
*/


package Weekopdracht02Yahtzee;

import java.util.ArrayList;

public class Scorekaart {
		String[][] scorekaart; // waarom was deze static???
			
		void vulBasisKaart(ArrayList<Speler> spelers){
			scorekaart = new String[8][(spelers.size() + 1)];
			for(int zz = 1; zz <= spelers.size(); zz++){
				scorekaart[0][zz] = spelers.get(zz-1).naam + " |";
			}
			scorekaart[0][0] = "______|";
			scorekaart[1][0] = "Enen  |";
			scorekaart[2][0] = "Tweeën|";				
			scorekaart[3][0] = "Drieën|";
			scorekaart[4][0] = "Vieren|";
			scorekaart[5][0] = "Vijfen|";
			scorekaart[6][0] = "Zessen|";
			scorekaart[7][0] = "Totaal|";
		}
		
//		void setScoreSpeler(ArrayList<Speler> spelers, ArrayList<Dobbelsteen> dobbelstenen){
//			String enen1 = Integer.toString(enen.size() * 1);
//			scorekaart[1][spelers.get(a)];
//		}
		
		void toonKaart(ArrayList<Speler> spelers){
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < (spelers.size() + 1); j++){
					System.out.print(scorekaart[i][j] + " ");
				}
				System.out.println("");
			}
		}
}