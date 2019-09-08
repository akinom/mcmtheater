/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class WidthColorSquareJump extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		while (true) {
			square();
			// jump to a randomly chosen position on the stage
			jumpTo(Dice.throwPoint(getStage()));
		}
	}
	public void square() {
		shape();
		left(90); 
		shape();
		left(90); 
		shape();
		left(90); 
		shape();
		left(90); 
	}	
	
	private void shape() {
		setTrailColor(Color.GREEN);
		setTrailWidth(3); 
		move(10);

		setTrailWidth(5); 
		setTrailColor(Color.ORANGE);
		move(20);

		setTrailWidth(7); 
		setTrailColor(Color.MAGENTA);
		move(30);
		
	}

}
