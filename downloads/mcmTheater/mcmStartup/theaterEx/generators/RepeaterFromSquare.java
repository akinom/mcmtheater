/** 
 * draws a square forever creating and starting MoveAcross actors at every corner.
 * The MoveAcross actors are initialized such that they start at the square's 
 * corners and move off to the stage's edge in this actor's movement direction.
 * 
 * see RepeaterLinesFromCenter for a variant 
 * 
 *  @author Monika Mevenkamp
 */
package theaterEx.generators;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.theater.*;

public class RepeaterFromSquare extends Actor {
	public void act() {
		setShape(new EllipseShape(21, 21, true)); 
		setColor(Color.BLUE);
		setTrailWidth(3);
		while (true) { // forever 
			// create and start OnceAcross actor
			shoot();
			// move along edge 
			move(30);
			// turn around corner
			left(90);
		}
	}


	private void shoot() {
		// create a new OnceAcross actor and call it across
		OnceAcross across = new OnceAcross();

		// set across actors's shape to an ellipse  
		across.setShape(new EllipseShape(11, 11, true)); 

		// give across actor the same direction, position, and trail width 
		// as this actor has
		across.setDirection(getDirection());
		across.jumpTo(getPos());
		across.setTrailWidth(getTrailWidth());

		// tell across actor to start on the stage ...
		// across actor's act() method is called and executed in parallel to all
		// other actors on the stage
		across.start(getStage());
	}
}
