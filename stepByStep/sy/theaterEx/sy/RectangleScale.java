package theaterEx.sy;

import mcm.theater.*;

public class RectangleScale extends Actor {
	double width, height; 
	
	public RectangleScale(double w, double h) {
		width = w; 
		height = h;
	}
	
	public void act() {
		while (true) {  // do statements inside { ... } forever 
			move(width);	// move width pixels forward 
			left(90);	// turn 90 degrees to the left
			move(height);	// move height pixels forward
			left(90);	// turn 90 degrees to the left
			move(width);	// move width pixels forward 
			left(90);	// turn 90 degrees to the left
			move(height);	// move height pixels forward
			left(90);	// turn 90 degrees to the left
		}
	}
}
