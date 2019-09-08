/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.Actor;

public class MultipleTimeJump extends Actor {
	/**
	 * create and start 4 actors:
	 * two TimeJump20, one TimeJump5, and a TimeStageColor actor
	 */
	public void act() {
		Actor a;

		a = new TimeJump20();   	// a now refers to the new TimeJump20 actor
		a.start(getStage());		// start that new actor on the stage
		a = new TimeJump20();   	// a now refers to the second new TimeJump20 actor
		a.start(getStage());		// start that new actor on the stage
		a = new TimeJump5();   		// a now refers to the new TimeJump5 actor
		a.start(getStage());		// start that new actor on the stage
		a = new TimeStageColor();	// a now refers to the new TimeStageColor actor
		a.start(getStage());		// start that new actor on the stage
	}
}
