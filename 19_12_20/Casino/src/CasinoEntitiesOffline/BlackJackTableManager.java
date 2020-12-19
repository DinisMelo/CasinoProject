package CasinoEntitiesOffline;

import BLACKJACK3.Dealer;
import BLACKJACK3.Deck;
import BLACKJACK3.InvalidDeckPosition;
import CasinoEntities.Bank;
import CasinoUtils.safeReader;
import casinoPersons.Player;

public class BlackJackTableManager extends TableManager{
	
	Deck deck;
	Dealer dealer;
	
	BlackJackTableManager(){
		
		dealer = new Dealer();
		type = 2;
	}
	@Override
	public void menuIntro() {
		System.out.println("BLACKJACK is a card casino game that can contain either 2,3,4 or 6 decks. \n");	
		System.out.println("The games rules are the following: \n");		
		System.out.println("Each participant attempts to beat the dealer by getting a count as close as 21 as possible, without going over 21");		
		System.out.println("An ace can be worth 1 or 11 (whatever is better for the player, leaving him/her closer to withuot going over it. Face cards are 10 and any other card is its pip value \n");		
		System.out.println("Before the deal begins, each player bets a bet with a limit from 5€ to 500€. \n");		
		System.out.println("After the bets, each player receives 2 cards a the dealer receive 1 turneed face up and another face down. \n");		
		System.out.println("Then the Player must decide whether to stand (not ask for another card) or hit (ask for another card). \n");		
		System.out.println("The Player can hit several times until he stands or bust (go over 21) \n");		
		System.out.println("Dealer Play: \n");		
		System.out.println("The dealers face-down card is  turned up. \n");		
		System.out.println("If the total is 17 or more, it must stand. If the total is 16 or under, they must take a card. \n");		
		System.out.println("The dealer must continue to take cards until the total is 17 or more, at which point the dealer must stand. \n");		
		System.out.println("If the dealer has an ace, and counting it as 11 would bring the total to 17 or more (but not over 21), the dealer must count the ace as 11 and stand. \n");		
		System.out.println("The dealer's decisions, then, are automatic on all plays, whereas the player always has the option of taking one or more cards. \n");				
	}
	
	public void hitOrStand (Player player) {
        int command;
                System.out.println();
                System.out.println(player.getName() + " has " + player.calculatePlayerTotal());

                do {
                    do {
                        System.out.println(player.getName() + " Hit or Stand? ");
                        System.out.println("1 - Hit");
                        System.out.println("2 - Stand");
                        command = safeReader.readIntSafetly();
                    } while ( command != 1 && command !=2 );
                    if (  command == 1 ) {
                        try {
							player.addCardToHand(deck.getCard());
							System.out.println(player.revealHandCard(player.getHandSize()-1));
						} catch (InvalidDeckPosition e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        //increments deck index
                        try {
							deck.SetNextDeckIndex();
						} catch (InvalidDeckPosition e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        System.out.println(player.getName() + " has " + player.calculatePlayerTotal());
                    }
                } while (!(command == 2 ) && player.calculatePlayerTotal() <= 21 );
            }
    //MUDAR
	public void endGame() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println("The Player " + players.get(i).getName() +     " has a return of  " + Bank.calculateBetReturnBJ(players.get(i), dealer) + "€ in this round.");
			if(players.get(i).calculatePlayerTotal() > 21){
				System.out.println("The Player " + players.get(i).getName() + " has bust so he loses the round.");
			}
			 
		}
		
		
		for (int i = 0; i < players.size(); i++) {
			players.get(i).clearPlayerHand();
			}
		
		dealer.clearDealerHand();
	}
		
