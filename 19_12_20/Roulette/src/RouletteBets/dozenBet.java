package RouletteBets;

import CasinoUtils.safeReader;
import Roulette.Roulette;
import Roulette.RoulettePocket;

public class dozenBet extends Bet {

//member variables	
	private int dozenType; //1-> 1-12, 2-> 13- 24, 3-> 25-36 
	
	public dozenBet(int dozenType,double betValue){
		super(betValue);
		this.dozenType = dozenType;
		this.payout = 2;
		this.odd = "32.40%";
	}
//obvious methods	

	
//non-obvious methods	
	@Override
	public boolean isWin(RoulettePocket winPocket) {
		switch(dozenType) {
		   case 1:
			   if (winPocket.getNumber() >=1 && winPocket.getNumber() <=12)
				   return true;
			   else
				   return false;
		   case 2:
			   if (winPocket.getNumber() >=13 && winPocket.getNumber() <=24)
				   return true;
			   else
				   return false; 
		   case 3:
			   if (winPocket.getNumber() >=25 && winPocket.getNumber() <=36)
				   return true;
			   else
				   return false;
		   
		   default:
			   System.out.println("Is not an option");
			   return false;
		
		}

	
	}
	public static int dozenBetRestrictionOffline() {
        //apenas pode apostar numa dúzia (1-12; 13-24; 25-36)
	      //apenas pode apostar numa dúzia (1-12; 13-24; 25-36)
        int dozenType;
        System.out.println("Insert a dozen: ");
        System.out.println("1: 1-12");
        System.out.println("2: 13-24");
        System.out.println("3: 25-26");
        dozenType= safeReader.readIntSafetly();

        while(dozenType < 0 || dozenType > 3){
            System.out.println("You can only bet in dozens 1,2 or 3");
            System.out.println("Insert a dozenType to bet");
            dozenType=safeReader.readIntSafetly();
        }
        return dozenType;

        
	}
	public String toString() {
		
		return "Dozen Bet: \n Dozen Type: " + this.dozenType + "\n Bet value: " + 
		this.betValue + "\n Value Earned: " + this.valueEarned;
		
	}
}
