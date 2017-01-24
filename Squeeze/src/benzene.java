// Tushar Chopra
// Benzene

import apcslib.*;

public class benzene {
	public static void main(String[] args) {
		DrawingTool pencil;
		SketchPad paper;
		
		paper = new SketchPad(500,500);
		pencil = new DrawingTool(paper);
		
		// Draw Circle
		pencil.drawCircle(250);
		
		//Draw Hexagon
		pencil.up();
		pencil.move(-160, 270);
		pencil.down();
		pencil.setDirection(0);
		pencil.forward(320);
		pencil.setDirection(-60);
		pencil.forward(320);
		pencil.setDirection(-120);
		pencil.forward(320);
		pencil.setDirection(-180);
		pencil.forward(320);
		pencil.setDirection(-240);
		pencil.forward(320);
		pencil.setDirection(-300);
		pencil.forward(320);
	}
}
