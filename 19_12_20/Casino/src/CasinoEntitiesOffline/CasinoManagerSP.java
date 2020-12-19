package CasinoEntitiesOffline;

import java.util.ArrayList;
import java.util.Collections;

import CasinoUtils.safeReader;
import casinoPersons.PersonPlayer;
import casinoPersons.Player;
public class CasinoManagerSP {
	
	
	private static ArrayList<Player> lobbyPlayers;
	private static ArrayList<Player> loserPlayers;
	private TableManager roulette;
	private TableManager blackjack;

	public static ArrayList<Player> getLoserPLayers() {
		return loserPlayers;
	}


	public static void setLoserPLayers(ArrayList<Player> loserPLayers) {
		CasinoManagerSP.loserPlayers = loserPLayers;
	}
	
	public static ArrayList<Player> getLobbyPlayers() {
		return lobbyPlayers;
	}


	public static void setLobbyPlayers(ArrayList<Player> lobbyPlayers) {
		CasinoManagerSP.lobbyPlayers = lobbyPlayers;
	}
	
	public TableManager getRoulette() {
		return roulette;
	}


	public void setRoulette(TableManager roulette) {
		this.roulette = roulette;
	}


	public TableManager getBlackjack() {
		return blackjack;
	}


	public void setBlackjack(TableManager blackjack) {
		this.blackjack = blackjack;
	}


	
	
	CasinoManagerSP(){
		roulette = new RouletteTableManager();
		lobbyPlayers = new <Player>ArrayList();
		blackjack = new BlackJackTableManager();
		loserPlayers = new <Player>ArrayList();
	}
	
	
	public void explanationMenu() {
		
		System.out.println("----WElCOME THE THE OFFLINE MODE----");
		System.out.println("---PLAY ALONE OR WITH YOUR FRIENDS---");
		
	}
	public int playerQuantitymenu() {
		System.out.println("\n");
		System.out.println("HOW MANY PLAYERS DO YOU WANT? (write the number)");
		int numberPlayers;
		do {
		System.out.println("		1- One");
		System.out.println("		2- Two");
		System.out.println("		3- Three");
		System.out.println("		4- Four");
		System.out.println("		5- Five");
		numberPlayers = safeReader.readIntSafetly();
		}while(numberPlayers < 1 ||numberPlayers >5 );
		
		return numberPlayers;
		
	}
	
public double initialPlayersMoneyNameMenu(int numberPlayers) {
		
		if(numberPlayers==1)System.out.println("\n\n-----CHOSE YOUR MONEY ENTERY FOR YOU---------");
		else System.out.println("\n\n-----CHOSE YOUR MONEY ENTERY FOR ALL OF YOU---------");
		double playerMoney=0;
		
		int reader;
		do {
			System.out.println("		1- BEGGAR -> 20€");
			System.out.println("		2- WORKER -> 50€");
			System.out.println("		3- MANAGER -> 100€");
			System.out.println("		4- CEO -> 1000€");
			System.out.println("		5- BILL GATES -> 10000€");
			reader = safeReader.readIntSafetly();
		}while(reader < 1 ||reader >5 );
		
		switch(reader) {
				case 1:
					playerMoney=20;
					break;
				case 2:
					playerMoney=50;
					break;
					
				case 3:
					playerMoney=100;
					break;
				
				case 4:
					playerMoney=1000;
					
					break;
				
				case 5:
					playerMoney=10000;
					break;
		
		
		}
		
		return playerMoney;
		
		
	}

public void createPLayers(int numberPlayers, double playerMoney) {
	String playerName;
	playerName = safeReader.readStringSafetly();
	for (int i = 0; i < numberPlayers; i++) {
		
		System.out.println("\n\nCHOOSE YOU NAME, PLAYER NUMBER "+(i+1));
		
		
		playerName = safeReader.readStringSafetly();
		lobbyPlayers.add(new PersonPlayer(playerMoney,playerName));
	
			
	}
}

	
public int RestrictiongameDuration() {
		
		int temp;
		int gameRounds=0;
		System.out.println("Do you prefer a short, medium or long game?");
		System.out.println("1- Short");
		System.out.println("2- Medium");
		System.out.println("3- Long");
		temp = safeReader.readIntSafetly();
		
		while (temp <1 || temp >3) {
			System.out.println("Please, insere a valid input");
			System.out.println("Do you prefer a short, medium or long game?");
			System.out.println("1- Short");
			System.out.println("2- Medium");
			System.out.println("3- Long");
			temp=safeReader.readIntSafetly();
		}
		if(temp==1) {
			gameRounds=10;
			
		}else if(temp==2) {
			gameRounds=20;
			
		}else if(temp==3) {
			gameRounds=40;
		}
		
		return gameRounds;
	}
	
	
	public int voteGame() {
		System.out.println("----VOTE IN A GAME TO START----");
		int bj=0;
		int r=0;
		int random=0;
		int temp;
		for (int i = 0; i < lobbyPlayers.size(); i++) {
			System.out.println("PLAYER "+(i+1)+"WHAT IS YOUR VOTE?");
			System.out.println("\n");
			System.out.println("	1 - Roulette");
			System.out.println("	2 - BlackJack");
			temp = safeReader.readIntSafetly();
			while(temp != 1 && temp != 2) {
			System.out.println("(insert a valid option!");
			System.out.println("	1 - Roulette");
			System.out.println("	2 - BlackJack");
			System.out.println("\n");
			temp = safeReader.readIntSafetly();
			}
		if(temp ==1)bj++;
		else r++;
		}
		if(r == bj) {
			System.out.println("-----EQUAL VOTES, A RANDOM GAME WILL BE CHOOSEN!------");
			System.out.println("\n");
			random = (int) ( Math.random() * 2 + 1);	
		}
		
		if(r>bj || random == 1) {
			System.out.println("-----ROULETTE WIL BE THE FISRT GAME!------");
			System.out.println("\n");
			return 1;
		}
		
		else if(r<bj || random==2) {
			System.out.println("-----BLACKJACK WIL BE THE FISRT GAME!------");
			System.out.println("\n");
			return 2;
		}
		return 1;
	
	}
	
	
	public boolean endGameForPlayer(TableManager table) {
		
		if(table.players.isEmpty()) {
			
			System.out.println("Everybody LOSED");
			return true;
		}
		
		for (int i = table.players.size()-1; i >=0 ; i--) {
			
			if(!table.players.get(i).haveMoney()) {
				
				table.players.get(i).seatInLobby(CasinoManagerSP.getLoserPLayers());
				table.players.remove(i);
				
			}
			
				
		}
		return false;
		
		
	}
	
