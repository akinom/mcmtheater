/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class Turn2 extends Actor {
	/*
	 * change the movement direction between moves 
	 */
	public void act() {
		right(180); 
		
		move(35);
		left(90); 
		move(20); 
		right(90); 
		move(35); 
	}

}
