package CasinoEntitiesOffline;

import java.util.ArrayList;

import CasinoUtils.safeReader;
import casinoPersons.PersonPlayer;
import casinoPersons.Player;

public abstract class TableManager {

	protected int type;
	protected int numberOfSeats;
	protected int occupiedSeats;
	public ArrayList<Player> players = new <Player>ArrayList();	
	
	
	public ArrayList<Player> getPlayers(){
		return players;
	}	

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getOccupiedSeats() {
		return occupiedSeats;
	}

	public void setOccupiedSeats(int occupiedSeats) {
		this.occupiedSeats = occupiedSeats;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void playersHaveMoney() {
		for (int i = 0; i < players.size(); i++) {
			if(!players.get(i).haveMoney()) {
				System.out.println("Player "+ players.get(i).getName()+" doesn't have money left so he was removed!" );
				players.get(i).seatInLobby(CasinoManagerSP.getLobbyPlayers());
				players.remove(i);
			}
		}
		
		
	}
	
	public static double betController(Player p, int type) {
		double betValue;
		System.out.println("Insert a bet value");
		betValue = safeReader.readDoubleSafetly();
		
		if( type == 1) {
			while(betValue < 0 || betValue > p.getPlayerMoney() ) {
				System.out.println("Insert a valid bet value");
				betValue = safeReader.readDoubleSafetly();
				// faz o pagamento ao 
				
				//ou não aposta
			}
		}else if(type == 2) {
			while(betValue < 5 || betValue > p.getPlayerMoney() || betValue >500 ) {
				System.out.println("Insert a valid bet value");
				betValue = safeReader.readDoubleSafetly();
				// faz o pagamento ao 
				
				//ou não aposta
			}
		}
		

		
		p.transferMoneytoBank(betValue);
		
		System.out.println("Value accepted");
		
		return betValue;
		
	}
	
	public boolean equals(int type) {
		if(this.type == type) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public abstract void start(int gameRounds);

	public abstract void menuIntro();
	
}