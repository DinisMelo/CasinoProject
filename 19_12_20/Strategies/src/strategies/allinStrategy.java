package strategies;

import RouletteBets.Bet;
import casinoPersons.RobotPlayer;
import statistics.playerStatistics;
public class allinStrategy extends Strategy {
	
	
	public allinStrategy(double tilt_odd) {
		super(tilt_odd);
	}
	
	Bet getNextBetTypeRoulette(double betValue) {
      
        double betTypeProb = (Math.random());
        RandomBetGeneratorRoulette generator = new RandomBetGeneratorRoulette();
        
        if(betTypeProb>=0 && betTypeProb< 0.05) { //SRTUP 5%
        	return generator.generateRandomStraightBet(betValue);	
        }
        else if(betTypeProb>=0.05 && betTypeProb< 0.15) { //DOZEN 10%
        	return generator.generateRandomDozenBet(betValue);
        }
        
        else if(betTypeProb>=0.15 && betTypeProb< 0.25) { //COLUMNBET 10%
        	return generator.generateRandomColumnBet(betValue);
        }
        
        else if(betTypeProb>=0.25 && betTypeProb< 0.5) {//EVENODD 25%
        	return generator.generateRandomEvenOddBet(betValue);
        }
        
        else if(betTypeProb>=0.50 && betTypeProb< 0.75) { //LOWHIGH 25%
        	return generator.generateRandomLowHighBet(betValue);
        }
        else if(betTypeProb>=0.75 && betTypeProb< 1) { //REDBLACK 25%
        	return generator.generateRandomRedBlackBet(betValue);
        }
        
        return null;	
     }
     
   

	public double generateMoneyGoal() {
	// gerar um valor a atingir por esta estrategia entre 100 e 10000	
		double moneyGoal =  Math.random()*(10000 -100)+100; 
		
		return moneyGoal;
	}
	
	
	public double betStrategyBJ(RobotPlayer player) {
	double betValue = 0;	
		
	//É A PRIMEIRA APOSTA?
	if(player.getPlayer_stats().getBjStatsRound().isEmpty()) {
		//money * 0.5
		betValue = player.getPlayerMoney() * 0.5;
	
	}
	
	//GANHOU A ULTIMA APOSTA? money *0.5
		
	//PERDEU A ULTIMA APOSTA? money *0.4	
	if(player.getPlayer_stats().wonBetBJ(player,player.getPlayer_stats().getBjStatsRound().size()-1)) {
		
		betValue = player.getPlayerMoney() * 0.6;
	}else {
		betValue = player.getPlayerMoney() * 0.4;
	}
	
	//PERDEU 2 APOSTAS? -> PROB. TILT BET 
	if(!player.getPlayer_stats().wonBetBJ(player,player.getPlayer_stats().getBjStatsRound().size()-1)
			&& !player.getPlayer_stats().wonBetBJ(player,player.getPlayer_stats().getBjStatsRound().size()-2)) {
		double tilt_temp = Math.random();
		if(tilt_temp < player.getTilt_odd()) {
			betValue = player.getPlayerMoney() * 0.8; //TILT BET
		}else {
			betValue = player.getPlayerMoney() * 0.6; //DEFAULT BET
		}
				
	}
		
		
	
		
		
		
		// TODO Auto-generated method stub
		return betValue;
	}

	@Override
	public double betStrategyRL(RobotPlayer player) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}




