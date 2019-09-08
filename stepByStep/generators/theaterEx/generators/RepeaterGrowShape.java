/**
 * Creates and starts a new OnceGrowShape actor every 30 clock ticks 
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.generators;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.theater.*;
import mcm.utils.Dice;

public class RepeaterGrowShape extends Actor {
	public void act() {
		// make this actor's shape invisible
		setVisible(false);

		while (true) { // forever
			jumpTo(Dice.throwPoint(getStage()));
			
			/*
			 * Make a red, green, yellow, blue GrowShape actor with shape
			 * sizes 80, 55, 30, and 5 resepctively and position them at
			 * this actor's location.
			 * 
			 * makeGrowShape sets the actors up to grow their shapes 
			 * from the given size, to the biggest integer value smaller
			 * than size + 100. Thus GrowShape actors live 50 clock ticks 
			 * since they grow their shapes 2 pixels per clock 
			 * tick. Setting the sleep interval to 50 makes 
			 * sure that at most 10 sets of GrowShape actors are on stage 
			 */
			makeGrowShape(Color.BLUE, 80, 100);  // size from 80 to 80 + delta
			makeGrowShape(Color.RED, 55, 100);   // size from 55 to 55 + delta
			makeGrowShape(Color.YELLOW, 30, 100);// size from 30 to 30 + delta
			makeGrowShape(Color.GREEN, 5, 100);  // size from 15 to 15 + delta
			sleep(5);
		}
	}

	void makeGrowShape(Color color, double size, double delta) {
		// create a new GrowShape actor and call it actor
		OnceGrowShape actor = new OnceGrowShape();

		// tell actor to jump to this actor's position
		actor.jumpTo(getPos());

		// set actors's shape to an ellipse with the given color
		actor.setShape(new EllipseShape(size, size, true));
		actor.setColor(color);

		// make actor grow shape from size to size + delta
		actor.setStartSize(size);
		actor.setStopSize(size + delta);

		// tell actor to start on the stage ...
		// actor's act() method is called and executed in parallel to all
		// other actors on the stage
		actor.start(getStage());
	}

}
