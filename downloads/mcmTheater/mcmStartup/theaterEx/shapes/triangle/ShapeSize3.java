/**
 * draws a triangle once
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeSize3 extends Actor {
	public void act() {
		while (true) {
			shape(30);
			shape(60);
			shape(90);
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
		Play.main(argv, new ShapeSize3()); 
	}
}