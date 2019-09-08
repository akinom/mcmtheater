/**
 * Actor moves from starting position in given direction 
 * until it reaches the stage's edge
 * 
 * see JumpAcross for a variant of this actor
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import mcm.theater.*;

public class OnceAcross extends Actor {
	public void act() {
		while (getStage().isInside(getPos())) {
			move(getStepSize());
		}		
	}
}