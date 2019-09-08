/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

import java.awt.Color;

public class MoveBF extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {	
		move(30); 
		move(-80);
		move(50);
	}
}
