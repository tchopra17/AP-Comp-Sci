
public class GradeCalc {
	
	
	private int myClasses, myGrades;
	private int total;
	private double gpa;
	boolean stuHasF;
	private int totalPoints;

	public GradeCalc(int classes, int grades, boolean hasF) {
		myClasses = classes;
		myGrades = grades;
		stuHasF = hasF;
	}
	
	public double getGPA() {
			return gpa;
	}
	
	void addGrade(int grade) {
		total++;
		totalPoints += grade;
		gpa = (double) totalPoints / total;
	}
	
	public int getClasses() {
		return total;
	}
	
	public boolean setF(boolean f) {
		stuHasF = f;
		return stuHasF;
	}
}
