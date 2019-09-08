/*
 * Created on Sep 30, 2005
 *
 * MonaLisa uses this to move her head
 */
package collage.head;

import java.awt.Color;

import mcm.theater.*;

public class BackForth extends Actor {
	public void act() {
		double distance = 60;

		setStepSize(1.0);
		move(distance); // move to  right most point 
		while (true) {
			move(-distance); // move back at starting position
			sleep(30);       // stay for 30 stage clock ticks
			move(-distance); // move to left most point 
			move(distance);  // move back at starting point 
			sleep(30);       // stay for 30 stage clock ticks
			move(distance);  // move to right most point
		}
	}

}