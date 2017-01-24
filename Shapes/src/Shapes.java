
public abstract class Shapes {
	protected String myName;
	protected double myPerimeter;
	protected double myArea;

	public Shapes(String name) {
		myName = name;
	}
	  
	public String getName(){
		return myName;
	}
	  
	public double getPerimeter(){
		return myPerimeter;
	}
	  
	public double getArea(){
		return myArea;
	}
	  
	public abstract void calcPerimeter();
	public abstract void calcArea();
}
