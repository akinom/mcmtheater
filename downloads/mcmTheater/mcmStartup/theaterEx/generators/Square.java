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

import mcm.theater.*;

public class Square extends Actor {
	public void act() {
		while (true) { // forever 
			// move along square's edge and turn right 
			move(30);
			left(90);
		}
	}

}