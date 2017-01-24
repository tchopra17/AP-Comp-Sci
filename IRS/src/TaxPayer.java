// Tushar Chopra

import chn.util.*;

public class TaxPayer {
	private boolean isSingle;
	private double income;
	
	public TaxPayer(boolean status, double inc){
		isSingle = status;
		income = inc;
	}
	
	public double getincome(){
		return income;
	}
	public boolean getStatus(){
		return isSingle;
	}
	public double calculateTax() {
		if (isSingle == true) {
			calculateTaxS();
		} else {
			calculateTaxM();
		}
		return income;
	}
	private void calculateTaxS(){
		double taxed = 0; 
		
		if (income >= 0 && income <= 27050){
			taxed = income * 0.15;
		} else if (income <= 65550) {
			taxed = (4057.50 + (0.275*(income - 27050)));
		} else if (income <= 136750) {
			taxed = (14645 + (0.305*(income - 65550)));
		} else if (income <= 297350) {
			taxed = (36361 + (0.355*(income - 135750)));
		} else {
			taxed = (93374 + (0.391*(income - 297350)));
		}
		
		income = taxed;
	}
	private void calculateTaxM(){
		double taxed = 0; 
		
		if (income >= 0 && income <= 45200){
			taxed = income * 0.15;
		} else if (income <= 109250) {
			taxed = (6780 + (0.275*(income - 45200)));
		} else if (income <= 166500) {
			taxed = (24393.75 + (0.305*(income - 109250)));
		} else if (income <= 297350) {
			taxed = (41855 + (0.355*(income - 166500)));
		} else {
			taxed = (88306 + (0.391*(income - 297350)));
		}
		
		income = taxed;
	}
}
