package BLACKJACK3;

import java.io.Serializable;

public class Dealer implements Serializable {

	private Hand DealerHand ;
	
	public Dealer() {
		
	DealerHand = new Hand();	
		
	}

	
	public void clearDealerHand() {
		DealerHand.ClearHand();
	}
	
	public boolean isBlackjack(){
		if (DealerHand.calculateTotal() == 21){
			return true;
		} else {
			return false;
		}
	}
	public void addCard(Cards card) {
		DealerHand.AddCard(card);

	}
	public int calculateTotal() {
		return DealerHand.calculateTotal();
	}
	public void clearHand() {
		DealerHand.ClearHand();
	}
	
	public String revealHandCard(int i) {
		
		return DealerHand.printHandCard(i);
	}
	
	public boolean dealersPlay() {
		if(DealerHand.calculateTotal() >= 17) return false;
			return true;
	}
	 public boolean dealersAce(int i) {
		 DealerHand.setFaceValueCard(i, 11);
	
		if (DealerHand.calculateTotal() > 21){
			DealerHand.setFaceValueCard(i, 1);
		}		
		return dealersPlay();	 
		 
	 
	 }

	public Hand getDealerHand() {
		return DealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		DealerHand = dealerHand;
	}
	
	
}
