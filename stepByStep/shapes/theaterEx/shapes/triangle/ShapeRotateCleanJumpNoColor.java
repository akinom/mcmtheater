/** 
 * forever draws a three triangle rotated about a center followed by a jump to 
 * a randomly chosen corner of one of the triangles drawn
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class ShapeRotateCleanJumpNoColor extends Actor {

	public void act() {
		while (true) {
			rotateShape();
			gotoPos();
		}
	}

	// draw shape three times rotating it by 120 degrees
	public void rotateShape() {
		for (int i = 0; i < 3; i++) {
			shape(20);
			right(120);
		}
	}

	
	public void gotoPos() {
		int dice = Dice.throwInt(2);   // dice = 0, 1, 2, 3, 4, or 5
		left(dice * 60);               // dice * 60 = 0, 60, 120, ..., 300
		
		// jump along one of the six triangle edges drawn out from center  
		// jump far enough to draw next three triangles non overlapping with 
		// last three triangle drawn 
		jump(45);
		
		// if actor jumped outside the stage area 
		// it jumps to stage center
		if (! getStage().isInside(getPos())) {
			jumpTo(getStage().getCenter());
		}
	}
	
	public void shape(double size) {
		move(size);
		right(120);
		move(size);
		right(120);
		move(size);
		right(120);
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ShapeRotateCleanJumpNoColor()); 
	}
}

