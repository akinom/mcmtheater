/**
 * Actor forever jumps to a random position on the stage followed by
 * taking a break (sleeping) for a number of clock ticks, which is 
 * determined by the value of the actor's delay variable. By default 
 * this is set to 5.
 * 
 * see ManyJumps for an actor creating instances of this actor.  
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class Jump extends Actor {
	int delay = 5;
	
	public void act() {
		while (true) {
			jumpTo(Dice.throwPoint(getStage()));
			sleep(delay);   // go on after stage advanced clock delay tick
		}
	}
}