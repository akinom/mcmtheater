/** 
 * draws a triangle once 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeOnce extends Actor {
	public void act() {
		move(40);
		right(120);
		move(40);
		right(120);
		move(40);
		right(120);
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ShapeOnce()); 
	}
}
