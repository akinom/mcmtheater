/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class DrawTurnColor extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		while (true) {
			setTrailColor(Dice.throwColor()); 
			for (int i = 0; i < 6; i = i + 1) {
				right(60);
				shape();
			}
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
