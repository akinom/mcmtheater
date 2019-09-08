
package theaterEx.sy;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class Start5Shape extends Actor {
	public void act() {
		Actor a;
		Shape shape = new EllipseShape(11, 11, true); 
		shape.setColor(Color.BLUE); 
		
		a = new Rectangle();
		a.setShape(shape);
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(60, 40);
		a.start(getStage());

		a = new Rectangle();
		a.setShape(shape);
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(120, 100);
		a.start(getStage());
		
		a = new Rectangle();
		a.setShape(shape);
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(180, 160);
		a.start(getStage());

		a = new Rectangle();
		a.setShape(shape);
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(240, 220);
		a.start(getStage());

		a = new Rectangle();
		a.setShape(shape);
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(300, 280);
		a.start(getStage());
		
	}
}
