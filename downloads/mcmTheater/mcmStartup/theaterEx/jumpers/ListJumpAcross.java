/**
 * creates a RED, GREEN, BLUE, and YELLOW jumping line 
 * 
 * see ListJumpCircles for a variant of this actor 
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;

public class ListJumpAcross extends Actor {
	public void act() {
		JumpAcross jumper;
		
		// The makeJumper method is defined below. 
		// It creates a JumpAcross actor, sets its shape, assigns the given 
		// color as the new actor's trail and shape color and returns a reference 
		// to the newly created actor. 
		// The statements below create four jumpers and start them on the stage.
		jumper = makeJumper(Color.RED); 
		jumper.start(getStage());

		jumper = makeJumper(Color.GREEN); 
		jumper.start(getStage());

		jumper = makeJumper(Color.YELLOW); 
		jumper.start(getStage());

		jumper = makeJumper(Color.BLUE); 
		jumper.start(getStage());
		
		// this actor becomes invisble and clears the stage every 500 clock ticks
		setVisible(false);
		while (true) {
			sleep(500);
			getStage().clear();
		}
	}
	
	/**
	 *  makeJumper is a method that: 
	 *    creates a JumpAcross actor,
	 *    sets the new actor's shape to a circle with an 11 pixel diameter,
	 *    sets the actor's shape and trail color to the given color,
	 *    and returns the newly created actor to the method caller
	 */
	JumpAcross makeJumper(Color color) 
	{
		JumpAcross jumpActor = new JumpAcross();
		Shape shape = new EllipseShape(11, 11, true); 
		shape.setColor(color);
		jumpActor.setShape(shape);
		jumpActor.setTrailColor(color);
		return jumpActor;
	}
}
