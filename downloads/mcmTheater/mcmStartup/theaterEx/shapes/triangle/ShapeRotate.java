/** 
 * forever  draws a triangle followed by 90 degree turn to the right 
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeRotate extends Actor {
	public void act() {
		while (true) {
			shape(70);
			right(90);
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
		Play.main(argv, new ShapeRotate()); 
	}
}