	@Override
	public void start(int gameRounds) {
		// TODO Auto-generated method stub
		playersHaveMoney();
		int numberofdecks;
		
		
		
		
		
		if(gameRounds+1 == 1) {
			menuIntro();
			
			System.out.println("HOW MANY DECKS DO YOU WANT?");
			numberofdecks = safeReader.readIntSafetly();
			while(numberofdecks<2 || numberofdecks>6 || numberofdecks==5 ) {
				System.out.println("Invalid value, insert other value ");
				numberofdecks = safeReader.readIntSafetly();
			}
			deck = new Deck(numberofdecks);
			try {
				deck.shuffle(numberofdecks);
			} catch (InvalidDeckPosition e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
		
		for (int i = 0; i < players.size(); i++) {
			System.out.println("!!!!!!!!!!!!!!!!");
			System.out.println(players.get(i).getName());
			System.out.println("!!!!!!!!!!!!!!!!");
		}
		
		
		
		//APOSTA
		for (int i = 0; i < players.size(); i++) {
			
			
			
			System.out.println("------ BLACKJACK GAME --------");
			System.out.println("\n ROUND NUMBER:"+ (gameRounds+1)+"\n");
			System.out.println("PLAYER : "+players.get(i).getName());
		
			
			players.get(i).placeOfflineBJBet();
			players.get(i).status();   
			
		}
		
		//DEALER DÃ� A CARTA
		for (int j = 0; j < 2; j++) {
			
			for (int i = 0; i < players.size(); i++) {
				try {
					players.get(i).addCardToHand(deck.getCard());
				} catch (InvalidDeckPosition e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//increments deck index
				try {
					deck.SetNextDeckIndex();
				} catch (InvalidDeckPosition e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 
			}
			try {
				dealer.addCard(deck.getCard());
			} catch (InvalidDeckPosition e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				deck.SetNextDeckIndex();
			} catch (InvalidDeckPosition e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//mostrar as cartas
		
		for (int i = 0; i < players.size(); i++) {
			
			for (int j = 0; j < 2; j++) {
				System.out.println("Player "+players.get(i).getName());
				System.out.println((j+1) +" º "+players.get(i).revealHandCard(j));
				System.out.println("\n");
				if(players.get(i).getNameValueCard(j).equals("Ace")) {
					int aceCase = 0;
					System.out.println("Do you want the Ace to count has a 1 or 11 ???");
					aceCase = safeReader.readIntSafetly();
					while(aceCase != 1 && aceCase != 11) {
						System.out.println("Invalid value, please insert 1 or 11 ");
						aceCase = safeReader.readIntSafetly();
					}
					players.get(i).setFaceValue(j,aceCase);
				}
			}
			
		}
		
		System.out.println("Dealer's Card");
		System.out.println("1º " +dealer.revealHandCard(0));
		
	
		
		
		int bustCounter=0;
		for (int i = 0; i < players.size(); i++) {
			
			hitOrStand(players.get(i));
			if(players.get(i).calculatePlayerTotal()>21) bustCounter++;
				
		}
		if(bustCounter == players.size()) {
		System.out.println("ALL PLAYERS HAVE BUST");
			
			
		}else {
			
		
		//o dinheiro que ganham pode ser diferente
		
		
		//estrategia do dealer
		System.out.println("Dealer's Hand");
		System.out.println("1º " +dealer.revealHandCard(0));
		System.out.println("\n");
		System.out.println("2º " +dealer.revealHandCard(1));
		System.out.println("\n");
		
		 //mostrar cartas a seguir ás duas primeiras
		while(dealer.dealersPlay()) {
			System.out.println("Dealer Hits");
			
			try {
				dealer.addCard(deck.getCard());
				System.out.println(dealer.revealHandCard(dealer.getDealerHand().getHand().size()-1));
				System.out.println("\n");
			} catch (InvalidDeckPosition e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				deck.SetNextDeckIndex();
			} catch (InvalidDeckPosition e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println(dealer.revealCard(dealer.getNumberOfCards()-1));
			dealer.dealersPlay();
		}
		System.out.println("Dealer Stands");
	}
	endGame();	
}
		
		


}
