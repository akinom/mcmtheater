/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class Turn1 extends Actor {
	/*
	 * change the movement direction between moves  
	 * 
	 * try something other than 90 degrees, negative values are ok
	 */
	public void act() {
		move(35);
		left(90); 
		move(20); 
		right(90); 
		move(35); 
	}

}
