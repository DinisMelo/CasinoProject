package strategies;

import RouletteBets.Bet;

public class cautiousStrategy extends Strategy {

	public cautiousStrategy(double tilt_odd) {
		super(tilt_odd);
	}
	@Override
	Bet getNextBetTypeRoulette() {
		
		//50% IN ALL BETS
		
		String[] betType = {"COLUMN", "EVENODD", "LOWHIGH", "REDBLACK", "STRAIGHT", "DOZEN"};

        int betTypeIndex = (int) (Math.random() * betType.length);
        RandomBetGeneratorRoulette generator = new RandomBetGeneratorRoulette();
        
        switch (betType[betTypeIndex]) {
            case "COLUMN":
            	
                return generator.generateRandomColumnBet(betStrategy());
            case "EVENODD":
                return generator.generateRandomEvenOddBet(betStrategy());
            
            case "LOWHIGH":
                return generator.generateRandomLowHighBet(betStrategy());
            case "REDBLACK":
                return generator.generateRandomRedBlackBet(betStrategy());
            
            case "STRAIGHT":
                return generator.generateRandomStraightBet(betStrategy());
            
            case "DOZEN":
                return generator.generateRandomDozenBet(betStrategy());
        }
        return null;
    }
	@Override
	public double betStrategy() {
		
	//primeira vez a jogar?
	
		//--aposta minima
	
	//não ganhou da ultima vez?
		
		//--dobra aposta
	
	//ganhou da ultima vez?
		
		//--aposta minima
		
	//tilt bet as 5;
	
		/*
		if (Statistics.getStatistics().size() <= 0)
            return minBet;
        else {
            if (!Statistics.isLastWin(p))
                currentBet = currentBet * 2;
            else
                currentBet = minBet;
        }
        return currentBet;
        */
		return 0;
	}

	}

	

