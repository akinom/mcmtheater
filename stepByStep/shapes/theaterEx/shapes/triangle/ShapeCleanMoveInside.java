/** 
 * forever 
 *    draws a triangle finishing at one of its corners 
 *    moves to one of the two other corners rotating 60 degrees in 50% of the cases
 *    and starts over drawing another rectangle draws another triangle
 * 
 * takes to care to not leave the stage 
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class ShapeCleanMoveInside extends Actor {
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
	
	public static void main(String argv[]) {
		Play.main(argv, new ShapeCleanMoveInside()); 
	}
}
