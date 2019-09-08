/** 
 * stays at the same position forever
 *      turning 30 degrees to the left,
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
import mcm.theater.*;

public class RepeaterFromCenterFirst extends Actor {
	public void act() {
		while (true) {                     // forever 
			// create a new OnceAcross actor and call it across
			OnceAcross across = new OnceAcross(); 
			
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
