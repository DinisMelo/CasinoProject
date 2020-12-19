package casinoPersons;

import statistics.playerStatistics;
import strategies.Strategy;
import strategies.allinStrategy;
import strategies.cautiousStrategy;
import strategies.impatientStrategy;

public class RobotPlayer extends Player{
	
	
		//definir tipo de estrat�gias
	
//attributes
	 
	 private Strategy strategy;
	 private PersonalityType personality;
	 private double tilt_odd;
	 private boolean inIntervention;
	 
//obvious-methods
	 
	    public RobotPlayer(double initialMoney,int personalityType, boolean inIntervention) {
	        super(initialMoney);
	        player_stats = new playerStatistics();
	    	name = PlayerNameGenerator.generateName();
	    	this.tilt_odd = defineTiltOdd(personalityType);
	
	    	strategy = getStrategy(personalityType,tilt_odd);
	        this.inIntervention = inIntervention;
	    }

	    public void setStrategy(Strategy strategy) {
	        this.strategy = strategy;
	    }

	   
	    public Strategy getStrategy(int personalityType,double tilt_odd) {
	        
	    	personality = PersonalityType.values()[personalityType];
	       
	        switch (personality) {
	            case HOPELESS:
	                return  new allinStrategy(tilt_odd);
	            case RATIONAL:
	                return   new cautiousStrategy(tilt_odd);
	            case ANGRY:
	                return  new impatientStrategy(tilt_odd);
	           
	        }
	        return null;
	    }
	    public PersonalityType getPersonality() {
			return personality;
		}

		public void setPersonality(PersonalityType personality) {
			this.personality = personality;
		}

		public double getTilt_odd() {
			return tilt_odd;
		}

		public void setTilt_odd(double tilt_odd) {
			this.tilt_odd = tilt_odd;
		}
		
		

		public boolean isInIntervention() {
			return inIntervention;
		}

		public void setInIntervention(boolean inIntervention) {
			this.inIntervention = inIntervention;
		}

		public Strategy getStrategy() {
			return strategy;
		}
//non-obvious methods		
	    
	    public double defineTiltOdd(int personalityType) {
	    	PersonalityType personality = PersonalityType.values()[personalityType];
		       
	        switch (personality) {
	            case HOPELESS:
	                return 0.5;
	            case RATIONAL:
	                return 0.2;
	            case ANGRY:
	                return 0.75;
	           
	        }
	        return 0;
	    }
	    	

	    @Override
	    public String toString() {
	        return "RobotPlayer{" +
	                "name = '" + name + '\'' +
	                ", playerMoney = " + playerMoney +
	                ", strategy = " + strategy.toString() +
	                '}';
	    }

		public void betBJ() {
			
			strategy.betStrategyBJ(this);
			
		}
		public void betRL() {
			
		}
		
}
	
	


