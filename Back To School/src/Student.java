
public class Student extends Person {
	
	protected String myId;
	protected double myGPA;
	
	public Student(String name, int age, String gender, String id, double gpa) {
		super(name, age, gender);
		
		myId = id;
		myGPA = gpa;
	}
	
	 public String getIdNum(){
        return myId;
      }

      public double getGPA(){
        return myGPA;
      }

      public void setIdNum(String idNum){
        myId = idNum;
      }

      public void setGPA(double gpa){
        myGPA = gpa;
      }
      
      public String toString(){
        return super.toString() + ", student id: " + myId + ", gpa: " + myGPA;
      }
}
