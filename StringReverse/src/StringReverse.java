// Tushar Chopra

import chn.util.*;

public class StringReverse {
	public static void main(String[] args) {
		
		boolean didQuit = false;
		
		ConsoleIO input = new ConsoleIO();
		
		do {
			System.out.print("Enter a word: ");
			String s = input.readToken();
			if (s.charAt(0) == 'q' || s.charAt(0) == 'Q'){
				break;
			}
			System.out.println("Reversed: " + reverse(s));
			
		} while (!didQuit);
	}
	
	static String reverse(String word) {
		 if (word.length() == 0) {
	         return word;
		 }
		return reverse(word.substring(1)) + word.charAt(0);
	}
}
