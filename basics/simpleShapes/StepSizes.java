/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.Point;
import mcm.theater.*;

import java.awt.Color;

public class StepSizes extends Actor {
	/**
	 * make a series of Line Actors with different step sizes
	 */
	public void act() {
		// this Actor serves to repeatedly start a series of Line actors
		// it does not wont to be seen on stage
		setVisible(false);
		while (true) {
			// start Line actors
			startActors();
			// sleep as long as it takes the slowest Line actor to finish its movement
			sleep((int) (2 * (getStage().getWidth() - 13)));
			// all Lines are done; clear the stage
			getStage().clear();
			// go back to beginning of while loop and
			// start actors; sleep; and clear again ... again .. and again
		}
	}

	public void startActors() {
		// makeActor create a Line actor; 
		// gives it the requested color, and 
		// positions it at the given point

		Actor a;
		Point pos = new Point(0, 13);

		// start first Actor at position (13, 13), 
		// the following actors are started at a y coordinate 13 pixels higher 
		// than the previous
		// Actors have increasinigly higher step sizes
		a = makeActor(pos, new Color(0x00ffff));
		a.setStepSize(0.5);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, Color.GREEN);
		a.setStepSize(1.0);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, Color.YELLOW);
		a.setStepSize(2.0);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, new Color(0xFFA500));
		a.setStepSize(3.0);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, Color.RED);
		a.setStepSize(5.0);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, new Color(0xFF00FF));
		a.setStepSize(10.0);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, Color.BLUE);
		a.setStepSize(100.0);
		a.start(getStage());
		pos.y += 13;

		a = makeActor(pos, Color.BLACK);
		a.setStepSize(1000.0);
		a.start(getStage());
		pos.y += 13;
	}

	Actor makeActor(Point at, Color col) {
		Actor a = new Line();
		a.jumpTo(at);
		a.setColor(col);
		a.setTrailColor(col);
		return a;
	}
}
