import chn.util.*;

public class Tester {

	public static void main(String[] args) {
		CheckingAccount errorFree = new CheckingAccount();
		ConsoleIO console = new ConsoleIO();
		
		while(1 > 0){
			try{
				System.out.print("Please enter a starting balance: ");
				double openingAmt = console.readDouble();
				errorFree = new CheckingAccount(openingAmt);
				System.out.println("Account opened with balance of " + errorFree.getBalance());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		while(1 > 0){
			try{
				System.out.print("Please enter an amount to deposit: ");
				double amount = console.readDouble();
				errorFree.deposit(amount);
				System.out.println("Deposit made. Current account balance = " + errorFree.getBalance());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		while(1 > 0){
			try{
				System.out.print("Please enter an amount to withdraw: ");
				double amount = console.readDouble();
				errorFree.withdraw(amount);
				System.out.println("Withdrawal made. Current account balance = " + errorFree.getBalance());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		
	}	

}
