
package theaterEx.sy;

import mcm.theater.*;
import mcm.theater.actor.*;

import java.awt.Color;

public class Start2Initial extends Actor {
	public void act() {
		// ShowShape actor's idea of acting is to stay where they are put on stage 
		Actor a;

		a = new ShowShape();   // create a new ShowShape actor 
		a.jumpTo(10, 20);	   // force it to go to position (10, 20)
		a.start(getStage());   // tell it to start acting on the stage 

		a = new ShowShape();   // create a new ShowShape actor 
		a.jumpTo(30, 40);	   // force it to go to position (30, 40)
		a.start(getStage());   // tell it to start acting on the stage 
	}
}
