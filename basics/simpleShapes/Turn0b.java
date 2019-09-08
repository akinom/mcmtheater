/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

import java.awt.Color;

public class Turn0b extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {	
		move(40);
		right(30); 
		move(40); 
	}
}
