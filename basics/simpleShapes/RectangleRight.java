/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class RectangleRight extends Actor {
	/*
	 * a rectangle with right turns 
	 */
	public void act() {	
		move(80);
		right(90); 
		move(50); 
		right(90); 
		move(80);
		right(90); 
		move(50); 
		right(90); 
	}

}
