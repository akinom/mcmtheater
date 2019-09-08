/** 
 * forever draws a three triangles rotated about a center followed by a jump to 
 * a randomly chosen corner of one of the triangles drawn
 * 
 * sets its shape and  trail color randomly before 
 * drawing each set of six triangles
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class RotateSlideTurn extends Actor {

	public void act() {
		setStepSize(100);
		while (true) {			
			rotateShapeSlide();			
			jumpTo(getStage().getCenter()); 
			left(Dice.throwInt(360));
		}
	}

	public void rotateShapeSlide() 
	{
	    for (int i = 0; i < 3; i++) {
			rotateShape();			
			jump(35);
	    }
	}
	
	// draw shape three times rotating it by 120 degrees
	public void rotateShape() {
		for (int i = 0; i < 3; i++) {
			shape(10);
			right(120);
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
		Play.main(argv, new RotateSlideTurn()); 
	}
}
