/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 
public class Turn3 extends Actor {
	/*
	 * change the movement direction between moves 
	 */
	public void act() {	
		move(30);
		left(180); 
		move(30); 
		right(180);
	}

}
