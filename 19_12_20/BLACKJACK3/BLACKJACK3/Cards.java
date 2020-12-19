package BLACKJACK3;

import java.io.Serializable;

public class Cards implements Serializable {
	
	private int facevalue ;
	private String suit;
	private String name;
	
	
	


	public Cards (String suit,int facevalue) {
		this.suit = suit;
		this.facevalue= facevalue;	
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getFacevalue() {
		return facevalue;
	}

	public void setFaceValue (int facevalue) {
		this.facevalue = facevalue;
	}
	
	
	public String getSuit() {
		return suit;
	}
	
	public String resetSuit(String suit) {
		return this.suit = suit;
	}
	
	public void setValueName(){

		String name = "";

		if (this.facevalue == 1) {		
			name = "Ace";
		}
		else if (this.facevalue == 2) {
			name = "Two";
		}
		else if (this.facevalue == 3) {
			name = "Three";
		}
		else if (this.facevalue == 4) {
			name = "Four";
		}
		else if (this.facevalue == 5) {
			name = "Five";
		}
		else if (this.facevalue == 6) {
			name = "Six";
		}
		else if (this.facevalue == 7) {
			name = "Seven";
		}
		else if (this.facevalue == 8) {
			name = "Eight";
		}
		else if (this.facevalue== 9) {

			name = "Nine";
		}
		else if (this.facevalue == 10) {

			name = "Ten";
		}
		else if (this.facevalue == 11) {

			name = "Jack";
		}
		else if (this.facevalue == 12) {

			name = "Queen";
		}
		else if (this.facevalue == 13) {

			name = "King";

		} 
		setName(name);

	}
	
	public String toString() {
		
		return "Card: \n" + name + "  of "+ suit;
	}
	
	
	
	
	
}


