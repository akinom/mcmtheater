package theaterEx.sy;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.Actor;
import mcm.utils.Dice;

public class Start5Scale extends Actor {
	public void act() {
		Actor a;
		Shape shape = new EllipseShape(7, 7, true); 
		shape.setColor(Color.BLUE); 
		
		double x = 4;
		double y = 16;
		for (int i = 0; i < 5; i = i + 1) {
			a = new RectangleScale(94, 24); 
			a.setShape(shape); 
			a.setTrailColor(Dice.throwColor());
			a.setTrailWidth(3); 
			a.jumpTo(x, y);
			a.start(getStage()); 
			// the Actor must jump to a position that is: 
			//     100 pixels further to the right and 
			//     50 pixels further up
			x = x + 24; 
			y = y + 24;		
		}	
	}

}