//Tushar Chopra
//Car Rental

import apcslib.*;
import chn.util.*;

public class CarRental {
	public static void main(String[] args) {
		
		int plateNum;
		
		ConsoleIO input = new ConsoleIO();
		
		// Get Values
		System.out.print("Make = ");
		String make = input.readToken();
		System.out.print("Model = ");
		String model = input.readToken();
		System.out.print("License Plate = ");
		String plateChar = input.readToken();
		plateNum = input.readInt();
		
		//Calculate ASCII
		char c1 = plateChar.charAt(0);		
		char c2 = plateChar.charAt(1);
		char c3 = plateChar.charAt(2);
		int letter1 = (char) (c1);
		int letter2 = (char) (c2);
		int letter3 = (char) (c3);
		int sum = letter1 + letter2 + letter3;
		int totSum = sum + plateNum;
		int offset = totSum % 26;
		char letter = (char) (offset + 'A');
		System.out.println("Rental Code = "+ letter + totSum);
	}
}
