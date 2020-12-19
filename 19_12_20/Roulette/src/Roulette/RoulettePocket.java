package Roulette;

public class RoulettePocket  {
//atributes
		private int number;
		private char color;
		private boolean even; 
		
		RoulettePocket(int number, char color, boolean even){
			this.number = number;
			this.color = color;
			this.even = even;
		}

//obvious-methods
		
		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public char getColor() {
			return color;
		}

		public void setColor(char color) {
			this.color = color;
		}

		public boolean isEven() {
			return even;
		}

		public void setEven(boolean even) {
			this.even = even;
		}
		
		//non-obvious methods
		public void printPocket() {
			System.out.println(" ----- ");
			System.out.println("|  "+this.getNumber()+"  |");
			System.out.println("|  "+this.getColor()+"   |");
			System.out.println(" ----- ");
		}
		
}
