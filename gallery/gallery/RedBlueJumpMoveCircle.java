package gallery;

/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;

import java.awt.Color;

public class RedBlueJumpMoveCircle extends Actor {
	
	public void act() {
		Stage stage = getStage(); 
		
		Shape redShape = new EllipseShape(7, 7, true);
		redShape.setColor(Color.RED);
		Shape blueShape = new EllipseShape(7, 7, true);
		blueShape.setColor(Color.BLUE);
		
		/* 
		 * length is 40% of min, which is the smaller of stage width and stage height \
		 * length is used to tell the BackAndForth actors created below how far they should move 
		 */
       
		double min =  Math.min(stage.getWidth(), stage.getHeight());
		double length = 0.4 * min; 	
		
		/* create a series of BackAndForth actors at the stage's center:
		 *   one for each angle: 15, 30, 60, .., 150, 165, no 180, 201, 220, ..., 345, no 360
		 * actors with a direction angle smaller 180 are red and jump on their way back
		 * actors with an angle greater 180 are blue and move on their way back
		 */	
		for (int angle = 15; angle < 360; angle = angle + 15) {
			if (angle == 180) continue;  // do not do this for angle == 180
			BackAndForth a = new BackAndForth();
			if (angle < 180) {
				a.setDoJump(true);        // jump on the way back
				a.setShape(redShape);
			} else {
				a.setDoJump(false);       // move n the way back
				a.setShape(blueShape);
			}
			a.setLength(length);          // cover length distance 
			a.setTrailVisible(false);     // do not leave a trail
			a.jumpTo(stage.getCenter());  // jump to the stage's center
			a.setDirection(angle);        // set direction to angle
			a.start(stage);               // start immediately 
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new RedBlueJumpMoveCircle()); 
	}
}
