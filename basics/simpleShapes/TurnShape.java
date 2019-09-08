/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import java.awt.Color;

public class TurnShape extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		while (true) {
			right(60);
			shape();
		}
	}
	public void shape() {
		move(40);
		right(45); 
		move(40); 
		right(135); 
		move(40);
		right(45); 
		move(40); 
		right(135); 
	}

}
