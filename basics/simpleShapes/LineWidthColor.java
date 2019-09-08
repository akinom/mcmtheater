/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class LineWidthColor extends Actor {
	/*
	 * modify to draw a lines with different line thicknesses 
	 * 
	 * choose your own thickness (minimum is 1) 
	 */	
	public void act() {
		setTrailWidth(3); 
		setTrailColor(Color.GREEN);
		move(10);

		setTrailWidth(5); 
		setTrailColor(Color.ORANGE);
		move(20);

		setTrailWidth(7); 
		setTrailColor(Color.MAGENTA);
		move(30);
	}

}
