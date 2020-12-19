package casinoPersons;
import java.util.ArrayList;

import BLACKJACK3.Hand;
import CasinoEntities.Bank;
import CasinoEntitiesOffline.TableManager;
import RouletteBets.Bet;
import RouletteBets.columnBet;
import RouletteBets.dozenBet;
import RouletteBets.lowHighbet;
import RouletteBets.oddEvenBet;
import RouletteBets.redBlackBet;
import RouletteBets.straightUpBet;
import casinoPersons.PersonPlayer;
import statistics.playerStatistics;
import BLACKJACK3.Cards;
public class Player {
	
	protected String name;
	protected double playerMoney;
	protected double initialMoney;
	protected ArrayList<Bet> roundBets = new ArrayList<Bet>(); // é reiniciado todas as rondas
	protected Hand playerHand = new Hand();
	protected ArrayList<Double> roundBJBets = new ArrayList<Double>();
	protected playerStatistics player_stats;
	//counter para numero de blackjack


	
	public Player(double playerMoney) {
		this.initialMoney = playerMoney;
		this.playerMoney= playerMoney;

		
	}
	public playerStatistics getPlayer_stats() {
		return this.player_stats;
	}

	public void setPlayer_stats(playerStatistics player_stats) {
		this.player_stats = player_stats;
	}
	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	

	public ArrayList<Double> getRoundBJBets() {
		return roundBJBets;
	}

	public void setRoundBJBets(ArrayList<Double> roundBJBets) {
		this.roundBJBets = roundBJBets;
	}
	
	public void addRoundBets(Bet bet) {
		roundBets.add(bet);
	}
	public double getInitialMoney() {
		return initialMoney;
	}
	public void setInitialMoney(double initialMoney) {
		this.initialMoney = initialMoney;
	}
	public void setPlayerMoney(double playerMoney) {
		this.playerMoney = playerMoney;
	}

    public double getPlayerMoney() {
        return this.playerMoney;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Bet> getRoundBets() {
		return roundBets;
	}

	public void setRoundBets(ArrayList<Bet> roundBets) {
		this.roundBets = roundBets;
	}



	
	//non-obvius methods
	
	public String getNameValueCard (int i) {
		
		
	return playerHand.getNameCard(i);
	}
	
	
	
	public double getBJLastRoundBet() {
		
		return roundBJBets.get(roundBJBets.size()-1);
	}
	
	
	public int calculatePlayerTotal () {
		
		
		return playerHand.calculateTotal();
		
	}
	
public void setFaceValue(int i, int value) {
		playerHand.setFaceValueCard(i, value);
	}
	
	public String revealHandCard(int i) {
		
		return playerHand.printHandCard(i);
	}
	
	public void addCardToHand(Cards card) {
		playerHand.AddCard(card);
	}
	
	
	public int getHandSize() {
		
	return	playerHand.getHand().size();
	}
	
	public void clearPlayerHand() {
		playerHand.ClearHand();
	}
	
	
	public void transferMoneytoBank(double betValue) {
		this.playerMoney = this.playerMoney - betValue;
		//dar dinheiro ao casino
		Bank.addBankMoney(betValue);
	}
	
	public void addMoney(double payToWinner) {
        playerMoney = playerMoney + payToWinner;
    }
	
	public void seatInTable(TableManager table) {
	
			table.players.add(this);
		
		
		
	}
	public void seatInLobby(ArrayList<Player> lobbyPlayers) {
			lobbyPlayers.add(this);					
	}
	
	public boolean haveMoney() {
		if(playerMoney <= 0) {
			playerMoney = 0;
			return false;
		}else {
			return true;
		}
	}
	
	public void printPlayerRoundBets() {
		System.out.println("<< Your Bets >>");
		for (int i = 0; i < roundBets.size(); i++) {
			System.out.println(roundBets.get(i).toString());
			System.out.println("\n");
		}
		
	}
	
	public void printPLayerBJRoundBets() {
		System.out.println("<< Your Bets >>");
		if(roundBJBets.size()>0)
		System.out.println("Bet Value: "+ getBJLastRoundBet());
		else {
			System.out.println("NO BETS HERE");
		}
	}
	
public void placeOfflineRouletteBet(int betType) {
		
		// Polimorfismo é usado para adicionar elemenos ao arrat RounBets, aceita obj tipo bet, adicionamos varias extensões
				switch(betType) {
				 case 1:
					 
					 int number = straightUpBet.strUpBetRestrictionOffline();
					 double betValue1 = TableManager.betController(this,1);
					 this.addRoundBets(new straightUpBet(number,betValue1));
					 
					 //add to a array history
					 //player. Rouletteroundbets.add(strupbet) arraylist type Bets
					 //player. roulettebetshistory.add(strupbet) arraylist
					 
					 break;
					 
				 case 2:
					 int column = columnBet.columnBetRestrictionOffline();
					 double betValue2 = TableManager.betController(this,1);
					 this.addRoundBets(new columnBet(column,betValue2));
					 
					 
					 break;
					 
				 case 3:
					 int dozenType = dozenBet.dozenBetRestrictionOffline();
					 double betValue3 = TableManager.betController(this,1);
					 this.addRoundBets(new dozenBet(dozenType,betValue3));
					 //tirar dinheiro do player e colocar no banco casino
					 
					 break;
				 
				 case 4:
					 boolean isLow = lowHighbet.lowHighBetRestrictionOffline();
					 double betValue4 = TableManager.betController(this,1);
					 this.addRoundBets(new lowHighbet(isLow,betValue4));
					 break;
				 
				 case 5:
					 boolean isEven = oddEvenBet.oddEvenBetRestrictionOffline();
					 double betValue5 = TableManager.betController(this,1);
					 
					 this.addRoundBets(new oddEvenBet(isEven,betValue5));
					 
					 break;
				 
				 case 6:
					 char color = redBlackBet.redBlackBetRestrictionOffline();
					 double betValue6 = TableManager.betController(this,1);
					 
					 this.addRoundBets(new redBlackBet(color,betValue6));
					 
					 break;
				}
	

	
	
	}

public double placeOfflineBJBet() {
	
	double betValue = TableManager.betController(this,2);
	roundBJBets.add(betValue);
	return betValue;
	
}

public void printPlayerResults(TableManager table) {
	
	System.out.println("\n");
	System.out.println("--------"+this.getName()+" BETS BALANCE IS: "+(this.getPlayerMoney()-this.getInitialMoney())+"€--------");
	System.out.println("\n");
	if(table.equals(1)) {
	printPlayerRoundBets();
	}
	else {
	printPLayerBJRoundBets();	
	}
	this.status();
	
	
	
	
}
	
	
	
	public void status() {
		System.out.println("\n");
		System.out.println("----PLAYER STATUS----");
		System.out.println("	Name     : "+this.getName());
		System.out.println("	Money    : "+this.getPlayerMoney());
		System.out.println("	TotalWins: ");
		System.out.println(" Total Earned: ");
		System.out.println("\n");
		
	}
	
	
	


}
