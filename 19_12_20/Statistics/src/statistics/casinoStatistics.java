package statistics;

import java.util.ArrayList;

import RouletteBets.Bet;

public class casinoStatistics extends Statistics {

    protected static ArrayList<Double> bjStatsRound = new <Double>ArrayList();
    protected static ArrayList <Double> rlStatsRound = new <Double>ArrayList();

    static public void setBalanceRoletteRound(double csBalanceRound ) {

        rlStatsRound.add(csBalanceRound);

    }

    static public void setBalanceBlackJackRound(double csBalanceRound ) {

        bjStatsRound.add(csBalanceRound);

    }

    static public double sumBalanceFromXtoY(int x, int y) {
        //mudar para o static game rounds
        double sum=0;
        for (int i = x; i < y; i++) {
            sum += rlStatsRound.get(i);
        }

        return sum;
    }




}