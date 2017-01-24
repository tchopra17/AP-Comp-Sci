//Tushar Chopra
//Draw House

import apcslib.*;
import java.awt.*;

public class draw {
	public static void main(String[] args) {
		DrawingTool pencil;
		SketchPad paper;
		
		paper = new SketchPad(1000, 1000);
		pencil = new DrawingTool(paper);
		
		//Draw Frame
		pencil.setColor(Color.black);
		pencil.setWidth(3);
		pencil.drawRect(400, 300);
		
		//Draw Roof
		pencil.up();
		pencil.move(-200, 150);
		pencil.down();
		pencil.setDirection(30);
		pencil.forward(231);
		pencil.setDirection(0);
		pencil.setDirection(-30);
		pencil.forward(231);
		
		//Draw Door
		pencil.up();
		pencil.move(-25, -150);
		pencil.down();
		pencil.setDirection(90);
		pencil.forward(100);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(100);
		pencil.up();
		pencil.move(15, -100);
		pencil.down();
		pencil.drawCircle(5);
		
		//Draw Windows
		pencil.setColor(Color.blue);
		pencil.up();
		pencil.move(-135, 75);
		pencil.down();
		pencil.setDirection(0);
		pencil.turn(45);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		
		pencil.up();
		pencil.move(75, 75);
		pencil.down();
		pencil.setDirection(0);
		pencil.turn(45);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(50);
		pencil.turnRight(90);
		
		//Draw Chimney
		pencil.setColor(Color.black);
		pencil.up();
		pencil.move(-200, 150);
		pencil.down();
		pencil.setDirection(90);
		pencil.forward(50);
		pencil.turnRight(90);
		pencil.forward(30);
		pencil.turnRight(90);
		pencil.forward(33);
		
		
	}
}
