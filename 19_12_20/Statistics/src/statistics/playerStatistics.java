package statistics;

import java.util.ArrayList;

import RouletteBets.Bet;
import casinoPersons.RobotPlayer;

public class playerStatistics extends Statistics  {





    public playerStatistics() {
       super();

    }

 
    public boolean wonBetBJ(RobotPlayer player,int index) {
    	
    	
    	if(player.getPlayer_stats().getBjStatsRound().get(index) < 0) {
    		return false;
    	}
    	else {
    		return true;
    	}
    	
    	
    }

 
}

	
	

