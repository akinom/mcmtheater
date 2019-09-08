/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class DrawRandom extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		while (true) {
			setTrailColor(Dice.throwColor());
			shape();
			setDirection(Dice.throwInt(360)); 
			jumpTo(Dice.throwPoint(getStage()));
		}
	}
	
	public void shape() {
		move(40);
		right(45);
		move(40);
		right(135);
		move(40);
		right(45);
		move(40);
		right(135);

	}

}
