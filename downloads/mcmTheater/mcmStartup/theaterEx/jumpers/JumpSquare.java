/**
 * Actor forever jumps to a random position on the stage followed 
 * by drawing a square. 
 * The square's side length is 30 by default but can be changed by 
 * assigning to the actor's size variable.
 * 
 * see OnceSquare for a variant of this actor
 *        
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import mcm.theater.*;
import mcm.utils.Dice;

public class JumpSquare extends Actor {
	double size = 30;

	public void act() {
		while (true) {
			jumpTo(Dice.throwPoint(getStage()));
			square();
		}
	}
	
	public void square() {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
		
	}
}