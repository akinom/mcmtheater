/**
 * Actor draws a square once.
 * The square's side length is 30 by default but can be changed by 
 * assigning to the actor's size variable.
 * 
 * see RepeaterSquare for an actor starting multiple copies of this actor
 * see JumpSquare for a variant of this actor
 *        
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import mcm.theater.Actor;

public class OnceSquare extends Actor {
	double size = 30; 

	public void act() {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
}