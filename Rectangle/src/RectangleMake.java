import apcslib.*;

public class RectangleMake {
	
	private double x1, y1, width1, height1, perim, area, myDirection;
	private static DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
	
	public RectangleMake() {
		x1 = 0;
		y1 = 0;
		width1 = 0;
		height1 = 0;
	}
	public RectangleMake(double x, double y, double width, double height){
		
		x1 = x;
		y1 = y; 
		width1 = width;
		height1 = height;
		
	}
	
	public RectangleMake(RectangleMake rect) {
         x1 = rect.getXPos();
         y1 = rect.getYPos();
         width1 = rect.getWidth();
         width1 = rect.getHeight();
	}
    public void setXPos(double x) {
        x1 = x;
    }


    public void setYPos(double y) {
        y1 = y;
    }

    public void setWidth(double width) {
        width1 = width;
    }


    public void setHeight(double height) {
        height1 = height;
    }


    public void setDirection(double direction) {
        myDirection = direction;
    }


    public double getXPos() {
        return x1;
    }


    public double getYPos() {
        return x1;
    }


    public double getWidth() {
        return width1;
    }


    public double getHeight() {
        return height1;
    }


    public double getDirection() {
        return myDirection;
    }


    public double getPerimeter() {
        return (height1 * 2) + (width1 * 2);
    }


    public double getArea() {
        return height1 * width1;
    }

    public void drawString(String str, double x, double y) {
        pen.up();
        pen.move(x, y);
        pen.down();
        pen.drawString(str);
    }

    public void draw() {
            pen.up();
            pen.move(x1, y1);
            pen.down();
            pen.setDirection(myDirection);
            pen.forward(width1);
            pen.turnRight(90);
            pen.forward(height1);
            pen.turnRight(90);
            pen.forward(width1);
            pen.turnRight(90);
            pen.forward(height1);
    }

	
	
}
