package CasinoEntitiesOffline;
import java.util.ArrayList;

import CasinoEntities.Bank;
import CasinoUtils.safeReader;
import Roulette.Roulette;
import Roulette.RoulettePocket;
import RouletteBets.columnBet;
import RouletteBets.dozenBet;
import RouletteBets.lowHighbet;
import RouletteBets.oddEvenBet;
import RouletteBets.redBlackBet;
import RouletteBets.straightUpBet;
import casinoPersons.Player;


public class RouletteTableManager extends TableManager{
	
//proximo passo criar classe player, criar arraylist roundsBets e BetsRecords.
//criar uma maneira de o player acabar o a bet e poder fazer mais apostas e depois sim rolar a roleta
	

//criar um array pra os players presentes roulette manager.
//1º entrar na ronda, depois meter ready
//2º tds ready fecha entrada ou começa
//3º meter os ready a falso outra vez, tready atributo do player
// fazem apostas e no final metem redy outra vez
// todos ready -> roda roleta
// verificar win no arraylist rounbets do player, e dar dinheiro ou tirar
// guardar esses vlores nas estatisticas da ronda, por player e para o casino



RoulettePocket winPocket;
Roulette roulette;


public RouletteTableManager(){
	roulette = new Roulette();
	numberOfSeats = 8;
	type = 1;

	}
	
	
	public void menuIntro() {
		System.out.println("--- Welcome to Roulette ---");
		System.out.println("The European roulette wheel has 37 divisions, where numbers from 1 to 36 and 0 can be found.\n" + 
				"Numbers from 1 to 36 are alternately colored red and black, while the single zero is marked in green.\n" + 
				"The main objective, which any player pursues, is to predict, which numbered pocket the roulette ball\n" + 
				"is going to settle into. In order to do that, all players make bets on a particular number, after which\n" + 
				"the dealer turns the roulette wheel in one direction and spins the roulette ball in the opposite. Once\n" + 
				"the ball finds its way into the pocket with that particular number, the respective player(s) get paid.");
	
		System.out.println("Let's play");
	
	}
	
	
	
	
	public int menuBets() {
		//escolher que tipo de bet outside ou inside
		int betType;
		System.out.println(" Bets: ");
		System.out.println("\n");
		System.out.println("Inside Bets:					Outside Bets:");
		System.out.println("	1- Straight Up Bet 					2- Column Bet");
		System.out.println("								3- Dozen Bet");
		System.out.println("								4- Low/High numbers Bet");
		System.out.println("								5- Odd/Even Bet");
		System.out.println("								6- Red/Black  Bet");
		System.out.println("\n");
		
		//
		
		betType = safeReader.readIntSafetly();
		
		return betType;
	}
	
	//fazer um metodo pra simplificar restrições de pedidos, parametros limite max e minimo e mensagem a dar
	public int menuProceedBet() {
		int temp;
		System.out.println("Press:");
		System.out.println("1- Make another bet");
		System.out.println("2- Finish Bet, and SPIN THE ROULETTE");
		temp = safeReader.readIntSafetly();
		while(temp!= 1 && temp !=2) {
			System.out.println("NUMBER NOT ACCEPTED, TRY AGAIN");
			System.out.println("1- Make another bet");
			System.out.println("2- Finish Bet, and SPIN THE ROULETTE");
			temp = safeReader.readIntSafetly();
		}
		
		//a escolha é tomada no metodo start() no do while!
		
		return temp;
		
	}

	
	public void start(int gameRounds) {
		
		//se o player não tiver dinheiro antes de começar sai da ronda.
		
		for (int i = 0; i < players.size(); i++) {
			
			System.out.println(players.get(i).getName());
			
		}
		System.out.println("\n");
		playersHaveMoney();
		
		for (int i = 0; i < players.size(); i++) {
			
			System.out.println(players.get(i).getName());
			
		}
		System.out.println("\n");
		
		if(gameRounds+1 == 1) menuIntro();
		//todos os player jogam
		for (int i = 0; i < players.size(); i++) {
			
			
			int betType;
			int proceedBet;
			System.out.println("------ ROULETTE GAME --------");
			System.out.println("\n ROUND NUMBER:"+ (gameRounds+1)+"\n");
			System.out.println("PLAYER : "+players.get(i).getName());
			do {
			
				betType = menuBets();            //1º
				players.get(i).placeOfflineRouletteBet(betType);//2º
				players.get(i).status();
				proceedBet= menuProceedBet();      //3º
			}while(proceedBet==1);
			
		}
		//roda roleta
		winPocket = roulette.spin();
		
		
		//dar print nas roundBETS metodo toString

		//verifica roundBets players //faz as transações
		for (int i = 0; i < players.size(); i++) {
			
			Bank.payWinners(players.get(i),winPocket);// win pocket vem do girar roleta
				
		}
		
		//Mostrar status PLayer
		
		for (int i = 0; i < players.size(); i++) {
			players.get(i).printPlayerResults(this);
		}
		// reiniciar round bets dos player
		for (int j = 0; j < players.size(); j++) {		
			players.get(j).getRoundBets().clear();
			//reniciar com um metodo os round bets
		}
		
		//recomeça (abrir inscrições)
		
		
		
		
		
		// start
		// rounbets ou matriz
		//transfer money e o banco
		//pensar sobre fazer uma "conta" para o player
		//restringir pra não fazer a mesma aposta
		
	}
	
	
}
