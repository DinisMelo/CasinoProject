package Roulette;
import java.util.Random;
public class Roulette {
	//atributes
	
	static public RoulettePocket[][] pockets;
	private int rows = 3;
	private int columns = 13;
	
	public Roulette(){
		pockets = new RoulettePocket[rows][columns];
		populateRoulette();
			
	}
	
//obvious-methods
static public int getPocketColumn(int number) {
	for (int i = 0; i < pockets.length; i++) {
		for (int j = 0; j < pockets[1].length; j++) { //[1] porque coluna 0 tem apenas o 0
			if(pockets[i][j].getNumber() == number) return j;
		}
	}
	
	return -1;
}
static public int getPocketRow(int number) {
	for (int i = 0; i < pockets.length; i++) {
		for (int j = 0; j < pockets[1].length; j++) { //[1] porque coluna 0 tem apenas o 0
			if(pockets[i][j].getNumber() == number) return i;
		}
	}
	
	return -1;
}



//non-obvious methods
	
	public void populateRoulette(){
		
		RoulettePocket pocket0 = new RoulettePocket(0,'G',true);
		RoulettePocket pocket1 = new RoulettePocket(1,'R',false);
		RoulettePocket pocket2 = new RoulettePocket(2,'B',true);
		RoulettePocket pocket3 = new RoulettePocket(3,'R',false);
		RoulettePocket pocket4 = new RoulettePocket(4,'B',true);
		RoulettePocket pocket5 = new RoulettePocket(5,'R',false);
		RoulettePocket pocket6 = new RoulettePocket(6,'B',true);
		RoulettePocket pocket7 = new RoulettePocket(7,'R',false);
		RoulettePocket pocket8 = new RoulettePocket(8,'B',true);
		RoulettePocket pocket9 = new RoulettePocket(9,'R',false);
		RoulettePocket pocket10 = new RoulettePocket(10,'B',true);
		
		RoulettePocket pocket11 = new RoulettePocket(11,'B',false);
		RoulettePocket pocket12 = new RoulettePocket(12,'R',true);
		RoulettePocket pocket13 = new RoulettePocket(13,'B',false);
		RoulettePocket pocket14 = new RoulettePocket(14,'R',true);
		RoulettePocket pocket15 = new RoulettePocket(15,'B',false);
		RoulettePocket pocket16 = new RoulettePocket(16,'R',true);	
		RoulettePocket pocket17 = new RoulettePocket(17,'B',false);
		RoulettePocket pocket18 = new RoulettePocket(18,'R',true);

		RoulettePocket pocket19 = new RoulettePocket(19,'R',false);
		RoulettePocket pocket20 = new RoulettePocket(20,'B',true);
		RoulettePocket pocket21 = new RoulettePocket(21,'R',false);
		RoulettePocket pocket22 = new RoulettePocket(22,'B',true);
		RoulettePocket pocket23 = new RoulettePocket(23,'R',false);
		RoulettePocket pocket24= new RoulettePocket(24,'B',true);
		RoulettePocket pocket25 = new RoulettePocket(25,'R',false);
		RoulettePocket pocket26= new RoulettePocket(26,'B',true);
		RoulettePocket pocket27= new RoulettePocket(27,'R',false);
		RoulettePocket pocket28 = new RoulettePocket(28,'B',true);
		
		RoulettePocket pocket29 = new RoulettePocket(29,'B',false);
		RoulettePocket pocket30 = new RoulettePocket(30,'R',true);
		RoulettePocket pocket31 = new RoulettePocket(31,'B',false);
		RoulettePocket pocket32 = new RoulettePocket(32,'R',true);
		RoulettePocket pocket33 = new RoulettePocket(33,'B',false);
		RoulettePocket pocket34 = new RoulettePocket(34,'R',true);	
		RoulettePocket pocket35 = new RoulettePocket(35,'B',false);
		RoulettePocket pocket36 = new RoulettePocket(36,'R',true);
		
		Roulette.pockets[0][0]=pocket0;
	    Roulette.pockets[0][1]=pocket3;
	    Roulette.pockets[0][2]=pocket6;
	    Roulette.pockets[0][3]=pocket9;
	    Roulette.pockets[0][4]=pocket12;
	    Roulette.pockets[0][5]=pocket15;
	    Roulette.pockets[0][6]=pocket18;
	    Roulette.pockets[0][7]=pocket21;
	    Roulette.pockets[0][8]=pocket24;
	    Roulette.pockets[0][9]=pocket27;
	    Roulette.pockets[0][10]=pocket30;
	    Roulette.pockets[0][11]=pocket33;
	    Roulette.pockets[0][12]=pocket36;
	   
	    Roulette.pockets[1][0]=pocket0;
	    Roulette.pockets[1][1]=pocket2;
	    Roulette.pockets[1][2]=pocket5;
	    Roulette.pockets[1][3]=pocket8;
	    Roulette.pockets[1][4]=pocket11;
	    Roulette.pockets[1][5]=pocket14;
	    Roulette.pockets[1][6]=pocket17;
	    Roulette.pockets[1][7]=pocket20;
	    Roulette.pockets[1][8]=pocket23;
	    Roulette.pockets[1][9]=pocket26;
	    Roulette.pockets[1][10]=pocket29;
	    Roulette.pockets[1][11]=pocket32;
	    Roulette.pockets[1][12]=pocket35;
	   
	    Roulette.pockets[2][0]=pocket0;
	    Roulette.pockets[2][1]=pocket1;
	    Roulette.pockets[2][2]=pocket4;
	    Roulette.pockets[2][3]=pocket7;
	    Roulette.pockets[2][4]=pocket10;
	    Roulette.pockets[2][5]=pocket13; 
	    Roulette.pockets[2][6]=pocket16;  
	    Roulette.pockets[2][7]=pocket19;  
	    Roulette.pockets[2][8]=pocket22; 
	    Roulette.pockets[2][9]=pocket25;
	    Roulette.pockets[2][10]=pocket28;
	    Roulette.pockets[2][11]=pocket31;	    
	    Roulette.pockets[2][12]=pocket34;
				
				
				
		}
	
	 public RoulettePocket spin() {
		//throw the ball and rotate
		int random_row = (int)(Math.random() * (rows));
		int random_column = (int)(Math.random() * (columns));
		System.out.println("WinPocket:");
		describeRoulettePocket(random_row,random_column);
		return pockets[random_row][random_column];
	}
	 
	public void describeRoulettePocket(int i, int j) {
		System.out.println("Atributes: ");
		System.out.println("	Color : " + pockets[i][j].getColor());
		System.out.println("	Number : " + pockets[i][j].getNumber());
		
		
	}
	public void printRouletteTable() {
		
		for (int i = 0; i < pockets.length; i++) {
			System.out.println("HEY!");
			for (int k = 0; i < pockets[0].length; k++) {
				System.out.print("|"+ pockets[i][k].getNumber() +"|");
			}
			System.out.println();
		}
	}
	





}
