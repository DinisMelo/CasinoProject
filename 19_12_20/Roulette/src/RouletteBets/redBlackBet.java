package RouletteBets;

import CasinoUtils.safeReader;
import Roulette.RoulettePocket;

public class redBlackBet extends Bet {
	
//member variables	
	private char betColor; // 'R' or 'B'
	
	public redBlackBet(char betColor, double betValue) {
		super(betValue);
		this.betColor= betColor;
		this.payout = 1;
		this.odd = "48.60%";
	
	}
//obvious methods
	
//non-obvious;
	@Override
	
	public boolean isWin(RoulettePocket winPocket) {
		if(betColor == winPocket.getColor()) {
			return true;
		}
		return false;
	}
	public String toString() {
		
		return "redBlackBet: \n Black or Red: " + this.betColor + "\n Bet value: "
		+ this.betValue + "\n Value Earned: " + this.valueEarned;
		
	}
	
	public static char redBlackBetRestrictionOffline() {
        char color;
        int temp;
        System.out.println("Do you whant to bet in:");
		System.out.println("		1- Red numbers");
		System.out.println("		2- Black numbers");
		temp = safeReader.readIntSafetly();
		while(temp != 1 && temp != 2) {
			System.out.println("The number inserted don't correspond to any option");
			System.out.println("Do you whant to bet in:");
			System.out.println("		1- Red numbers");
			System.out.println("		2- Black numbers");
			temp = safeReader.readIntSafetly();
		}
		if(temp %2 == 0) color = 'B';
		else color = 'R';
		return color;
	}

	
}