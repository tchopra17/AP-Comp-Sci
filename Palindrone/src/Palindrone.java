// Tushar Chopra

import chn.util.*;
public class Palindrone {
	
	public static String broken = "";
	public static int length = 0;
	public static String rever = "";
	public static boolean isPalindrone;
	
	public static void main(String[] args) {
	
		ConsoleIO input = new ConsoleIO();
		boolean quit = false;
		do {
			
			System.out.print("Enter a word or phrase ('quit' to quit) -> ");
			String full = input.readLine();
			
			if (full.contains("quit") || full.contains("Quit")) {
				quit = true;
				break;
			}
			
			Palindrone(full);
			reverse();
			if (isPalindrone == false) {
				System.out.println("This is not a palindrone.");
			} else {
				System.out.println("This is a palindrone");
			}
			
			System.out.println(broken);
			broken = "";
			rever = "";
			
		} while (!quit);
		
	}
	
	public static String Palindrone (String line) {
		length = line.length();
		String lower = line.toLowerCase();
		
		for (int i = 0; i < length; i++) {
			if ((lower.charAt(i) >= 'a' && lower.charAt(i) <= 'z') || (lower.charAt(i) >= '0' && lower.charAt(i) <= '9') ){
				broken += lower.charAt(i);
			}
		}
		return broken;
	}
	
	public static boolean reverse() {
		length = broken.length();
		for (int i = (length - 1); i >= 0; i--) {
			if ((broken.charAt(i) >= 'a' && broken.charAt(i) <= 'z') || (broken.charAt(i) >= '0' && broken.charAt(i) <= '9') ){
				rever += broken.charAt(i);
			}
		}
		if (rever.equals(broken)) {
			isPalindrone = true;
		} else {
			isPalindrone = false;
		}
		return isPalindrone;
	}

}
