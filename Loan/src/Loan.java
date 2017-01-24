// Tushar Chopra

import chn.util.*;
import apcslib.*;

public class Loan {
	public static void main(String[] args) {
		
		double principal, time, lowRate, highRate, monthlyPayment;
		
		ConsoleIO input = new ConsoleIO();
		
		System.out.print("Principal = ");
		principal = input.readDouble();
		System.out.print("Time = ");
		time = input.readDouble();
		System.out.print("Low Rate = ");
		lowRate = input.readDouble();
		System.out.print("High Rate = ");
		highRate = input.readDouble();
		System.out.println("");
		System.out.println("Annual Interest Rate  |  Monthly Payment");
		
		while (lowRate <= highRate) {
			double c, k, newLow;
			newLow = lowRate / 100;
			k = newLow / 12;
			c = Math.pow((1 + k), (time * 12));
			monthlyPayment = ((principal * k * c) / (c-1)) ;
			System.out.println(Format.left(lowRate, 30, 2) + Format.right(monthlyPayment, 10, 2));
			lowRate += 0.25;
		}
		
	}
}
