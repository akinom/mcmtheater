/** 
 * stays at the same position forever
 *      turning 18 degrees to the left,
 *      shooting a MoveAcross actor out of the center in current direction, 
 *      taking a break 
 *      starting over: turn, create, shoot, ....
 *      
 *  see RepeaterLinesFromSquare for a variant of this     
 *  
 *  @author Monika Mevenkamp
 */
package theaterEx.generators;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;

public class RepeaterFromCenter extends Actor {
	public void act() {
		// this has the same shape as the actors it creates
		Shape shape = new EllipseShape(11, 11, true);
		setShape(shape);
		while (true) {                     // forever 
			// create a new OnceAcross actor and call it across
			OnceAcross across = new OnceAcross(); 
			
			// set across actors's shape to an ellipse 
			across.setShape(shape); 
			
			// make across actor's trail invisible
			across.setTrailVisible(false);
						
			// across actor moves 1 pixel at a time; it's slow
			across.setStepSize(1.0);
						
			// give across actor the same direction and position this actor has
			across.setDirection(getDirection());
			across.jumpTo(getPos());
			
			// tell across actor to start on the stage ...
			// across actor's act() method is called and executed in parallel to all
			// other actors on the stage
			across.start(getStage());
			
			left(29); 	
			sleep(6);
		}
	}


}
