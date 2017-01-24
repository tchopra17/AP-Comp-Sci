
public class gpaCalculator {
	private String studentName, studentID;
	private int totalPoints, numberGrades;
	private double gpa;
	
	public gpaCalculator(String name, String id){
		studentName = name;
		studentID = id;
		totalPoints = 0;
		numberGrades = 0;
		gpa = 0;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	void addGrade(int grade) {
		totalPoints += grade;
		numberGrades++;
		gpa = (double) totalPoints / numberGrades;
	}
}
