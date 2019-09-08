/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 
import java.awt.Color;
 

public class TurnRectangle extends Actor {
	/** 
	 * turn each time before drawing a rectangle 
	 */
	public void act() {	
		while (true) { 
			left(60); 
			
			// draw a rectangle 
			move(70);
			right(90); 
			move(30); 
			right(90); 
			move(70);
			right(90); 
			move(30); 
			right(90); 
		}
	}

}
