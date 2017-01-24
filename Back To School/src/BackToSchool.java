// Tushar Chopra

public class BackToSchool {
	public static void main(String[] args) {
		Person person = new Person("Coach Bob", 27, "M");
		Student student = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
		Teacher teacher = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
		CollegeStudent college = new CollegeStudent("Ima Frosh", 18, "F", "UCB123", 4.0, 1, "English");
		
		System.out.println(person);
		System.out.println(student);
		System.out.println(teacher);
		System.out.println(college);
	}
}
