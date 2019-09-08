/**
 * create a RED, GREEN, and BLUE ShapeRotateCleanJumpNoColor actor
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.theater.*;
import mcm.utils.Dice;

public class ListShapeMoveCleanRGB extends Actor {
	public void act() {
		setVisible(false); // this actor is hidden on stage 
		
		makeJumper(Color.RED);
		sleep(10); // wait 10 clock ticks before starting the next 
		makeJumper(Color.GREEN);
		sleep(10); // wait 10 clock ticks before starting the next 
		makeJumper(Color.BLUE);
		sleep(10); // wait 10 clock ticks before starting the next 
	}
	
	public void makeJumper(Color color) 
	{
		Actor mover; 
		
		mover = new ShapeCleanMoveInside(); 
		mover.setTrailWidth(2);
		mover.jumpTo(getStage().getCenter());
		mover.setShape(new EllipseShape(9, 9, true));
		mover.setColor(color);
		mover.setTrailColor(color);
		mover.start(getStage());
	}
	
	 class ShapeCleanMoveInside extends Actor {
		public void act() {
			while (true) {
				shape(20);
				int choice = Dice.throwInt(2); // either 0 or 1
				if (choice == 0) {  // go one triangle corner
					right(60);
					move(20);
				} else {
					move(20);      // go to other triangle corner
				}
				if (! getStage().isInside(getPos())) {
					move(-20); // return to stage 
				}
			}
		}
		
		// draw triangle 
		public void shape(double size) {
			move(size);
			right(120);
			move(size);
			right(120);
			move(size);
			right(120);
		}
	}

}
