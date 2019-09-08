/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import java.awt.Color;

public class DrawWhile extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		while (true) {
			shape();
		}
	}
	public void shape() {
		move(50);
		right(45); 
		move(50); 
		right(135); 
		move(50);
		right(45); 
		move(50); 
		right(135); 

	}

}
