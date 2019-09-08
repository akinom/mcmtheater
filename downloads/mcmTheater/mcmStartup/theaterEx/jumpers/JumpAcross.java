/**
 * Actor forever jumps to a random position on the stage followed 
 * by drawing a line to the stage's edge.
 * 
 * see OnceAcross for a variant of this actor
 *        
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import mcm.theater.*;
import mcm.utils.Dice;

public class JumpAcross extends Actor {
	public void act() {
		while (true) {
			jumpTo(Dice.throwPoint(getStage()));
			line();
		}		
	}
	
	public void line() {
		while (getStage().isInside(getPos())) {
			move(getStepSize());
		}		
	}
}