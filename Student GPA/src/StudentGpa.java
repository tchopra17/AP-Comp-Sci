// Tushar Chopra
// Student GPA

import apcslib.Format;
import chn.util.*;

class StudentGpa {
	public static void main(String[] args) {
		
		ConsoleIO input = new ConsoleIO();
		
		System.out.print("Enter Student's Name: ");
		String name = input.readLine();
		System.out.print("Enter Student's ID: ");
		String id = input.readToken();
		
		gpaCalculator gradePoint = new gpaCalculator(name, id);
		
		System.out.println(" ");
		System.out.println("GPA is: "+gradePoint.getGPA());
		System.out.println(" ");
		System.out.print("Enter first grade: ");
		int grade1 = input.readInt();
		gradePoint.addGrade(grade1);
		
		System.out.println(" ");
		System.out.println("GPA is: "+gradePoint.getGPA());
		System.out.println(" ");
		System.out.print("Enter second grade: ");
		int grade2 = input.readInt();
		gradePoint.addGrade(grade2);
		
		System.out.println(" ");
		System.out.println("GPA is: "+gradePoint.getGPA());
		System.out.println(" ");
		System.out.print("Enter first grade: ");
		int grade3 = input.readInt();
		gradePoint.addGrade(grade3);
		System.out.println(" ");
		System.out.println("GPA is: "+Format.decimalPlaces(gradePoint.getGPA(), 2));
	}
	
}
