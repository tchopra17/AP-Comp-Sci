// Tushar Chopra
// Taxes

import apcslib.*;
import chn.util.*;

public class Taxes {
	public static void main(String[] args) {
		
		double hours, rate, pay, fedTax, fica, state;
		final double FED_TAX = 0.15;
		final double FICA = 0.0765;
		final double STATE_TAX = 0.04;
		ConsoleIO input = new ConsoleIO();
		
		System.out.print("Hours Worked: ");
		hours = input.readDouble();
		System.out.print("Hourly Rate: ");
		rate = input.readDouble();
		
		pay = (rate*hours);
		fedTax = FED_TAX*pay;
		fica = FICA*pay;
		state = STATE_TAX*pay;
		System.out.println("");
		System.out.println("Gross Pay: "+(Format.right(pay,17,2)));
		System.out.println("");
		System.out.println("Fedral Tax (15%): "+(Format.right((fedTax), 10, 2)));
		System.out.println("FICA (7.65%): "+(Format.right((fica), 14, 2)));
		System.out.println("State Tax (4%): "+(Format.right((state), 12, 2)));
		System.out.println("");
		System.out.println("Net Pay: "+(Format.right((pay-fedTax-fica-state), 19, 2)));
	}
}
