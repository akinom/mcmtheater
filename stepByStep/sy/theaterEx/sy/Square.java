package theaterEx.sy;

import mcm.theater.*;

public class Square extends Actor {
	public void act() {
		// draw a 100 pixel square ONCE
		move(100);	// move 100 pixels forward
		left(90);	// turn 90 degrees to the left
		move(100);	// move 100 pixels forward
		left(90);	// turn 90 degrees to the left
		move(100);	// move 100 pixels forward
		left(90);	// turn 90 degrees to the left
		move(100);	// move 100 pixels forward
		left(90);	// turn 90 degrees to the right
	}
}
