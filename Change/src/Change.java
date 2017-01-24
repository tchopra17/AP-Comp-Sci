// Tushar Chopra
// Change

import apcslib.*;
import chn.util.*;

public class Change {
	public static void main(String[] args) {
		
		ConsoleIO input = new ConsoleIO();
		
		double purchaseAmnt, cashPaid, temp;
		int change, quarter, dime, nickel, penny;
		
		//Get Input
		System.out.print("Amount of Purchase = $");
		purchaseAmnt = input.readDouble();
		System.out.print("Amount Paid = $");
		cashPaid = input.readDouble();
		
		//Calculate Change
		temp = cashPaid-purchaseAmnt;
		temp = temp - (int) temp + 0.00001;
		if (temp < 0) {
			System.out.println("You do not have enough money to buy this item.");
		}
		change = (int)(temp*100);
		System.out.println(change + " Cents");
		quarter = change/25;
		dime = (change % 25)/10;
		nickel = (change % 25 % 10)/5;
		penny = (change % 25 % 10 % 5);
		
		System.out.println(quarter + " Quarters");
		System.out.println(dime + " Dimes");
		System.out.println(nickel + " Nickels");
		System.out.println(penny + " Penny");
  }
}
