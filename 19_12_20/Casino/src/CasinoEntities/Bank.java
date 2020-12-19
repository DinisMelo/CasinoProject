package CasinoEntities;

import BLACKJACK3.Dealer;
import Roulette.RoulettePocket;
import casinoPersons.Player;

public class Bank {
	private static double balance;
	
	
	 public static void addBankMoney(double value) {
		balance += value;
		
	}
	
	public static void payWinners(Player p,RoulettePocket  winPocket) {
		// player Bet Value -> p.getRoundBets().get(i).getBetValue()
		// player Bet payout ->  p.getRoundBets().get(i).getPayout();
		double totalPayToWinner=0;
		double totalMoneyLost =0;
		
		for (int i = 0; i < p.getRoundBets().size(); i++) {
			
			if(p.getRoundBets().get(i).isWin(winPocket)) {
				double payToWinner = //betvalue + betvalue * payout
				p.getRoundBets().get(i).getBetValue()+p.getRoundBets().get(i).getBetValue() * p.getRoundBets().get(i).getPayout();				
				p.addMoney(payToWinner);
				p.getRoundBets().get(i).setValueEaned(payToWinner);// valueEarned na aposta = pay to winner
				totalPayToWinner+= payToWinner;
				//adicionar value earned
				
				p.getPlayer_stats().addRLStatsRound();
				
			}else {
				totalMoneyLost += p.getRoundBets().get(i).getBetValue();
				p.getRoundBets().get(i).setValueEaned(0); // valueEarned na aposta =0
			}
			
			
		}
			

		
	}
	
	public static double calculateBetReturnBJ(Player player, Dealer dealer) {
    	double returnBet=0;
    	
    	
    	 
    	// Player bust
    	if( player.calculatePlayerTotal() > 21) {
			returnBet = 0;
		}
    	else {
    		
    	
    	//PLAYER WINS
	    	if((player.calculatePlayerTotal() > dealer.calculateTotal())  ||  dealer.calculateTotal()>21) { // odd normal
	    		System.out.println("The Player 1" + player.getName() + " won.");
	    		returnBet = 2* player.getBJLastRoundBet(); 
	    		
	    	}
	    	else if(player.calculatePlayerTotal() > dealer.calculateTotal()  && player.getHandSize()==2 && player.calculatePlayerTotal()==21 ) {		//blackjack win
	    		System.out.println("The Player" + player.getName() + " won with BLACKJACK.");
	    		returnBet = 1.5*player.getBJLastRoundBet() + player.getBJLastRoundBet();
	    		
	  
	    	// Player ties with the dealer	
	    		
	    		
	    	}else if(player.calculatePlayerTotal() == dealer.calculateTotal()) {
	    		System.out.println("The Player" + player.getName() + " tied with the Dealer.");
	    		returnBet = player.getBJLastRoundBet(); 
	    		
	    	//Player loses	
	    	}else if(player.calculatePlayerTotal() < dealer.calculateTotal()) {
	    		System.out.println("The Player" + player.getName() + " loses.");
	    		returnBet=0;
	    	}
    	}
    	
    	player.addMoney(returnBet);
    	
    	return returnBet;
    }
	
	
	
}
