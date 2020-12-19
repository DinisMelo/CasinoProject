package RouletteBets;
import CasinoUtils.safeReader;
import Roulette.Roulette;
import Roulette.RoulettePocket;


public class straightUpBet extends Bet {
//member variables
	private int number;
	
	 public straightUpBet(int number, double betValue){
		super(betValue);
		this.number = number;
		this.payout = 35;
		this.odd = "2.7%";
	}
	
	
//obvious methods
	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}

//non-obvious methods
	@Override
	public boolean isWin(RoulettePocket winPocket) {
		
		return getNumber() == winPocket.getNumber();
	
	}
	public static int  strUpBetRestrictionOffline() {
		  //apenas pode apostar num número de 0 a 36 inclusive
     
		int number;
      System.out.println("Insert a number to bet");
      number= safeReader.readIntSafetly();
		
      while(number < 0  || number > 36) {
          System.out.println("You can only in a number between 0 and 36");
          System.out.println("Insert a number to bet:");
          number= safeReader.readIntSafetly();
      }

		return number;
	}
	
	public String toString() {
		
		return "StraightUpBet: \n Number: " + this.number + "\n BetValue: " +
		this.betValue + "\n Value Earned: " + this.valueEarned;
		
	}




	

	
}
