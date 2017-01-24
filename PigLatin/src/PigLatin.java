// Tushar Chopra 

import chn.util.*;

public class PigLatin {
	static boolean stop = false;
	 
 
    public static void main(String[] args) {
    	boolean quit = false;
           do {
                    ConsoleIO console = new ConsoleIO();
                    System.out.print("Enter a word to translate ('quit' to quit): ");
                    String word = console.readLine();
                    if (word.equals("quit") || (word.equals("Quit"))) {
                    	quit = true;
                    	break;
                    }
                    System.out.println("");
                    System.out.println("Version 1: "+test1(word));
                    System.out.println("Version 2: "+test2(word));
                    System.out.println("");
                    
           } while (!quit);
    }

    public static String test1(String word) {
    	
            String splitFront, splitOrig, result = "";
            int spaces = 0;
            
            if (word.charAt(0) == 'A' || word.charAt(0) == 'a'
                            || word.charAt(0) == 'E' || word.charAt(0) == 'e'
                            || word.charAt(0) == 'I' || word.charAt(0) == 'i'
                            || word.charAt(0) == 'O' || word.charAt(0) == 'o'
                            || word.charAt(0) == 'U' || word.charAt(0) == 'u') {
                    result += word += "yay";
            } else {
                    boolean go = true;
                    for (int i = 1; i <= word.length() - 1; i++) {
                            if (word.charAt(i) == 'A' || word.charAt(i) == 'a'
                                            || word.charAt(i) == 'E' || word.charAt(i) == 'e'
                                            || word.charAt(i) == 'I' || word.charAt(i) == 'i'
                                            || word.charAt(i) == 'O' || word.charAt(i) == 'o'
                                            || word.charAt(i) == 'U' || word.charAt(i) == 'u') {
                                    splitFront = word.substring(i);
                                    splitOrig = word.substring(0, i);
                                    result = splitFront + splitOrig + "ay";
                                    go = false;
                                    break;
                            }
                    }
                    if (go == true) { 
                            result = word + "ay";
                    }
            }
            return result;
    }

    public static String test2(String word) {
            String blank = "", format = "";
            int min;
            if (word.indexOf('A') == 0 || word.indexOf('a') == 0
                            || word.indexOf('E') == 0 || word.indexOf('e') == 0
                            || word.indexOf('I') == 0 || word.indexOf('i') == 0
                            || word.indexOf('O') == 0 || word.indexOf('o') == 0
                            || word.indexOf('U') == 0 || word.indexOf('u') == 0) {
                    
                    blank = word + "yay";
            }
            else if (word.indexOf('A') < 0 && word.indexOf('a') < 0
                            && word.indexOf('E') < 0 && word.indexOf('e') < 0
                            && word.indexOf('I') < 0 && word.indexOf('i') < 0
                            && word.indexOf('O') < 0 && word.indexOf('o') < 0
                            && word.indexOf('U') < 0 && word.indexOf('u') < 0) {
                    blank = word + "ay";
                    
            } else {
                    format = word.toLowerCase();
                    min = Integer.MAX_VALUE;
                    if (format.indexOf('a') > 0 && format.indexOf('a') < min) {
                            min = format.indexOf('a');
                    } if (format.indexOf('e') > 0 && format.indexOf('e') < min) {
                            min = format.indexOf('e');
                    } if (format.indexOf('i') > 0 && format.indexOf('i') < min) {
                            min = format.indexOf('i');
                    }  if (format.indexOf('o') > 0 && format.indexOf('o') < min) {
                            min = format.indexOf('o');
                    }  if (format.indexOf('u') > 0 && format.indexOf('u') < min) {
                            min = format.indexOf('u');
                    }

                    String test = word.substring(min);
                    blank += test;
                    blank += word.substring(0, min);
                    blank += "ay";
            }
            return blank;
    }
}
