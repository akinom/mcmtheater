/** 
 * forever jumps to a randomly chosen spot on the stage, and 
 *         draws a triangle
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeJump extends Actor {
	public void act() {
		// as long as this actor remains inside the stage 
		while (getStage().isInside(getPos())) {
			shape(20);
			jump(25);
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
		Play.main(argv, new ShapeJump()); 
	}
}
