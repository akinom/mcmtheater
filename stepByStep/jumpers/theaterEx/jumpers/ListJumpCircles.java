/**
 * creates a RED, GREEN, BLUE, and YELLOW GrowShape actor
 * 
 * see ListJumpAcross for a variant of this actor 
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;

public class ListJumpCircles extends Actor {
	public void act() {
		// The makeJumper method is defined below. 
		// It creates a JumpGrowShape actor, sets its size variable, its shape, 
		// and shape color returns a reference to the newly created actor.
		// The statements below create a jumper with a RED, GREEN, YELLOW, and 
		// BLUE shape. The four actors start at different times: 
		//       RED    start immediately
		//       GREEN  is scheduled to start 10 clock ticks into the future 
		//       YELLOW is scheduled to start 20 clock ticks into the future 
		//       BLUE   is scheduled to start 10 clock ticks into the future 
		JumpGrowShape jumper;
		
		jumper = makeJumper(Color.RED); 
		jumper.start(getStage());       // start immediately

		jumper = makeJumper(Color.GREEN); 
		jumper.start(getStage(), 10);   // start in 10 clock ticks

		jumper = makeJumper(Color.YELLOW); 
		jumper.start(getStage(), 20);   // start in 20 clock ticks

		jumper = makeJumper(Color.BLUE); 
		jumper.start(getStage(), 30);   // start in 30 clock ticks
	}
	
	/**
	 *  makeJumper is a method that: 
	 *    creates a JumpAcross actor
	 *    sets the actor's size variable to a third of the stage's width
	 *            (thus the JumpGrowActor will grow its shape from 5 pixels to 
	 *             a third of the stage's width)
	 *    sets the new actor'shape to a circle with a 5 pixel diameter
	 *    sets the shape's color to the given color
	 *    and returns the newly created actor to the method caller
	 */
    JumpGrowShape makeJumper(Color color) 
	{
		JumpGrowShape jumpActor = new JumpGrowShape();
		jumpActor.size = getStage().getWidth() / 3;
		Shape shape = new EllipseShape(5, 5, true); 
		shape.setColor(color);
		jumpActor.setShape(shape);
		return jumpActor;
	}
}
