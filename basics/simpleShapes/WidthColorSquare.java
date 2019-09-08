/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

import java.awt.Color;

public class WidthColorSquare extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		shape();
		left(90); 
		shape();
		left(90); 
		shape();
		left(90); 
		shape();
		left(90); 
	}	
	
	private void shape() {
		setTrailColor(Color.GREEN);
		setTrailWidth(3); 
		move(10);

		setTrailWidth(5); 
		setTrailColor(Color.ORANGE);
		move(20);

		setTrailWidth(7); 
		setTrailColor(Color.MAGENTA);
		move(30);
		
	}

}
