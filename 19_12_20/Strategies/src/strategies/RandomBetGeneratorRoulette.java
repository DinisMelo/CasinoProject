package strategies;

import RouletteBets.columnBet;
import RouletteBets.dozenBet;
import RouletteBets.lowHighbet;
import RouletteBets.oddEvenBet;
import RouletteBets.redBlackBet;
import RouletteBets.straightUpBet;

public class RandomBetGeneratorRoulette {

	    public columnBet generateRandomColumnBet(double betValue){
	        int col = (int)(Math.random() * 2);
	        return new columnBet(col,betValue);
	    }

	    public oddEvenBet generateRandomEvenOddBet(double betValue){
	        int col = (int)(1 + Math.random() * 2);
	        boolean isEven=false;
	        if(col==1)isEven = true;
	        return new oddEvenBet(isEven,betValue);
	    }


	    public lowHighbet generateRandomLowHighBet(double betValue){
	        int lowHigh = (int)(1 + Math.random() * 2);
	        boolean isLow=false;
	        if(lowHigh==1)isLow = true;
	        return new lowHighbet( isLow,betValue);
	    }

	    public redBlackBet generateRandomRedBlackBet(double betValue){
	        int redBlack = (int)(1 + Math.random() * 2);
	        char color='R';
	        if(redBlack==1)color = 'B';
	        return new redBlackBet( color,betValue);
	    }

	    public straightUpBet generateRandomStraightBet(double betValue){
	        int i = (int)(Math.random() * 36);
	        return new straightUpBet( i,betValue);
	    }

	    public dozenBet generateRandomDozenBet(double betValue){
	        int i = (int)(1 + Math.random() * 3);
	        return new dozenBet(i,betValue);
	    }

	    
	    
}
