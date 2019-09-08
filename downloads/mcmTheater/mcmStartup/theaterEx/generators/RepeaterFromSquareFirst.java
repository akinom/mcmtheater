/** 
 * draws a square forever creating and starting MoveAcross actors at every corner.
 * The MoveAcross actors are initialized such that they start at the square's 
 * corners and move off to the stage's edge in this actor's movement direction.
 * 
 *  @author Monika Mevenkamp
 */
package theaterEx.generators;

import java.awt.Color;

import mcm.theater.*;

public class RepeaterFromSquareFirst extends Actor {
	public void act() {
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

		// give across actor the same direction, position as this actor has
		across.setDirection(getDirection());
		across.jumpTo(getPos());
		
		// tell across actor to start on the stage ...
		// across actor's act() method is called and executed in parallel to all
		// other actors on the stage
		across.start(getStage());
	}

}
