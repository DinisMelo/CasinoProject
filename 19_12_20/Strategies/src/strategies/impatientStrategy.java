package strategies;

import RouletteBets.Bet;

public class impatientStrategy extends Strategy {

	public impatientStrategy(double tilt_odd) {
		super(tilt_odd);
	}
	
	@Override
	Bet getNextBetTypeRoulette() {
		
		double betTypeProb = (Math.random());
        RandomBetGeneratorRoulette generator = new RandomBetGeneratorRoulette();
		
		if(betTypeProb>=0 && betTypeProb<= 0.3) //30%
            return generator.generateRandomStraightBet(betStrategy());

		else if(betTypeProb>=0.3 && betTypeProb<= 0.5) //20%
        return generator.generateRandomColumnBet(betStrategy());

		else if(betTypeProb>=0.5 && betTypeProb<= 0.6) //10%
        return generator.generateRandomEvenOddBet(betStrategy());

		else if(betTypeProb>=0.6 && betTypeProb<= 0.7) //10%
        return generator.generateRandomLowHighBet(betStrategy());

		else if(betTypeProb>=0.7 && betTypeProb<= 0.8)  //10%
        return generator.generateRandomRedBlackBet(betStrategy());

		else if(betTypeProb>=0.8 && betTypeProb<= 1) //20%
        return generator.generateRandomDozenBet(betStrategy());		
		
		return null;
	}
	
	@Override
	public double betStrategy() {
		// TODO Auto-generated method stub
		
		//primeira aposta?
			//-- aposta minima *2
		
		//ultima aposta perdeu?
		
			// -- aposta minima
		
		//ultima aposta ganhou?
			
			//-- aposta minima * 4;
		
		//tilt bet quando perde 3;
		
		
		
		
		return 0;
	}
	

	
	
}
