/** 
 * forever  draws a triangle followed by 90 degree turn to the right 
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class Shape3PackRound extends Actor {
	public void act() {
		while (true) {
			setTrailColor(Dice.throwColor());
			setColor(getTrailColor());
			threeShapes();
			threeShapes();
			threeShapes();
			threeShapes();
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
		Play.main(argv, new Shape3PackRound()); 
	}
}