/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

import java.awt.Color;

public class MultipleRotate extends Actor {

	public void act() {
		getStage().setMode(Stage.LEAVE);
		setColor(Color.BLUE); // this actor has a BLUE shape
		while (true) { // do forever 
			// this actor turn 15 degrees to the left
			left(15);

			// create a new MoveDashed actor and call it dasher
			MoveDashed dasher = new MoveDashed();

			// remember the angle of my direction in the variable myAngle 
			double myAngle = getDirection();

			// set dasher's direction angle to myAngle
			// note the "dasher." in front of setDirection;
			// it means do setDirection to dasher (as opposed to this actor)
			dasher.setDirection(myAngle);

			// tell dasher to jump to the center of the stage
			dasher.jumpTo(getStage().getCenter());

			// tell dasher to start on the stage ...
			// dasher's act() method is called and executed in parallel to all
			// other actors on the stage
			dasher.start(getStage());

			// this actor goes to sleep for 15 clock ticks on the stage
			sleep(15);
			// now start the while loop over again 
			// turning a bit to the left and starting another 'dasher' in  
			// this actor's new direction
		}
	}
}
