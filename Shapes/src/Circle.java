
public class Circle extends Shapes {
 	private double myRadius;	// length of radius
	
 	// initializes myName and myRadius
 	public Circle (String name, double radius){
 		super(name);
 		myRadius = radius;
 		myName = name;
 	}
	
 	public void calcPerimeter() {
 		myPerimeter = (2 * Math.PI * myRadius);
 	}
 	public void calcArea(){
 		myArea = Math.PI * (myRadius * myRadius);
 	}
}
