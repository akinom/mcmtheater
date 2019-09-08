
package simpleShapes;

import mcm.theater.Actor;

public class CenteredSquare extends Actor {
	
	double len = 10;
	
	public void setLength(double l) { len = l; }
	
	public void act() {
		// move to the upper left corner of the len  by len square 
		// that is drawn in the while loop
		jump(-len / 2);   
		right(90);        
		jump(-len / 2);
		left(90);
		setDebugMode(true);
		while (true) {
			for (int i = 0; i < 4; i++) {
				move(len);
				right(90);
			}
		}
	}
}