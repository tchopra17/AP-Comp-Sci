// Tushar Chopra
// Quadratic

import chn.util.*;
import apcslib.*;

public class Quadratic {
	public static void main(String[] args) {
		
		ConsoleIO input = new ConsoleIO();
		double a, b, c, one, two;
		
		//Get abc
		System.out.println("ax^2 + bx + c = 0");
		System.out.print("a = ");
		a = input.readDouble();
		System.out.print("b = ");
		b = input.readDouble();
		System.out.print("c = ");
		c = input.readDouble();
		
		//Calculate
		one = (-b + (Math.sqrt((b*b) - 4*a*c)))/(2*a);
		two = (-b - (Math.sqrt((b*b) - 4*a*c)))/(2*a);
		System.out.println("");
		System.out.println("1st Root: "+(Format.decimalPlaces(one, 4)));
		System.out.println("2nd Root: "+(Format.decimalPlaces(two, 4)));
	}
}
