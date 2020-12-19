package RouletteBets;

import CasinoUtils.safeReader;
import Roulette.RoulettePocket;

public class lowHighbet extends Bet {
	private boolean isLow;
	public lowHighbet(boolean isLow,double betValue) {
		super(betValue);
		this.isLow = isLow;
		this.payout = 1;
		this.odd = "48.60%";
	}

	@Override
	public boolean isWin(RoulettePocket winPocket) {
		
		if(isLow && winPocket.getNumber() <= 18 
		|| !isLow && winPocket.getNumber() > 18) 
		{
		return true;	
			
		}
		else return false;
	
	}
	public static boolean lowHighBetRestrictionOffline() {
		boolean isLow;
		int temp;
        System.out.println("Do you whant to bet in a high or low category:");
        System.out.println("        1- Low Category include all numbers from 1 to 18");
        System.out.println("        2- High Numbers include all numbers from 19 to 36");
        temp = safeReader.readIntSafetly();
        while(temp != 1 && temp != 2) {
            System.out.println("The number inserted don't correspond to any option");
            System.out.println("Do you whant to bet in:");
            System.out.println("        1- Low category");
            System.out.println("        2- High category");
            temp = safeReader.readIntSafetly();
        }

        if(temp %2 == 0) isLow = false;
        else isLow = true;

        return isLow;
	}
	public String toString() {
		
		return "lowHighBet: \n isLow: " + this.isLow + "\n Bet value: " +
			this.betValue + "\n Value Earned: " + this.valueEarned;
		
	}

}
