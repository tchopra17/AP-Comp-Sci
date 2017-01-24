// Tushar Chopra

import apcslib.Format;
import chn.util.*;

public class Grades {
	public static void main(String[] args) {
		
		ConsoleIO input = new ConsoleIO();
		GradeCalc calcGrade = new GradeCalc( 0, 0, false);
		boolean stop = false;
		boolean hasF = false;
		
		do {
			if (calcGrade.getClasses() > 0) {
			System.out.println("");
			System.out.println("GPA: " + Format.decimalPlaces(calcGrade.getGPA(), 2));
				if (calcGrade.getClasses() < 4) {
					System.out.println("Ineligible, has less than 4 classes. ");
				} else if (calcGrade.getGPA() < 2.0 && calcGrade.setF(hasF) == true ){
					System.out.println("Ineligible, gpa below 2.0 and has F grade ");
				} else if (calcGrade.getGPA() > 2.0 && calcGrade.setF(hasF) == true) {
					System.out.println("Ineligible, gpa above 2.0 but has F grade");
				} else {
					System.out.println("Eligible");
				}
			}
			System.out.println("");
			System.out.println("Enter A Letter Grade: ");
			String grade = input.readToken();
			char letterGrade = grade.charAt(0);
			
			switch (letterGrade) {
			case 'A':
			case 'a':
				calcGrade.addGrade(4);
				break;
			case 'B':
			case 'b':
				calcGrade.addGrade(3);
				break;
			case 'C':
			case 'c':
				calcGrade.addGrade(2);
				break;
			case 'D':
			case 'd':
				calcGrade.addGrade(1);
				break;
			case 'F':
			case 'f':
				calcGrade.addGrade(0);
				hasF = true;
				calcGrade.setF(hasF);
				break;
			case 'S':
			case 's':
				stop = true;
				break;
			}
		} while (!stop);
		
	}
}
