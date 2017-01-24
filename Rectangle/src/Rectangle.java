// Tushar Chopra

public class Rectangle {
	public static void main(String[] args) {
		RectangleMake rectA = new RectangleMake(0, 0, 200, 50);
        RectangleMake copy = new RectangleMake(rectA);
       
        int turn = 27;
        int width = 10;
   
        copy.setXPos(-220);
        copy.setYPos(180);
        copy.draw();
        copy.drawString("Area = " + copy.getArea(), -200, 150);
        copy.drawString("Width = " + copy.getWidth(), -200, 200);
        copy.drawString("Perimeter = " + copy.getPerimeter(), -200, 100);
        copy.drawString("Height = " + copy.getHeight(), 0, 150);
        rectA.draw();
  
        for (int i = 0; i < 11; i++) {
                rectA.setDirection(rectA.getDirection() - turn);
                rectA.setWidth(rectA.getWidth() - width);
                rectA.draw();
        }
	}
}
