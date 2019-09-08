/**
 * create 20 Jump actors with randomly chosen colors for their 
 * circle shapes and different delays between jumping 
 * 
 * @author Monika Mevenkamp
 *
 */
package theaterEx.jumpers;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class ManyJumps extends Actor {
	public void act() {
		for (int i = 0; i < 20; i++) { // 20 times 			
			// create a new Jump actor and call it jump
			Jump jump = new Jump(); 
			
			// set the jump actors's shape to a circle with a random color 
			Shape shape = new EllipseShape(15, 15, true); 
			shape.setColor(Dice.throwColor());
			jump.setShape(shape);
			
			// choose a random delay bewteen 5 and 25 for the new jump actor
			jump.delay = Dice.throwInt(5, 25);
			
			// tell the jump actor to start on the stage ...
			// jump's act() method is called and executed in parallel to all
			// other actors on the stage
			jump.start(getStage());
		}
	}
}