public class Square extends Shapes{
	private double mySide;	// length of side
	
 	// initializes myName and mySide
 	public Square(String name, double side){
 		super(name);
 		mySide = side;
 		myName = name;
 	}
	
 	public void calcPerimeter() {
 		myPerimeter = mySide * 4;
 	}
 	public void calcArea() {
 		myArea = mySide * mySide;
 	}
}
