/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class RectangleLeft extends Actor {
	/*
	 * this makes a rectangle 
	 */
	public void act() {	
		move(80);
		left(90); 
		move(50); 
		left(90); 
		move(80);
		left(90); 
		move(50); 
		left(90); 
	}

}
