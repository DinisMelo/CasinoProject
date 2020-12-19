package strategies;

import RouletteBets.Bet;
import casinoPersons.RobotPlayer;

public abstract class Strategy {
	
	// fazer as estratégias de cada tipo de jogador em relação ao valor a apostar, implementar a tiltodd, pra apostas anormais
	// Fazer class intervention para que depois de ele fazer X tilt bets intervenha
	// Montar o RouletteManagerSimulation
	

	double tilt_odd;
	
	Strategy(double tilt_odd){
		
		this.tilt_odd = tilt_odd;
		
	}
	
	abstract Bet getNextBetTypeRoulette(double betValue);
        
	
	
	public abstract double betStrategyBJ(RobotPlayer player);
	public abstract double betStrategyRL(RobotPlayer player);
	
}
