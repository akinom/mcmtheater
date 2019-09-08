/*
 * Created on Oct 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package theaterEx.shapes.triangle;

import mcm.theater.Actor;
import mcm.theater.Play;
import mcm.utils.Dice;

/**
 * @author monika
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ShapeCtrLineJump extends Actor {

	public void act() {
		while (true) {
			jumpTo(Dice.throwPoint(getStage())); 
			shapeLine();
		}
	}

	// draw line of triangles until jumping over the edge of the stage 
	public void shapeLine() {
		while (getStage().isInside(getPos())) {
			jump(12);
			left(30); 
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
		Play.main(argv, new ShapeCtrLineJump()); 
	}
}