/** 
 * forever jumps to a randomly chosen spot on the stage, and 
 *         draws a triangle
 *         and turns 60 degrees to the right, so that consecutively drawn 
 *         triangles are rotated relative to each other
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class ShapeJumpRandom extends Actor {
	public void act() {
		while (true) {
			jumpTo(Dice.throwPoint(getStage()));
			shape(25);
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
		Play.main(argv, new ShapeJumpRandom()); 
	}
}
