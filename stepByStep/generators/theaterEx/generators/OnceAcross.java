/**
 * Actor moves from starting position in given direction 
 * until it reaches the stage's edge
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.generators;

import mcm.theater.*;

public class OnceAcross extends Actor {
	public void act() {
		while (getStage().isInside(getPos())) {
			move(getStepSize());
		}		
	}
}