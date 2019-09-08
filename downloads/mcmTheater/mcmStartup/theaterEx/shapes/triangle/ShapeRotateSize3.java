/** 
 * forever  draws a triangle followed by 90 degree turn to the right 
 *
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeRotateSize3 extends Actor {
	public void act() {
		while (true) {
			shape(90);
			right(30);
			shape(60);
			right(30);
			shape(40);
			right(30);
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
		Play.main(argv, new ShapeRotateSize3()); 
	}
}
