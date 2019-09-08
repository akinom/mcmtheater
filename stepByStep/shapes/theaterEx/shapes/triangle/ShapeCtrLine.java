/*
 * Created on Oct 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package theaterEx.shapes.triangle;

import mcm.theater.*;

/**
 * @author monika
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ShapeCtrLine extends Actor {

	public void act() {
		while (getStage().isInside(getPos())) {  // while inside stage
			jump(12);                            // jump forward 
			left(30);                            // draw rotated  shape
			shape(10);
			right(30);
		}
	}

	// draw triangle
	public void shape(double size) {
		move(size);
		right(120);
		move(size);
		right(120);
		move(size);
		right(120);
	}
	public static void main(String argv[]) {
		Play.main(argv, new ShapeCtrLine()); 
	}
}