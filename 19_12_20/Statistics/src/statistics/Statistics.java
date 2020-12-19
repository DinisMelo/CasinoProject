
package statistics;

import java.util.ArrayList;

import RouletteBets.Bet;
import casinoPersons.Player;
import casinoPersons.RobotPlayer;

public class Statistics {

	
    protected ArrayList<Double> bjStatsRound;
    protected ArrayList <ArrayList<Bet>> rlStatsRound; 

    //fazer um static gameRounds depois ao criar o jogo
    Statistics(){

        bjStatsRound = new <Integer>ArrayList();
        rlStatsRound = new ArrayList<> (500);

    }
    
    public ArrayList<ArrayList<Bet>> getRlStatsRound() {
        return rlStatsRound;
    }

    public void setRlStatsRound(ArrayList<ArrayList<Bet>> rlStatsRound) {
        this.rlStatsRound = rlStatsRound;
    }
    public ArrayList<Double> getBjStatsRound() {
		return bjStatsRound;
	}

	public void addBjStatsRound(double value) {
	bjStatsRound.add(value);
	}
    public void addRLStatsRound(ArrayList<Bet> roundBets) {
    	rlStatsRound.add(roundBets);
    }


    public String generateArrayListNameRound() {
          return "round" + (++gameRounds); 

    }

    public double profitsPlayerRoulette(ArrayList<Player> players) {
        double sum=0;

    for (int j = 0; j < 500; j++) {
        for (int i = 0; i < players.size(); i++) {

            sum += players.get(i).getPlayer_stats().getRlStatsRound().get(j).get(i).getBetValue();
        }

    }
    return sum;

    }

    public double profitsPlayerIntervention(ArrayList<RobotPlayer> players, boolean inIntervention) {
        double sum=0;

    for (int j = 0; j < 500; j++) {
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).isInIntervention()) {
                sum += players.get(i).getPlayer_stats().getRlStatsRound().get(j).get(i).getBetValue();
            }
        }

    }
    return sum;

    }

    public double profitsPlayerNonIntervention(ArrayList<RobotPlayer> players, boolean inIntervention) {
        double sum=0;

    for (int j = 0; j < 500; j++) {
        for (int i = 0; i < players.size(); i++) {
            if(!players.get(i).isInIntervention()) {
                sum += players.get(i).getPlayer_stats().getRlStatsRound().get(j).get(i).getBetValue();
            }
        }

    }

    return sum;

    }


	




}