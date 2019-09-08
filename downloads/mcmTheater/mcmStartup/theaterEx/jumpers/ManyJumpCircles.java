/**
 * create 20 JumpGrowShape actors with randomly chosen colors for their 
 * circle shapes 
 * 
 * @author Monika Mevenkamp
 *
 */package theaterEx.jumpers;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class ManyJumpCircles extends Actor {
	public void act() {
		for (int i = 0; i < 20; i++) { // 20 times 			
			// create a new JumpGrowShape actor and call it jumper
			Actor jumper = new JumpGrowShape(); 
			
			// set jumper's shape to a circle with a random color 
			Shape shape = new EllipseShape(5, 5, false); 
			shape.setColor(Dice.throwColor());
			jumper.setShape(shape);
			
			// tell jumper to start on the stage ...
			// jumper's act() method is called and executed in parallel to all
			// other actors on the stage
			jumper.start(getStage());
		}
	}
}
