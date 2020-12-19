package CasinoUtils;

import java.util.Scanner;
import java.util.InputMismatchException;

public class safeReader {
	
private static Scanner sc = new Scanner(System.in);
private static String errorMessage = "wrong data type!! Insert again:\n";

	public static double readDoubleSafetly() {
		
	
		double num = 0.0;
		
		boolean reading = true; 
		
		while(reading) {
			
			try {
				num = sc.nextDouble();
				reading = false;
			} 
			
			catch(InputMismatchException e) {
				
				System.out.println(errorMessage);
				sc.next();
				
			}
			
			
		}
		
		
		return num;
		
	}
	
	public static int readIntSafetly() {
		
		int n = 0;
		boolean reading = true;
		
		while(reading) {
			
			try {
				
				// 1)
				
				n = sc.nextInt();
				// 1.2)
				reading = false;
				
			
				//2)
				
				}catch(InputMismatchException e) {
				
				System.out.println(errorMessage);
				sc.next();
				
			}
		}
		

		
		
	return n;
	
}
	
	
public static String readStringSafetly() {
		
		String n = "";
		boolean reading = true;
		
		while(reading) {
			
			try {
				
				// 1)
				n = sc.nextLine();
				// 1.2)
				reading = false;
				
			
				//2)
				
				}catch(InputMismatchException e) {
				
				System.out.println(errorMessage);
				sc.next();
				
			}
		}
		

		
		
	return n;
	
}
	
	

public static boolean readBooleanSafetly() {
	
	boolean n = false;
	
	boolean reading = true;
	
	while(reading) {
		
		try {
			
			// 1)
			n = sc.nextBoolean();
			// 1.2)
			reading = false;
			
		
			//2
			
			}catch(InputMismatchException e) {
			
			System.out.println(errorMessage);
			sc.next();
			
		}
	}
	

	
	
return n;

}
	// Make readStringSafetly,readBooleanSafetly,readCharSafetly!
	
	
	
	
	}
