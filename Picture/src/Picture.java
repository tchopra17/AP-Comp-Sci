// Tushar Chopra

import chn.util.*;

public class Picture {
	public static void main(String[] args) {
		
			ConsoleIO keyboard = new ConsoleIO();
		    String get;

		    printTable(4,6);
		    get = keyboard.readLine(); // freezes the output screen to see the picture
		    printTable(11,12);
		    get = keyboard.readLine();
		    pyramid(10);
		    get = keyboard.readLine();
		    pyramid(25);
		    get = keyboard.readLine();
	}
	
	 public static void printTable(int rows, int columns) {
		 
         System.out.print("     ");
         
         for (int i = 1; i <= rows; i++) {
        	 
        	 if (i < 9) {
                System.out.print(i + "    ");
        	 } else {
        		 System.out.print(i + "   ");
        	 }
 
         }
         
         int test = columns;
         
         System.out.println(" ");
         
         for (int c = 1; c <= test; c++) {
                 System.out.print(c + "  ");

                 for (int x = 1; x <= rows; x++) {
                	 	if ((c*x) < 10) {
                	 		System.out.print("  " + c * x + "  ");
                	 	} else if ((c*x) < 100) {
                	 		System.out.print(" " + c * x + "  ");
                	 	} 
                 }
                 System.out.println(" ");
         }
	 }
	 
	 public static void pyramid(int lines) {
          int stars, spaces, c;
          c = lines;
          for (int row = 1; row <= lines; row++) {
                  stars = (2 * row) - 1;
                  spaces = c;
                  
                  for (int s = 0; s <= spaces; s++) {
                          System.out.print(" ");
                  }    
                  
                  c--;
                  for (int column = 1; column <= stars; column++) {
                          System.out.print("*");
                  }
                  System.out.println(" ");
          }
	  }
}
