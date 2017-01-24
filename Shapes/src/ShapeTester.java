import apcslib.Format;

public class ShapeTester {
	public static void main(String[] args) {
		// instantiate Shapes array
		Shapes[] shapes = new Shapes[3];
			
		// construct each Shape object
		// 	Square with side length 3
		shapes[0] = new Square("square", 3);
		//	Circle with radius 3
		shapes[1] = new Circle("circle", 3);		
		// 	Rectangle with length 3 and width 4
		shapes[2] = new Rectangle("rectangle", 3, 4);

		System.out.println();
		for (Shapes s : shapes)
		{
			s.calcPerimeter();
			s.calcArea();
			System.out.println(s.getName() +"   Perimeter: " + Format.decimalPlaces(s.getPerimeter(), 2) + "   Area: " + Format.decimalPlaces(s.getArea(), 2));
		}
	}
}
 