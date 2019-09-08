/** 
 * forever  draws a triangle followed by 90 degree turn to the right 
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class Shape3PackFinal extends Actor {
	public void act() {
		setStepSize(100);   // move really fast 
		setTrailWidth(2);   // leave 2 pixel wide path 
		setVisible(false);  // do not show shape
		while (true) {
			// choose random trail color
			setTrailColor(Dice.throwColor());
			threeShapes();
			threeShapes();
			threeShapes();
			threeShapes();
			sleep(10);
			// set stage's background to current trail color
			getStage().setColor(getTrailColor());
		}
	}
	
	public void threeShapes() {
		shape(90);
		right(30);
		shape(60);
		right(30);
		shape(40);
		right(30);
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
		Play.main(argv, new Shape3PackFinal()); 
	}
}
