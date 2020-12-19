package RouletteBets;

import CasinoUtils.safeReader;
import Roulette.RoulettePocket;

public class oddEvenBet extends Bet {
//member variables
	private boolean even;
	
	public oddEvenBet(boolean even, double betValue) {
		super(betValue);
		this.even = even;
		this.payout = 1;
		this.odd = "48.60%";
	}
//obvious methods	

	
//non-obvious methods
	@Override
	public boolean isWin(RoulettePocket winPocket) {
		if(even == winPocket.isEven()) return true;
		else return false;
	}
	public static boolean oddEvenBetRestrictionOffline() {
		boolean isEven;
		int temp;
		System.out.println("Do you whant to bet in:");
		System.out.println("		1- Even numbers");
		System.out.println("		2- Odd numbers");
		temp = safeReader.readIntSafetly();
		while(temp != 1 && temp != 2) {
			System.out.println("The number inserted don't correspond to any option");
			System.out.println("Do you whant to bet in:");
			System.out.println("		1- Even numbers");
			System.out.println("		2- Odd numbers");
			temp = safeReader.readIntSafetly();
		}
		
		if(temp %2 == 0) isEven = false;
		else isEven = true;
		
		return isEven;
	}
	
	public String toString() {
		
		return "oddEvenBet: \n isEven: " + this.even + "\n Bet value: " +
		this.betValue + "\n Value Earned: " + this.valueEarned;		
	
	}

	
}
