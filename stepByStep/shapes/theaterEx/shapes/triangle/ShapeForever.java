/** 
 * draws a triangle once 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeForever extends Actor {
	public void act() {
		while (true) {
			shape();
		}
	}
	
	public void shape() {
		move(40);
		right(120);
		move(40);
		right(120);
		move(40);
		right(120);
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ShapeForever()); 
	}
}
