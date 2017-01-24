// Tushar Chopra

import chn.util.*;

public class Fibonacci {
	public static void main(String[] args) {
		
		int a = 0;
		
		boolean didFinishRec = false;
		boolean didFinishMult = false;
		boolean didFinishNonRec = false;
		
		ConsoleIO input = new ConsoleIO();
		do {
			
			System.out.println("Recursive Fibonacci: ");
		
			System.out.print("Enter a position to get the Fibonacci value: ");  
		
			int position = input.readInt();
			System.out.println("Fibbonaci value: " + fib(position));
			a++;
			if (a == 3) {
				didFinishRec = true;
				a = 0;
			}
			System.out.println();
		} while (!didFinishRec);
		
		do {
			
			System.out.println("Non-Recursive Fibonacci: ");
		
			System.out.print("Enter a position to get the Fibonacci value: ");  
		
			int position = input.readInt();
			System.out.println("Fibbonaci value: " + nonFib(position));
			a++;
			if (a == 3) {
				didFinishNonRec = true;
				a = 0;
			}
			System.out.println();
		} while (!didFinishNonRec);
		
		do {
			System.out.println("\nRecursive multiplication: ");
			System.out.print("Enter the first factor: ");
			int factor1 = input.readInt();
			System.out.print("Enter the second factor: ");
			int factor2 = input.readInt();
			System.out.println(factor1 + " x " + factor2 + " = " + mult(factor1, factor2));
			a++;
			if (a == 4) {
				didFinishMult = true;
				a = 0;
			}
			System.out.println();
		} while (!didFinishMult);
	}
	
	static int fib (int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1 || num == 2) {
			return 1;
     	} else{
			return fib(num-1) + fib(num-2);
		}
    }
	
	static int nonFib (int num) {
	
		if (num <= 1){
			return num;
		}
		int fibo = 1;
		int fiboPrev = 1;
		for(int i = 2; i < num; ++i){
			int temp = fibo;
			fibo += fiboPrev;
			fiboPrev = temp;
		}
		return fibo;
	}
	
	static int mult (int factor1, int factor2)
    {
    	if (factor1==1) {
    		return factor2;
    	}
    	if(factor2==1) {
    		return factor1;
    	}
    	if (factor1==0 || factor2==0) {
    		return 0;
    	}
    	else {
    		return mult(factor1,factor2-1)+factor1;
    	}
	}

}
