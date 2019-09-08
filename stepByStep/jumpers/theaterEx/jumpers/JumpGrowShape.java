/**
 * Actor forever jumps to a random position on the stage followed 
 * by growing its shape from size (width,height) = (5,5), (6,6), (7,7), ...
 * By default this actors grows its shape to a width,height of (99, 99). 
 * The maximum size is determined by the actor's size variable.
 * 
 * see GrowShape for a variant of this actor
 * see ManyGrowSquares, ManyJumpCircles, LitsJumpCircles for users of this actor
 *        
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import java.awt.Color;

import mcm.theater.*;
import mcm.utils.Dice;

public class JumpGrowShape extends Actor {
	public double size = 100;

	public void act() {
		while (true) {
			jumpTo(Dice.throwPoint(getStage()));
			growShape();
		}
	}
	
	/**
	 * grow shape from size 
	 *       (width,height) = (5,5), (6,6), (7,7), ..., to (s, s) 
	 * where s is the biggest integer number smaller than size 
	 */ 
	void growShape() {
		for (int i = 5; i < size; i++) {
			setWidth(i);
			setHeight(i);
			sleep(1);
		}
	}
}