	public void removeFromLobby() {
		
		for (int i = lobbyPlayers.size()-1; i >=0; i--) {
			//fazrr os if consoante os votos
			
			lobbyPlayers.remove(i);
			
			
		}
		
	}
	
	public void start() {
		explanationMenu();
		int numberPlayers= playerQuantitymenu();
		double playerMoney=initialPlayersMoneyNameMenu(numberPlayers);
		createPLayers(numberPlayers,playerMoney);
		int gameRounds = RestrictiongameDuration();
		double max=0;
		String winnerName="";
		int equalMoneyCounter;
		//sentar os jogadores 
		
		
	
		for (int i = 0; i < lobbyPlayers.size(); i++) {
			//fazrr os if consoante os votos
			
			lobbyPlayers.get(i).seatInTable(roulette);
			
			
		}
		//remover os players do lobby
		removeFromLobby();
		
		
			for (int i = 0; i < gameRounds/2; i++) {
			
			
			roulette.start(i);
			if(endGameForPlayer(roulette)) {
				System.out.println("GAME ENDED, ALL PLAYERS HAVE NO MONEY");
			break;
		}
			
		}
		
		//sentar os jogadores no lobby após jogo
		
		
		for (int i = 0; i < roulette.players.size(); i++) {
			//fazrr os if consoante os votos
		
			roulette.players.get(i).seatInLobby(lobbyPlayers);
		}
	
		
		//SENTAR JOGADORES NO BLACKJACK
		for (int i = 0; i < lobbyPlayers.size(); i++) {
			//fazrr os if consoante os votos
			if(lobbyPlayers.get(i).getPlayerMoney()>5) {
				lobbyPlayers.get(i).seatInTable(blackjack);
			}
			else {
				System.out.println(lobbyPlayers.get(i).getName()+" WAS REMOVED, HAVE LESS THAN 5 EUROS");
				CasinoManagerSP.getLoserPLayers().add(lobbyPlayers.get(i));
				
			}
			
		}
		
		removeFromLobby();
		
		
		
		//JOGAR BLACKJACK
		for (int i = 0; i < gameRounds/2; i++) {
			
			
			blackjack.start(i);
			if(endGameForPlayer(blackjack)) {
				System.out.println("GAME ENDED, ALL PLAYERS HAVE NO MONEY");
				break;
			}
			/*
			if(startChosenGame==1)roulette.start();
			else blackjack.start();
			*/
		}
		//SENTAR JOGADORES DO BLACKJACK -> LOBBY
		for (int i = 0; i < blackjack.players.size(); i++) {
			//fazrr os if consoante os votos
		
			blackjack.players.get(i).seatInLobby(lobbyPlayers);
		}
		
		//ANALISAR VENCEDORES
		
		/*for (int i = 1; i < lobbyPlayers.size(); i++) {
			 max = lobbyPlayers.get(0).getPlayerMoney();
			 
			if(max < lobbyPlayers.get(i).getPlayerMoney()) {
				max = lobbyPlayers.get(i).getPlayerMoney();
				
			}
	
			
		}
		*/
		//fazer print dos vencedores!
		System.out.println("----------END GAME------");
		System.out.println("\n");
		System.out.println("--------SCOREBOARD-------");
		for (int i = 0; i < lobbyPlayers.size(); i++) {
			
				if(max == lobbyPlayers.get(i).getPlayerMoney()) {	
					System.out.println("VICTORIOUS : " + lobbyPlayers.get(i).getPlayerMoney() );
					lobbyPlayers.get(i).status();
				}
			
		/*
		for (int i = 0; i < gameRounds/2; i++) {
			if(startChosenGame==1)blackjack.start();
			else roulette.start();

		}
		*/
		
	
	}



}


}
