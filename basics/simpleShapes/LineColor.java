/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import java.awt.Color;

public class LineColor extends Actor {
	/*
	 * modify to draw lines in colors of your choice; 
	 * 
	 * choose your own movement length 
	 * 
	 * choose from the following predefined colors:
	 * 
	 * Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
	 * Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
	 * Color.RED, Color.WHITE, Color.YELLOW
	 */

	/**
	 * draws a square of length 30
	 */
	public void act() {
		setTrailWidth(3); 
		
		setTrailColor(Color.GREEN);
		move(10);

		setTrailColor(Color.ORANGE);
		move(20);

		setTrailColor(Color.MAGENTA);
		move(30);
	}


}
