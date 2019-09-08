/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import java.awt.Color;

public class LineInvisible extends Actor {

	public void act() {
		// make trail invisible 
		setTrailVisible(false); 
		// move 60 pixels forward
		move(60); 
	}
}
