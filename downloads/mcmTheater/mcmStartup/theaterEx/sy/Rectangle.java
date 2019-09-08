package theaterEx.sy;

import mcm.theater.*;

public class Rectangle extends Actor {
	public void act() {
		while (true) {  // do statements inside { ... } forever 
			move(250);	// move 250 pixels forward 
			left(90);	// turn 90 degrees to the left
			move(60);	// move 60 pixels forward
			left(90);	// turn 90 degrees to the left
			move(250);	// move 250 pixels forward 
			left(90);	// turn 90 degrees to the left
			move(60);	// move 60 pixels forward
			left(90);	// turn 90 degrees to the left
		}
	}
}
