package RouletteBets;

import Roulette.RoulettePocket;
import CasinoUtils.safeReader;
import Roulette.Roulette;
public class columnBet extends Bet {
	//member variables
	int column;
	
	public columnBet(int column, double betValue){
		super(betValue);
		this.column = column-1; // matriz começa em 0, utilizador escolhe 1, 2 ,3
		this.payout = 2;
		this.odd = "32.40%";
	}
	//obvious methods

	// non-obvious methods
	@Override
	
	public boolean isWin(RoulettePocket winPocket) {
	    //column funciona como row
		for (int i = 1; i < Roulette.pockets[0].length ; i++) {
			if(Roulette.pockets[column][i].getNumber() == winPocket.getNumber()) 
				return true;
		}
		
		return false;
	}
	public static int columnBetRestrictionOffline() {
        //apenas pode apostar numa coluna (1 em 3; 2:1)
		int column;
        System.out.println("Insert a column to bet");
        column= safeReader.readIntSafetly();
		
        while(column < 1  || column > 3) {
            System.out.println("You can only in a column between 1 and 3");
            System.out.println("Insert a column to bet:");
            column= safeReader.readIntSafetly();
        }

		return column;
	}
	
	public String toString() {
		
		return "Column Bet: \n Column: "+column+ "\n Bet Value: "+ this.betValue+ "\n Value Earned"+ this.valueEarned;
	}


	
	
	
}
