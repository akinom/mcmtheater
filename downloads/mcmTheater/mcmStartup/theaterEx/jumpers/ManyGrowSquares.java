/**
 * create 20 JumpGrowShape actors with randomly chosen colors for their 
 * square shapes 
 * 
 * @author Monika Mevenkamp
 *
 */
package theaterEx.jumpers;

import mcm.graphics.RectangleShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class ManyGrowSquares extends Actor {
	public void act() {
		for (int i = 0; i < 20; i++) { // 20 times 			
			// create a new TimeJump actor and call it square
			Actor actor = new JumpGrowShape(); 
			
			// set actors's shape to a square with a random color 
			Shape shape = new RectangleShape(5, 5, true); 
			shape.setColor(Dice.throwColor());
			actor.setShape(shape);
			
			// tell actor to start on the stage ...
			// actor's act() method is called and executed in parallel to all
			// other actors on the stage
			actor.start(getStage());
		}
	}
}
