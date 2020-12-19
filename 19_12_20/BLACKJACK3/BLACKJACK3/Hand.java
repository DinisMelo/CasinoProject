package BLACKJACK3;

import java.io.Serializable;
import java.util.ArrayList;

public class Hand implements Serializable {
	
	//private Cards[] Hand; // max value of cards 4 Ases + 4 duques + 4 ternos  = 24 pontos o que rebenta
	
	private ArrayList<Cards> Hand = new ArrayList<Cards>();
	public Hand() {
		
	
	}

	public ArrayList<Cards> getHand() {
		return Hand;
	}

	public void setHand(ArrayList<Cards> hand) {
		Hand = hand;
	}

	
	
//non-obvious methods
	
	public Cards getCard(int i) {
		return Hand.get(i);
	}
	
	public String printHandCard(int i) {
		
		return Hand.get(i).toString();
	}
	
	public void AddCard(Cards Card) {
	Hand.add(Card) ;
	}
	
	
	
	public String getNameCard(int i) {
		return Hand.get(i).getName();
}
	
	public void setFaceValueCard(int i, int value) {
		Hand.get(i).setFaceValue(value);
	}
	
	
	
	public void ClearHand() {
		while(!Hand.isEmpty()){
		Hand.remove(Hand.size()-1);
			
		}
		
		
		
	
	}
	
	public int calculateTotal() {
		int total = 0;
		for (int i = 0; i< Hand.size(); i++) {
			if ((Hand.get(i).getName().equals("Jack")) || (Hand.get(i).getName().equals("Queen")) || (Hand.get(i).getName().equals("King"))){
				Hand.get(i).setFaceValue(10);	
			}	
			
			total += Hand.get(i).getFacevalue();
		}return total;
		
		
		
	}
	
	

	




	
}
