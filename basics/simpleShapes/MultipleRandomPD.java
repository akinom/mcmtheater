/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class MultipleRandomPD extends Actor {
	public void act() {
		setColor(Color.BLUE);   // I have a BLUE shape
		while (true) {                     // forever 
			
			// create a new square actor and call it square
			Square square = new Square(); 
			
			// tell square to jump to a random point 
			square.jumpTo(Dice.throwPoint(getStage()));
			
			// set square's trail color to a random color 
			square.setTrailColor(Dice.throwColor());
			
			// set square's trail width to 9
			square.setTrailWidth(9);
			
			// tell square to start on the stage ...
			// square's act() method is called and executed in parallel to all
			// other actors on the stage
			square.start(getStage());
			
			// this actor goes to sleep for 30 clock ticks on the stage
			sleep(30);
			// now start the while loop over again 
		}
	}
}
