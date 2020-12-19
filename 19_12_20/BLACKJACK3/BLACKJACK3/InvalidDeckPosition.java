package BLACKJACK3;

public class InvalidDeckPosition extends Exception {
 private int Identifier = 0 ;
 
 public InvalidDeckPosition(int Invalid) {
	 
	 
	 Identifier = Invalid;
	 
	 System.out.println("Invalid Deck Index " +Invalid);
	 
 }
 
 
 
 
}
