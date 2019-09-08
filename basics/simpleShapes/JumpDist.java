/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.DirectionShape;
import mcm.graphics.Point;
import mcm.theater.*;

import java.awt.Color;

public class JumpDist extends Actor {
	/**
	 * make a series of Line Actors with different step sizes
	 */
	public void act() {
		// this Actor serves to repeatedly start a series of Line actors
		// it does not wont to be seen on stage
		setVisible(false);
		getStage().setMode(Stage.LEAVE);
		while (true) {
			// start Line actors
			startActors();
			// sleep as long as it takes the slowest Line actor to finish its
			// movement
			sleep((int) ((getStage().getWidth() - 21) / 0.5));
			// all Lines are done; clear the stage
			getStage().clear();
			// go back to beginning of while loop and
			// start actors; sleep; and clear again ... again .. and again
		}
	}

	public void startActors() {
		tracer.print("startActors");
		// makeActor create a Line actor;
		// gives it the requested color, and
		// positions it at the given point

		Point pos = new Point(21, 21);
		makeMovers(pos, 100, Color.RED); 
		makeMovers(pos, 50, Color.GREEN); 
		makeMovers(pos, 25, Color.YELLOW); 
		makeMovers(pos, 5, Color.BLUE); 
	}

	void makeMovers(Point pos, double dist, Color color) {
		MoveDashed amd = new MoveDashed();
		initActor(amd, pos, color, true);
		amd.setDist(dist);
		amd.start(getStage());
		pos.y += 21;

		JumpMove ajm = new JumpMove();
		initActor(ajm, pos, color, false);
		ajm.setDist(dist);
		ajm.start(getStage());
		pos.y += 21;
	}

	void initActor(Actor a, Point at, Color col, boolean solid) {
		a.jumpTo(at);
		a.setShape(new DirectionShape(getWidth(), getHeight(), solid)); 
		a.setColor(col);
		a.setTrailColor(col);
		a.setStepSize(0.5);
	}

}
