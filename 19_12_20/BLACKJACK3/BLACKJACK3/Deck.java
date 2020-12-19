package BLACKJACK3;

import java.io.Serializable;
import java.util.Random;

public class Deck implements Serializable {

	
	private int DeckIndex;
	private int numberofdecks;
	private Cards[] Deck;
	
	
	public int getNumberofdecks() {
		return numberofdecks;
	}
	public void setNumberofdecks(int numberofdecks) {
		this.numberofdecks = numberofdecks;
	}
	
	
	public int getDeckIndex() {
		return DeckIndex;
	}
	
	
	public void setDeckIndex(int deckIndex) {
		DeckIndex = deckIndex;
	}
	
	public int SetNextDeckIndex() throws InvalidDeckPosition {
		if(isIndexGood()) {
			DeckIndex++;	
		}
		else {
			setDeckIndex(0);
		}
		return DeckIndex;
	}
	
	public Cards getCard()  throws InvalidDeckPosition {
		return Deck[DeckIndex];
	}
	
	public boolean isIndexGood() {
		if((DeckIndex >= 0 && DeckIndex < Deck.length)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

	
	public Deck(int numberofdecks) {
		setNumberofdecks(numberofdecks);
		Deck = new Cards[this.numberofdecks*52];
		int count = 0;
		for(int j = 0; j< numberofdecks; j++) {
			for (int i = 1; i <= 13; i++) {
			Deck[count] =  new Cards("Hearts", i);
			Deck[count].setValueName();	
			count++;
			}
			for (int z = 1; z <= 13; z++) {
			Deck[count] = new Cards("Spades", z);
			Deck[count].setValueName();	
			count++;
			}
			for (int x = 1; x <= 13; x++) {
			Deck[count] = new Cards("Clubs", x);
			Deck[count].setValueName();	
			count++;
			}
			for (int y = 1; y <= 13; y++) {
			Deck[count] = new Cards("Diamonds", y);
			Deck[count].setValueName();	
			count++;
			}	
		}
		
	}
		
	public void shuffle(int numberofdecks) throws InvalidDeckPosition {
		
		Random rand = new Random();
		for(int j = 0 ; j<4 ;j++) {
		for (int i =0 ; i<this.numberofdecks*52;i++) {
		swapCards(i,rand.nextInt(this.numberofdecks*52));
		}
		}
		
		setDeckIndex(0);	
	}
	
		private void swapCards(int index1, int index2)  throws InvalidDeckPosition{	
			Cards hold;
			indexGood(index1);
			indexGood(index2);
			hold = Deck[index1];
			Deck[index1] = Deck[index2];
			Deck[index2] = hold;
		}	
	

private void indexGood(int index) throws InvalidDeckPosition {
	if (index < 0 || index > this.numberofdecks*52-1) {
		throw new InvalidDeckPosition(index);
	}
}
}
	// criar um WHITECARD, para dar shuffle quando chegar ao final do baralho e para nunca dar erro
	// Deck[numberofdecks*52] = new Cards ("PlasticCard",0);
	// int WhiteCardIndex = rand.nextInt(numberofdecks*52+1 - numberofdecks*20) + numberofdecks*20;
	// Deck[WhiteCardIndex] = Deck[numberofdecks*52];
