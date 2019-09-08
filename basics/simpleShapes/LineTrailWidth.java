/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class LineTrailWidth extends Actor {
	/*
	 * modify to draw a lines with different line thicknesses 
	 * 
	 * choose your own thickness (minimum is 1) 
	 */	
	public void act() {
		setTrailWidth(3); 
		move(10);

		setTrailWidth(5); 
		move(20);

		setTrailWidth(7); 
		move(30);
	}

}
