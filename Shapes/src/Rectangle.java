public class Rectangle extends Shapes{
	private double myLength, myWidth;	// length, width
	
 	// initializes myName, myLength, myWidth
 	public Rectangle (String name, double length, double width) {
 		super(name);
 		myLength = length;
 		myWidth = width;
 		myName = name;
 	}
 	
	
 	public void calcPerimeter(){
 		myPerimeter = (myLength * 2) + (myWidth * 2);
 	}
 	public void calcArea(){
 		myArea = (myLength * myWidth);
 	}
}
