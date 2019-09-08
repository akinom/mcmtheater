/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

import java.awt.Color;

public class Turn0a extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {	
		move(40);
		left(30); 
		move(40); 
	}
}
