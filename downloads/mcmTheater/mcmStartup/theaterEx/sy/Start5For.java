
package theaterEx.sy;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class Start5For extends Actor {
	public void act() {
		Actor a;
		Shape shape = new EllipseShape(11, 11, true); 
		shape.setColor(Color.BLUE); 
		
		double x = 60;
		double y = 40;
		for (int i = 0; i < 5; i = i + 1) {
			a = new Rectangle(); 
			a.setShape(shape); 
			a.setTrailColor(Dice.throwColor());
			a.setTrailWidth(3); 
			a.jumpTo(x, y);
			a.start(getStage()); 
			// the Actor must jump to a position that is: 
			//     100 pixels further to the right and 
			//     50 pixels further up
			x = x + 60; 
			y = y + 60;		
		}	
	}

}
