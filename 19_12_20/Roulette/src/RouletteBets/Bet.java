package RouletteBets;


import CasinoUtils.safeReader;
import Roulette.RoulettePocket;
import casinoPersons.Player;

/* restrições

so pode escolher n de 0-36

não pode repetir apostas exemplo, (1,2,1)

no máximo pode fazer 36 apostas, restringir tamanho arraylist

*/


public abstract class Bet {
  protected double payout;
  protected String odd;
  protected double betValue;
  protected double valueEarned;
  protected double valueLost;

  Bet(double betValue){
	  this.betValue= betValue;
  }
  
  
//obvious meyhods;
public double getPayout() {
	return payout;
}
public void setPayout(double payout) {
	this.payout = payout;
}
public String getOdd() {
	return odd;
}
public void setOdd(String odd) {
	this.odd = odd;
}
public double getBetValue() {
	return betValue;
}
public void setBetValue(double betValue) {
	this.betValue = betValue;
}

public double getValueEarned() {
	return valueEarned;
}


public void setValueEarned(double valueEarned) {
	this.valueEarned = valueEarned;
}


public double getValueLost() {
	return valueLost;
}


public void setValueLost(double valueLost) {
	this.valueLost = valueLost;
}


 // non-obvious methods 

public abstract boolean isWin(RoulettePocket winPocket);


public double getValueEaned() {
	return valueEarned;
}


public void setValueEaned(double valueEaned) {
	this.valueEarned = valueEaned;
}

public static double betController(Player p) {
	double betValue;
	System.out.println("Insert a bet value");
	betValue = safeReader.readDoubleSafetly();
	while(betValue < 0 || betValue > p.getPlayerMoney() /*|| Player emocional state, bank account ...*/) {
		System.out.println("Insert a valid bet value");
		betValue = safeReader.readDoubleSafetly();
		// faz o pagamento ao 
		
		//ou não aposta
	}
	p.transferMoneytoBank(betValue);
	
	System.out.println("Value accepted");
	
	return betValue;
	
}




  
}
